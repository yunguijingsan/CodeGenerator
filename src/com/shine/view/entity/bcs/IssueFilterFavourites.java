package com.shine.view.entity.bcs;
// Generated by Hibernate Tools 3.4.0.CR1



/**
 *功能
 */
public class IssueFilterFavourites  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 public IssueFilterFavourites() {
		    
	 }
	 

	/**
	*Name:id
	*Comment:
	*/
	 private Integer  id;
	/**
	*Name:userLogin
	*Comment:
	*/
	 private String  userLogin;
	/**
	*Name:issueFilterId
	*Comment:
	*/
	 private Integer  issueFilterId;
	/**
	*Name:createdAt
	*Comment:
	*/
	 private java.util.Date  createdAt;
   

   
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
	*Name:issueFilterId
	*Comment:
	*/
    public Integer getIssueFilterId() {
        return this.issueFilterId;
    }
    
	/**
	*Name:issueFilterId
	*Comment:
	*/
    public void setIssueFilterId(Integer issueFilterId) {
        this.issueFilterId = issueFilterId;
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
    
}

