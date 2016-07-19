package ${params.daoPackage};

import com.shine.core.utils.page.Page;
import com.shine.dao.BaseDao;
import ${params.entityBasePath}.${params.entityName};
import ${params.conditionPackage}.${params.entityName}Condition;

public interface ${params.entityName}Dao extends BaseDao{

    public void add${params.entityName}(${params.entityName} ${params.nameLowerFirstCharactor});

    public ${params.entityName} find${params.entityName}ById(Integer id);

    public void update${params.entityName}(${params.entityName} ${params.nameLowerFirstCharactor});

    public Page<${params.entityName}> search${params.entityName}(${params.entityName}Condition ${params.nameLowerFirstCharactor}Condition);
}