package com.shine.view.entity.bcs;
// Generated by Hibernate Tools 3.4.0.CR1



/**
 *功能
 */
public class GroupRoles  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	 public GroupRoles() {
		    
	 }
	 

	/**
	*Name:id
	*Comment:
	*/
	 private Integer  id;
	/**
	*Name:groupId
	*Comment:
	*/
	 private Integer  groupId;
	/**
	*Name:resourceId
	*Comment:
	*/
	 private Integer  resourceId;
	/**
	*Name:role
	*Comment:
	*/
	 private String  role;
   

   
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
	*Name:groupId
	*Comment:
	*/
    public Integer getGroupId() {
        return this.groupId;
    }
    
	/**
	*Name:groupId
	*Comment:
	*/
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
	/**
	*Name:resourceId
	*Comment:
	*/
    public Integer getResourceId() {
        return this.resourceId;
    }
    
	/**
	*Name:resourceId
	*Comment:
	*/
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
	/**
	*Name:role
	*Comment:
	*/
    public String getRole() {
        return this.role;
    }
    
	/**
	*Name:role
	*Comment:
	*/
    public void setRole(String role) {
        this.role = role;
    }
    
}


