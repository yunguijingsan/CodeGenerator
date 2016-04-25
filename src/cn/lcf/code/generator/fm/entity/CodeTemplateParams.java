package cn.lcf.code.generator.fm.entity;

public class CodeTemplateParams {
	private String entityName;
	private String servicePackage;
	private String daoPackage;
	private String controllerPackage;
	private String entityPackage;
	private String productCode;
	private String conditionPackage;
	
	
	public String getConditionPackage() {
		return conditionPackage;
	}
	public void setConditionPackage(String conditionPackage) {
		this.conditionPackage = conditionPackage;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getServicePackage() {
		return servicePackage;
	}
	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}
	public String getDaoPackage() {
		return daoPackage;
	}
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	public String getControllerPackage() {
		return controllerPackage;
	}
	public void setControllerPackage(String controllerPackage) {
		this.controllerPackage = controllerPackage;
	}
	public String getEntityPackage() {
		return entityPackage;
	}
	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}
	
	public String getNameLowerFirstCharactor(){
		return this.entityName.substring(0,1).toLowerCase() + this.entityName.substring(1,this.entityName.length());
	}
	
	public String getUpcaseEntityName(){
		return this.entityName.toUpperCase();
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
}
