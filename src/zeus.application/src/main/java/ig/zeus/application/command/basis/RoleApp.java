package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IRoleApp;
import ig.zeus.domain.service.IRoleService;
import ig.zeus.domain.service.command.RoleCommand;

public class RoleApp implements IRoleApp {

	private IRoleService iRoleService;

	public IRoleService getiRoleService() {
		return iRoleService;
	}

	public void setiRoleService(IRoleService iRoleService) {
		this.iRoleService = iRoleService;
	}

	@Override
	public StateData<Boolean> remove(int id) {
		try {
			this.iRoleService.remove(id);
			return new StateData<Boolean>(State.Success, "删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "删除失败!", false);
	}

	@Override
	public StateData<Integer> add(RoleCommand roleCommand) {
		try {
			int x = this.iRoleService.add(roleCommand);
			return new StateData<Integer>(State.Success, "添加成功", x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Integer>(State.Failure, "添加失败!");
	}

	@Override
	public StateData<Boolean> update(RoleCommand roleCommand) {
		try {
			this.iRoleService.update(roleCommand);
			return new StateData<Boolean>(State.Success, "更新成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "更新失败!", false);
	}

}
