package com.sky.xposed.wechat.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sky on 18-3-12.
 */

public class PreferencesManager {

    public static final String WE_CAT = "weCat";

    private Context mContext;
    private SharedPreferences mPreferences;
    private Map<String, Object> mMap = new HashMap<>();

    public PreferencesManager(Context context) {
        mContext = context;
        mPreferences = mContext.getSharedPreferences(WE_CAT, Context.MODE_PRIVATE);

        initPreferencesManager();
    }

    private void initPreferencesManager() {
        // 添加所有
        mMap.putAll(mPreferences.getAll());
    }

    public String getString(String key, String defValue) {
        String v = (String)mMap.get(key);
        return v != null ? v : defValue;
    }

    public int getInt(String key, int defValue) {
        Integer v = (Integer)mMap.get(key);
        return v != null ? v : defValue;
    }
    public long getLong(String key, long defValue) {
        Long v = (Long)mMap.get(key);
        return v != null ? v : defValue;
    }
    public float getFloat(String key, float defValue) {
        Float v = (Float)mMap.get(key);
        return v != null ? v : defValue;
    }
    public boolean getBoolean(String key, boolean defValue) {
        Boolean v = (Boolean)mMap.get(key);
        return v != null ? v : defValue;
    }

    public boolean contains(String key) {
        return mMap.containsKey(key);
    }

    public void putString(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
    }

    public void putInt(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
    }

    public void putLong(String key, long value) {
        mPreferences.edit().putLong(key, value).apply();
    }

    public void putFloat(String key, float value) {
        mPreferences.edit().putFloat(key, value).apply();
    }

    public void putBoolean(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
    }

    public void remove(String key) {
        mPreferences.edit().remove(key).apply();
    }

    public void clear() {
        mPreferences.edit().clear().apply();
    }
}
