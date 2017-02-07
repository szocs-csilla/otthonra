package szocsc.user.role.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import szocsc.user.role.common.IRole;
import szocsc.user.role.jpa.Role;
@Named("role")
@ApplicationScoped
public class ManagedRole implements Serializable, IRole {
	private static final long serialVersionUID = 1L;
	private List<Role> listRole;
	private IRole roleBean;

	public ManagedRole() {
		super();
	}

	@Override
	public List<Role> getAllRole() {
		return getRoleBean().getAllRole();
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addRole(String name) {
		Role newRole = new Role();
		newRole.setRole(name);
		getRoleBean().addRole(name);
		return 0;
	}

	@Override
	public int modifyRole(String oldName, String newName) {
		getRoleBean().modifyRole(oldName, newName);
		return 0;
	}

	@Override
	public int removeRoleById(int id) {
		getRoleBean().removeRoleById(id);
		return 0;
	}

	@Override
	public List<Role> getRoleByName(String name) {
		listRole = getRoleBean().getRoleByName(name);
		return listRole;
	}
	

	public List<Role> getListRole() {
		return listRole;
	}

	public void setListRole(List<Role> listRole) {
		this.listRole = listRole;
	}

	private IRole getRoleBean() {
		if (roleBean == null) {
			try {
				System.out.println("sfhadshfausehf");
				InitialContext jndi = new InitialContext();
				roleBean = (IRole) jndi
						.lookup("java:global/user-role-ear-0.0.1-SNAPSHOT/user-role-ejb-0.0.1-SNAPSHOT/RoleBean");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return roleBean;

	}
}
