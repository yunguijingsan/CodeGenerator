package com.ibenew.code.entity;

import java.util.List;

public class CodeParams {
	private String projectName;
	//实体类名称
	private String entityName;
	
	private String entityPackage;
	private String servicePackage;
	private String daoPackage;
	private String controllerPackage;	
	private String voPackage;
	private String conditionPackage;

	private String serviceAbsolutePath;
	private String daoAbsolutePath;
	private String controllerAbsolutePath;	
	private String conditionAbsolutePath;
	private String voAbsolutePath;

	

	private String conditionBasePath;
	private String entityBasePath;
	private String serviceBasePath;
	private String daoBasePath;
	private String controllerBasePath;
	private String voBasePath;

	
	//要生成的实体类名称
	private List<String> entities;
	//排除生成service
	private List<String> serviceExclude;
	//排除生成controller
	private List<String> controllerExclude;
	//排除生成dao
	private List<String> daoExclude;
	public List<String> voExclude;

	public String getConditionAbsolutePath() {
		return conditionAbsolutePath;
	}

	public void setConditionAbsolutePath(String conditionAbsolutePath) {
		this.conditionAbsolutePath = conditionAbsolutePath;
	}

	public List<String> getVoExclude() {
		return voExclude;
	}

	public void setVoExclude(List<String> voExclude) {
		this.voExclude = voExclude;
	}
	
	public String getEntityPackage() {
		return entityPackage;
	}

	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}

	private String templatePackage;
	
	
	public String getConditionPackage() {
		return conditionPackage;
	}

	public void setConditionPackage(String conditionPackage) {
		this.conditionPackage = conditionPackage;
	}

	public String getServiceAbsolutePath() {
		return serviceAbsolutePath;
	}
	public void setServiceAbsolutePath(String serviceAbsolutePath) {
		this.serviceAbsolutePath = serviceAbsolutePath;
	}
	public String getDaoAbsolutePath() {
		return daoAbsolutePath;
	}
	public void setDaoAbsolutePath(String daoAbsolutePath) {
		this.daoAbsolutePath = daoAbsolutePath;
	}
	public String getControllerAbsolutePath() {
		return controllerAbsolutePath;
	}
	public void setControllerAbsolutePath(String controllerAbsolutePath) {
		this.controllerAbsolutePath = controllerAbsolutePath;
	}
	public List<String> getEntities() {
		return entities;
	}
	public void setEntities(List<String> entities) {
		this.entities = entities;
	}
	public List<String> getServiceExclude() {
		return serviceExclude;
	}
	public void setServiceExclude(List<String> serviceExclude) {
		this.serviceExclude = serviceExclude;
	}
	public List<String> getControllerExclude() {
		return controllerExclude;
	}
	public void setControllerExclude(List<String> controllerExclude) {
		this.controllerExclude = controllerExclude;
	}
	public List<String> getDaoExclude() {
		return daoExclude;
	}
	public void setDaoExclude(List<String> daoExclude) {
		this.daoExclude = daoExclude;
	}
	public String getConditionBasePath() {
		return conditionBasePath;
	}
	public void setConditionBasePath(String conditionBasePath) {
		this.conditionBasePath = conditionBasePath;
	}
	public String getEntityBasePath() {
		return entityBasePath;
	}
	public void setEntityBasePath(String entityBasePath) {
		this.entityBasePath = entityBasePath;
	}
	public String getServiceBasePath() {
		return serviceBasePath;
	}
	public void setServiceBasePath(String serviceBasePath) {
		this.serviceBasePath = serviceBasePath;
	}
	public String getDaoBasePath() {
		return daoBasePath;
	}
	public void setDaoBasePath(String daoBasePath) {
		this.daoBasePath = daoBasePath;
	}
	public String getControllerBasePath() {
		return controllerBasePath;
	}
	public void setControllerBasePath(String controllerBasePath) {
		this.controllerBasePath = controllerBasePath;
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
	public String getNameLowerFirstCharactor(){
		return this.entityName.substring(0,1).toLowerCase() + this.entityName.substring(1,this.entityName.length());
	}
	public String getUpcaseEntityName(){
		return this.entityName.toUpperCase();
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTemplatePackage() {
		return templatePackage;
	}
	public void setTemplatePackage(String templatePackage) {
		this.templatePackage = templatePackage;
	}
	
	public String getVoAbsolutePath() {
		return voAbsolutePath;
	}
	public void setVoAbsolutePath(String voAbsolutePath) {
		this.voAbsolutePath = voAbsolutePath;
	}
	public String getVoPackage() {
		return voPackage;
	}
	public void setVoPackage(String voPackage) {
		this.voPackage = voPackage;
	}
	public String getVoBasePath() {
		return voBasePath;
	}
	public void setVoBasePath(String voBasePath) {
		this.voBasePath = voBasePath;
	}
	@Override
	public String toString() {
		return "CodeParams [entityName=" + entityName + ", projectName="
				+ projectName + ", serviceAbsolutePath=" + serviceAbsolutePath
				+ ", daoAbsolutePath=" + daoAbsolutePath
				+ ", controllerAbsolutePath=" + controllerAbsolutePath
				+ ", servicePackage=" + servicePackage + ", daoPackage="
				+ daoPackage + ", controllerPackage=" + controllerPackage
				+ ", conditionBasePath=" + conditionBasePath
				+ ", entityBasePath=" + entityBasePath + ", serviceBasePath="
				+ serviceBasePath + ", daoBasePath=" + daoBasePath
				+ ", controllerBasePath=" + controllerBasePath + ", entities="
				+ entities + ", serviceExclude=" + serviceExclude
				+ ", controllerExclude=" + controllerExclude + ", daoExclude="
				+ daoExclude + ", templatePackage=" + templatePackage + "]";
	}
	
}
