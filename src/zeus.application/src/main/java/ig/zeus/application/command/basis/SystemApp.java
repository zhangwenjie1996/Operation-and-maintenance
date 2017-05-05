package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.ISystemApp;
import ig.zeus.domain.service.ISystemService;
import ig.zeus.domain.service.command.SystemCommand;

public class SystemApp implements ISystemApp {
	private ISystemService iSystemService;

	public ISystemService getiSystemService() {
		return iSystemService;
	}

	public void setiSystemService(ISystemService iSystemService) {
		this.iSystemService = iSystemService;
	}

	@Override
	public StateData<Boolean> remove(int id) {
		try {
			this.iSystemService.remove(id);
			return new StateData<Boolean>(State.Success, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "删除失败");
	}

	@Override
	public StateData<Integer> add(SystemCommand systemCommand) {
		try {
			int x = this.iSystemService.add(systemCommand);
			return new StateData<Integer>(State.Success, "添加成功",x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Integer>(State.Failure, "添加失败");
	}

	@Override
	public StateData<Boolean> update(SystemCommand systemCommand) {
		try {
			this.iSystemService.update(systemCommand);
			return new StateData<Boolean>(State.Success, "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "更新失败");
	}

}
