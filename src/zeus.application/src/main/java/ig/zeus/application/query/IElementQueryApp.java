package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.ElementViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;

public interface IElementQueryApp  {
	StateData<PagingData> findAllByMenuId(int current, int rowCount, int organID,int roleid);

	StateData<ElementViewModel> findById(int id);

	StateData<List<TreeListViewModel>> findElementTree(int menuId);
}
