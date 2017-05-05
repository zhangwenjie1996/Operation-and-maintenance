package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import ig.zeus.domain.repository.viewmodel.MenuViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;
import ig.zeus.domain.repository.viewmodel.TreeViewModel;

/**
 * 菜单接口
 * 
 * @author Administrator
 *
 */
public interface IMenuQueryApp  {
	StateData<PagingData> findPageData(int current, int rowCount);

	StateData<MenuViewModel> findById(int id);

	StateData<List<TreeListViewModel>> findMenuTree(int systemId);

	StateData<List<TreeViewModel>> findMenuTreeByRole(int systemId, AccountViewModel account);
}
