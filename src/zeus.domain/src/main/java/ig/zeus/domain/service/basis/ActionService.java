package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.resource.server.Action;
import ig.zeus.domain.repository.command.IActionRepository;
import ig.zeus.domain.service.IActionService;
import ig.zeus.domain.service.command.ActionCommand;

public class ActionService implements IActionService {
	private IActionRepository iActionRepository;
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private ActionCommand actionCommand;
	private Action action;

	public IActionRepository getiActionRepository() {
		return iActionRepository;
	}

	public void setiActionRepository(IActionRepository iActionRepository) {
		this.iActionRepository = iActionRepository;
	}

	public ActionCommand getActionViewModel() {
		return actionCommand;
	}

	public void setActionViewModel(ActionCommand actionCommand) {
		this.actionCommand = actionCommand;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public int remove(Integer id) {
		return iActionRepository.remove(id);
	}

	@Override
	public int add(ActionCommand entity) {
		action = dozer.map(entity, Action.class);
		return iActionRepository.add(action);
	}

	@Override
	public int update(ActionCommand entity) {
		action = dozer.map(entity, Action.class);
		return iActionRepository.update(action);
	}

}
