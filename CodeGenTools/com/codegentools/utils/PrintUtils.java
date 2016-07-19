package com.codegentools.utils;

import java.util.List;

import com.codegentools.db.Table;

/**
 * 打印工具类
 * @author yangquanhui
 *
 */
public class PrintUtils {
	
	public  static void PrintList(List<Table> list){
		for(int i=0;i<list.size();i++){
			Table table=list.get(i);
			print(table);
			
		}
	}
	public static void print(Object message){
		System.out.println(message);
	}
  
}
