package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.ActionViewModel;

/**
 * 角色服务接口
 * 
 * @author Administrator
 *
 */
public interface IActionQueryApp extends IBaseQuery<ActionViewModel> {
	List<ActionViewModel> findPageData(PagingData args);
	int count();
}
