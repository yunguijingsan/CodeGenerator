package cn.lcf.code.generator.entity;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseFile {
	
	public static final String END_LINE = ";";
	public static final String PUBLIC = "public";
	public static final String TAB = "    ";
	public static final String SPACE = " ";
	public static final String NEW_LINE = "\n";
	public static final String VOID = "void";
	public static final String RESPONS_ERESULT="ResponseResult";
	public static final String RESPONS_BODY="@ResponseBody";
    	

	protected String basePath;

	protected String name;

	protected String suffix;

	protected String packageName;

	protected Set<String> extendsClass = new HashSet<String>();;

	protected Set<String> implementsInteface = new HashSet<String>();;

	protected Set<String> imports = new HashSet<String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Set<String> getImports() {
		return imports;
	}

	public void setImports(Set<String> imports) {
		this.imports = imports;
	}

	protected Set<String> getExtendsClass() {
		return extendsClass;
	}

	protected Set<String> getImplementsInteface() {
		return implementsInteface;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String packageNameToPath() {
		return this.packageName.replace(".", File.separator);
	}

	public String getDirPath() {
		return this.basePath + File.separator + this.packageNameToPath();
	}

	public String getFilePath() {
		return this.getDirPath() + File.separator + this.getName()
				+ this.getSuffix() + ".java";
	}

	public boolean isFileExists() {
		File file = new File(this.getDirPath());
		return file.exists();
	}

	public String getClassName() {
		return this.getName() + this.getSuffix();
	}

	public String getFileString() {
		StringBuffer sb = new StringBuffer();
		// 包
		sb.append(this.getPackageLine());
		// 导入包列表
		sb.append(this.getImportPackageLines());
		// 类注解
		sb.append(this.getAnnotations());
		// 类名第一行
		sb.append(this.getFirstLine());
		// 日志行
		sb.append(this.getLoggerLine());
		//属性
		sb.append(this.getPropertiesLine());
		// 方法列表
		sb.append(this.getDefaultMethods());
		sb.append(NEW_LINE);
		sb.append("}");
		return sb.toString();

	}

	public String getPropertiesLine() {
		return "";
	}

	public abstract String getLoggerLine();

	public abstract String getAnnotations();

	public String getDefaultMethods() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getAddMethod());
		sb.append(this.getFindByIdMethod());
		sb.append(this.getUpdateMethod());
		sb.append(this.getSearchMethod());
		return sb.toString();
	}

	public String getSearchMethod() {
		return NEW_LINE+
		NEW_LINE+
		TAB + PUBLIC + SPACE + "Page<" + this.name + ">" + SPACE
				+ "search" + this.name + "s()";
	}

	public String getFindByIdMethod() {
		return NEW_LINE + NEW_LINE + TAB + 
				PUBLIC + SPACE + this.name + SPACE + "find" + this.name + "ById(Integer id)";
	}

	public String getUpdateMethod() {
		return NEW_LINE + NEW_LINE + TAB + 
				PUBLIC + SPACE + VOID + SPACE + "update" + this.name + "("
						+ this.name + SPACE + this.name.substring(0, 1).toLowerCase()
						+ this.name.substring(1, this.name.length()) + ")";
	}

	public String getAddMethod() {
		return NEW_LINE +
		       NEW_LINE +
		       TAB + PUBLIC + SPACE + VOID + SPACE + "add" + this.name + "("
				+ this.name + SPACE + this.name.substring(0, 1).toLowerCase()
				+ this.name.substring(1, this.name.length()) + ")";
	}

	private Object getFirstLine() {
		return "public" + SPACE + this.getTypeString() + SPACE + this.name
				+ this.suffix + SPACE + this.getExtends()
				+ this.getImplements() + "{";
	}

	public String getExtends() {
		if (this.extendsClass.isEmpty()) {
			return "";
		}
		String result = SPACE + "extends" + SPACE;
		for (String str : this.extendsClass) {
			result += str + ",";
		}
		return result.substring(0, result.length() - 1);
	}

	private String getImplements() {
		if (this.implementsInteface.isEmpty()) {
			return "";
		}
		String result = SPACE + "implements" + SPACE;
		for (String str : this.implementsInteface) {
			result += str + ",";
		}
		return result.substring(0, result.length() - 1);
	}

	public abstract String getTypeString();

	private String getPackageLine() {
		return "package" + SPACE + this.packageName + END_LINE + NEW_LINE
				+ NEW_LINE;
	}

	private String getImportPackageLine(String packageName) {
		return "import" + SPACE + packageName + END_LINE + NEW_LINE;
	}

	private String getImportPackageLines() {
		String str = "";
		for (String packageName : this.getImports()) {
			str += this.getImportPackageLine(packageName);
		}
		return str + NEW_LINE;
	}

	public void addInterface(String in) {
		this.addImport(this.getPackageName().substring(0,
				this.packageName.lastIndexOf("."))
				+ "." + in);
		this.getImplementsInteface().add(in);
	}

	public void addImport(String string) {
		this.getImports().add(string);
	}
	
	public String getEmptyMethodBody(){
		return "{" + NEW_LINE+NEW_LINE+TAB+"}"; 
	}
	public String getNoMethodBody(){
		return ";";
	}

	public String getDefaultMethodBody() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getLowerFirstCharactor(String name){
		return name.substring(0,1).toLowerCase() + name.substring(1,name.length()); 
	}
	
	public String nameLowerFirstCharactor(){
		return this.name.substring(0,1).toLowerCase() + this.name.substring(1,this.name.length());
	}

}
