package com.bootdo.common.utils;

/**
 * <p>Title: ExceptionUtils</p>
 * <p>Description: ExceptionUtils</p>
 *
 * @author
 * @version 1.0
 * @date
 */
public class ExceptionUtils {

    public static String getExceptionAllinformation(Exception ex) {
        String sOut = "";
        StackTraceElement[] trace = ex.getStackTrace();
        for (StackTraceElement s : trace) {
            sOut += "\tat " + s + "\r\n";
        }
        return sOut;
    }
}
