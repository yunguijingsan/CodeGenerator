package com.codegentools.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.codegentools.app.VoBean;
import com.codegentools.db.Table;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 模板引擎工具类
 * @author yangquanhui
 *
 */
public class FreeMarkerUtils {
    public static List<String> generateVo(List<Table> tables,Config config) throws IOException{
    	List<String> generateVos=new ArrayList<String>();
        
        // Prepare the FreeMarker configuration;
        // - Load templates from the WEB-INF/templates directory of the Web app.
    	Configuration cfg= Configuration.getDefaultConfiguration();
    	File file=new File(config.getTemplateUrl());
        cfg.setDirectoryForTemplateLoading(file);
        cfg.setEncoding(Locale.CHINA,"UTF-8");
    	 // Build the data-model
        for(int i=0;i<tables.size();i++){
        	   Table table=tables.get(i);
        	   if(!CommonUtils.isObjectNotEmpty(table)){
        		   continue;
        	   }
        	   VoBean voBean=TableToVoUtils.CovertTableToVo(table);
        	   Map root = new HashMap();
               root.put("config", config);
               root.put("voBean", voBean);
               // Get the templat object
              Template t = cfg.getTemplate(config.getTemplateFileName());
              
              // Prepare the HTTP response:
              // - Use the charset of template for the output
              // - Use text/html MIME-type
              String targetDirectName=config.getPackagePath();
              File targetDirect=new File(targetDirectName);
              if(!targetDirect.exists()){
            	  targetDirect.mkdirs();
              }
              generateVos.add(voBean.getClassName());
              String targetFileName=config.getPackagePath()+File.separator+voBean.getClassName()+".java";
              
              Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFileName), t.getEncoding()));  
              // Merge the data-model and the template
              try {
                  t.process(root, out);
              } catch (TemplateException e) {
                  e.printStackTrace();
              }finally{
            	  out.close();
              }
        }
        return generateVos;
      
    }
    /**
     * 测试入口
     * @param args
     */
    public static void main(String args[]){
    	CodeGenUtils codeGenUtils=new CodeGenUtils();
    	Config config=new Config();
    /*	config.setDriverClass("oracle.jdbc.driver.OracleDriver");
    	config.setUrl("jdbc:oracle:thin:@localhost:1521:dev");
    	config.setUserName("SCOTT");
    	config.setPassord("SCOTT");
    	config.setCatalog("SCOTT");
    	config.setSchema("SCOTT");*/
    	try{
    		List<Table> tables=codeGenUtils.getAllTable(config);
    	    FreeMarkerUtils.generateVo(tables, config);
    		PrintUtils.PrintList(tables);
        	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }
}
