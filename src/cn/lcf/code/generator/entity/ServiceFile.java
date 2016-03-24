package cn.lcf.code.generator.entity;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class ServiceFile extends ClassFile{
	public ServiceFile(){
		this.addImport("org.springframework.stereotype.Service");
	}

	@Override
	public String getAnnotations() {
		return NEW_LINE+"@Service" + NEW_LINE;
	}

	@Override
	public String getSearchMethod() {
		return super.getSearchMethod() + this.getSearchMethodBody();
	}


	@Override
	public String getFindByIdMethod() {
		return super.getFindByIdMethod() + this.getFindByIdMethodBody();
	}

	@Override
	public String getUpdateMethod() {
		return super.getUpdateMethod() + this.getUpdateMethodBody();
	}

	@Override
	public String getAddMethod() {
		return super.getAddMethod() + this.getAddMethodBody();
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

	
}
