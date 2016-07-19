package com.codegentools.app;

import java.util.ArrayList;
import java.util.List;

import com.codegentools.utils.NameConvertUtils;

/**
 * vo.ftl用到的配置属性
 * @author lenovo
 *
 */
public class VoBean {
   /**
    * 类名
    */
   private String className;
   /**
    * 表备注信息
    */
   private String remarks;
   /**
    * 所有Vo属性
    */
   private List<VoProperty>  voPropertys=new ArrayList<VoProperty>();
   
   
	public String getClassName() {
		this.className=NameConvertUtils.ConvertClassName(this.className);
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<VoProperty> getVoPropertys() {
		return voPropertys;
	}
	public void setVoPropertys(List<VoProperty> voPropertys) {
		this.voPropertys = voPropertys;
	}
	
	 public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String toString(){
			StringBuffer buff=new StringBuffer();
			buff.append(this.getClassName()+"类信息:remarks:"+remarks).append("\n");
			buff.append("\n"+this.getClassName()+"属性信息").append("\n{");
			for(int i=0;i<voPropertys.size();i++){
				buff.append(voPropertys.get(i));
			}
			buff.append("\n}");
			return buff.toString();
		}
   
   
   
   
}
