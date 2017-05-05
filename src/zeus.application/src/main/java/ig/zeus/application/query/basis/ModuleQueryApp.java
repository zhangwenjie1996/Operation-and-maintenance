package ig.zeus.application.query.basis;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.zeus.application.query.IModuleQueryApp;
import ig.zeus.domain.repository.query.IModuleQueryRepository;
import ig.zeus.domain.repository.viewmodel.ModuleViewModel;

public class ModuleQueryApp implements IModuleQueryApp {

	private IModuleQueryRepository iModuleQueryRepository;

	public IModuleQueryRepository getiModuleQueryRepository() {
		return iModuleQueryRepository;
	}

	public void setiModuleQueryRepository(IModuleQueryRepository iModuleQueryRepository) {
		this.iModuleQueryRepository = iModuleQueryRepository;
	}

	

	@Override
	public List<ModuleViewModel> findAll() {

		return iModuleQueryRepository.findAll();
	}

	@Override
	public List<ModuleViewModel> findPageData(PagingData args) {
		return iModuleQueryRepository.findPageData(args);
	}

	@Override
	public int count() {
		return iModuleQueryRepository.count();
	}

	@Override
	public ModuleViewModel findById(int id) {
		return this.getiModuleQueryRepository().findById(id);
	}

	

}
