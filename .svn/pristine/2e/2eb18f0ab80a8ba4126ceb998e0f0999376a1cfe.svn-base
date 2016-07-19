package com.codegentools.utils;

import java.util.List;

import com.codegentools.app.VoBean;
import com.codegentools.app.VoProperty;
import com.codegentools.db.Column;
import com.codegentools.db.Table;

/**
 * 表对象转换为Vo模板请求对象
 * @author lenovo
 *
 */
public class TableToVoUtils {

	public static VoBean  CovertTableToVo(Table table){
		 VoBean voBean=new VoBean();
		voBean.setClassName(table.getTableName());
		voBean.setRemarks(table.getTableRemark());
		 CovertColumnToVoProperty( table, voBean);
		return voBean;
	}
	public static void CovertColumnToVoProperty(Table table,VoBean voBean){
		if(!CommonUtils.isObjectNotEmpty(table.getColumns())){
			return;
		}
		List<Column>  columns=table.getColumns();
		for(int i=0;i<columns.size();i++){
			Column column=columns.get(i);
			if(!CommonUtils.isObjectNotEmpty(column)){
			   continue;
			}
			VoProperty voProperty=new VoProperty();
			voBean.getVoPropertys().add(voProperty);
			voProperty.setJavaMethodName(column.getColumnName());
			voProperty.setJavaPropertyName(column.getColumnName());
	        System.out.println(column.getTypeName());
			voProperty.setJavaType(column.getTypeName());
			voProperty.setJavaRemarks(column.getRemarks());
			
		}
	}
}
