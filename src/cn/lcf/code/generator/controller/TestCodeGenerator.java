package cn.lcf.code.generator.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class TestCodeGenerator {
	 public static Properties prop = new Properties();
	public static void main(String[] args){
		CodeGenerator  codeGenerator = new CodeGenerator();
//		Set<String> set = new HashSet<String>();
//		set.add("People");
		initProperties();
		
//		codeGenerator.autoCreateDaoFiles(basePath, "com.shine.dao."+productCode, set,"com.shine.entity."+productCode);
//		codeGenerator.autoCreateServiceFiles(basePath, "com.shine.view.service."+productCode, set,"com.shine.entity."+productCode,"com.shine.dao."+productCode);
//		codeGenerator.autoCreateControllerFiles(basePath, "com.shine.view."+productCode, set,"com.shine.entity."+productCode,"com.shine.view.service."+productCode,"/resources/"+productCode+"/");
//		codeGenerator.writeFile();
		String daoBasePath = prop.getProperty("daoBasePath");
		String serviceBasePath = prop.getProperty("serviceBasePath");
		String controllerBasePath = prop.getProperty("controllerBasePath");

		String daoPackage = prop.getProperty("daoPackage");
		String servicePackage = prop.getProperty("servicePackage");
		String entityPackage = prop.getProperty("entityPackage");
		String controllerPackage = prop.getProperty("controllerPackage");
		
		String productCode = prop.getProperty("productCode").toLowerCase();
		String baseUrl = prop.getProperty("baseUrl");
		
		entityPackage =entityPackage+"."+productCode;
		daoPackage = daoPackage+"."+productCode;
		servicePackage = servicePackage+"."+productCode;
		controllerPackage = controllerPackage+"."+productCode;
		
		codeGenerator.autoCreateDaoFiles(daoBasePath, daoPackage, getSet("entities"),entityPackage);
		codeGenerator.autoCreateServiceFiles(serviceBasePath, servicePackage, getServiceSet(),entityPackage,daoPackage);
		codeGenerator.autoCreateControllerFiles(controllerBasePath, controllerPackage, getControllerSet(),entityPackage,servicePackage,baseUrl);
		codeGenerator.writeFile();
		
		printSet(getSet("entities"));
		printSet(getServiceSet());
		printSet(getControllerSet());
		 
	}
	public static void printSet(Set<String> set){
		System.out.println("=========");
		for(String s :set){
			System.out.println(s);
		}
	}
	
	public static void initProperties(){
		 InputStream in = CodeGenerator.class.getResourceAsStream("config.properties");
		 try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
	
	public static Set<String> getSet(String key){
		Set<String> set = new HashSet<String>();
		String str = prop.getProperty(key);
		if(str !=null && !"".equalsIgnoreCase(str.trim())){
			String strs[] = str.split(",");
			for(String s : strs){
				set.add(s);
			}
		}
		return set;
	}
	
	public static Set<String> getServiceSet(){
		Set<String> all = getSet("entities");
		Set<String> serviceExclude = getSet("serviceExclude");
		all.removeAll(serviceExclude);
		return all;
	}
	
	public static Set<String> getControllerSet(){
		Set<String> all = getSet("entities");
		Set<String> serviceExclude =getSet("controllerExclude");
		all.removeAll(serviceExclude);
		return all;
	}
	
	
}
