package com.ibenew.code.generator;

import com.ibenew.code.entity.CodeParams;

public class VoCodeImpl extends BaseCode {

	public VoCodeImpl(CodeParams params) {
		super(params);
	}

	@Override
	public void generateThis() {
		String filePath =params.getVoAbsolutePath() + "/" + params.getEntityName() + "VOImpl.java"; 
		
		processTemplate("VoImpl.ftl", filePath);
				
	}

}
