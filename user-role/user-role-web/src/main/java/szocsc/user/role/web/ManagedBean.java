package szocsc.user.role.web;

import java.io.Serializable;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import szocsc.user.role.common.IUser;
import szocsc.user.role.jpa.User;

public class ManagedBean implements Serializable, IUser {
	private List<User> listUser;
	private IUser userBean;

	@Override
	public List<User> getAllUser() {
		return getUserBean().getAllUser();
	}

	@Override
	public User getUserById(int id) {

		return null;
	}

	@Override
	public int addUser(String name) {
		getUserBean().addUser(name);
		return 0;
	}

	@Override
	public int modifyUser(String oldName, String newName) {
		getUserBean().modifyUser(oldName, newName);
		return 0;
	}

	@Override
	public int removeUser(int id) {
		getUserBean().removeUser(id);
		return 0;
	}

	@Override
	public List<User> getUserByName(String name) {
		listUser = getUserBean().getUserByName(name);
		return listUser;
	}
	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

	private IUser getUserBean() {
		if (userBean == null) {
			try {
				InitialContext jndi = new InitialContext();
				userBean = (IUser) jndi
						.lookup("java:global/userManagement-EAR-0.0.1-SNAPSHOT/oser-role-ejb-0.0.1-SNAPSHOT/UserBean");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return userBean;

	}

}
