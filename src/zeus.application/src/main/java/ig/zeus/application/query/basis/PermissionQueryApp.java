package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IPermissionQueryApp;
import ig.zeus.domain.repository.query.IPermissionQueryRepository;
import ig.zeus.domain.repository.viewmodel.RoleResourceViewModel;

public class PermissionQueryApp implements IPermissionQueryApp {
	private IPermissionQueryRepository iPermissionQueryRepository;

	/**
	 * @return the iPermissionQueryRepository
	 */
	public IPermissionQueryRepository getiPermissionQueryRepository() {
		return iPermissionQueryRepository;
	}

	/**
	 * @param iPermissionQueryRepository
	 *            the iPermissionQueryRepository to set
	 */
	public void setiPermissionQueryRepository(IPermissionQueryRepository iPermissionQueryRepository) {
		this.iPermissionQueryRepository = iPermissionQueryRepository;
	}

	@Override
	public StateData<List<RoleResourceViewModel>> findSystemByRoleId(int roleId) {
		List<RoleResourceViewModel> list = this.iPermissionQueryRepository.findSystemByRoleId(roleId);
		if (list.isEmpty()) {
			return new StateData<List<RoleResourceViewModel>>(State.Failure, "请求失败！");
		} else {
			return new StateData<List<RoleResourceViewModel>>(State.Success, "请求成功！", list);
		}
	}

	@Override
	public StateData<List<RoleResourceViewModel>> findMenuByRoleId(int roleId) {
		List<RoleResourceViewModel> list = this.iPermissionQueryRepository.findMenuByRoleId(roleId);
		if (list.isEmpty()) {
			return new StateData<List<RoleResourceViewModel>>(State.Failure, "请求失败！");
		} else {
			return new StateData<List<RoleResourceViewModel>>(State.Success, "请求成功！", list);
		}
	}

	@Override
	public StateData<List<RoleResourceViewModel>> findElementByRoleId(int roleId) {
		List<RoleResourceViewModel> list = this.iPermissionQueryRepository.findElementByRoleId(roleId);
		if (list.isEmpty()) {
			return new StateData<List<RoleResourceViewModel>>(State.Failure, "请求失败！");
		} else {
			return new StateData<List<RoleResourceViewModel>>(State.Success, "请求成功！", list);
		}
	}

}
