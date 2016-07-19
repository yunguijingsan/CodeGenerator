package com.codegentools.app;

import com.codegentools.utils.NameConvertUtils;
import com.codegentools.utils.SqlTypeMapJavaUtils;

/**
 * vo.ftl模板用到的配置属性
 * @author lenovo
 *
 */
public class VoProperty {
    private String javaType;
    
    private String javaPropertyName;
    
    private String javaMethodName;
    
    private String javaRemarks;

	public String getJavaType() {
		
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType=SqlTypeMapJavaUtils.getValue(javaType);
	}

	public String getJavaPropertyName() {
		return javaPropertyName;
	}

	public void setJavaPropertyName(String javaPropertyName) {
		this.javaPropertyName = NameConvertUtils.ConvertPropertyName(javaPropertyName);
	}

	public String getJavaMethodName() {
		return javaMethodName;
	}

	public void setJavaMethodName(String javaMethodName) {
		this.javaMethodName = NameConvertUtils.ConvertMethdoName(javaMethodName);
	}
	
	
	
	public String getJavaRemarks() {
		return javaRemarks;
	}

	public void setJavaRemarks(String javaRemarks) {
		this.javaRemarks = javaRemarks;
	}

	public String toString(){
		 StringBuffer buff=new StringBuffer();
		 buff.append("[\n");
		 buff.append("javaType").append(":").append(javaType).append("\n");
		 buff.append("javaPropertyName").append(":").append(javaPropertyName).append("\n");
		 buff.append("javaMethodName").append(":").append(javaMethodName).append("\n");
		 buff.append("javaRemarks").append(":").append(javaRemarks).append("\n");
		 buff.append("]");
		 buff.append("[\n");
		 return buff.toString();
		
	}
    
    
}
