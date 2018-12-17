package com.luv2code.springsecurity.demo.entity;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name="userdetails")
@Table(name="userdetails")

/*@SqlResultSetMapping(
        name = "UserDetailsMapping",
        entities = { 
        		@EntityResult(
        		entityClass = UserDetails.class,
        		fields = {
        	        @FieldResult(name = "username", column = "username"),
        	        @FieldResult(name = "emailid",column="emailid")})})*/

/*@SqlResultSetMapping(
        name = "UserDetailsMapping",
        entities = { 
        		@EntityResult(
        		entityClass = UserDetails.class,
        		fields = {
        	        @FieldResult(name = "username", column = "username"),
        	        @FieldResult(name = "emailid",column="emailid")}),
        @EntityResult(
                entityClass = Authorities.class,
                fields = {
                	@FieldResult(name = "authority", column="authority")})})*/
public class UserDetails {

	@Id @GeneratedValue
	private int userauthid;
	
	@NotBlank(message="cannot be blank")
	@Pattern(regexp="^[A-Za-z]{8,}", message="should be minimum 8 characters with no spaces")
	private String username;
	
	/*@NotBlank(message="cannot be blank")
	@Email(message="Invalid email")*/
	@Column(unique=true)
	private String emailid;

	@Transient
	private String roles;
	
	@Transient
	@Pattern(regexp="^[A-Za-z0-9!@#$%*]{6,}", message="Invalid Password format")
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public int getUserauthid() {
		return userauthid;
	}

	public void setUserauthid(int userauthid) {
		this.userauthid = userauthid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
}
