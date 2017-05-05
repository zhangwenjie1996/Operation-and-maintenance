package ig.zeus.domain.repository.query;

import java.util.List;

import ig.zeus.domain.repository.viewmodel.RoleResourceViewModel;

/**
 * 事件公共接口
 * 
 * @author Administrator
 *
 */
public interface IPermissionQueryRepository {
	/**
	 * 根据角色id查找系统权限id
	 * 
	 * @param roleId
	 * @return
	 */
	List<RoleResourceViewModel> findSystemByRoleId(int roleId);

	/**
	 * 根据角色id查找菜单权限id
	 * 
	 * @param roleId
	 * @return
	 */
	List<RoleResourceViewModel> findMenuByRoleId(int roleId);

	/**
	 * 根据角色id查找元素权限id
	 * 
	 * @param roleId
	 * @return
	 */
	List<RoleResourceViewModel> findElementByRoleId(int roleId);
}
