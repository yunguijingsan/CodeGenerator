package com.ibenew.code.generator;

import com.ibenew.code.entity.CodeParams;

public class ControllerCodeImpl extends BaseCode{

	public ControllerCodeImpl(CodeParams params) {
		super(params);
	}

	@Override
	public void generateThis() {		
		String filePath = params.getControllerAbsolutePath()+"/"+params.getEntityName()+"Controller.java"; 
		
		processTemplate("Controller.ftl", filePath);
	}

}
