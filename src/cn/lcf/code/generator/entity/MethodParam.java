package cn.lcf.code.generator.entity;

public class MethodParam {
	private String type;
	private String name;
	
	public MethodParam(String type, String name) {
		this.type = type;
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toMethodParamString() {
		return this.type +" " + this.name;
	}
	

}
