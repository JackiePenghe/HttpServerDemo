package cn.almsound.www.testhttpserver.utils;

import android.util.Log;

/**
 * 日志打印工具类
 * <p>
 * Created by ALM on 2016/7/7.
 */
public class LogUtil {

    /**
     * 默认的tag
     */
    private static final String tag = "LogUtil";

    /**
     * 调试输出的标志
     */
    private static boolean debugFlag = true;

    /**
     * 获取tag
     * @return tag
     */
    public static String getTag() {
        return tag;
    }

    /**
     * 获取当前调试标志
     * @return true表示打印log，false表示不打印
     */
    public static boolean isDebug() {
        return debugFlag;
    }

    /**
     * s设置调试标志
     * @param debugFlag 调试标志
     */
    public static void setDebugFlag(boolean debugFlag) {
        LogUtil.debugFlag = debugFlag;
    }

    /**
     * 用 log.i 的方式打印日志信息
     * @param tag TAG
     * @param msg 日志信息
     */
    public static void i(String tag, String msg) {
        if (debugFlag) {
            Log.i(tag, msg);
        }
    }

    /**
     * 用 log.i 的方式打印日志信息
     * @param msg 日志信息
     */
    public static void i(String msg) {
        if (debugFlag) {
            Log.i(tag, msg);
        }
    }

    /**
     * 用 log.d 的方式打印日志信息
     * @param tag TAG
     * @param msg 日志信息
     */
    public static void d(String tag, String msg) {
        if (debugFlag) {
            Log.d(tag, msg);
        }
    }

    /**
     * 用 log.d 的方式打印日志信息
     * @param msg 日志信息
     */
    @SuppressWarnings("WeakerAccess")
    public static void d(String msg) {
        if (debugFlag) {
            Log.d(tag, msg);
        }
    }

    /**
     * 用 log.e 的方式打印日志信息
     * @param tag TAG
     * @param msg 日志信息
     */
    public static void e(String tag, String msg) {
        if (debugFlag) {
            Log.e(tag, msg);
        }
    }

    /**
     * 用 log.e 的方式打印日志信息
     * @param msg 日志信息
     */
    public static void e(String msg) {
        if (debugFlag) {
            Log.e(tag, msg);
        }
    }

    /**
     * 用 log.w 的方式打印日志信息
     * @param tag TAG
     * @param msg 日志信息
     */
    public static void w(String tag, String msg) {
        if (debugFlag) {
            Log.w(tag, msg);
        }
    }

    /**
     * 用 log.w 的方式打印日志信息
     * @param msg 日志信息
     */
    public static void w(String msg) {
        if (debugFlag) {
            Log.w(tag, msg);
        }
    }
}