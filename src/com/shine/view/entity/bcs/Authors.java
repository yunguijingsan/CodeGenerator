package com.shine.view.entity.bcs;
// Generated by Hibernate Tools 3.4.0.CR1



/**
 *功能
 */
public class Authors  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 public Authors() {
		    
	 }
	 

	/**
	*Name:id
	*Comment:
	*/
	 private Integer  id;
	/**
	*Name:personId
	*Comment:
	*/
	 private Integer  personId;
	/**
	*Name:login
	*Comment:
	*/
	 private String  login;
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
	*Name:personId
	*Comment:
	*/
    public Integer getPersonId() {
        return this.personId;
    }
    
	/**
	*Name:personId
	*Comment:
	*/
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
	/**
	*Name:login
	*Comment:
	*/
    public String getLogin() {
        return this.login;
    }
    
	/**
	*Name:login
	*Comment:
	*/
    public void setLogin(String login) {
        this.login = login;
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


