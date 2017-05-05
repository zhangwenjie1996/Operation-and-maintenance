package ig.zeus.domain.repository.command;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.zeus.domain.model.resource.ui.Menu;

public interface IMenuRepository extends IRepository<Menu, Integer> {
	/**
	 * 查询全部
	 * 
	 * @return
	 */
	List<Menu> findAll();
}
