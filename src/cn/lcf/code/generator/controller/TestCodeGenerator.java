package cn.lcf.code.generator.controller;

import java.util.HashSet;
import java.util.Set;

public class TestCodeGenerator {
	public static String basePath = "C:\\Users\\Administrator\\workspace\\CodeGenerator\\src";
	public static void main(String[] args){
		CodeGenerator  codeGenerator = new CodeGenerator();
		
		Set<String> set = new HashSet<String>();
		set.add("User");
		set.add("Menu");
		set.add("Role");
		codeGenerator.autoCreateServiceFiles(basePath, "cn.lcf.code.test.service", set,"cn.lcf.code.test.model");
		codeGenerator.autoCreateControllerFiles(basePath, "cn.lcf.code.test.controller", set,"cn.lcf.code.test.model");
		codeGenerator.autoCreateDaoFiles(basePath, "cn.lcf.code.test.dao", set,"cn.lcf.code.test.model");
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
