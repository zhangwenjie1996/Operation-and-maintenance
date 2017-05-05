package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.resource.server.Module;
import ig.zeus.domain.repository.command.IModuleRepository;
import ig.zeus.domain.service.IModuleService;
import ig.zeus.domain.service.command.ModuleCommand;

public class ModuleService implements IModuleService {
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private IModuleRepository iModuleRepository;
	private ModuleCommand moduleCommand;
	private Module module;

	public IModuleRepository getiModuleRepository() {
		return iModuleRepository;
	}

	public void setiModuleRepository(IModuleRepository iModuleRepository) {
		this.iModuleRepository = iModuleRepository;
	}

	public ModuleCommand getModuleViewModel() {
		return moduleCommand;
	}

	public void setModuleViewModel(ModuleCommand moduleCommand) {
		this.moduleCommand = moduleCommand;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	@Override
	public int remove(Integer id) {
		return iModuleRepository.remove(id);
	}

	@Override
	public int add(ModuleCommand entity) {
		module = dozer.map(entity, Module.class);
		return iModuleRepository.add(module);
	}

	@Override
	public int update(ModuleCommand entity) {
		module = dozer.map(entity, Module.class);
		return iModuleRepository.update(module);
	}
}
