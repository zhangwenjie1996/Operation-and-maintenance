package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;
import ig.zeus.domain.repository.viewmodel.OrganViewModel;
import ig.zeus.domain.repository.viewmodel.TreeViewModel;

public interface IOrganQueryRepository extends IRepository<OrganViewModel, Integer> {
	/**
	 * 查询所有
	 * @return list
	 */
	List<OrganViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
	List<OrganViewModel> findPageData(PagingData args);
	/**
     * 计数查询
     * 
     * @return
     */
    int count();
    
	List<TreeListViewModel> findOrganTree();
	List<TreeListViewModel> findOrganListTree();
	
	List<OrganViewModel> findOrganListSelect();

	List<TreeViewModel> findOrganReactTree();
}
