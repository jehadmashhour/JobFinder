package com.example.jehad.jobfinder.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Utils for every data type
 */
public class DataTypeUtils {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String isSafeNull(String str) {
        try {
            return str;
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> boolean isNull(T object) {
        return object == null;
    }

    public static <T> T isSafeNull(T object) {
        try {
            return object;
        } catch (Exception e) {
            return null;
        }

    }

    public static <T> boolean isNullOrEmpty(List<T> objects) {
        return objects == null || objects.isEmpty();
    }


    public static boolean isNullOrEmpty(Object[] objects) {
        return objects == null || objects.length == 0;
    }

    public static <T> boolean isNullOrEmpty(ArrayList<T> arrayList) {
        return arrayList == null || arrayList.isEmpty();
    }
}
