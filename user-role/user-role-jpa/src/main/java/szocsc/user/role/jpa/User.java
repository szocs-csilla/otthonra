package szocsc.user.role.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.countAll", query = "select count(u) +1 from User u") })
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
