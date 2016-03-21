package cn.lcf.code.generator.entity;

import java.util.Set;

public class ServiceFile extends BaseFile{
	
	private Set<String> properties;

	@Override
	public String toFileString() {
		return null;
	}

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
	public String getDefaultMethods() {
		StringBuffer sb = new StringBuffer();
		sb.append(NEW_LINE);
		sb.append(NEW_LINE);
		sb.append(TAB+PUBLIC +SPACE + VOID + SPACE+"add"+this.name +"("+this.name +SPACE + this.name.substring(0, 1).toLowerCase() + this.name.substring(1, this.name.length())+"){");
		sb.append(NEW_LINE);
		sb.append(NEW_LINE);
		sb.append(TAB+"}");
		sb.append(NEW_LINE);
		return sb.toString();
	}

}
