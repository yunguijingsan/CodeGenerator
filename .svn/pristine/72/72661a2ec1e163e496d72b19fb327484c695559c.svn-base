package com.codegentools.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codegentools.db.Column;
import com.codegentools.db.Table;

public class CodeGenUtils {
	/**
	 * 测试入口
	 * @param args
	 */
    public static void main(String args[]){
    	
    	CodeGenUtils codeGenUtils=new CodeGenUtils();
    	Config config=new Config();
    	try{
    		List<Table> tables=codeGenUtils.getAllTable(config);
    		PrintUtils.PrintList(tables);
        	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    
    }
    /**
     * 获取所有表信息
     * @param config
     * @return
     * @throws SQLException 
     */
    public List<Table> getAllTable(Config config) throws SQLException{
    	List<Table>  tables=new ArrayList<Table>();
    	Connection conn=getConnection(config);
    	//获取数据库元数据
    	DatabaseMetaData databaseMetaData =conn.getMetaData();
    	//组装表数据
    	getTables(databaseMetaData,config,tables);
    	getColumns(databaseMetaData,config,tables);
    	close(conn,null,null);
    	return tables;
    }
    /**
     * 根据配置获取连接信息
     * @param config
     * @return
     */
    public Connection getConnection(Config config){
    	Connection conn=null;
    	try{
    		Class.forName(config.getDriverClass());
    		conn=DriverManager.getConnection(config.getUrl(),config.getUserName(),config.getPassord());
    	}catch(Exception e){
    		throw new java.lang.NoClassDefFoundError("数据库实例化失败!");
    	}
    	
    	return conn;
    		
    }
    /**
     * 根据数据库元数据获取数据库的表
     * @throws SQLException 
     */
    private  void  getTables(DatabaseMetaData databaseMetaData,Config config,List<Table> tables) throws SQLException{
    	/* if(!CommonUtils.isListNotEmpty(tables)){
    	 	return;
    	 }*/
    	 ResultSet rs=databaseMetaData.getTables(config.getCatalog(), config.getSchema(), null, config.getTableType());
    	 //组装表的基本信息
    	 /**
    	  * 1.TABLE_CAT String => table catalog (may be null) 
            2.TABLE_SCHEM String => table schema (may be null) 
            3.TABLE_NAME String => table name 
            4.TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM". 
            5.REMARKS String => explanatory comment on the table 
            6.TYPE_CAT String => the types catalog (may be null) 
            7.TYPE_SCHEM String => the types schema (may be null) 
            8.TYPE_NAME String => type name (may be null) 
            9.SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null) 
            10.REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null) 

    	  */
    	 while(rs.next()){
    		 Table table=new Table();
    		 tables.add(table);
    		 //设置table基本属性
    		 table.setTableName(rs.getString("TABLE_NAME")==null?"":rs.getString("TABLE_NAME"));
    		 table.setTableRemark(rs.getString("REMARKS")==null?"":rs.getString("REMARKS"));
    		 table.setTableType(rs.getString("TABLE_TYPE")==null?"":rs.getString("TABLE_TYPE"));
    		 table.setTableSchema(rs.getString("TABLE_SCHEM")==null?config.getSchema():rs.getString("TABLE_SCHEM"));
    		 table.setTableCat(rs.getString("TABLE_CAT")==null?config.getCatalog():rs.getString("TABLE_CAT"));
    		 
    		 
    	 }
    	close(null,null,rs);
    }
    /**
     * 组装表下面的列信息
     * @param conn
     * @param tables
     * @throws SQLException 
     */
    private void getColumns(DatabaseMetaData databaseMetaData,Config config,List<Table> tables) throws SQLException{
    	/*if(!CommonUtils.isListNotEmpty(tables)){
    		return;
    	}*/
    	processColumns(databaseMetaData,tables);
    }
    private void processColumns(DatabaseMetaData databaseMetaData,List<Table> tables) throws SQLException{
    	for(int i=0;i<tables.size();i++){
    		Table table=tables.get(i);
    		ResultSet rs=databaseMetaData.getColumns(table.getTableCat(), table.getTableSchema(), table.getTableName(),null);
    		
    		//处理列信息
    		/**
    		 * Each column description has the following columns: 
				1.TABLE_CAT String => table catalog (may be null) 
				2.TABLE_SCHEM String => table schema (may be null) 
				3.TABLE_NAME String => table name 
				4.COLUMN_NAME String => column name 
				5.DATA_TYPE int => SQL type from java.sql.Types 
				6.TYPE_NAME String => Data source dependent type name, for a UDT the type name is fully qualified 
				7.COLUMN_SIZE int => column size. 
				8.BUFFER_LENGTH is not used. 
				9.DECIMAL_DIGITS int => the number of fractional digits. Null is returned for data types where DECIMAL_DIGITS is not applicable. 
				10.NUM_PREC_RADIX int => Radix (typically either 10 or 2) 
				11.NULLABLE int => is NULL allowed. 
				•columnNoNulls - might not allow NULL values 
				•columnNullable - definitely allows NULL values 
				•columnNullableUnknown - nullability unknown 
				12.REMARKS String => comment describing column (may be null) 
				13.COLUMN_DEF String => default value for the column, which should be interpreted as a string when the value is enclosed in single quotes (may be null) 
				14.SQL_DATA_TYPE int => unused 
				15.SQL_DATETIME_SUB int => unused 
				16.CHAR_OCTET_LENGTH int => for char types the maximum number of bytes in the column 
				17.ORDINAL_POSITION int => index of column in table (starting at 1) 
				18.IS_NULLABLE String => ISO rules are used to determine the nullability for a column. 
				•YES --- if the column can include NULLs 
				•NO --- if the column cannot include NULLs 
				•empty string --- if the nullability for the column is unknown 
				19.SCOPE_CATALOG String => catalog of table that is the scope of a reference attribute (null if DATA_TYPE isn't REF) 
				20.SCOPE_SCHEMA String => schema of table that is the scope of a reference attribute (null if the DATA_TYPE isn't REF) 
				21.SCOPE_TABLE String => table name that this the scope of a reference attribute (null if the DATA_TYPE isn't REF) 
				22.SOURCE_DATA_TYPE short => source type of a distinct type or user-generated Ref type, SQL type from java.sql.Types (null if DATA_TYPE isn't DISTINCT or user-generated REF) 
				23.IS_AUTOINCREMENT String => Indicates whether this column is auto incremented 
				•YES --- if the column is auto incremented 
				•NO --- if the column is not auto incremented 
				•empty string --- if it cannot be determined whether the column is auto incremented 
				24.IS_GENERATEDCOLUMN String => Indicates whether this is a generated column 
				•YES --- if this a generated column 
				•NO --- if this not a generated column 
				•empty string --- if it cannot be determined whether this is a generated column 

    		 */
    		while(rs.next()){
    		//	System.out.println("组装列");
    			//组装列信息
    			Column column=new Column();
    			table.getColumns().add(column);
    			column.setTableCat(rs.getString("TABLE_CAT")==null?"":rs.getString("TABLE_CAT"));
    			column.setTableSchem(rs.getString("TABLE_SCHEM")==null?"":rs.getString("TABLE_SCHEM"));
    			column.setTableName(rs.getString("TABLE_NAME")==null?"":rs.getString("TABLE_NAME"));
    			column.setColumnName(rs.getString("COLUMN_NAME")==null?"":rs.getString("COLUMN_NAME"));
    			column.setDataType(rs.getInt("DATA_TYPE"));
    			column.setTypeName(rs.getString("TYPE_NAME")==null?"":rs.getString("TYPE_NAME"));
    			column.setColumnSize(rs.getInt("COLUMN_SIZE"));
    			column.setNullAble(rs.getInt("NULLABLE"));
    			column.setRemarks(rs.getString("REMARKS")==null?"":rs.getString("REMARKS"));
    		}
    		 close(null,null,rs);
    		
    		
    	}
    }
    /**
     * 关闭数据库信息
     * @param conn
     * @param stmt
     * @param rs
     */
    public void close(Connection conn,Statement stmt,ResultSet rs){
    	try{
    		if(conn!=null){
    			conn.close();
    		}
    		if(stmt!=null){
    			stmt.close();
    		}
    		if(rs!=null){
    			rs.close();
    		}
    	}catch(Exception  ex ){
    	   ex.printStackTrace();	
    	}
    }
    
    
    
}
