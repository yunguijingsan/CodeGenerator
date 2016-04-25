package com.shine.core.exception;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 *
 * 统一的返回结果
 */
public class ResponseResult {
    /**
     * 状态码
     * 1：业务成功
     * 2：业务失败
     * 3：系统异常  未处理的异常
     * 4：未登录
     * 5：无权限
     */
    private int status;
    /*
	 * 业务失败结果码 只有状态码为 2 时才生效，状态码不为 2时业务结果为 0
	 */
    private String resultCode;
    // 消息
    private String message;
    // 返回的数据
    private Object data;

    public static ResponseResult createNotAuthorized() {
        return ResponseResult.createFail(5, "PUBLIC.SYSTEM.NOT.AUTHORIZED");
    }

    public static ResponseResult createNotLogin() {
        return ResponseResult.createFail(4, "PUBLIC.SYSTEM.NOT.LOGIN");
    }

    public static ResponseResult createError() {
        return ResponseResult.createFail(3, "PUBLIC.SYSTEM.ERROR");
    }

    /**
     *创建业务失败的返回结果对象
     * @param resultCode 传入结果码
     * @return 业务失败的返回结果对象
     */
    public static ResponseResult createFail(String resultCode) {
        return ResponseResult.createFail(2, resultCode);
    }

    private static ResponseResult createFail(int status, String resultCode) {
        return ResponseResult.createResponseResult(status, resultCode, null, null);
    }

    /**
     *创建业务成功的返回结果，无返回数据和无返回消息时使用
     * @return 业务成功的返回结果对象
     */
    public static ResponseResult createSuccess() {
        return ResponseResult.createSuccessWithMessage("成功", null);
    }

    /**
     * 创建业务成功的返回结果  有返回数据时使用
     * @param data
     * @return
     */
    public static ResponseResult createSuccess(Object data) {
        return ResponseResult.createResponseResult(1, "0", "", data);
    }

    /**
     * 创建业务成功的返回结果 有返回消息时使用
     * @param data
     * @return
     */
    public static ResponseResult createSuccessWithMessage(String message) {
        return ResponseResult.createSuccessWithMessage(message, null);
    }

    /**
     * 创建业务成功的返回结果 有返回消息和返回数据时使用
     * @param data
     * @return
     */
    public static ResponseResult createSuccessWithMessage(String message, Object data) {
        return ResponseResult.createResponseResult(1, "0", message, data);
    }

    private static ResponseResult createResponseResult(int status, String resultCode, String message, Object data) {
        return new ResponseResult(status, resultCode, message, data);
    }

    private ResponseResult(int status, String resultCode, String message, Object data) {
        this.status = status;
        this.resultCode = resultCode;
        this.message = message;
        this.data = data;
        this.excludeLocal(ResponseResult.class, "includeMap", "excludeMap");
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    /**
     * 指定某个类在序列化时包含的属性，如果指定了，则这个类在序列化时，只会序列化指定的属性
     * 如果重复指定,则后指定的回覆盖之前的
     * 使用方法，例如返回的Documents对象只返回,documentId,creationDate,url 三个字段
     *  ResponseResult.createSuccess(document).include(Documents.class, "documentId","creationDate","url")
     * 
     * @param clazz  要指定的类型
     * @param properties  指定的属性名
     * @return
     */
    public ResponseResult include(Class clazz, String... properties) {
        if (clazz.equals(ResponseResult.class)) {
            throw ServiceException.create("PUBLIC.PROPERTY.FILTER.ILLIGAL");
        }
        includeMap.put(clazz, this.getSetFromProperties(properties));
        return this;
    }
    /**
     * 指定某个类在序列化时不包含的属性，如果指定了不包含的属性，则这个类在序列化时，不会序列化指定的属性
     * 如果一个类包含了指定了序列化时包含的属性(includeMap)，则指定不包含的属性不会生效，
     * 
     * 使用方法，例如返回的Documents对象不需要返回creationDate
     *      ResponseResult.createSuccess(document).exclude(Documents.class, "creationDate")
     *  
     * @param clazz  要指定的类型
     * @param properties  指定不包含的属性名
     * @return
     */
    public ResponseResult exclude(Class clazz, String... properties) {
        if (clazz.equals(ResponseResult.class)) {
            throw ServiceException.create("PUBLIC.PROPERTY.FILTER.ILLIGAL");
        }
        excludeMap.put(clazz, this.getSetFromProperties(properties));
        return this;
    }

    private ResponseResult excludeLocal(Class clazz, String... properties) {
        excludeMap.put(clazz, this.getSetFromProperties(properties));
        return this;
    }

    private void includeLocal(Class clazz, String... properties) {
        includeMap.put(clazz, this.getSetFromProperties(properties));
    }

    private Set<String> getSetFromProperties(String... properties) {
        Set<String> set = new HashSet<String>();
        for (String property : properties) {
            if(property !=null && "".equals(property)){
                set.add(property);
            }
        }
        return set;
    }

    public Map<Class<?>, Set<String>> getIncludeMap() {
        return this.includeMap;
    }

    public Map<Class<?>, Set<String>> getExcludeMap() {
        return this.excludeMap;
    }

    private final Map<Class<?>, Set<String>> includeMap = new HashMap<Class<?>, Set<String>>();
    private final Map<Class<?>, Set<String>> excludeMap = new HashMap<Class<?>, Set<String>>();
}
