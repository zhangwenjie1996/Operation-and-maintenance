package ig.zeus.application.query.basis;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IOrganQueryApp;
import ig.zeus.domain.repository.query.IOrganQueryRepository;
import ig.zeus.domain.repository.viewmodel.OrganViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;
import ig.zeus.domain.repository.viewmodel.TreeViewModel;
import sun.reflect.generics.tree.Tree;

public class OrganQueryApp implements IOrganQueryApp {
	private IOrganQueryRepository iOrganQueryRepository;

	public IOrganQueryRepository getiOrganQueryRepository() {
		return iOrganQueryRepository;
	}

	public void setiOrganQueryRepository(IOrganQueryRepository iOrganQueryRepository) {
		this.iOrganQueryRepository = iOrganQueryRepository;
	}

	@Override
	public List<OrganViewModel> findPageData(PagingData args) {
		return iOrganQueryRepository.findPageData(args);
	}

	@Override
	public int count() {
		return iOrganQueryRepository.count();
	}

	@Override
	public StateData<OrganViewModel> findById(int id) {
		OrganViewModel organViewModel = iOrganQueryRepository.findById(id);
		if (organViewModel != null) {
			return new StateData<OrganViewModel>(State.Success, "请求成功！", organViewModel);
		} else {
			return new StateData<OrganViewModel>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<TreeListViewModel>> findOrganListTree() {
		List<TreeListViewModel> list = this.iOrganQueryRepository.findOrganListTree();
		list.forEach((model) -> {
			if ("0".equals(model.getParent())) {
				model.setParent("#");
			}
		});
		return new StateData<List<TreeListViewModel>>(State.Success, "请求成功！", list);
	}

	@Override
	public StateData<List<TreeViewModel>> findOrganTree() {
		List<TreeViewModel> list = this.iOrganQueryRepository.findOrganReactTree();
		Queue<TreeViewModel> queue = new LinkedBlockingDeque<>();
		List<TreeViewModel> root = new ArrayList<TreeViewModel>();
		list.forEach((model) -> {
			model.setKey(model.getId());
			model.setId(null);
			if("0".equals(model.getParent())){
				queue.add(model);
				root.add(model);
			}
		});
		while(!queue.isEmpty()){
			TreeViewModel t = queue.poll();
			list.stream().forEach(model->{
				if(model.getParent().equals(t.getKey())){
					t.getChildren().add(model);
					queue.add(model);
				}
			});
		}
		return new StateData<List<TreeViewModel>>(State.Success, "请求成功！", root);
	}

}
