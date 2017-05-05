package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.ModuleViewModel;

/**
 * 页面元素接口
 * 
 * @author Administrator
 *
 */
public interface IModuleQueryApp extends IBaseQuery<ModuleViewModel> {
	List<ModuleViewModel> findPageData(PagingData args);
	int count();
}
