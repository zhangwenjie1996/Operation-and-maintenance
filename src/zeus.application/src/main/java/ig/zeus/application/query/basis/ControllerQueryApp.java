package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.zeus.application.query.IControllerQueryApp;
import ig.zeus.domain.repository.query.IControllerQueryRepository;
import ig.zeus.domain.repository.viewmodel.ControllerViewModel;

public class ControllerQueryApp implements IControllerQueryApp {

	private IControllerQueryRepository iControllerQueryRepository;
	
	public IControllerQueryRepository getiControllerQueryRepository() {
		return iControllerQueryRepository;
	}

	public void setiControllerQueryRepository(IControllerQueryRepository iControllerQueryRepository) {
		this.iControllerQueryRepository = iControllerQueryRepository;
	}

	@Override
	public ControllerViewModel findById(int id) {
		// TODO Auto-generated method stub
		return this.iControllerQueryRepository.findById(id);
	}

	@Override
	public List<ControllerViewModel> findAll() {
		// TODO Auto-generated method stub
		return this.iControllerQueryRepository.findAll();
	}

	@Override
	public List<ControllerViewModel> findPageData(PagingData args) {
		// TODO Auto-generated method stub
		return this.iControllerQueryRepository.findPageData(args);
	}

	@Override
	public int count() {
		return this.iControllerQueryRepository.count();
	}

}
