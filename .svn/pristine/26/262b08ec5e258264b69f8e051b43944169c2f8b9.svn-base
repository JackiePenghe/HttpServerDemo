package cn.almsound.www.testhttpserver.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import static android.text.format.Formatter.formatIpAddress;

/**
 * Created by jacke on 2017/2/20 0020.
 */

public class MacAddressUtil {

    /**
     * 使用WIFI时，获取本机IP地址
     *
     * @param mContext 上下文
     * @return
     */
    public static String getWIFILocalIpAdress(Context mContext) {

        //获取wifi服务
        WifiManager wifiManager = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        //判断wifi是否开启
        if (!wifiManager.isWifiEnabled()) {
            wifiManager.setWifiEnabled(true);
        }
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        return formatIpAddress(ipAddress);
    }
}
