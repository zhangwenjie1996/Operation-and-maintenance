package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.SystemViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;

public interface ISystemQueryApp{
	StateData<PagingData> findPageData(int current, int rowCount);

	StateData<SystemViewModel> findById(int id);

	StateData<List<SystemViewModel>> findAllSelect();

	StateData<List<TreeListViewModel>> findSystemTree();
}
