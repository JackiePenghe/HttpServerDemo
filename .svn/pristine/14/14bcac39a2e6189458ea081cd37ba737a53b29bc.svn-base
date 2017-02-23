package cn.almsound.www.testhttpserver.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jacke on 2017/2/21 0021.
 */

public class AddressUtil {

    /**
     * 获取外网的IP(要访问Url，要放到后台线程里处理)
     *
     * @Title: GetNetIp
     * @Description:
     * @param @return
     * @return String
     */
    public static String GetNetIp() {
        URL infoUrl = null;
        InputStream inStream = null;
        String ipLine = "";
        HttpURLConnection httpConnection = null;
        try {
            infoUrl = new URL("http://ip168.com/");
            URLConnection connection = infoUrl.openConnection();
            httpConnection = (HttpURLConnection) connection;
            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                inStream = httpConnection.getInputStream();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(inStream, "utf-8"));
                StringBuilder strber = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null)
                    strber.append(line).append("\n");

                Pattern pattern = Pattern.compile("((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))");
                Matcher matcher = pattern.matcher(strber.toString());
                if (matcher.find()) {
                    ipLine = matcher.group();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inStream != null;
                inStream.close();
                httpConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ipLine;
    }

    // 获取本地IP函数
    public static String getLocalIPAddress() {
        try {
            for (Enumeration<NetworkInterface> mEnumeration = NetworkInterface
                    .getNetworkInterfaces(); mEnumeration.hasMoreElements();) {
                NetworkInterface intf = mEnumeration.nextElement();
                for (Enumeration<InetAddress> enumIPAddr = intf
                        .getInetAddresses(); enumIPAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIPAddr.nextElement();
                    // 如果不是回环地址
                    if (!inetAddress.isLoopbackAddress()) {
                        // 直接返回本地IP地址
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            System.err.print("error");
        }
        return null;
    }
    public static byte[] Ip4StringToByte(String ip4String){
        String[] split = ip4String.split("\\.");
        if (split.length != 4){
            return null;
        }
        byte[]  bytes = new byte[4];

        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) Integer.parseInt(split[i]);
        }

        return bytes;
    }
}
