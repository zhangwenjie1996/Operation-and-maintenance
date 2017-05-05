package ig.zeus.domain.service;

public interface IPermissionService {

	/**
	 * 添加角色系统关系
	 */
	int addRoleSystem(int roleId, int[] systemIds);

	/**
	 * 添加角色元素关系
	 * 
	 * @param roleId
	 * @param elementIds
	 * @return
	 */
	int addRoleElement(int roleId, int[] elementIds, int[] permissions);

	/**
	 * 添加角色菜单关系
	 * 
	 * @param roleId
	 * @param elementIds
	 * @return
	 */
	int addRoleMenu(int roleId, int[] menuIds);

	/**
	 * 删除角色菜单关系
	 * 
	 * @param roleId
	 * @return
	 */
	boolean removeRoleMenu(int roleId);

	/**
	 * 删除角色元素关系
	 * 
	 * @param roleId
	 * @return
	 */
	boolean removeRoleElement(int roleId);

	/**
	 * 删除角色系统关系
	 * 
	 * @param roleId
	 * @return
	 */
	boolean removeRoleSystem(int roleId);
}
