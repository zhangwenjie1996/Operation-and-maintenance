package ig.zeus.domain.repository.command;

import java.util.List;

import ig.zeus.domain.model.permission.Permission;

/**
 * 事件公共接口
 * 
 * @author Administrator
 *
 */
public interface IPermissionRepository {
	/**
	 * 批量插入角色关系
	 */
	int addRoleSystem(List<Permission> list);

	/**
	 * 添加角色元素关系
	 * 
	 * @param roleId
	 * @param elementIds
	 * @return
	 */
	int addRoleElement(List<Permission> list);

	/**
	 * 添加角色菜单关系
	 * 
	 * @param roleId
	 * @param elementIds
	 * @return
	 */
	int addRoleMenu(List<Permission> list);

	/**删除角色菜单关系
	 * @param roleId
	 * @return
	 */
	boolean removeRoleMenu(int roleId);

	/**删除角色元素关系
	 * @param roleId
	 * @return
	 */
	boolean removeRoleElement(int roleId);

	/**删除角色系统关系
	 * @param roleId
	 * @return
	 */
	boolean removeRoleSystem(int roleId);

}
