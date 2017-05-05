package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.resource.ui.Menu;
import ig.zeus.domain.repository.command.IMenuRepository;
import ig.zeus.domain.service.IMenuService;
import ig.zeus.domain.service.command.MenuCommand;

public class MenuService implements IMenuService {
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private IMenuRepository iMenuRepository;
	private MenuCommand menuCommand;
	private Menu menu;

	public IMenuRepository getiMenuRepository() {
		return iMenuRepository;
	}

	public void setiMenuRepository(IMenuRepository iMenuRepository) {
		this.iMenuRepository = iMenuRepository;
	}

	public MenuCommand getMenuViewModel() {
		return menuCommand;
	}

	public void setMenuViewModel(MenuCommand menuViewModel) {
		this.menuCommand = menuViewModel;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public int remove(Integer id) {
		return iMenuRepository.remove(id);
	}

	@Override
	public int add(MenuCommand entity) {
		menu = dozer.map(entity, Menu.class);
		iMenuRepository.add(menu);
		return menu.getID();
	}

	@Override
	public int update(MenuCommand entity) {
		menu = dozer.map(entity, Menu.class);
		return iMenuRepository.update(menu);
	}

}
