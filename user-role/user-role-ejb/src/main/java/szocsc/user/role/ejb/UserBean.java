package szocsc.user.role.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import szocsc.user.role.common.IUser;
import szocsc.user.role.jpa.User;

@Stateless
public class UserBean implements IUser {

	@PersistenceContext(unitName = "UserRole")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> users;
		users = entityManager.createNamedQuery("User.findAll").getResultList();
		return users;
	}

	@Override
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public int addUser(String name) {
		int number = ((Number) entityManager.createNamedQuery("User.countAll").getSingleResult()).intValue();
		User user = new User();
		user.setId(number);
		user.setUsername(name);
		entityManager.persist(user);
		return 0;
	}

	@Override
	public int modifyUser(String oldName, String newName) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> userRoot = criteriaQuery.from(User.class);

		criteriaQuery.select(userRoot).where(builder.equal(userRoot.get("name"), oldName));
		User user = entityManager.createQuery(criteriaQuery).getSingleResult();
		user.setUsername(newName);
		return 0;
	}

	@Override
	public int removeUser(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);

		return 0;
	}

	@Override
	public List<User> getUserByName(String name) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		Root<User> userRoot = criteriaQuery.from(User.class);
		
		criteriaQuery.select(userRoot).where(builder.like(userRoot.get("name"), "%" + name + "%"));
		List<User> users = entityManager.createQuery(criteriaQuery).getResultList();
		return users;
		
	}

}
