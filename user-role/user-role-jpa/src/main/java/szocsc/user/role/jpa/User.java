package szocsc.user.role.jpa;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.*;

import com.mysql.fabric.xmlrpc.base.Value;

import java.util.List;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String username;

	
	@ManyToMany
	@JoinTable(name = "users_roles", 
		joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
	)
	private List<Role> roles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
