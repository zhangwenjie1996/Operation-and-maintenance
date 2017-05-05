package ig.zeus.application.command.basis;

import ig.zeus.application.command.IModuleApp;
import ig.zeus.domain.service.IModuleService;
import ig.zeus.domain.service.command.ModuleCommand;

public class ModuleApp implements IModuleApp {

	private IModuleService iModuleService;

	public IModuleService getiModuleService() {
		return iModuleService;
	}

	public void setiModuleService(IModuleService iModuleService) {
		this.iModuleService = iModuleService;
	}

	@Override
	public int remove(Integer id) {
		return iModuleService.remove(id);
	}

	@Override
	public int add(ModuleCommand entity) {
		return iModuleService.add(entity);
	}

	@Override
	public int update(ModuleCommand entity) {
		return iModuleService.update(entity);
	}

	

}
