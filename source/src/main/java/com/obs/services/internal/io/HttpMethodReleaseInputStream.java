package com.obs.services.internal.io;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.obs.log.ILogger;
import com.obs.log.LoggerBuilder;

import okhttp3.Response;

public class HttpMethodReleaseInputStream extends InputStream implements InputStreamWrapper {
    private static final ILogger interfaceLog = LoggerBuilder.getLogger("com.obs.services.internal.RestStorageService");
    
    private InputStream inputStream = null;
    private Response httpResponse = null;
    private boolean alreadyReleased = false;
    private boolean underlyingStreamConsumed = false;

    public HttpMethodReleaseInputStream(Response response) {
        this.httpResponse = response;
        try {
            this.inputStream = new InterruptableInputStream(response.body().byteStream());
        } catch (Exception e) {
            try {
                response.close();
            } catch (Exception ee){
                // ignore
            }
            this.inputStream = new ByteArrayInputStream(new byte[] {}); // Empty input stream;
        }
    }

    public Response getHttpResponse() {
        return httpResponse;
    }

    protected void releaseConnection() throws IOException {
        if (!alreadyReleased) {
            if (!underlyingStreamConsumed && httpResponse != null) {
                httpResponse.close();
            }
            alreadyReleased = true;
        }
    }

    @Override
    public int read() throws IOException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                underlyingStreamConsumed = true;
                if (!alreadyReleased) {
                    releaseConnection();
                }
            }
            return read;
        } catch (IOException e) {
            try {
                releaseConnection();
            } catch(IOException ignored) {
            }
            throw e;
        }
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        try {
            int read = inputStream.read(b, off, len);
            if (read == -1) {
                underlyingStreamConsumed = true;
                if (!alreadyReleased) {
                    releaseConnection();
                }
            }
            return read;
        } catch (IOException e) {
            try {
                releaseConnection();
            } catch(IOException ignored) {
                //
            }
            throw e;
        }
    }

    @Override
    public int available() throws IOException {
        try {
            return inputStream.available();
        } catch (IOException e) {
            try {
                releaseConnection();
            } catch(IOException ignored) {
                //
            }
            throw e;
        }
    }

    @Override
    public void close() throws IOException {
        if (!alreadyReleased) {
            releaseConnection();
        }
        inputStream.close();
    }

    @Override
    protected void finalize() throws Throwable {
        if (!alreadyReleased) {
            if (interfaceLog.isWarnEnabled()) {
            	interfaceLog.warn("Attempting to release HttpMethod in finalize() as its response data stream has gone out of scope. "
                + "This attempt will not always succeed and cannot be relied upon! Please ensure response data streams are "
                + "always fully consumed or closed to avoid HTTP connection starvation.");
            }
            releaseConnection();
            if (interfaceLog.isWarnEnabled()) {
            	interfaceLog.warn("Successfully released HttpMethod in finalize(). You were lucky this time... "
                + "Please ensure response data streams are always fully consumed or closed.");
            }
        }
        super.finalize();
    }

    public InputStream getWrappedInputStream() {
        return inputStream;
    }

}
