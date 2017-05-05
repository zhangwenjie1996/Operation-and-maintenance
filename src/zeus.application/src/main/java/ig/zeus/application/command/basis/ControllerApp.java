package ig.zeus.application.command.basis;

import ig.zeus.application.command.IControllerApp;
import ig.zeus.domain.service.IControllerService;
import ig.zeus.domain.service.command.ControllerCommand;

public class ControllerApp implements IControllerApp {
	private IControllerService iControllerService;

	public IControllerService getiControllerService() {
		return iControllerService;
	}

	public void setiControllerService(IControllerService iControllerService) {
		this.iControllerService = iControllerService;
	}

	@Override
	public int remove(Integer id) {
		return iControllerService.remove(id);
	}

	@Override
	public int add(ControllerCommand entity) {
		return iControllerService.add(entity);
	}

	@Override
	public int update(ControllerCommand entity) {
		return iControllerService.update(entity);
	}

	

}
