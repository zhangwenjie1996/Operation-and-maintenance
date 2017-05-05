package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IMenuApp;
import ig.zeus.domain.service.IMenuService;
import ig.zeus.domain.service.command.MenuCommand;

public class MenuApp implements IMenuApp {

	private IMenuService iMenuService;

	public IMenuService getiMenuService() {
		return iMenuService;
	}

	public void setiMenuService(IMenuService iMenuService) {
		this.iMenuService = iMenuService;
	}

	@Override
	public StateData<Boolean> remove(int id) {
		try {
			this.iMenuService.remove(id);
			return new StateData<Boolean>(State.Success, "删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "删除失败!", false);
	}

	@Override
	public StateData<Integer> add(MenuCommand menuCommand) {
		try {
			int x = this.iMenuService.add(menuCommand);
			return new StateData<Integer>(State.Success, "添加成功", x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Integer>(State.Failure, "添加失败!");
	}

	@Override
	public StateData<Boolean> update(MenuCommand menuCommand) {
		try {
			this.iMenuService.update(menuCommand);
			return new StateData<Boolean>(State.Success, "更新成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "更新失败!", false);
	}
}
