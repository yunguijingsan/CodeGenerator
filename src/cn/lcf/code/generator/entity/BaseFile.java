package cn.lcf.code.generator.entity;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseFile implements BaseConstants {

	protected String basePath;

	protected String name;

	protected String suffix;

	protected String packageName;

	private Set<String> extendsClass = new HashSet<String>();;

	private Set<String> implementsInteface = new HashSet<String>();;

	private Set<String> imports = new HashSet<String>();

	private Set<Method> methods = new HashSet<Method>();

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
		// 属性
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
		// sb.append(this.getAddMethod());
		// sb.append(this.getFindByIdMethod());
		// sb.append(this.getUpdateMethod());
		// sb.append(this.getSearchMethod());
		for (Method method : methods) {
			sb.append(method.toMethodString());
		}

		return sb.toString();
	}

	public Method getMethodSearch() {
		Method method = new Method();
		method.setName(METHOD_SEARCH + this.name + "s");
		method.setReturnObject("Page<" + this.name + ">");
		method.setModifier(PUBLIC);
		return method;
	}

	public Method getMethodFindById() {
		Method method = new Method();
		method.setName(METHOD_FIND + this.name + "ById");
		method.setReturnObject(this.name);
		method.setModifier(PUBLIC);
		method.addMethodParams("Integer", "id");
		return method;
	}

	public Method getMethodUpdate() {
		Method method = new Method();
		method.setName(METHOD_UPDATE + this.name);
		method.setReturnObject(VOID);
		method.setModifier(PUBLIC);
		method.addMethodParams(this.name, this.nameLowerFirstCharactor());
		return method;
	}

	public Method getMethodAdd() {
		Method method = new Method();
		method.setName(METHOD_ADD + this.name);
		method.setReturnObject(VOID);
		method.setModifier(PUBLIC);
		method.addMethodParams(this.name, this.nameLowerFirstCharactor());
		return method;
	}

	public String getSearchMethod() {
		return this.getMethodSearch().toMethodString();
	}

	public String getFindByIdMethod() {
		return this.getMethodFindById().toMethodString();
	}

	public String getUpdateMethod() {
		return this.getMethodUpdate().toMethodString();
	}

	public String getAddMethod() {
		return this.getMethodAdd().toMethodString();
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

	public void addImport(String importStr) {
		this.getImports().add(importStr);
	}

	public void addImplementsInteface(String in) {
		this.getImplementsInteface().add(in);
	}

	public String getEmptyMethodBody() {
		return "{" + NEW_LINE + NEW_LINE + TAB + "}";
	}

	public String getNoMethodBody() {
		return ";";
	}

	public String getLowerFirstCharactor(String name) {
		return name.substring(0, 1).toLowerCase()
				+ name.substring(1, name.length());
	}

	public String nameLowerFirstCharactor() {
		return this.name.substring(0, 1).toLowerCase()
				+ this.name.substring(1, this.name.length());
	}

	public void addMethod(Method method) {
		this.methods.add(method);
	}

	public abstract void addMethods();

	public String getDefaultMethodBody() {
		// TODO Auto-generated method stub
		return null;
	}
}
