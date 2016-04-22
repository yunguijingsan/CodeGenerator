package cn.lcf.code.generator.entity;


public class ServiceFile extends ClassFile{
	public ServiceFile(){
		this.addImport("org.springframework.stereotype.Service");
	}

	@Override
	public String getAnnotations() {
		return NEW_LINE+"@Service" + NEW_LINE;
	}

	
	@Override
	public String getPropertiesLine() {
		return NEW_LINE + TAB + "private" + SPACE + this.name + "Dao"
				+ SPACE + nameLowerFirstCharactor() + "Dao;";
	}
	
	public String getAddMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + this.nameLowerFirstCharactor()
				+ "Dao.add" + this.name + "("
				+ this.nameLowerFirstCharactor() + ");"
				+ NEW_LINE + TAB + "}";
	}
	public String getUpdateMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + this.nameLowerFirstCharactor()
				+ "Dao.update" + this.name + "("
				+ this.nameLowerFirstCharactor() + ");" 
				+ NEW_LINE + TAB + "}";
	}

	public String getFindByIdMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + this.name +SPACE+ this.nameLowerFirstCharactor() +"="+ this.nameLowerFirstCharactor()
				+ "Dao.find" + this.name + "ById(id);" + NEW_LINE + TAB
				+ TAB + "return" + SPACE
				+ this.nameLowerFirstCharactor() + ";" + NEW_LINE + TAB + "}";
	}

	public String getSearchMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + "Page<"+this.name+"> "+this.nameLowerFirstCharactor()+"s = " +this.nameLowerFirstCharactor()
				+ "Dao.search" + this.name + "s();" + NEW_LINE + TAB + TAB
				+ "return "+ this.nameLowerFirstCharactor()+"s;" + NEW_LINE + TAB + "}";
	}

	@Override
	public void addMethods() {
		Method addMethod = super.getMethodAdd();
		addMethod.setMethodBody(this.getAddMethodBody());
		
		Method updateMethod = super.getMethodUpdate();
		updateMethod.setMethodBody(this.getUpdateMethodBody());
		
		Method searchMethod = super.getMethodSearch();
		searchMethod.setMethodBody(this.getSearchMethodBody());
		
		Method findMethod = super.getMethodFindById();
		findMethod.setMethodBody(this.getFindByIdMethodBody());
		
		Method applyMethod = new Method();
		applyMethod.setModifier(PUBLIC);
		applyMethod.setName("apply");
		applyMethod.setReturnObject(VOID);
		applyMethod.setMethodBody(this.getApplyMethodBody());
		applyMethod.addAnnotation("@Override");
		
		super.addMethod(addMethod);
		super.addMethod(updateMethod);
		super.addMethod(searchMethod);
		super.addMethod(findMethod);
		super.addMethod(applyMethod);
	}

	private String getApplyMethodBody() {
		 return "{ " + NEW_LINE + TAB + TAB + this.nameLowerFirstCharactor()
			+ "Dao.apply();" 
			+ NEW_LINE + TAB + "}";
	}

}
