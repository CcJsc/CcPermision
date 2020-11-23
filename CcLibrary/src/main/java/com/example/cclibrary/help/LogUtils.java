package com.example.cclibrary.help;

import android.util.Log;



/**
 * @author AlienChao
 * @date 2019/08/01 14:16
 */
public class LogUtils {
    private static boolean isDebug;
    static String className;//类名
    static String methodName;//方法名
    static int lineNumber;//行数

    /**
     * 判断是否可以调试
     *
     * @return
     */
    public static boolean isDebuggable() {
        return isDebug;
    }

    public static void setIsDebug(boolean isDebug) {
        LogUtils.isDebug = isDebug;
    }

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();

        buffer.append("(").append(className);
        buffer.append(":").append(lineNumber).append(")-");
        buffer.append(methodName).append(":");
        buffer.append(log);
        return buffer.toString();
    }

    /**
     * 获取文件名、方法名、所在行数
     *
     * @param sElements
     */
    private static void getMethodNames(StackTraceElement[] sElements) {
        className = sElements[1].getFileName();
        methodName = sElements[1].getMethodName();
        lineNumber = sElements[1].getLineNumber();
    }

    public static void e(String message) {
        if (!isDebuggable()) {
            return;
        }

        getMethodNames(new Throwable().getStackTrace());
        if (isDebuggable()) {
            Log.e(className, createLog(message));
        }
    }

    public static void i(String message) {
        if (!isDebuggable()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        if (isDebuggable()) {
            Log.i(className, createLog(message));
        }
    }

    public static void i(String tag, String message) {
        if (!isDebuggable()) { //||tag.equals("基类")
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        if (isDebuggable()) {
            Log.i(tag, createLog(message));
        }
    }

    public static void d(String message) {
        if (!isDebuggable()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        if (isDebuggable()) {
            Log.d(className, createLog(message));
        }
    }

    public static void v(String message) {
        if (!isDebuggable()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        if (isDebuggable()) {
            Log.v(className, createLog(message));
        }
    }

    public static void w(String message) {
        if (!isDebuggable()) {
            return;
        }
        getMethodNames(new Throwable().getStackTrace());
        if (isDebuggable()) {
            Log.w(className, createLog(message));
        }
    }
}
