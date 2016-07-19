package com.ibenew.code.generator;

import com.ibenew.code.entity.CodeParams;

public class DaoCodeImpl extends BaseCode{

	public DaoCodeImpl(CodeParams params) {
		super(params);
	}

	@Override
	public void generateThis() {
		String filePath =params.getDaoAbsolutePath() + "/" + params.getEntityName() + "Dao.java"; 
		
		processTemplate("Dao.ftl", filePath);
	}

}
