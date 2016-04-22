package cn.lcf.code.generator.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import cn.lcf.code.generator.entity.BaseFile;
import cn.lcf.code.generator.entity.ControllerFile;
import cn.lcf.code.generator.entity.DaoInterfaceFile;
import cn.lcf.code.generator.entity.InterfaceFile;
import cn.lcf.code.generator.entity.ServiceFile;
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
			InterfaceFile serviceFile = new ServiceInterfaceFile();
			serviceFile.setBasePath(basePath);
			serviceFile.setName(entity);
			serviceFile.setSuffix("Service");
			serviceFile.setPackageName(packageName);
			serviceFile.addImport(modePackage+"."+entity);
			serviceFile.addExtends("BaseService");
			serviceFile.addMethods();
			
			
			ServiceFile serviceImplFile = new ServiceFile();
			serviceImplFile.setName(entity);
			serviceImplFile.setBasePath(basePath);
			serviceImplFile.setPackageName(packageName +".impl");
			serviceImplFile.addInterface(serviceFile.getName() +serviceFile.getSuffix());
			serviceImplFile.setSuffix("ServiceImpl");
			serviceImplFile.addImport(modePackage+"."+entity);
			serviceImplFile.addImport(daoPackage+"."+entity+"Dao");
			serviceImplFile.addMethods();

			files.add(serviceFile);
			files.add(serviceImplFile);
		}
	}
	public void autoCreateControllerFiles(String basePath,String packageName,Set<String> entities,String modePackage,String servicePackage,String url){
		for(String entity : entities){
			ControllerFile controllerFile = new ControllerFile();
			controllerFile.setName(entity);
			controllerFile.setBasePath(basePath);
			controllerFile.setPackageName(packageName);
			controllerFile.setSuffix("Controller");
			controllerFile.addImport(modePackage+"."+entity);
			controllerFile.addImport(servicePackage +"." +entity +"Service");
			controllerFile.setUrl(url);
			controllerFile.addMethods();
			files.add(controllerFile);
		}
	}
	public void autoCreateDaoFiles(String basePath, String packageName, Set<String> entities,String modePackage) {
		for(String entity : entities){
			BaseFile daoFile = new DaoInterfaceFile();
			daoFile.setName(entity);
			daoFile.setBasePath(basePath);
			daoFile.setSuffix("Dao");
			daoFile.setPackageName(packageName);
			daoFile.addImport(modePackage+"."+entity);
			daoFile.addMethods();
			daoFile.addExtends("BaseDao");
			files.add(daoFile);
		}	
	}
	
	public void writeFile() {
		System.out.println("开始写类文件,共" + this.files.size() + " 个！");
		File file;
		FileWriter fileWriter = null;
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

				file = new File(classFile.getFilePath());
			    fileWriter = new FileWriter(file);
				System.out.println(classFile.getFileString());
				fileWriter.write(classFile.getFileString());
				fileWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					fileWriter.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

}
