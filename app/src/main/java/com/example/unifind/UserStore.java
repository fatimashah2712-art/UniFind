package com.example.unifind;


import android.content.Context;
import android.content.SharedPreferences;

/**
 * Simulated local "database": keeps ONE account in SharedPreferences.
 * A demo account is created automatically the first time it is needed:
 *   email: demo@unifind.com   password: 123456
 */
public class UserStore {

    private static final String PREFS = "unifind_prefs";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    private static SharedPreferences prefs(Context c) {
        return c.getApplicationContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
    }

    private static void seedDemo(Context c) {
        if (!prefs(c).contains(KEY_EMAIL)) {
            saveUser(c, "Demo Student", "demo@unifind.com", "123456");
        }
    }

    public static void saveUser(Context c, String name, String email, String password) {
        prefs(c).edit()
                .putString(KEY_NAME, name)
                .putString(KEY_EMAIL, email)
                .putString(KEY_PASSWORD, password)
                .apply();
    }

    public static boolean checkLogin(Context c, String email, String password) {
        seedDemo(c);
        SharedPreferences p = prefs(c);
        return email.equalsIgnoreCase(p.getString(KEY_EMAIL, ""))
                && password.equals(p.getString(KEY_PASSWORD, ""));
    }

    public static boolean emailExists(Context c, String email) {
        seedDemo(c);
        return email.equalsIgnoreCase(prefs(c).getString(KEY_EMAIL, ""));
    }

    public static void setPassword(Context c, String newPassword) {
        prefs(c).edit().putString(KEY_PASSWORD, newPassword).apply();
    }

    public static String getName(Context c) {
        seedDemo(c);
        return prefs(c).getString(KEY_NAME, "");
    }

    public static String getEmail(Context c) {
        seedDemo(c);
        return prefs(c).getString(KEY_EMAIL, "");
    }
}
