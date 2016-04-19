package cn.lcf.code.generator.entity;

import java.util.Set;

public abstract class ClassFile extends BaseFile{
	
	{
		this.addImport("org.apache.log4j.Logger");
		this.addImport("com.shine.core.utils.page.Page");
	}
		
	private Set<String> properties;

	public Set<String> getProperties() {
		return properties;
	}

	public void setProperties(Set<String> properties) {
		this.properties = properties;
	}

	@Override
	public String getTypeString() {
		return "class";
	}

	@Override
	public String getLoggerLine() {
		return NEW_LINE+TAB+"private static Logger logger = Logger.getLogger("+this.getName() + this.getSuffix()+".class);" + NEW_LINE;
	}
	
}
