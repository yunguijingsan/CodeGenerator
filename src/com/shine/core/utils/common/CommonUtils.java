package com.shine.core.utils.common;

import java.sql.Timestamp;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * 通用工具类
 * @author kuangbinhua
 *
 */
public class CommonUtils {
    /*这个值不可以更改，更改后之前注册的用户密码验证将不正确*/
    public final static String SALT_PWD = "salt";

    /**
     * 生成用户密码
     * @author kuangbinhua
     * @param pwd
     * @return
     */
    public static String generatePwd(String pwd) {
        return new Sha256Hash(pwd, SALT_PWD).toHex();
    }

    public static void main(String[] args) {
        Integer i = 1;
        Integer[] a = { 1, 20 };
        //        System.out.println(a[0].equals(i));
        System.out.println(arrayContains(a, i));
    }

    /**
     * 生成六位随机验证码
     * @Description: TODO
     * @return
     * @return int
     */
    public static String createCheckCode() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
    }

    /**
     * 生成8位随机验证码
     * @Description: TODO
     * @return
     * @return int
     */
    public static String generateNumber() {
        return String.valueOf((int) ((Math.random() * 9 + 1) * 10000000));
    }

    public static boolean isBlank(String str) {
        return str == null || "".equals(str.trim());
    }

    public static boolean isBlank(Object arr[]) {
        return arr == null || arr.length == 0;
    }

    public static boolean isBlank(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(Object obj) {
        return null == obj;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isBlank(Collection col) {
        return col == null || col.isEmpty();
    }

    /**
     * 判断数组是否包含某个元素
     * @param array 数组
     * @param o 元素
     * @return
     */
    public static boolean arrayContains(Object[] array, Object o) {
        if (array != null) {
            for (Object arr : array) {
                if (arr instanceof String || arr instanceof Integer || arr instanceof Long || arr instanceof Double ||
                    arr instanceof Float || arr instanceof Byte) {
                    if (arr.equals(o)) {
                        return true;
                    }
                } else {
                    if (arr == o) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 返回某个元素在数组中的索引，不存在则返回-1
     * @param array 数组
     * @param o 元素
     * @return
     */
    public static int arrayIndex(Object[] array, Object o) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] instanceof String || array[i] instanceof Integer || array[i] instanceof Long ||
                    array[i] instanceof Double || array[i] instanceof Float || array[i] instanceof Byte) {
                    if (array[i].equals(o)) {
                        return i;
                    }
                } else {
                    if (array[i] == o) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     *  得到请求上下文地址（域名+上下文）
     * @param request
     * @return
     */
    public static String getRequestConetxtUrl() {
        HttpServletRequest request =
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuffer url = request.getRequestURL();
        String tempContextUrl =
            url.delete(url.length() - request.getRequestURI().length(),
                       url.length()).append(request.getServletContext().getContextPath()).append("/").toString();
        return tempContextUrl;
    }

    /**
     *判断验证码是否过期
     * @param date
     * @return
     */
    public static boolean ischekCodeDateOut(Date date) {
        return date.before(new Date(System.currentTimeMillis() - 30 * 60 * 1000));
    }

    /**
     *判断是否请求时间在规定时间以外   90秒
     * @param date
     * @return
     */
    public static boolean ischekCodeRequestDate(Date date) {
        return date.after(new Date(System.currentTimeMillis() - 90 * 1000));
    }

    public static void printStackTraceInfo(Logger log, Exception e) {
        log.error(e.getMessage(), e);
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        boolean flag = false;
        try {
            Pattern regex = Pattern.compile("^1[34578][0-9]{9}$");
            Matcher matcher = regex.matcher(mobileNumber);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
