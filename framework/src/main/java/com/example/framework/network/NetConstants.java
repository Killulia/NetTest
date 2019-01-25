package com.example.framework.network;

public class NetConstants {

    private static boolean isDebug = false;

    /** 正式服务器地址 */
    public static final String SERVER_ADDRESS_RELEASE = "http://v.juhe.cn/";

    /** 测试服务器地址 */
    public static final String SERVER_ADDRESS_DEBUG = "";

    /** 服务器域名 */
    public static final String SERVER_ADDRESS = isDebug ? SERVER_ADDRESS_DEBUG : SERVER_ADDRESS_RELEASE;

}
