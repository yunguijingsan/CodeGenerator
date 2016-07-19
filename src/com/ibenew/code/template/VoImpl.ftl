package ${params.voPackage};

import com.shine.core.exception.ServiceException;
import com.shine.core.utils.common.CommonUtils;
import ${params.entityBasePath}.${params.entityName};
import ${params.conditionPackage}.${params.entityName}Condition;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.ViewObjectImpl;
public class ${params.entityName}VOImpl extends ViewObjectImpl {
    public ${params.entityName}VOImpl() {
    }
    private final String seq${params.entityName}="BCS_WIP_PLAN_HEADER_S"; //TODO 填写相关的序列名;
    
    private Integer generateSeq(String seqName){
          SequenceImpl seq=new SequenceImpl(seqName,this.getDBTransaction());
          Integer seqNextval=seq.getSequenceNumber().intValue();
          return seqNextval;
    }
    public Row[] findByKey(Key pKey){
        Row [] rows=this.findByKey(pKey,-1);
        return rows; 
    } 
    public RowIterator findByAltKey(String columnName) {
        Key altKey = new Key(new Object[] { columnName});
        RowIterator iter = findByAltKey("ShortNameAltKey", altKey, -1, false);
        return iter;
    }
    public void update${params.entityName}(${params.entityName} ${params.nameLowerFirstCharactor}){
        Key key=new Key(new Object[]{/*TODO*/});
        this.setWhereClause(null);
        this.applyViewCriteria(null);
        this.executeQuery();
        Row [] rows=this.findByKey(key, 1);
        if(rows!=null&&rows.length>0){
            Row row = rows[0];
            //TODO
        }else{
            throw ServiceException.create("PUBLIC.ENTITY.NOT.FOUND");    
        }
    }
    public void create${params.entityName}(${params.entityName} ${params.nameLowerFirstCharactor}){
          Row row=this.createRow();
		  //TODO
    }
    
    public RowIterator search${params.entityName}(${params.entityName}Condition condition){
         this.setWhereClause(null);
         this.setOrderByClause(null);
         this.setFetchMode(FETCH_ALL);
         ViewCriteria vc=this.createViewCriteria();
         ViewCriteriaRow vcr=vc.createViewCriteriaRow();
         //查询条件设置 TODO
         vc.setViewObject(this);
         vc.add(vcr);
         this.executeQuery();
         RowIterator rowIterator = findByViewCriteria(vc, -1, ViewObject.QUERY_MODE_SCAN_VIEW_ROWS);
         return rowIterator;
    }
}

