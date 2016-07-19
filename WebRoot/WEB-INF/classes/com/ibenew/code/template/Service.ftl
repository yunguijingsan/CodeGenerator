package ${params.servicePackage};

import com.shine.core.utils.page.Page;
import com.shine.view.service.BaseService;
import ${params.entityBasePath}.${params.entityName};
import ${params.conditionPackage}.${params.entityName}Condition;

public interface ${params.entityName}Service extends BaseService{

    public void add${params.entityName}(${params.entityName} ${params.nameLowerFirstCharactor});

    public ${params.entityName} find${params.entityName}ById(Integer id);

    public void update${params.entityName}(${params.entityName} ${params.nameLowerFirstCharactor});

    public Page<${params.entityName}> search${params.entityName}( ${params.entityName}Condition ${params.nameLowerFirstCharactor}Condition );
}