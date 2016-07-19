package com.codegentools.utils;
/**
 * ��������Ϣ
 * @author yangquanhui
 *
 */
public class Config {

	private String driverClass="com.mysql.jdbc.Driver";
	
	private String  url="jdbc:mysql://localhost:3306/sonar?useUnicode=true&amp;characterEncoding=UTF-8";
	
	private String userName="root";
	
	private String passord="root";
	
    private String packageName="com.view.entity";
    
    private String packagePath="D:\\Work\\CODEProject\\CodeGenTools\\com\\view\\entity";
    
    private String templateUrl="D:\\Work\\CODEProject\\CodeGenTools\\com\\codegentools\\template";
    
    private String templateFileName="vo.ftl";
    
    
	private String  catalog="";
	
	private String  schema="";
	
	private String[] tableType=new String[]{"TABLE"};

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String[] getTableType() {
		return tableType;
	}

	public void setTableType(String[] tableType) {
		this.tableType = tableType;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public String getTemplateFileName() {
		return templateFileName;
	}

	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}
	
	
	
	
}
