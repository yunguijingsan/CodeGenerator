package com.codegentools.db;
/**
 * ��ݿ���ж���
 * @author yangquanhui
 *
 */
public class Column {
    private String tableCat;
    
    private String tableSchem;
    
    private String tableName;
    
    private String columnName;
    
    private Integer dataType;
    
    private String typeName;
    
    private Integer columnSize;
    
    private int nullAble;
    
    private String remarks;

	public String getTableCat() {
		return tableCat;
	}

	public void setTableCat(String tableCat) {
		this.tableCat = tableCat;
	}

	public String getTableSchem() {
		return tableSchem;
	}

	public void setTableSchem(String tableSchem) {
		this.tableSchem = tableSchem;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}

	public int getNullAble() {
		return nullAble;
	}

	public void setNullAble(int nullAble) {
		this.nullAble = nullAble;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
    
    
	public String toString(){
		 StringBuffer buff=new StringBuffer();
		 buff.append("\n");
		 buff.append("[\n");
		 buff.append("tableCat").append(":").append(tableCat).append("\n");
		 buff.append("tableSchem").append(":").append(tableSchem).append("\n");
		 buff.append("tableName").append(":").append(tableName).append("\n");
		 buff.append("columnName").append(":").append(columnName).append("\n");
		 buff.append("dataType").append(":").append(dataType).append("\n");
		 buff.append("typeName").append(":").append(typeName).append("\n");
		 buff.append("columnSize").append(":").append(columnSize).append("\n");
		 buff.append("nullAble").append(":").append(nullAble).append("\n");
		 buff.append("remarks").append(":").append(remarks).append("\n");
		 buff.append("]");
		 return buff.toString();
		
	}
    
    
}
