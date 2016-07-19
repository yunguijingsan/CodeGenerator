package com.codegentools.utils;

import java.util.StringTokenizer;

/**
 * 命名转换
 * @author lenovo
 *
 */
public class NameConvertUtils {
	/**
	 * 根据属性名成,转换方法
	 * @param propertyName
	 * @return
	 */
    public static   String   ConvertMethdoName(String propertyName){
    	StringBuffer buff=new StringBuffer();
    	if(!CommonUtils.isStrNotEmpty(propertyName)){
    		return buff.toString();
    	}
    	String methodName=ConvertPropertyName(propertyName,"_",false);
    	buff.append(methodName);
    	return buff.toString();
    }
    /**
	 * 根据属性名成,转换方法
	 * @param propertyName
	 * @return
	 */
    public static   String   ConvertClassName(String propertyName){
    	StringBuffer buff=new StringBuffer();
    	if(!CommonUtils.isStrNotEmpty(propertyName)){
    		return buff.toString();
    	}
    	String className=ConvertPropertyName(propertyName,"_",false);
    	buff.append(className);
    	return buff.toString();
    }
    /**
     * 转换属性名
     * @param propertyName
     * @return
     */
    public static String ConvertPropertyName(String propertyName){
    	StringBuffer buff=new StringBuffer();
    	if(!CommonUtils.isStrNotEmpty(propertyName)){
    		return buff.toString();
    	}
    	String strName=ConvertPropertyName(propertyName,"_",true);
    	buff.append(strName);
    	return buff.toString();
    }
    /**
     * 
     * @param propertyName  属性名
     * @param separator  分隔符
     * @param flag  true:表示第一个字母大写,false:所有字母都大写 
     * @return
     */
    public static String ConvertPropertyName(String propertyName,String separator,boolean flag){
    	StringBuffer buff=new StringBuffer();
    	StringTokenizer strTokenizer=new StringTokenizer(propertyName,separator);
    	while(strTokenizer.hasMoreElements()){
    		String str=String.valueOf(strTokenizer.nextElement());
    		if(flag){
    			buff.append(str);
    			flag=false;
    			continue;
    		}
    		str=str.replaceFirst(str.substring(0, 1),str.substring(0, 1).toUpperCase())  ; 
    		buff.append(str);
    	}
    	return buff.toString();
    }
    
    public static void main(String args[]){
    	String propertyName="aa_bb_cc";
    	String str=NameConvertUtils.ConvertPropertyName(propertyName,"_",false);
    	System.out.println(str);
    }
    
   
}
