package com.ibenew.code.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import com.codegentools.utils.Config;
import com.ibenew.code.entity.CodeParams;

public class DocumentUtil {
	static String resources = "config.properties";

	public static CodeParams test() {
		// 将配置文件加载单独写成一个函数，将异常处理进行封装，使代码整洁
		Properties properties = loadProperties(resources);
		// 直接用getProperty获取属性值
		CodeParams params = new CodeParams(); 
		
		params.setProjectName(properties.getProperty("projectCode"));
		
		params.setDaoPackage(properties.getProperty("daoPackage") + ("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		params.setServicePackage(properties.getProperty("servicePackage") + ("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		params.setControllerPackage(properties.getProperty("controllerPackage") + ("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		params.setVoPackage(properties.getProperty("voPackage") + ("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		params.setConditionPackage(properties.getProperty("conditionPackage") + ("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		params.setEntityPackage(properties.getProperty("entityPackage") + ("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		
		
		params.setDaoBasePath(properties.getProperty("daoBasePath"));
		params.setServiceBasePath(properties.getProperty("serviceBasePath"));
		params.setControllerBasePath(properties.getProperty("controllerBasePath"));
		params.setVoBasePath(properties.getProperty("voBasePath"));
		params.setConditionBasePath(properties.getProperty("conditionBasePath"));

		params.setTemplatePackage(properties.getProperty("templatePackage"));
		
		
		params.setEntityBasePath(properties.getProperty("entityPackage")+("".equals(params.getProjectName()) ? "" : "."+params.getProjectName()));
		
		params.setDaoAbsolutePath(params.getDaoBasePath() + getPathFromPackage(params.getDaoPackage()));
		params.setServiceAbsolutePath(params.getServiceBasePath() + getPathFromPackage(params.getServicePackage()));
		params.setControllerAbsolutePath(params.getControllerBasePath() + getPathFromPackage(params.getControllerPackage()));
		params.setVoAbsolutePath(params.getVoBasePath()+getPathFromPackage(params.getVoPackage()));
		params.setConditionAbsolutePath(params.getConditionBasePath()+getPathFromPackage(params.getConditionPackage()));
			
		List<String> entitieList = new ArrayList<String>();
		Collections.addAll(entitieList, properties.getProperty("entities").split(","));
		params.setEntities(entitieList);
		List<String> serviceList = new ArrayList<String>();
		Collections.addAll(serviceList, properties.getProperty("controllerExclude").split(","));
		params.setControllerExclude(serviceList);
		List<String> controllerList = new ArrayList<String>();
		Collections.addAll(controllerList, properties.getProperty("serviceExclude").split(","));
		params.setServiceExclude(controllerList);
		List<String> daoList = new ArrayList<String>();
		Collections.addAll(daoList, properties.getProperty("daoExclude").split(","));
		params.setDaoExclude(daoList);
		List<String> voList = new ArrayList<String>();
		Collections.addAll(voList, properties.getProperty("voExclude").split(","));
		params.setVoExclude(voList);
		System.out.println(params);
		return params;
	}
	
	public static String getPathFromPackage(String packageName) {
		return packageName.replace(".", File.separator);
	}

	public static Properties loadProperties(String resources) {
	   // 使用InputStream得到一个资源文件
	   InputStream inputstream = DocumentUtil.class.getResourceAsStream(resources);
	   // new 一个Properties
	   Properties properties = new Properties();
	   try {
	   // 加载配置文件
	      properties.load(inputstream);
	      return properties;
	   } catch (IOException e) {
	      throw new RuntimeException(e);
	   } finally {
	      try {
	         inputstream.close();
	      } catch (IOException e) {
	         throw new RuntimeException(e);
	      }
	   }
	}
	
	public static void initDir(String dir){
		File targetDirect = new File(dir);
		if (!targetDirect.exists()) {
			targetDirect.mkdirs();
		}
	}
	
	public static Config getEntityConfig(){
		Config config = new Config();
		Properties properties = loadProperties(resources);
		config.setDriverClass(properties.getProperty("driverClass"));
		config.setPackageName(properties.getProperty("entityPackage")+"." + properties.getProperty("projectCode").toLowerCase());
		config.setPackagePath(properties.getProperty("daoBasePath") + getPathFromPackage(config.getPackageName()));
		config.setUrl(properties.getProperty("jdbcUrl"));
		config.setUserName(properties.getProperty("userName"));
		config.setPassord(properties.getProperty("password"));
		return config;
	}

	public static void write(List<String> entityNames) {
		Properties properties = loadProperties(resources);
		String str = entityNames.toString();
		properties.setProperty("entities", str.substring(1,str.length()-1));
		
		FileOutputStream fos = null;   
		try {
			fos = new FileOutputStream(resources);
			//将Properties集合保存到流中   
			properties.store(fos, "Copyright (c) Boxcode Studio"); 
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static String get(String key){
		Properties properties = loadProperties(resources);
		return properties.getProperty(key);
	}

	public static List<String> getEntityNamesFromPath(String path) {
		File entityDir = new File(path);
		entityDir.listFiles();
		return null;
	}
	
	public static List<String> getEntityNamesInFile(File file){
		return null;
		
	}
}
