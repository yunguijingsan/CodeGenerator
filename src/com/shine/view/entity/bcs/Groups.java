package com.shine.view.entity.bcs;
// Generated by Hibernate Tools 3.4.0.CR1



/**
 *功能
 */
public class Groups  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 public Groups() {
		    
	 }
	 

	/**
	*Name:id
	*Comment:
	*/
	 private Integer  id;
	/**
	*Name:name
	*Comment:
	*/
	 private String  name;
	/**
	*Name:description
	*Comment:
	*/
	 private String  description;
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
	*Name:name
	*Comment:
	*/
    public String getName() {
        return this.name;
    }
    
	/**
	*Name:name
	*Comment:
	*/
    public void setName(String name) {
        this.name = name;
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


