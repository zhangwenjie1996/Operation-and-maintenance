package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.resource.ui.Element;
import ig.zeus.domain.repository.command.IElementRepository;
import ig.zeus.domain.service.IElementService;
import ig.zeus.domain.service.command.ElementCommand;

public class ElementService implements IElementService {
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private IElementRepository iElementRepository;
	private Element element;
	private ElementCommand elementCommand;

	public IElementRepository getiElementRepository() {
		return iElementRepository;
	}

	public void setiElementRepository(IElementRepository iElementRepository) {
		this.iElementRepository = iElementRepository;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public ElementCommand getElementViewModel() {
		return elementCommand;
	}

	public void setElementViewModel(ElementCommand elementViewModel) {
		this.elementCommand = elementViewModel;
	}

	@Override
	public int remove(Integer id) {
		return iElementRepository.remove(id);
	}

	@Override
	public int add(ElementCommand entity) {
		element = dozer.map(entity, Element.class);
		iElementRepository.add(element);
		return element.getID();
	}

	@Override
	public int update(ElementCommand entity) {
		element = dozer.map(entity, Element.class);
		return iElementRepository.update(element);
	}
}
