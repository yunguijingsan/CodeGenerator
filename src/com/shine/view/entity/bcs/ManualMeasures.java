package com.shine.view.entity.bcs;
// Generated by Hibernate Tools 3.4.0.CR1



/**
 *功能
 */
public class ManualMeasures  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 public ManualMeasures() {
		    
	 }
	 

	/**
	*Name:id
	*Comment:
	*/
	 private Long  id;
	/**
	*Name:metricId
	*Comment:
	*/
	 private Integer  metricId;
	/**
	*Name:value
	*Comment:
	*/
	 private java.math.BigDecimal  value;
	/**
	*Name:textValue
	*Comment:
	*/
	 private String  textValue;
	/**
	*Name:userLogin
	*Comment:
	*/
	 private String  userLogin;
	/**
	*Name:description
	*Comment:
	*/
	 private String  description;
	/**
	*Name:createdAt
	*Comment:
	*/
	 private Long  createdAt;
	/**
	*Name:updatedAt
	*Comment:
	*/
	 private Long  updatedAt;
	/**
	*Name:componentUuid
	*Comment:
	*/
	 private String  componentUuid;
   

   
	/**
	*Name:id
	*Comment:
	*/
    public Long getId() {
        return this.id;
    }
    
	/**
	*Name:id
	*Comment:
	*/
    public void setId(Long id) {
        this.id = id;
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
	*Name:value
	*Comment:
	*/
    public java.math.BigDecimal getValue() {
        return this.value;
    }
    
	/**
	*Name:value
	*Comment:
	*/
    public void setValue(java.math.BigDecimal value) {
        this.value = value;
    }
	/**
	*Name:textValue
	*Comment:
	*/
    public String getTextValue() {
        return this.textValue;
    }
    
	/**
	*Name:textValue
	*Comment:
	*/
    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }
	/**
	*Name:userLogin
	*Comment:
	*/
    public String getUserLogin() {
        return this.userLogin;
    }
    
	/**
	*Name:userLogin
	*Comment:
	*/
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
	/**
	*Name:description
	*Comment:
	*/
    public String getDescription() {
        return this.description;
    }
    
	/**
	*Name:description
	*Comment:
	*/
    public void setDescription(String description) {
        this.description = description;
    }
	/**
	*Name:createdAt
	*Comment:
	*/
    public Long getCreatedAt() {
        return this.createdAt;
    }
    
	/**
	*Name:createdAt
	*Comment:
	*/
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
	/**
	*Name:updatedAt
	*Comment:
	*/
    public Long getUpdatedAt() {
        return this.updatedAt;
    }
    
	/**
	*Name:updatedAt
	*Comment:
	*/
    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
	/**
	*Name:componentUuid
	*Comment:
	*/
    public String getComponentUuid() {
        return this.componentUuid;
    }
    
	/**
	*Name:componentUuid
	*Comment:
	*/
    public void setComponentUuid(String componentUuid) {
        this.componentUuid = componentUuid;
    }
    
}


