package cn.lcf.code.generator.entity;

public class ServiceInterfaceFile extends InterfaceFile {

	public ServiceInterfaceFile() {
		super();
		this.addImport("com.shine.view.service.BaseService");
		this.addExtends("BaseService");
	}
	
}
