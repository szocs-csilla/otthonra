package szocsc.user.role.common;

import java.util.List;

import szocsc.user.role.jpa.Role;

public interface IRole {
	/**
	 * This function gets all the Roles from DB.
	 * @return roles
	 */
	public List<Role>getAllRols();
	/**
	 * This method searches for a Role with the specified id.
	 * @param id
	 * @return role
	 */
	public Role getRoleById(int id);
	/**
	 * This method inserts a Role into DB.
	 * @param name
	 * @return role
	 */
	public int addRole(String name);
	/**
	 * This method updates role by name
	 * @param oldName
	 * @param newName
	 * @return
	 */
	public int modifyRole(String oldName, String newName);
	/**
	 * This method deletes the Role by its id.
	 * @param id
	 * @return
	 */
	public int removeRoleById(int id);
	/**
	 * This method searches for the Role with the specified name.
	 * @param name
	 * @return
	 */
	public List<Role>getRoleByName(String name);
	
}
