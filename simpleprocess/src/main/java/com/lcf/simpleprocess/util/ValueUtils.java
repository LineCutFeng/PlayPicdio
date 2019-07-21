package com.lcf.simpleprocess.util;

public class ValueUtils {

    public static <T extends Number> T FClamp(T t, T tLow, T tHigh) {
        if (t.doubleValue() < tHigh.doubleValue()) {
            return ((t.doubleValue() > tLow.doubleValue()) ? t : tLow);
        }
        return tHigh;
    }
}
