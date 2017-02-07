package szocsc.user.role.common;

import java.util.List;

import szocsc.user.role.jpa.Role;
import szocsc.user.role.jpa.User;

public interface IUser {
	/**
	 * This function gets all the Users from DB.
	 * @return users
	 */
	public List<User>getAllUser();
	/**
	 * This method searches for a User with the specified id.
	 * @param id 
	 * @return user
	 */
	public User getUserById(int id);
	/**
	 * This method inserts a User into DB.
	 * @param name
	 * @return user
	 */
	public int addUser(String name);
	/**
	 * This method add role to user.
	 * @param role
	 * @return role
	 */
	public int addRole(String name, List<Role>roles);
	/**
	 * This method updates user by name
	 * @param oldName
	 * @param newName
	 * @return
	 */
	
	public int modifyUser(String oldName, String newName);
	/**
	 * This method deletes the User by its id.
	 * @param id
	 */
	public int removeUser(int id);
	/**
	 * This method searches for the User with the specified name.
	 * @param name
	 * @return user
	 */
	public List<User>getUserByName(String name);
	
}
