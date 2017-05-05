package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.zeus.application.query.IPostQueryApp;
import ig.zeus.domain.repository.query.IPostQueryRepository;
import ig.zeus.domain.repository.viewmodel.PostViewModel;

public class PostQueryApp implements IPostQueryApp {
	private IPostQueryRepository iPostQueryRepository;

	public IPostQueryRepository getiPostQueryRepository() {
		return iPostQueryRepository;
	}

	public void setiPostQueryRepository(IPostQueryRepository iPostQueryRepository) {
		this.iPostQueryRepository = iPostQueryRepository;
	}

	@Override
	public StateData<PagingData> findPageData(PagingData data) {
		List<PostViewModel> pageData = iPostQueryRepository.findPageData(data);
		if (pageData != null) {
			data.setRows(pageData);
			data.setTotal(this.iPostQueryRepository.count());
			return new StateData<PagingData>(State.Success, "请求成功！", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求失败！");
		}
	}

	public StateData<PostViewModel> findById(int id) {
		PostViewModel postViewModel = iPostQueryRepository.findById(id);
		if (postViewModel != null) {
			return new StateData<PostViewModel>(State.Success, "请求成功！", postViewModel);
		} else {
			return new StateData<PostViewModel>(State.Failure, "请求失败！");
		}
	}

	public StateData<PagingData> getAllPostByOrganID(int current, int rowCount, int organID) {
		PagingData data = new PagingData(current, rowCount);
		List<PostViewModel> pageData = this.iPostQueryRepository.getAllPostByOrganID((current - 1) * rowCount, rowCount,
				organID);
		if (pageData != null) {
			data.setRows(pageData);
			data.setTotal(this.iPostQueryRepository.countByOrganID(organID));
			return new StateData<PagingData>(State.Success, "请求成功！", data);
		} else {
			return new StateData<PagingData>(State.Failure, "请求失败！");
		}
	}

	@Override
	public StateData<List<PostViewModel>> findSelectPostByOrganID(int organid) {
		List<PostViewModel> list = this.iPostQueryRepository.findSelectPostByOrganID(organid);
		if (list.isEmpty()) {
			return new StateData<List<PostViewModel>>(State.Failure, "请求失败！");
		} else {
			return new StateData<List<PostViewModel>>(State.Success, "请求成功！", list);
		}
	}

}
