package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;

public interface IPermissionApp {

	/**
	 * 为角色分配权限
	 */
	StateData<Boolean> addRoleSystem(int roleId, int[] systemIds);

	/**
	 * 为角色分配菜单权限
	 * 
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	StateData<Boolean> addRoleMenu(int roleId, int[] menuIds);

	/**
	 * 为角色分配元素权限
	 * 
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	StateData<Boolean> addRoleElement(int roleId, int[] elementIds,int[] permissions);

}
