package ${params.servicePackage}.impl;

import com.shine.core.exception.ServiceException;
import com.shine.core.utils.common.CommonUtils;
import org.springframework.stereotype.Service;
import com.shine.core.utils.page.Page;
import org.apache.log4j.Logger;
import ${params.daoPackage}.${params.entityName}Dao;
import ${params.entityBasePath}.${params.entityName};
import ${params.conditionPackage}.${params.entityName}Condition;
import  ${params.servicePackage}.${params.entityName}Service;
import com.shine.view.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ${params.entityName}ServiceImpl  implements ${params.entityName}Service{
    private static Logger logger = Logger.getLogger(${params.entityName}ServiceImpl.class);

    @Autowired
    private ${params.entityName}Dao  ${params.nameLowerFirstCharactor}Dao;

    public void add${params.entityName}(${params.entityName}  ${params.nameLowerFirstCharactor}){ 
        validate( ${params.nameLowerFirstCharactor});
        try{
        	${params.nameLowerFirstCharactor}Dao.add${params.entityName}(${params.nameLowerFirstCharactor});
        }catch(Exception e){
            CommonUtils.printStackTraceInfo(logger, e);
            throw ServiceException.create("${params.upcaseEntityName}.ADD.FAIL");
        }
         
    }

    public ${params.entityName}  find${params.entityName}ById(Integer id){ 
        validateId(id);
        ${params.entityName} ${params.nameLowerFirstCharactor};
        try {
            ${params.nameLowerFirstCharactor}= ${params.nameLowerFirstCharactor}Dao.find${params.entityName}ById(id);
        } catch (Exception e) {
            CommonUtils.printStackTraceInfo(logger, e);
            throw ServiceException.create("${params.upcaseEntityName}.FIND.IS.FALL");
        }
        
        return ${params.nameLowerFirstCharactor};
    }

    public void update${params.entityName}( ${params.entityName} ${params.nameLowerFirstCharactor}){ 
        validateId(1);//TODO
        validate(${params.nameLowerFirstCharactor});
        try {
             ${params.nameLowerFirstCharactor}Dao.update${params.entityName}( ${params.nameLowerFirstCharactor});
        } catch (Exception e) {
            CommonUtils.printStackTraceInfo(logger, e);
            throw ServiceException.create("${params.upcaseEntityName}.UPDATE.FAIL");
        }
    }

    public Page<${params.entityName}> search${params.entityName}(${params.entityName}Condition ${params.nameLowerFirstCharactor}Condition){ 
    	Page<${params.entityName}>  ${params.nameLowerFirstCharactor}s;
    	try {
            ${params.nameLowerFirstCharactor}s =  ${params.nameLowerFirstCharactor}Dao.search${params.entityName}(${params.nameLowerFirstCharactor}Condition);
        } catch (Exception e) {
          CommonUtils.printStackTraceInfo(logger, e);
          throw ServiceException.create("${params.upcaseEntityName}.SEARCH.FAIL");
        }
        return  ${params.nameLowerFirstCharactor}s;
    }

    private void validate(${params.entityName}  ${params.nameLowerFirstCharactor}) {
        if ( ${params.nameLowerFirstCharactor} == null) {
            throw ServiceException.create("${params.upcaseEntityName}.IS.NULL");
        }
    }

    private void validateId(Integer id) {
        if (id == null) {
            throw ServiceException.create("${params.upcaseEntityName}.ID.IS.NULL");
        }
    }

    public void apply() {
         ${params.nameLowerFirstCharactor}Dao.apply();
    }
}