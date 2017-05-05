package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.RoleResourceViewModel;


public interface IPermissionQueryApp {
	/**
	 * 根据角色id查找系统权限id
	 * @param roleId
	 * @return
	 */
	StateData<List<RoleResourceViewModel>> findSystemByRoleId(int roleId);
	/**
	 * 根据角色id查找菜单权限id
	 * @param roleId
	 * @return
	 */
	StateData<List<RoleResourceViewModel>> findMenuByRoleId(int roleId);
	/**
	 * 根据角色id查找元素权限id
	 * @param roleId
	 * @return
	 */
	StateData<List<RoleResourceViewModel>> findElementByRoleId(int roleId);	
}
