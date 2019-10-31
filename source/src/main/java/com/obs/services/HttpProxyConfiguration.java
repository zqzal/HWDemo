package com.obs.services;

/**
 * HTTP代理配置信息
 */
public class HttpProxyConfiguration
{
    
    private String proxyAddr;
    
    private int proxyPort;
    
    private String proxyUname;
    
    private String userPaaswd;
    
    private String domain;
    
    private String workstation;
    
    public HttpProxyConfiguration()
    {
    }
    
    /**
     * 
     * @param proxyAddr 代理地址
     * @param proxyPort 代理端口
     * @param proxyUname 代理用户名
     * @param userPaaswd 代理密码
     * @param domain 代理域
     */
    public HttpProxyConfiguration(String proxyAddr, int proxyPort, String proxyUname, String userPaaswd, String domain)
    {
        this.proxyAddr = proxyAddr;
        this.proxyPort = proxyPort;
        this.proxyUname = proxyUname;
        this.userPaaswd = userPaaswd;
        this.domain = domain;
        this.workstation = this.proxyAddr;
    }
    
    /**
     * 带参构造函数
     * 
     * @param proxyAddr 代理地址
     * @param proxyPort 代理端口
     * @param proxyUname 代理用户名
     * @param userPaaswd 代理密码
     * @param domain 代理域
     * @param workstation 代理所在工作区
     */
    public HttpProxyConfiguration(String proxyAddr, int proxyPort, String proxyUname, String userPaaswd, String domain, String workstation)
    {
        this(proxyAddr, proxyPort, proxyUname, userPaaswd, domain);
        this.workstation = this.proxyAddr;
    }
    
    /**
     * 获取代理地址
     * 
     * @return 代理地址
     */
    public String getProxyAddr()
    {
        return proxyAddr;
    }
    
    /**
     * 设置代理地址
     * 
     * @param proxyAddr 代理地址
     */
    public void setProxyAddr(String proxyAddr)
    {
        this.proxyAddr = proxyAddr;
    }
    
    /**
     * 获取代理端口
     * 
     * @return 代理端口
     */
    public int getProxyPort()
    {
        return proxyPort;
    }
    
    /**
     * 设置代理端口
     * 
     * @param proxyPort 代理端口
     */
    public void setProxyPort(int proxyPort)
    {
        this.proxyPort = proxyPort;
    }
    
    /**
     * 获取用户名
     * 
     * @return 用户名
     */
    public String getProxyUName()
    {
        return proxyUname;
    }
    
    /**
     * 设置用户名
     * 
     * @param proxyUName 用户名
     */
    public void setProxyUName(String proxyUName)
    {
        this.proxyUname = proxyUName;
    }
    
    /**
     * 获取代理用户密码
     * @return 代理用户密码
     */
    public String getUserPaaswd()
    {
        return userPaaswd;
    }
    
    /**
     * 设置代理用户密码
     * @param userPaaswd 代理用户密码
     */
    public void setUserPaaswd(String userPaaswd)
    {
        this.userPaaswd = userPaaswd;
    }
    
    /**
     * 获取代理域
     * 
     * @return 代理域
     */
    public String getDomain()
    {
        return domain;
    }
    
    /**
     * 设置代理域
     * 
     * @param domain 代理域
     */
    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    /**
     * 获取代理工作区
     * @return 代理工作区
     */
    public String getWorkstation()
    {
        return workstation;
    }

    /**
     * 设置代理工作区
     * @param workstation 代理工作区
     */
    public void setWorkstation(String workstation)
    {
        this.workstation = workstation;
    }
    
}
