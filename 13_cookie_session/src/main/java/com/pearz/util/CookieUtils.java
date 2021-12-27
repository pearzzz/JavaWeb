package com.pearz.util;

import javax.servlet.http.Cookie;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:08 2021/12/22
 */
public class CookieUtils {

    public static Cookie findCookie(String name, Cookie[] cookies) {
        if (name == null || cookies ==null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}
