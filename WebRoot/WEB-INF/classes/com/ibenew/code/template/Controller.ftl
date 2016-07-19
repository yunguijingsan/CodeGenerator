package ${params.controllerPackage};

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shine.core.utils.page.Page;
import com.shine.core.exception.ResponseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ${params.entityBasePath}.${params.entityName};
import ${params.servicePackage}.${params.entityName}Service;
import ${params.conditionPackage}.${params.entityName}Condition;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/resources/${"${params.projectName}"?uncap_first}/${"${params.entityName}"?uncap_first}")
public class ${params.entityName}Controller{

    @Autowired
    private ${params.entityName}Service ${"${params.entityName}Service"?uncap_first};

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    public ResponseResult add${params.entityName}(@RequestBody ${params.entityName} ${params.nameLowerFirstCharactor}){
    	${params.nameLowerFirstCharactor}Service.add${params.entityName}(${params.nameLowerFirstCharactor});
	 	return ResponseResult.createSuccess(${params.nameLowerFirstCharactor});
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.GET)
    public ResponseResult find${params.entityName}ById(Integer id){
    	${params.entityName} ${params.nameLowerFirstCharactor} = ${"${params.entityName}Service"?uncap_first}.find${params.entityName}ById(id);
    	return ResponseResult.createSuccess(${params.nameLowerFirstCharactor});
    }

    @ResponseBody
    @RequestMapping(method=RequestMethod.PUT)
    public ResponseResult update${params.entityName}(@RequestBody ${params.entityName} ${params.nameLowerFirstCharactor}){
    	${"${params.entityName}Service"?uncap_first}.update${params.entityName}(${params.nameLowerFirstCharactor});
    	return ResponseResult.createSuccess(${params.nameLowerFirstCharactor});
    }

    @ResponseBody
    @RequestMapping(value="search",method=RequestMethod.GET)
    public ResponseResult search${params.entityName}(${params.entityName}Condition condition){
        Page<${params.entityName}> ${params.nameLowerFirstCharactor} = ${"${params.entityName}Service"?uncap_first}.search${params.entityName}(condition);
        return ResponseResult.createSuccess(${params.nameLowerFirstCharactor});
    }
}