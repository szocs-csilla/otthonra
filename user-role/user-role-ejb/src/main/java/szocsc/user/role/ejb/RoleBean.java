package szocsc.user.role.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import szocsc.user.role.common.IRole;
import szocsc.user.role.jpa.Role;
@Stateless
public class RoleBean implements IRole {
	@PersistenceContext(unitName = "UserRole")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRole() {
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
		int number = ((Number) entityManager.createNamedQuery("Role.countAll").getSingleResult()).intValue();
		Role role = new Role();
		role.setId(number);
		role.setRole(name);
		entityManager.persist(role);
		return 0;
	}

	@Override
	public int modifyRole(String oldName, String newName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);
		Root<Role> roleRoot = criteriaQuery.from(Role.class);

		criteriaQuery.select(roleRoot).where(builder.equal(roleRoot.get("role"), oldName));
		Role role = entityManager.createQuery(criteriaQuery).getSingleResult();
		role.setRole(newName);
		return 0;
	}

	@Override
	public int removeRoleById(int id) {
		Role role = entityManager.find(Role.class, id);
		entityManager.remove(role);
		return 0;
	}

	@Override
	public List<Role> getRoleByName(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);
		Root<Role> roleRoot = criteriaQuery.from(Role.class);
		
		criteriaQuery.select(roleRoot).where(builder.like(roleRoot.get("role"), "%" + name + "%"));
		List<Role> roles = entityManager.createQuery(criteriaQuery).getResultList();
		return roles;
	}

}
