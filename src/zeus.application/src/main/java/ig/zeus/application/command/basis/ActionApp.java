package ig.zeus.application.command.basis;

import ig.zeus.application.command.IActionApp;
import ig.zeus.domain.service.IActionService;
import ig.zeus.domain.service.command.ActionCommand;

public class ActionApp implements IActionApp {
	private IActionService iActionService;

	public IActionService getiActionService() {
		return iActionService;
	}

	public void setiActionService(IActionService iActionService) {
		this.iActionService = iActionService;
	}

	@Override
	public int remove(Integer id) {
		return iActionService.remove(id);
	}

	@Override
	public int add(ActionCommand entity) {
		return iActionService.add(entity);
	}

	@Override
	public int update(ActionCommand entity) {
		return iActionService.update(entity);
	}

	
}
