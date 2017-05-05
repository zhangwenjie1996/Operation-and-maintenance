package ig.zeus.application.query.basis;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IMenuQueryApp;
import ig.zeus.domain.repository.query.IMenuQueryRepository;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import ig.zeus.domain.repository.viewmodel.MenuViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;
import ig.zeus.domain.repository.viewmodel.TreeViewModel;

public class MenuQueryApp implements IMenuQueryApp {

	private IMenuQueryRepository iMenuQueryRepository;

	public IMenuQueryRepository getiMenuQueryRepository() {
		return iMenuQueryRepository;
	}

	public void setiMenuQueryRepository(IMenuQueryRepository iMenuQueryRepository) {
		this.iMenuQueryRepository = iMenuQueryRepository;
	}

	@Override
	public StateData<PagingData> findPageData(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		List<MenuViewModel> list = this.iMenuQueryRepository.findPageData(data);
		if (list != null) {
			data.setRows(list);
			data.setTotal(this.iMenuQueryRepository.count());
			return new StateData<PagingData>(State.Success, "请求成功！", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<MenuViewModel> findById(int id) {
		MenuViewModel roleViewModel = this.iMenuQueryRepository.findById(id);
		if (roleViewModel != null) {
			return new StateData<MenuViewModel>(State.Success, "请求成功！", roleViewModel);
		} else {
			return new StateData<MenuViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<TreeListViewModel>> findMenuTree(int systemId) {
		List<TreeListViewModel> list = this.iMenuQueryRepository.findMenuTree(systemId);
		list.stream().filter(model -> "0".equals(model.getParent())).forEach(m -> m.setParent("#"));
		return new StateData<List<TreeListViewModel>>(State.Success, "请求成功！", list);
	}

	@Override
	public StateData<List<TreeViewModel>> findMenuTreeByRole(int systemId, AccountViewModel account) {

		if (account == null) {
			return new StateData<List<TreeViewModel>>(State.Failure, "请求失败,请重新登陆！");
		}
		List<TreeViewModel> list = null;
		if ("superadmin".equalsIgnoreCase(account.getAccountname())) {
			list = this.iMenuQueryRepository.findMenuAllTree(systemId);
		} else {
			list = this.iMenuQueryRepository.findMenuTreeByRole(systemId, account.getAccountid());
		}
		List<TreeViewModel> nlist = new ArrayList<>();

		Queue<TreeViewModel> queue = new LinkedBlockingQueue<>();
		list.stream().filter(model -> "1".equals(model.getParent())).forEach(model -> {
			model.setParent("#");
			queue.add(model);
			nlist.add(model);

		});
		while (!queue.isEmpty()) {
			TreeViewModel tvm = queue.poll();
			list.stream().filter(model -> tvm.getId().equals(model.getParent())).forEach(model -> {
				tvm.getChildren().add(model);
				queue.add(model);
			});
			;
		}
		return new StateData<List<TreeViewModel>>(State.Success, "请求成功！", nlist);
	}

}
