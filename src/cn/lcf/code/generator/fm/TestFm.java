package cn.lcf.code.generator.fm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.lcf.code.generator.fm.entity.CodeTemplateParams;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class TestFm {
	public static void main(String[] args) throws IOException, TemplateException{
		
	}
	
	@Test
	public void generateServiceImpl(){
		try {
			System.out.println(new File("template").getAbsolutePath());
			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.24) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			Configuration cfg = new Configuration(Configuration.getVersion());

			// Specify the source where the template files come from. Here I set a
			// plain directory for it, but non-file-system sources are possible too:
			cfg.setDirectoryForTemplateLoading(new File("template"));

			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");

			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
			cfg.setLogTemplateExceptions(false);
			// Create the root hash. We use a Map here, but it could be a JavaBean too.
			Map<String, Object> root = new HashMap<>();
			CodeTemplateParams params = new CodeTemplateParams();
			params.setProductCode("cg");
			params.setEntityName("Address");
			params.setEntityPackage("com.shine.entity.cg");
			params.setConditionPackage("com.shine.model.condition");
			params.setServicePackage("com.shine.view.service.cg");
			params.setDaoPackage("com.shine.dao.cg");
			Template temp = cfg.getTemplate("ServiceImpl.ftl");

			root.put("params", params);
			 Writer out = new OutputStreamWriter(new FileOutputStream("src/com/shine/view/service/cg/impl/AddressServiceImpl.java"),Charset.forName("UTF-8"));
			 temp.process(root, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void generateService(){
		try {
			System.out.println(new File("template").getAbsolutePath());
			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.24) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			Configuration cfg = new Configuration(Configuration.getVersion());

			// Specify the source where the template files come from. Here I set a
			// plain directory for it, but non-file-system sources are possible too:
			cfg.setDirectoryForTemplateLoading(new File("template"));

			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");

			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
			cfg.setLogTemplateExceptions(false);
			// Create the root hash. We use a Map here, but it could be a JavaBean too.
			Map<String, Object> root = new HashMap<>();
			CodeTemplateParams params = new CodeTemplateParams();
			params.setProductCode("cg");
			params.setEntityName("Address");
			params.setEntityPackage("com.shine.entity.cg");
			params.setConditionPackage("com.shine.model.condition");
			params.setServicePackage("com.shine.view.service.cg");
			params.setDaoPackage("com.shine.dao.cg");
			Template temp = cfg.getTemplate("Service.ftl");

			root.put("params", params);
			 Writer out = new OutputStreamWriter(new FileOutputStream("src/com/shine/view/service/cg/AddressService.java"),Charset.forName("UTF-8"));
			 temp.process(root, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void generate(CodeTemplateParams params,String templateName){
		try {
			System.out.println(new File("template").getAbsolutePath());
			// Create your Configuration instance, and specify if up to what FreeMarker
			// version (here 2.3.24) do you want to apply the fixes that are not 100%
			// backward-compatible. See the Configuration JavaDoc for details.
			Configuration cfg = new Configuration(Configuration.getVersion());

			// Specify the source where the template files come from. Here I set a
			// plain directory for it, but non-file-system sources are possible too:
			cfg.setDirectoryForTemplateLoading(new File("template"));

			// Set the preferred charset template files are stored in. UTF-8 is
			// a good choice in most applications:
			cfg.setDefaultEncoding("UTF-8");

			// Sets how errors will appear.
			// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			// Don't log exceptions inside FreeMarker that it will thrown at you anyway:
			cfg.setLogTemplateExceptions(false);
			// Create the root hash. We use a Map here, but it could be a JavaBean too.
			Map<String, Object> root = new HashMap<>();
			params.setProductCode("cg");
			params.setEntityName("Address");
			params.setEntityPackage("com.shine.entity.cg");
			params.setConditionPackage("com.shine.model.condition");
			params.setServicePackage("com.shine.view.service.cg");
			params.setDaoPackage("com.shine.dao.cg");
			Template temp = cfg.getTemplate("Service.ftl");

			root.put("params", params);
			 Writer out = new OutputStreamWriter(new FileOutputStream("src/com/shine/view/service/cg/AddressService.java"),Charset.forName("UTF-8"));
			 temp.process(root, out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
