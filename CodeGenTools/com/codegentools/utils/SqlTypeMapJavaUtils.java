package com.codegentools.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据库类型与Java类型映射工具类
 * @author lenovo
 *
 */
public class SqlTypeMapJavaUtils {
   public static Map<String,String> typeMaps=new HashMap<String,String>();
   /**
    * 	BIGINT	java.lang.long	BIGINT	NUMBER (38, 0)	BIGINT	BIGINT	INT8	DK_CM_BIGINT
 	BINARY	byte[]	CHAR FOR BIT DATA	RAW	BINARY	IMAGE	BYTE	DK_CM_BLOB
 	BIT	java.lang.Boolean	N/A	BIT	BIT	BIT	BIT	DK_CM_SMALLINT
 	BLOB	byte[]	BLOB	BLOB	BLOB	BLOB	BLOB	DK_CM_BLOB
 	CHAR	java.lang.String	CHAR, GRAPHIC	CHAR	CHAR	CHAR	CHAR	DK_CM_CHAR
 	CLOB	java.lang.String	CLOB, DBCLOB	CLOB	CLOB	CLOB	CLOB	DK_CM_CLOB
 	DATE	java.sql.Date	DATE	DATE	DATE	DATE	DATE	DK_CM_DATE
 	DECIMAL	java.math.BigDecimal	DECIMAL	NUMBER	DECIMAL, MONEY, SMALLMONEY	DECIMAL	DECIMAL	DK_CM_DECIMAL
 	DOUBLE	java.lang.Double	DOUBLE	DOUBLE PRECISION	DOUBLE PRECISION	DOUBLE PRECISION	DOUBLE PRECISION	DK_CM_DOUBLE
 	FLOAT	java.lang.Double	FLOAT	FLOAT	FLOAT	FLOAT	FLOAT	DK_CM_DOUBLE
 	INTEGER	java.lang.Integer	INTEGER	INTEGER	INT	INTEGER	INTEGER	DK_CM_INTEGER
 	JAVA_OBJECT	java.lang.Object	JAVA_OBJECT	JAVA_OBJECT	JAVA_OBJECT	JAVA_OBJECT	OPAQUE	N/A
 	LONGVARBINARY	byte[]	LONG VARCHAR FOR BIT DATA	LONG RAW	IMAGE	IMAGE	BYTE	DK_CM_BLOB
 	LONGVARCHAR	java.lang.String	LONG VARCHAR, LONG VARGRAPHIC	LONG	TEXT	TEXT	TEXT	DK_CM_VARCHAR(3500)
 	NUMERIC	java.math.BigDecimal	NUMERIC	NUMBER	NUMERIC	NUMERIC	NUMERIC	DK_CM_DECIMAL
 	OTHER	java.lang.Object	OTHER	OTHER	OTHER	OTHER	OTHER	N/A
 	REAL	java.lang.Float	REAL	REAL	REAL	REAL	REAL	DK_CM_DOUBLE
 	SMALLINT	java.lang.Integer	SMALLINT	SMALLINT	SMALLINT	SMALLINT	SMALLINT	DK_CM_INTEGER
 	TIME	java.sql.Time	TIME	DATE	TIME	TIME	DATETIME HOUR TO SECOND	DK_CM_TIME
 	TIMESTAMP	java.sql.Timestamp	TIMESTAMP	DATE	DATETIME, SMALLDATETIME	DATETIME	DATETIME YEAR TO FRACTION (5)	DK_CM_TIMESTAMP
 	TINYINT	java.lang.Bute	SMALLINT	
    TINYINT
    TINYINT
    TINYINT	TINYINT	DK_CM_INTEGER
 	VARBINARY	byte[]	VARCHAR FOR BIT DATA	RAW	VARBINARY	IMAGE	BYTE	DK_CM_BLOB
 	VARCHAR	java.lang.String	VARCHAR, VARGRAPHIC	VARCHAR	VARCHAR	VARCHAR	VARCHAR	DK_CM_VARCHAR
    */
   static{
	   //BIGINT==>java.lang.Long
	   typeMaps.put("BIGINT", "Long");
	   //BINARY==>java.lang.Byte
	   typeMaps.put("BINARY","Byte []");
	   //BIT===>java.lang.Boolean
	   typeMaps.put("BIT", "Boolean");
	   //BLOB==>ava.lang.Byte
	   typeMaps.put("BLOB", "Byte []");
	   //CHAR==>ava.lang.String
	   typeMaps.put("CHAR", "String");
	   //CLOB==>java.lang.String
	   typeMaps.put("CLOB", "String");
	   //DATE==>java.util.Date
	   typeMaps.put("DATE", "Date");
	   //DECIMAL	java.math.BigDecimal
	   typeMaps.put("DECIMAL", "java.math.BigDecimal");
	   //DOUBLE	java.lang.Double
	   typeMaps.put("DOUBLE", "Double");
	   //FLOAT	java.lang.Double
	   typeMaps.put("FLOAT", "Double");
	   //INTEGER	java.lang.Integer
	   typeMaps.put("INTEGER", "Integer");
	   typeMaps.put("INT", "Integer");
	   //JAVA_OBJECT	java.lang.Object
	   typeMaps.put("JAVA_OBJECT", "Object");
	   //VARCHAR	java.lang.String
	   typeMaps.put("VARCHAR", "String");
	   
	   typeMaps.put("DATETIME", "java.util.Date");
	   
	   typeMaps.put("LONGTEXT", "String");
	   
	   typeMaps.put("LONGBLOB", "Byte[]");
	   typeMaps.put("TEXT", "String");
	   
   }
   /**
    * 通过数据库类型获得Java类型
    * @param key
    * @return
    */
   public static  String  getValue(String key){
	   StringBuffer buff=new StringBuffer();
	 /*  if(!CommonUtils.isStrNotEmpty(key)){
		   return buff.toString();
	   }*/
	   System.out.println("key:="+key+",value="+typeMaps.get(key));
	   buff.append(typeMaps.get(key));
	   return buff.toString();
   }
}
