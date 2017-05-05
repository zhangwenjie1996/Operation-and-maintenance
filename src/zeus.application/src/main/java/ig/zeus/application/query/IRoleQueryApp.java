package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.RoleViewModel;

public interface IRoleQueryApp {
	StateData<PagingData> findPageData(int current, int rowCount);

	StateData<RoleViewModel> findById(int roleid);

	StateData<List<RoleViewModel>> findAllSelect();
}
