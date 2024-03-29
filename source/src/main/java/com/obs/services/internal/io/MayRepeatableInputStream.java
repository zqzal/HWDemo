package com.obs.services.internal.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

import com.obs.services.internal.ServiceException;

public class MayRepeatableInputStream extends FilterInputStream {
	
	private static class SdkBufferedInputStream extends BufferedInputStream{

		public SdkBufferedInputStream(InputStream in, int size) {
			super(in, size);
		}
		
		public void tearDown() {
			this.count = 0;
			this.markpos = -1;
			this.marklimit = 0;
			this.pos = 0;
		}
	}
	
	private FileChannel fileChannel;
	private long markPos;
	private InputStream originInputStream;

	public MayRepeatableInputStream(InputStream in, int bufferSize) {
		super(in);
		this.init(bufferSize);
		this.originInputStream = in;
	}

	private void init(int bufferSize) {
		if (this.in instanceof FileInputStream) {
			fileChannel = ((FileInputStream) in).getChannel();
			try {
				markPos = fileChannel.position();
			} catch (IOException e) {
				throw new IllegalArgumentException("Invalid FileInputStream", e);
			}
		}
		if(bufferSize > 0) {
			this.in = new SdkBufferedInputStream(in, bufferSize);
		}
	}

	@Override
	public final boolean markSupported() {
		return fileChannel != null || (originInputStream instanceof ByteArrayInputStream);
	}

	protected final void abortIfNeeded() {
		if (Thread.interrupted()) {
			throw new RuntimeException("Abort io due to thread interrupted");
		}
	}

	@Override
	public void mark(int a) {
		abortIfNeeded();
		try {
			if (fileChannel != null) {
				markPos = fileChannel.position();
			}else if(originInputStream instanceof ByteArrayInputStream) {
				((ByteArrayInputStream)originInputStream).mark(a);
			}
		} catch (IOException e) {
			throw new ServiceException("Failed to mark the file position", e);
		}
	}

	@Override
	public void reset() throws IOException {
		if (fileChannel != null) {
			fileChannel.position(markPos);
			if(in instanceof SdkBufferedInputStream) {
				((SdkBufferedInputStream)in).tearDown();
			}
		} else if(originInputStream instanceof ByteArrayInputStream) {
			if(in instanceof SdkBufferedInputStream) {
				((SdkBufferedInputStream)in).tearDown();
			}
			((ByteArrayInputStream)originInputStream).reset();
		} else {
			throw new UnrecoverableIOException("UnRepeatable");
		}
	}

	@Override
	public long skip(long n) throws IOException {
		abortIfNeeded();
		return super.skip(n);
	}

	@Override
	public int available() throws IOException {
		abortIfNeeded();
		return super.available();
	}

	@Override
	public void close() throws IOException {
		super.close();
		abortIfNeeded();
	}

	@Override
	public int read() throws IOException {
		abortIfNeeded();
		return super.read();
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		abortIfNeeded();
		return super.read(b, off, len);
	}

}
