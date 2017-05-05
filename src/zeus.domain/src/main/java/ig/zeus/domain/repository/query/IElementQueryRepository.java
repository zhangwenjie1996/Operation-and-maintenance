package ig.zeus.domain.repository.query;

import java.util.List;

import ig.zeus.domain.repository.viewmodel.ElementViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;

public interface IElementQueryRepository {

	List<ElementViewModel> findAllByMenuId(int i, int rowCount, int menuID,int roleid);

	int countByMenuId(int menuID);

	ElementViewModel findById(int id);

	List<TreeListViewModel> findElementTree(int menuId);
}
