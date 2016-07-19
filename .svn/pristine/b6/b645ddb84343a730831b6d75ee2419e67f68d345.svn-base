package com.ibenew.code.generator;

import com.ibenew.code.entity.CodeParams;

public class ConditionCodeImpl extends BaseCode{

	public ConditionCodeImpl(CodeParams params) {
		super(params);
	}

	@Override
	public void generateThis() {
		String filePath =params.getConditionAbsolutePath() + "/" + params.getEntityName() + "Condition.java"; 
		
		processTemplate("Condition.ftl", filePath);
	}

}
