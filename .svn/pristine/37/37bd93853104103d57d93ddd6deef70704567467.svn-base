package com.ibenew.code.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import com.ibenew.code.entity.CodeParams;
import com.ibenew.code.tools.DocumentUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public abstract class BaseCode {
	protected CodeParams params;
	private Configuration cfg;
	
	public BaseCode(CodeParams params){
		this.params = params;
	}

	public void generate() {
		try {

			// 创建配置实例
			cfg = new Configuration(Configuration.getVersion());
			// 指定模板文件的来源
			cfg.setDirectoryForTemplateLoading(new File("src/"
					+ DocumentUtil.getPathFromPackage(params
							.getTemplatePackage())));

			// 设置编码格式
			cfg.setDefaultEncoding("UTF-8");
			// 异常
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setLogTemplateExceptions(false);
			generateThis();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public abstract void generateThis();
	
	public void processTemplate(String tempalteName,String filePath){
		try {
			Map<String, Object> root = new HashMap<String, Object>();
			Template temp = cfg.getTemplate(tempalteName);
			root.put("params", params);
			File file = new File(filePath);
			DocumentUtil.initDir(file.getParent());
			Writer out = new OutputStreamWriter(new FileOutputStream(file),
					Charset.forName("UTF-8"));
			temp.process(root, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
