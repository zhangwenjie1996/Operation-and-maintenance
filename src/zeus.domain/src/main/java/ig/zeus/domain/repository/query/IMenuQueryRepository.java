package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.MenuViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;
import ig.zeus.domain.repository.viewmodel.TreeViewModel;

/**
 * @author wxf
 *
 */
public interface IMenuQueryRepository extends IRepository<MenuViewModel, Integer> {
	/**
	 * 查询所有
	 * 
	 * @return list
	 */
	List<MenuViewModel> findAll();

	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
	List<MenuViewModel> findPageData(PagingData args);

	/**
	 * 计数查询
	 * 
	 * @return
	 */
	int count();

	/**
	 * 查找菜单数
	 * 
	 * @return
	 */
	List<TreeListViewModel> findMenuTree(int systemId);

	/**
	 * 根据登陆人查询权限菜单
	 */
	List<TreeViewModel> findMenuTreeByRole(int systemId, Integer accountid);

	/**
	 * 账号为superadmin的根据系统查询全部菜单
	 */
	List<TreeViewModel> findMenuAllTree(int systemId);
}
