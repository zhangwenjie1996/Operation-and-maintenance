package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IRoleQueryApp;
import ig.zeus.domain.repository.query.IRoleQueryRepository;
import ig.zeus.domain.repository.viewmodel.RoleViewModel;

public class RoleQueryApp implements IRoleQueryApp {
	private IRoleQueryRepository iRoleQueryRepository;

	public IRoleQueryRepository getiRoleQueryRepository() {
		return iRoleQueryRepository;
	}

	public void setiRoleQueryRepository(IRoleQueryRepository iRoleQueryRepository) {
		this.iRoleQueryRepository = iRoleQueryRepository;
	}

	@Override
	public StateData<PagingData> findPageData(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		List<RoleViewModel> list = this.iRoleQueryRepository.findPageData(data);
		if (list != null) {
			data.setRows(list);
			data.setTotal(this.iRoleQueryRepository.count());
			return new StateData<PagingData>(State.Success, "请求成功！", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<RoleViewModel> findById(int roleid) {
		RoleViewModel roleViewModel = this.iRoleQueryRepository.findById(roleid);
		if (roleViewModel != null) {
			return new StateData<RoleViewModel>(State.Success, "请求成功！", roleViewModel);
		} else {
			return new StateData<RoleViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<RoleViewModel>> findAllSelect() {
		List<RoleViewModel> list = this.iRoleQueryRepository.findAllSelect();
		if (list != null) {
			return new StateData<List<RoleViewModel>>(State.Success, "请求成功！", list);
		} else {
			return new StateData<List<RoleViewModel>>(State.Failure, "请求失败！");
		}
	}

}
