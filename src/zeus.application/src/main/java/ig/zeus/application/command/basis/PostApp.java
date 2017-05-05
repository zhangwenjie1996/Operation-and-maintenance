package ig.zeus.application.command.basis;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.command.IPostApp;
import ig.zeus.domain.service.IPostService;
import ig.zeus.domain.service.command.PostCommand;

public class PostApp implements IPostApp {
	private IPostService iPostService;

	public IPostService getiPostService() {
		return iPostService;
	}

	public void setiPostService(IPostService iPostService) {
		this.iPostService = iPostService;
	}

	@Override
	public StateData<Boolean> remove(int id) {
		try {
			iPostService.remove(id);
			return new StateData<Boolean>(State.Success, "删除成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "删除失败!", false);
	}

	@Override
	public StateData<Integer> add(PostCommand postCommand) {
		try {
			int x = iPostService.add(postCommand);
			return new StateData<Integer>(State.Success, "保存成功", x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Integer>(State.Failure, "保存失败!");
	}

	@Override
	public StateData<Boolean> update(PostCommand postCommand) {
		try {
			iPostService.update(postCommand);
			return new StateData<Boolean>(State.Success, "更新成功", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new StateData<Boolean>(State.Failure, "更新失败!", false);
	}

}
