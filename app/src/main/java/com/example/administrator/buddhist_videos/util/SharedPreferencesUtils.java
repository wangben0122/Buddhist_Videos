package com.example.administrator.buddhist_videos.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * SharedPreferences工具类
 */

public class SharedPreferencesUtils {
    private static SharedPreferences sharedPreferences;
    private static final String KEY = "HHZN";

    ///sdsa
    public static void init(Context context) {//在App中初始化
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }

    public static void add(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public static void add(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public static void add(String key, int value) {
        sharedPreferences.edit().putInt(key, value).apply();

    }

    public static void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public static String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public static int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }

    public static boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public static Set<String> getStringSet(String key) {
        return sharedPreferences.getStringSet(key, new HashSet<String>());
    }

    public static void add(String key, Set<String> value) {
        sharedPreferences.edit().putStringSet(key, value).apply();
    }
}
