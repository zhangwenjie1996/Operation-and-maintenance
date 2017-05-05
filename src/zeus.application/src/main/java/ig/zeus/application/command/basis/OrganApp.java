package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IOrganApp;
import ig.zeus.domain.service.IOrganService;
import ig.zeus.domain.service.command.OrganCommand;

public class OrganApp implements IOrganApp {
	private IOrganService iOrganService;

	public IOrganService getiOrganService() {
		return iOrganService;
	}

	public void setiOrganService(IOrganService iOrganService) {
		this.iOrganService = iOrganService;
	}

	@Override
	public StateData<Boolean> remove(int id) {
		try {
			iOrganService.remove(id);
			return new StateData<Boolean>(State.Success, "删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "删除失败!", false);
	}

	@Override
	public StateData<Integer> add(OrganCommand organCommand) {
		try {
			int x = iOrganService.add(organCommand);
			return new StateData<Integer>(State.Success, "保存成功", x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Integer>(State.Failure, "保存失败!");
	}

	@Override
	public StateData<Boolean> update(OrganCommand organCommand) {
		try {
			iOrganService.update(organCommand);
			return new StateData<Boolean>(State.Success, "更新成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "更新失败!", false);
	}

}
