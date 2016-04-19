package cn.lcf.code.generator.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import cn.lcf.code.generator.entity.BaseFile;
import cn.lcf.code.generator.entity.ControllerFile;
import cn.lcf.code.generator.entity.DaoInterfaceFile;
import cn.lcf.code.generator.entity.ServiceFile;
import cn.lcf.code.generator.entity.InterfaceFile;
import cn.lcf.code.generator.entity.ServiceInterfaceFile;

public class CodeGenerator {
	private Set<BaseFile> files = new HashSet<>();

	public Set<BaseFile> getFiles() {
		return files;
	}

	public void setFiles(Set<BaseFile> files) {
		this.files = files;
	}
	
	public void autoCreateServiceFiles(String basePath,String packageName,Set<String> entities,String modePackage,String daoPackage){
		for(String entity : entities){
			InterfaceFile file = new ServiceInterfaceFile();
			file.setBasePath(basePath);
			file.setName(entity);
			file.setSuffix("Service");
			file.setPackageName(packageName);
			file.addImport(modePackage+"."+entity);
			
			
			ServiceFile classFile = new ServiceFile();
			classFile.setName(entity);
			classFile.setBasePath(basePath);
			classFile.setPackageName(packageName +".impl");
			classFile.addInterface(file.getName() +file.getSuffix());
			classFile.setSuffix("ServiceImpl");
			classFile.addImport(modePackage+"."+entity);
			classFile.addImport(daoPackage+"."+entity+"Dao");
			files.add(file);
			files.add(classFile);
		}
	}
	public void autoCreateControllerFiles(String basePath,String packageName,Set<String> entities,String modePackage,String servicePackage,String url){
		for(String entity : entities){
			ControllerFile classFile = new ControllerFile();
			classFile.setName(entity);
			classFile.setBasePath(basePath);
			classFile.setPackageName(packageName);
			classFile.setSuffix("Controller");
			classFile.addImport(modePackage+"."+entity);
			classFile.addImport(servicePackage +"." +entity +"Service");
			classFile.setUrl(url);
			files.add(classFile);
		}
	}
	public void autoCreateDaoFiles(String basePath, String packageName, Set<String> entities,String modePackage) {
		for(String entity : entities){
			BaseFile classFile = new DaoInterfaceFile();
			classFile.setName(entity);
			classFile.setBasePath(basePath);
			classFile.setSuffix("Dao");
			classFile.setPackageName(packageName);
			classFile.addImport(modePackage+"."+entity);
			files.add(classFile);
		}	
	}
	
	public void writeFile() {
		System.out.println("开始写类文件,共" + this.files.size() + " 个！");
		for (BaseFile classFile : files) {

			try {
				File dir = new File(classFile.getDirPath());
				if (!dir.exists()) {
					if (dir.mkdirs()) {
						System.out.println("创建目录成功");
					} else {
						System.out.println("创建目录失败");
					}
				}

				File file = new File(classFile.getFilePath());
				FileWriter fileWriter = new FileWriter(file);
				System.out.println(classFile.getFileString());
				fileWriter.write(classFile.getFileString());
				fileWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


}
