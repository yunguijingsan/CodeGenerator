package cn.lcf.code.generator.entity;

public class ControllerFile extends ClassFile {

	public ControllerFile() {
		this.addImport("org.springframework.beans.factory.annotation.Autowired");
		this.addImport("org.springframework.stereotype.Controller");
		this.addImport("org.springframework.web.bind.annotation.RequestMapping");
		this.addImport("org.springframework.web.bind.annotation.RequestMethod");
		this.addImport("org.springframework.web.bind.annotation.RequestBody");
		this.addImport("org.springframework.web.bind.annotation.ResponseBody");
		this.addImport("com.shine.core.exception.ResponseResult");
	}

	@Override
	public String getAnnotations() {
		return NEW_LINE + "@Controller" + NEW_LINE
				+ "@RequestMapping(\""+this.getUrl() + this.nameLowerFirstCharactor() + "\")"
				+ NEW_LINE;
	}

	@Override
	public String getSearchMethod() {
		return NEW_LINE + NEW_LINE + getSearchMethodAnnotation() + NEW_LINE
				+ TAB + PUBLIC + SPACE + RESPONS_ERESULT + SPACE + "search"
				+ this.name + "s()" + this.getSearchMethodBody();
	}

	@Override
	public String getFindByIdMethod() {
		return NEW_LINE + this.getFindByIdMethodAnnotation() + NEW_LINE + TAB
				+ PUBLIC + SPACE + RESPONS_ERESULT + SPACE + "find" + this.name
				+ "ById(Integer id)" + this.getFindByIdMethodBody();
	}

	@Override
	public String getUpdateMethod() {
		return NEW_LINE + this.getUpdateMethodAnnotation() + NEW_LINE + TAB
				+ PUBLIC + SPACE + RESPONS_ERESULT + SPACE + "update"
				+ this.name + "(@RequestBody " + this.name + SPACE
				+ this.name.substring(0, 1).toLowerCase()
				+ this.name.substring(1, this.name.length()) + ")"
				+ this.getUpdateMethodBody();
	}

	@Override
	public String getAddMethod() {
		return NEW_LINE + getAddMethodAnnotation() + NEW_LINE + TAB + PUBLIC
				+ SPACE + RESPONS_ERESULT + SPACE + "add" + this.name + "(@RequestBody "
				+ this.name + SPACE + this.name.substring(0, 1).toLowerCase()
				+ this.name.substring(1, this.name.length()) + ")"
				+ this.getAddMethodBody();
	}

	public String getAddMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + this.nameLowerFirstCharactor()
				+ "Service.add" + this.name + "("
				+ this.nameLowerFirstCharactor() + ");" + NEW_LINE + TAB + TAB
				+ "return ResponseResult.createSuccess("
				+ this.nameLowerFirstCharactor() + ");" + NEW_LINE + TAB + "}";
	}
	
	@Override
	public String getDefaultMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB
				+ "return ResponseResult.createSuccess();" + NEW_LINE + TAB
				+ "}";
	}
	public String getUpdateMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + this.nameLowerFirstCharactor()
				+ "Service.update" + this.name + "("
				+ this.nameLowerFirstCharactor() + ");" + NEW_LINE + TAB + TAB
				+ "return ResponseResult.createSuccess("
				+ this.nameLowerFirstCharactor() + ");" + NEW_LINE + TAB + "}";
	}

	public String getFindByIdMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + this.name +SPACE+ this.nameLowerFirstCharactor() +"="+ this.nameLowerFirstCharactor()
				+ "Service.find" + this.name + "ById(id);" + NEW_LINE + TAB
				+ TAB + "return ResponseResult.createSuccess("
				+ this.nameLowerFirstCharactor() + ");" + NEW_LINE + TAB + "}";
	}

	public String getSearchMethodBody() {
		return "{ " + NEW_LINE + TAB + TAB + "Page<"+this.name+"> "+this.nameLowerFirstCharactor()+"s = " +this.nameLowerFirstCharactor()
				+ "Service.search" + this.name + "s();" + NEW_LINE + TAB + TAB
				+ "return ResponseResult.createSuccess("
				+ this.nameLowerFirstCharactor() + "s);" + NEW_LINE + TAB + "}";
	}

	public String getSearchMethodAnnotation() {
		return NEW_LINE + TAB + RESPONS_BODY + NEW_LINE + TAB
				+ "@RequestMapping(value=\"search\",method=RequestMethod.GET)";
	}

	public String getRequestMapping(String type) {
		return "@RequestMapping(method=RequestMethod." + type + ")";
	}

	public String getFindByIdMethodAnnotation() {
		return NEW_LINE + TAB + RESPONS_BODY + NEW_LINE + TAB
				+ getRequestMapping("GET");
	}

	public String getUpdateMethodAnnotation() {
		return NEW_LINE + TAB + RESPONS_BODY + NEW_LINE + TAB
				+ getRequestMapping("PUT");
	}

	public String getAddMethodAnnotation() {
		return NEW_LINE + TAB + RESPONS_BODY + NEW_LINE + TAB
				+ getRequestMapping("POST");
	}

	@Override
	public String getPropertiesLine() {
		return NEW_LINE + TAB + "@Autowired"+
			   NEW_LINE + TAB + "private" + SPACE + this.name + "Service"
				+ SPACE + nameLowerFirstCharactor() + "Service;";
	}

	private ServiceFile serviceFile;

	public ServiceFile getServiceFile() {
		return serviceFile;
	}

	public void setServiceFile(ServiceFile serviceFile) {
		this.serviceFile = serviceFile;
	}
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	


}
