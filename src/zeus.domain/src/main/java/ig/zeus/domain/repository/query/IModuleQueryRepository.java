package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.ModuleViewModel;

public interface IModuleQueryRepository extends IRepository<ModuleViewModel, Integer> {
	/**
	 * 查询所有
	 * @return list
	 */
	List<ModuleViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
	List<ModuleViewModel> findPageData(PagingData args);
	/**
     * 计数查询
     * 
     * @return
     */
    int count();
}
