package com.qyys.quickapp.common.constant;

/**
 * @author : Yuan.Pan 2022/4/17 1:08 PM
 */
public class UserContext {

    private static final ThreadLocal<String> USER_ID = new ThreadLocal<>();

    public static String getUserId() {
        return USER_ID.get();
    }

    public static void init(String userId) {
        USER_ID.set(userId);
    }

    public static void destroy() {
        USER_ID.remove();
    }
}
