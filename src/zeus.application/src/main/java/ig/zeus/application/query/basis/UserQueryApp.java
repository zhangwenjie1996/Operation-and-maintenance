package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IUserQueryApp;
import ig.zeus.domain.repository.query.IAccountQueryRepository;
import ig.zeus.domain.repository.query.IUserQueryRepository;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import ig.zeus.domain.repository.viewmodel.EmployeeViewModel;

public class UserQueryApp implements IUserQueryApp {
	private IUserQueryRepository iUserQueryRepository;

	private IAccountQueryRepository iAccountQueryRepository;

	/**
	 * @return the iAccountQueryRepository
	 */
	public IAccountQueryRepository getiAccountQueryRepository() {
		return iAccountQueryRepository;
	}

	/**
	 * @param iAccountQueryRepository
	 *            the iAccountQueryRepository to set
	 */
	public void setiAccountQueryRepository(IAccountQueryRepository iAccountQueryRepository) {
		this.iAccountQueryRepository = iAccountQueryRepository;
	}

	public IUserQueryRepository getiUserQueryRepository() {
		return iUserQueryRepository;
	}

	public void setiUserQueryRepository(IUserQueryRepository iUserQueryRepository) {
		this.iUserQueryRepository = iUserQueryRepository;
	}

	@Override
	public StateData<PagingData> findPageData(PagingData data, EmployeeViewModel viewModel) {
		data.setRows(viewModel);
		List<EmployeeViewModel> list = this.iUserQueryRepository.findPageData(data);
		if (list != null) {
			data.setRows(list);
			data.setTotal(this.iUserQueryRepository.count(viewModel));
			return new StateData<PagingData>(State.Success, "请求成功！", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<EmployeeViewModel> findById(Integer id) {
		EmployeeViewModel employeeViewModel = iUserQueryRepository.findById(id);
		if (employeeViewModel != null) {
			return new StateData<EmployeeViewModel>(State.Success, "请求成功！", employeeViewModel);
		} else {
			return new StateData<EmployeeViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<AccountViewModel> findAccountByEmployeeId(Integer id) {
		AccountViewModel accountViewModel = this.iAccountQueryRepository.findByEmployeeId(id);
		if (accountViewModel != null) {
			return new StateData<AccountViewModel>(State.Success, "请求成功！", accountViewModel);
		} else {
			return new StateData<AccountViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<EmployeeViewModel>> findEmployeeByOrganID(Integer organID) {
		List<EmployeeViewModel> employeeViewModels = this.iUserQueryRepository.findEmployeeByOrganID(organID);
		if (employeeViewModels != null) {
			return new StateData<List<EmployeeViewModel>>(State.Success, "请求成功！", employeeViewModels);
		} else {
			return new StateData<List<EmployeeViewModel>>(State.Failure, "请求失败！");
		}
	}
}