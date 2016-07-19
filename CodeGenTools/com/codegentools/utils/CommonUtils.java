package com.codegentools.utils;

import java.util.List;
/**
 * ͨ�ù�����
 * @author yangquanhui
 *
 */
public class CommonUtils {
    public static   boolean isListNotEmpty(List list){
    	boolean flag=true;
    	if(list==null||list.size()==0){
    		flag=false;
    	}
         return flag;
    }
    public static boolean  isStrNotEmpty(String str){
    	if(str==null||str.trim().length()==0){
    		return false;
    	}else{
    		return true;
    	}
    }
    public static boolean  isObjectNotEmpty(Object obj){
    	if(obj==null){
    		return false;
    	}else{
    		return true;
    	}
    }
}
