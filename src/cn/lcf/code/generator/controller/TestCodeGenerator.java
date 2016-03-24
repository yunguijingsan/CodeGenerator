package cn.lcf.code.generator.controller;

import java.util.HashSet;
import java.util.Set;

public class TestCodeGenerator {
	public static String basePath = "D:\\Work\\CodeGenerator\\src";
	public static String eihBasePath ="D:\\Work\\NEIH\\EIHProject\\Model\\eihView\\src";
	public static String eihDaoPath ="D:\\Work\\EIHProject\\Model\\appsModel\\src";
	public static void main(String[] args){
		CodeGenerator  codeGenerator = new CodeGenerator();
		
		Set<String> set = new HashSet<String>();
//		set.add("Accounts");
//		set.add("Order");
//		set.add("OrderService");
//		set.add("Message");
//		set.add("OrderProcess");
//		set.add("ShoppingCart");
//		set.add("Comment");
//		set.add("Assignments");
		set.add("Accumulate");
		codeGenerator.autoCreateDaoFiles(eihDaoPath, "com.shine.dao.eih", set,"com.shine.entity.eih");
//		codeGenerator.autoCreateServiceFiles(eihBasePath, "com.shine.view.service", set,"com.shine.entity.eih","com.shine.dao.eih");
//		codeGenerator.autoCreateControllerFiles(eihBasePath, "com.shine.view.eih", set,"com.shine.entity.eih","com.shine.view.service","eihView/resources/eih/");
//		ClassFile classFile = new ClassFile();
//		classFile.setBasePath(basePath);
//		classFile.setName("UserServiceImpl");
//		classFile.setPackageName("cn.lcf.code.service.impl");
//		classFile.addInterface("UserService");
//		
//		codeGenerator.getFiles().add(classFile);
//		
//		InterfaceFile interfaceFile = new InterfaceFile();
//		interfaceFile.setBasePath(basePath);
//		interfaceFile.setName("UserService");
//		interfaceFile.setPackageName("cn.lcf.code.service");
//		
//		codeGenerator.getFiles().add(interfaceFile);
//		
		codeGenerator.writeFile();
	}
}
