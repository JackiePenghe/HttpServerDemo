package cn.almsound.www.almhttpserverlibrary.utils;

import android.util.Log;

/**
 * Created by jacke on 2017/2/22 0022.
 * Tools
 */

@SuppressWarnings("WeakerAccess")
public class Tools {
    /**
     * default tag
     */
    private static final String tag = "HttpServer";

    /**
     * Decide whether to print log
     */
    private static boolean debugFlag = true;

    /**
     * get tag
     *
     * @return tag
     */
    public static String getTag() {
        return tag;
    }

    /**
     * get debugFlag
     *
     * @return true means print log.false means not.
     */
    public static boolean isDebug() {
        return debugFlag;
    }

    /**
     * set debugFlag
     *
     * @param debugFlag debugFlag
     */
    public static void setDebugFlag(boolean debugFlag) {
        Tools.debugFlag = debugFlag;
    }

    /**
     * use log.i to print
     *
     * @param tag TAG
     * @param msg log info
     */
    public static void infoOut(String tag, String msg) {
        if (debugFlag) {
            Log.i(tag, msg);
        }
    }

    /**
     * use log.i to print
     *
     * @param msg log info
     */
    public static void infoOut(String msg) {
        if (debugFlag) {
            Log.i(tag, msg);
        }
    }

    /**
     * use log.d to print
     *
     * @param tag TAG
     * @param msg log info
     */
    public static void debugOut(String tag, String msg) {
        if (debugFlag) {
            Log.d(tag, msg);
        }
    }

    /**
     * use log.i to print
     *
     * @param msg log info
     */
    @SuppressWarnings("WeakerAccess")
    public static void debugOut(String msg) {
        if (debugFlag) {
            Log.d(tag, msg);
        }
    }

    /**
     * 用 log.e 的方式打印日志信息
     *
     * @param tag TAG
     * @param msg 日志信息
     */
    public static void errorOut(String tag, String msg) {
        if (debugFlag) {
            Log.e(tag, msg);
        }
    }

    /**
     * 用 log.e 的方式打印日志信息
     *
     * @param msg 日志信息
     */
    public static void errorOut(String msg) {
        if (debugFlag) {
            Log.e(tag, msg);
        }
    }

    /**
     * 用 log.w 的方式打印日志信息
     *
     * @param tag TAG
     * @param msg 日志信息
     */
    public static void warnOut(String tag, String msg) {
        if (debugFlag) {
            Log.w(tag, msg);
        }
    }

    /**
     * 用 log.w 的方式打印日志信息
     *
     * @param msg 日志信息
     */
    public static void warnOut(String msg) {
        if (debugFlag) {
            Log.w(tag, msg);
        }
    }
}
