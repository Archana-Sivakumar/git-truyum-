package com.cognizant.truyumSignUp.model;


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@Column(name = "us_user_name")
	@NotNull
	@Size(min = 2, max = 10, message = "UserName is required." + "User Name must at least have 2 characters.")
	private String userName;

	@Column(name = "us_first_name")
	@NotNull
	private String firstName;

	@Column(name = "us_last_name")
	@NotNull
	private String lastName;

	@Column(name = "us_password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cart", joinColumns = @JoinColumn(name = "ct_us_id"), inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
	private Set<MenuItem> menuItemsList;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
    private Set<Role> roleList;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String userName, String firstName, String lastName, String password,
			Set<MenuItem> menuItemsList,Set<Role> roleList) {

		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.menuItemsList = menuItemsList;
		this.roleList = roleList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Set<MenuItem> getMenuItemsList() {
		return menuItemsList;
	}

	public void setMenuItemsList(Set<MenuItem> menuItemsList) {
		this.menuItemsList = menuItemsList;
	}
	
	

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ",  menuItemsList=" + menuItemsList
				+ "]";
	}

}
