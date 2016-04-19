package cn.lcf.code.generator.entity;

import java.util.HashSet;
import java.util.Set;

public class Method implements BaseConstants{
	private String modifier;
	private String returnObject;
	private String name;
	private Set<String> annotations = new HashSet<>();
	private Set<MethodParam> methodParams = new HashSet<>();
	
	private String methodBody;

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(String returnObject) {
		this.returnObject = returnObject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethodBody() {
		return methodBody;
	}

	public void setMethodBody(String methodBody) {
		this.methodBody = methodBody;
	}
	
	public void addMethodParams(String type,String name){
		this.methodParams.add(new MethodParam(type,name));
	}
	
	public String toMethodString(){
		StringBuilder sb = new StringBuilder();
		sb.append(NEW_LINE);
		sb.append(NEW_LINE);
		if(!this.annotations.isEmpty()){
			sb.append(TAB);
			sb.append(this.getMethodAnnotations());
			sb.append(NEW_LINE);
		}
		sb.append(TAB);
		sb.append(this.getModifier());
		sb.append(SPACE);
		sb.append(this.getReturnObject());
		sb.append(SPACE);
		sb.append(this.getName());
		sb.append(this.getMethodParamsString());
		sb.append(this.getMethodBody());
		return sb.toString();
	}

	private String getMethodAnnotations() {
		StringBuilder sb = new StringBuilder();
		for(String str : this.annotations){
			sb.append(str);
		}
		return sb.toString();
	}

	private String getMethodParamsString() {
		if(this.methodParams.isEmpty()){
			return "()";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("(");
		for(MethodParam methodParam : methodParams){
			sb.append(methodParam.toMethodParamString());
			sb.append(",");
		}
		String s = sb.substring(0, sb.length()-1);
		return s +")";
		
	}
	public void addAnnotation(String annotation){
		this.annotations.add(annotation);
	}
}
