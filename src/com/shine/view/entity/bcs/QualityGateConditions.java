package com.shine.view.entity.bcs;
// Generated by Hibernate Tools 3.4.0.CR1



/**
 *功能
 */
public class QualityGateConditions  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 public QualityGateConditions() {
		    
	 }
	 

	/**
	*Name:id
	*Comment:
	*/
	 private Integer  id;
	/**
	*Name:qgateId
	*Comment:
	*/
	 private Integer  qgateId;
	/**
	*Name:metricId
	*Comment:
	*/
	 private Integer  metricId;
	/**
	*Name:period
	*Comment:
	*/
	 private Integer  period;
	/**
	*Name:operator
	*Comment:
	*/
	 private String  operator;
	/**
	*Name:valueError
	*Comment:
	*/
	 private String  valueError;
	/**
	*Name:valueWarning
	*Comment:
	*/
	 private String  valueWarning;
	/**
	*Name:createdAt
	*Comment:
	*/
	 private java.util.Date  createdAt;
	/**
	*Name:updatedAt
	*Comment:
	*/
	 private java.util.Date  updatedAt;
   

   
	/**
	*Name:id
	*Comment:
	*/
    public Integer getId() {
        return this.id;
    }
    
	/**
	*Name:id
	*Comment:
	*/
    public void setId(Integer id) {
        this.id = id;
    }
	/**
	*Name:qgateId
	*Comment:
	*/
    public Integer getQgateId() {
        return this.qgateId;
    }
    
	/**
	*Name:qgateId
	*Comment:
	*/
    public void setQgateId(Integer qgateId) {
        this.qgateId = qgateId;
    }
	/**
	*Name:metricId
	*Comment:
	*/
    public Integer getMetricId() {
        return this.metricId;
    }
    
	/**
	*Name:metricId
	*Comment:
	*/
    public void setMetricId(Integer metricId) {
        this.metricId = metricId;
    }
	/**
	*Name:period
	*Comment:
	*/
    public Integer getPeriod() {
        return this.period;
    }
    
	/**
	*Name:period
	*Comment:
	*/
    public void setPeriod(Integer period) {
        this.period = period;
    }
	/**
	*Name:operator
	*Comment:
	*/
    public String getOperator() {
        return this.operator;
    }
    
	/**
	*Name:operator
	*Comment:
	*/
    public void setOperator(String operator) {
        this.operator = operator;
    }
	/**
	*Name:valueError
	*Comment:
	*/
    public String getValueError() {
        return this.valueError;
    }
    
	/**
	*Name:valueError
	*Comment:
	*/
    public void setValueError(String valueError) {
        this.valueError = valueError;
    }
	/**
	*Name:valueWarning
	*Comment:
	*/
    public String getValueWarning() {
        return this.valueWarning;
    }
    
	/**
	*Name:valueWarning
	*Comment:
	*/
    public void setValueWarning(String valueWarning) {
        this.valueWarning = valueWarning;
    }
	/**
	*Name:createdAt
	*Comment:
	*/
    public java.util.Date getCreatedAt() {
        return this.createdAt;
    }
    
	/**
	*Name:createdAt
	*Comment:
	*/
    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }
	/**
	*Name:updatedAt
	*Comment:
	*/
    public java.util.Date getUpdatedAt() {
        return this.updatedAt;
    }
    
	/**
	*Name:updatedAt
	*Comment:
	*/
    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
}


