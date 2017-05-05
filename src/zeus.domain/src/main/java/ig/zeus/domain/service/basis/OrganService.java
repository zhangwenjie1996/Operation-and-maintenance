package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.user.Organ;
import ig.zeus.domain.repository.command.IOrganRepository;
import ig.zeus.domain.service.IOrganService;
import ig.zeus.domain.service.command.OrganCommand;

public class OrganService implements IOrganService {
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private IOrganRepository iOrganRepository;
	private Organ organ;
	private OrganCommand organCommand;

	public IOrganRepository getiOrganRepository() {
		return iOrganRepository;
	}

	public void setiOrganRepository(IOrganRepository iOrganRepository) {
		this.iOrganRepository = iOrganRepository;
	}

	public Organ getOrgan() {
		return organ;
	}

	public void setOrgan(Organ organ) {
		this.organ = organ;
	}

	public OrganCommand getOrganViewModel() {
		return organCommand;
	}

	public void setOrganViewModel(OrganCommand organViewModel) {
		this.organCommand = organViewModel;
	}

	@Override
	public int remove(Integer id) {
		return iOrganRepository.remove(id);
	}

	@Override
	public int add(OrganCommand entity) {
		organ = dozer.map(entity, Organ.class);
		iOrganRepository.add(organ);
		return organ.getID();
	}

	@Override
	public int update(OrganCommand entity) {
		organ = dozer.map(entity, Organ.class);
		return iOrganRepository.update(organ);
	}

}
