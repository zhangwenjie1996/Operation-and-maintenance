package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IElementApp;
import ig.zeus.domain.service.IElementService;
import ig.zeus.domain.service.command.ElementCommand;

public class ElementApp implements IElementApp {

	private IElementService iElementService;

	public IElementService getiElementService() {
		return iElementService;
	}

	public void setiElementService(IElementService iElementService) {
		this.iElementService = iElementService;
	}

	@Override
	public StateData<Boolean> remove(int id) {
		try {
			iElementService.remove(id);
			return new StateData<Boolean>(State.Success, "删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "删除失败!", false);
	}

	@Override
	public StateData<Integer> add(ElementCommand elementCommand) {
		try {
			int x = iElementService.add(elementCommand);
			return new StateData<Integer>(State.Success, "保存成功", x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Integer>(State.Failure, "保存失败!");
	}

	@Override
	public StateData<Boolean> update(ElementCommand elementCommand) {
		try {
			iElementService.update(elementCommand);
			return new StateData<Boolean>(State.Success, "更新成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "更新失败!", false);
	}

}
