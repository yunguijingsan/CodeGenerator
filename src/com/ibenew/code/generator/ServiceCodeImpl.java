package com.ibenew.code.generator;

import com.ibenew.code.entity.CodeParams;

public class ServiceCodeImpl extends BaseCode {

	public ServiceCodeImpl(CodeParams params) {
		super(params);
	}

	@Override
	public void generateThis() {
		String filePath =params.getServiceAbsolutePath() + "/" + params.getEntityName() + "Service.java"; 
		
		processTemplate("Service.ftl", filePath);
		
		this.generateThisImpl();
	}
	
	public void generateThisImpl() {
		String filePath =params.getServiceAbsolutePath() + "/impl/" + params.getEntityName() + "ServiceImpl.java"; 
		
		processTemplate("ServiceImpl.ftl", filePath);
	}
	

}
