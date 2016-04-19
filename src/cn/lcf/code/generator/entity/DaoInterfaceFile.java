package cn.lcf.code.generator.entity;

public class DaoInterfaceFile extends InterfaceFile {

	public DaoInterfaceFile() {
		super();
		this.addImport("com.shine.dao.BaseDao");
		this.addExtends("BaseDao");
	}
	
}
