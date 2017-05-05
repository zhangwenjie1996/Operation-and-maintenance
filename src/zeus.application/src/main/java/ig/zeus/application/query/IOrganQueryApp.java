package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;
import ig.zeus.domain.repository.viewmodel.OrganViewModel;
import ig.zeus.domain.repository.viewmodel.TreeViewModel;

/**
 * 部门服务接口
 * 
 * @author Administrator
 *
 */
public interface IOrganQueryApp {
	List<OrganViewModel> findPageData(PagingData args);

	int count();

	StateData<OrganViewModel> findById(int id);

	/**
	 * 部门树显示
	 * */
	StateData<List<TreeListViewModel>> findOrganListTree();

	StateData<List<TreeViewModel>> findOrganTree();
}
