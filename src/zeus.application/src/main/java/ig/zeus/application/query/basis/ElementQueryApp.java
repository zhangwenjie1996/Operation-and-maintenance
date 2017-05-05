package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IElementQueryApp;
import ig.zeus.domain.repository.query.IElementQueryRepository;
import ig.zeus.domain.repository.viewmodel.ElementViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;

public class ElementQueryApp implements IElementQueryApp {

	private IElementQueryRepository iElementQueryRepository;

	public IElementQueryRepository getiElementQueryRepository() {
		return iElementQueryRepository;
	}

	public void setiElementQueryRepository(IElementQueryRepository iElementQueryRepository) {
		this.iElementQueryRepository = iElementQueryRepository;
	}

	@Override
	public StateData<PagingData> findAllByMenuId(int current, int rowCount, int menuID,int roleid) {
		PagingData data = new PagingData(current, rowCount);
		List<ElementViewModel> pageData = this.iElementQueryRepository.findAllByMenuId((current - 1) * rowCount,
				rowCount, menuID, roleid);
		if (pageData != null) {
			data.setRows(pageData);
			data.setTotal(this.iElementQueryRepository.countByMenuId(menuID));
			return new StateData<PagingData>(State.Success, "请求成功！", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<ElementViewModel> findById(int id) {
		ElementViewModel postViewModel = iElementQueryRepository.findById(id);
		if (postViewModel != null) {
			return new StateData<ElementViewModel>(State.Success, "请求成功！", postViewModel);
		} else {
			return new StateData<ElementViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<TreeListViewModel>> findElementTree(int menuId) {
		List<TreeListViewModel> roleViewModel = this.iElementQueryRepository.findElementTree(menuId);
		if (roleViewModel != null) {
			return new StateData<List<TreeListViewModel>>(State.Success, "请求成功！", roleViewModel);
		} else {
			return new StateData<List<TreeListViewModel>>(State.Failure, "请求失败！");
		}
	}

}
