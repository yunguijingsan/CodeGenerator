package cn.lcf.code.generator.controller;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class TestCodeGenerator {
	public static String basePath = "D:\\Work\\CodeGenerator\\src";
//	public static String eihBasePath ="D:\\Work\\NEIH\\EIHProject\\Model\\eihView\\src";
//	public static String eihDaoPath ="D:\\Work\\EIHProject\\Model\\appsModel\\src";
	public static String productCode = "cg";
	public static String PRODUCT_CODE = "CG";
//	public static String hrBasePath ="D:\\Work\\"+PRODUCT_CODE+"Project\\Model\\"+productCode+"View\\src";
//	public static String hrDaoPath ="D:\\Work\\"+PRODUCT_CODE+"Project\\Model\\"+productCode+"Model\\src";
	public static void main(String[] args){
		CodeGenerator  codeGenerator = new CodeGenerator();
		Set<String> set = new HashSet<String>();
		set.add("People");
		
		codeGenerator.autoCreateDaoFiles(basePath, "com.shine.dao."+productCode, set,"com.shine.entity."+productCode);
		codeGenerator.autoCreateServiceFiles(basePath, "com.shine.view.service."+productCode, set,"com.shine.entity."+productCode,"com.shine.dao."+productCode);
		codeGenerator.autoCreateControllerFiles(basePath, "com.shine.view."+productCode, set,"com.shine.entity."+productCode,"com.shine.view.service."+productCode,"/resources/"+productCode+"/");
		codeGenerator.writeFile();
	}
}
