package com.codegentools.db;

import java.util.ArrayList;
import java.util.List;

/**
 *��ݿ����Ϣ
 * @author yangquanhui
 *
 */
public class Table {
    private String tableName;
    
    private String tableRemark;
    
    private String tableType;
    
    private String tableCat;
    
    private String tableSchema;
    
    private List<Column>  columns=new ArrayList<Column>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableRemark() {
		return tableRemark;
	}

	public void setTableRemark(String tableRemark) {
		this.tableRemark = tableRemark;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getTableCat() {
		return tableCat;
	}

	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}

	public String getTableSchema() {
		return tableSchema;
	}

	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	
    
    
	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

   public String toString(){
		StringBuffer buff=new StringBuffer();
		buff.append(tableName+"表信息").append("\n");
		buff.append("[\n");
		buff.append("tableName").append(":").append(tableName).append("\n");
		buff.append("tableRemark").append(":").append(tableRemark).append("\n");
		buff.append("tableType").append(":").append(tableType).append("\n");
		buff.append("tableCat").append(":").append(tableCat).append("\n");
		buff.append("tableSchema").append(":").append(tableSchema).append("\n");
		buff.append("]");
		buff.append("\n"+tableName+"表列信息").append("\n{");
		for(int i=0;i<columns.size();i++){
			buff.append(columns.get(i));
		}
		buff.append("\n}");
		return buff.toString();
	}
    
	
	
    
}
