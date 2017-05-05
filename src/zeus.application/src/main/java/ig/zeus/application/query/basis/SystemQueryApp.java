package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.ISystemQueryApp;
import ig.zeus.domain.repository.query.ISystemQueryRespository;
import ig.zeus.domain.repository.viewmodel.SystemViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;

public class SystemQueryApp implements ISystemQueryApp {
	private ISystemQueryRespository iSystemQueryRespository;

	public ISystemQueryRespository getiSystemQueryRespository() {
		return iSystemQueryRespository;
	}

	public void setiSystemQueryRespository(ISystemQueryRespository iSystemQueryRespository) {
		this.iSystemQueryRespository = iSystemQueryRespository;
	}

	@Override
	public StateData<PagingData> findPageData(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		List<SystemViewModel> list = this.iSystemQueryRespository.findPageData(data);
		if (list != null) {
			data.setRows(list);
			data.setTotal(this.iSystemQueryRespository.count());
			return new StateData<PagingData>(State.Success, "请求数据成功", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求数据失败");
		}
	}

	@Override
	public StateData<SystemViewModel> findById(int id) {
		SystemViewModel roleViewModel = this.iSystemQueryRespository.findById(id);
		if (roleViewModel != null) {
			return new StateData<SystemViewModel>(State.Success, "请求成功！", roleViewModel);
		} else {
			return new StateData<SystemViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<SystemViewModel>> findAllSelect() {
		List<SystemViewModel> roleViewModel = this.iSystemQueryRespository.findAllSelect();
		if (roleViewModel != null) {
			return new StateData<List<SystemViewModel>>(State.Success, "请求成功！", roleViewModel);
		} else {
			return new StateData<List<SystemViewModel>>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<TreeListViewModel>> findSystemTree() {
		List<TreeListViewModel> roleViewModel = this.iSystemQueryRespository.findSystemTree();
		if (roleViewModel != null) {
			return new StateData<List<TreeListViewModel>>(State.Success, "请求成功！", roleViewModel);
		} else {
			return new StateData<List<TreeListViewModel>>(State.Failure, "请求失败！");
		}
	}

}
