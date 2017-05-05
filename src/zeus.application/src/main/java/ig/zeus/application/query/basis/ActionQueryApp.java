package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.zeus.application.query.IActionQueryApp;
import ig.zeus.domain.repository.query.IActionQueryRepository;
import ig.zeus.domain.repository.viewmodel.ActionViewModel;

public class ActionQueryApp implements IActionQueryApp {
	private IActionQueryRepository iActionQueryRepository;

	public IActionQueryRepository getiActionQueryRepository() {
		return iActionQueryRepository;
	}

	public void setiActionQueryRepository(IActionQueryRepository iActionQueryRepository) {
		this.iActionQueryRepository = iActionQueryRepository;
	}

	@Override
	public List<ActionViewModel> findAll() {

		return iActionQueryRepository.findAll();
	}

	@Override
	public List<ActionViewModel> findPageData(PagingData args) {
		return iActionQueryRepository.findPageData(args);
	}

	@Override
	public int count() {
		return iActionQueryRepository.count();
	}

	@Override
	public ActionViewModel findById(int id) {
		return iActionQueryRepository.findById(id);
	}
}
