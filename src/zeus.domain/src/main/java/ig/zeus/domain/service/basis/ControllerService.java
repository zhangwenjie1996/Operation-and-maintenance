package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.resource.server.Controller;
import ig.zeus.domain.repository.command.IControllerRepository;
import ig.zeus.domain.service.IControllerService;
import ig.zeus.domain.service.command.ControllerCommand;

public class ControllerService implements IControllerService {
	private IControllerRepository iControllerRepository;
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private Controller controller;
	private ControllerCommand controllerCommand;

	public IControllerRepository getiControllerRepository() {
		return iControllerRepository;
	}

	public void setiControllerRepository(IControllerRepository iControllerRepository) {
		this.iControllerRepository = iControllerRepository;
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	public ControllerCommand getControllerViewModel() {
		return controllerCommand;
	}

	public void setControllerViewModel(ControllerCommand controllerCommand) {
		this.controllerCommand = controllerCommand;
	}

	@Override
	public int remove(Integer id) {
		return iControllerRepository.remove(id);
	}

	@Override
	public int add(ControllerCommand entity) {
		controller = dozer.map(entity, Controller.class);
		return iControllerRepository.add(controller);
	}

	@Override
	public int update(ControllerCommand entity) {
		controller = dozer.map(entity, Controller.class);
		return iControllerRepository.update(controller);
	}
}
