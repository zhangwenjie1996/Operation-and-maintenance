package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.ControllerViewModel;

public interface IControllerQueryApp extends IBaseQuery<ControllerViewModel> {
	List<ControllerViewModel> findPageData(PagingData args);
	int count();
}
