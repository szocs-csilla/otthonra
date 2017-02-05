package szocsc.user.role.ejb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import szocsc.user.role.common.IRole;
import szocsc.user.role.jpa.Role;

public class RoleBean implements IRole {
	@PersistenceContext(unitName = "user-role-jpa")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRols() {
		List<Role> roles;
		roles = entityManager.createNamedQuery("Role.findAll").getResultList();
		return roles;
	}

	@Override
	public Role getRoleById(int id) {
		return entityManager.find(Role.class,id);
	}

	@Override
	public int addRole(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyRole(String oldName, String newName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeRoleById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Role> getRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
