package cn.lcf.code.generator.entity;

public class InterfaceFile extends BaseFile{
	public InterfaceFile(){
		this.addImport("com.shine.core.utils.page.Page");
	}

	@Override
	public String getTypeString() {
		return "interface";
	}

	@Override
	public String getExtends() {
		return "";
	}

	@Override
	public String getAnnotations() {
		return "";
	}

	@Override
	public String getLoggerLine() {
		return "";
	}

	@Override
	public String getSearchMethod() {
		return super.getSearchMethod() + this.getNoMethodBody();
	}

	@Override
	public String getFindByIdMethod() {
		return super.getFindByIdMethod()+ this.getNoMethodBody();
	}

	@Override
	public String getUpdateMethod() {
		return super.getUpdateMethod()+ this.getNoMethodBody();
	}

	@Override
	public String getAddMethod() {
		return super.getAddMethod()+ this.getNoMethodBody();
	}

	@Override
	public void addMethods() {
		Method addMethod = super.getMethodAdd();
		addMethod.setMethodBody(this.getNoMethodBody());
		
		Method updateMethod = super.getMethodUpdate();
		updateMethod.setMethodBody(this.getNoMethodBody());
		
		Method searchMethod = super.getMethodSearch();
		searchMethod.setMethodBody(this.getNoMethodBody());
		
		Method findMethod = super.getMethodFindById();
		findMethod.setMethodBody(this.getNoMethodBody());
		
		super.addMethod(addMethod);
		super.addMethod(updateMethod);
		super.addMethod(searchMethod);
		super.addMethod(findMethod);
		
	}

	
}
