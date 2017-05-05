package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IPermissionApp;
import ig.zeus.domain.service.IPermissionService;

public class PermissionApp implements IPermissionApp {
	private IPermissionService iPermissionService;

	public IPermissionService getiPermissionService() {
		return iPermissionService;
	}

	public void setiPermissionService(IPermissionService iPermissionService) {
		this.iPermissionService = iPermissionService;
	}

	@Override
	public StateData<Boolean> addRoleSystem(int roleId, int[] systemIds) {
		try {
			this.iPermissionService.removeRoleSystem(roleId);
			this.iPermissionService.addRoleSystem(roleId, systemIds);
			return new StateData<Boolean>(State.Success, "添加成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "添加失败!", false);
	}

	@Override
	public StateData<Boolean> addRoleMenu(int roleId, int[] menuIds) {
		try {
			this.iPermissionService.removeRoleMenu(roleId);
			this.iPermissionService.addRoleMenu(roleId, menuIds);
			return new StateData<Boolean>(State.Success, "添加成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "添加失败!", false);
	}

	@Override
	public StateData<Boolean> addRoleElement(int roleId, int[] elementIds, int[] permissions) {
		try {
			this.iPermissionService.removeRoleElement(roleId);
			this.iPermissionService.addRoleElement(roleId, elementIds,permissions);
			return new StateData<Boolean>(State.Success, "添加成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "添加失败!", false);
	}
}
