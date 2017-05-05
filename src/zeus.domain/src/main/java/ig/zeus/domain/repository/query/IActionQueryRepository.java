package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.ActionViewModel;

public interface IActionQueryRepository extends IRepository<ActionViewModel, Integer> {
	/**
	 * 查询全部
	 * @return
	 */
	List<ActionViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
    List<ActionViewModel> findPageData(PagingData args);
    /**
     * 计数查询
     * 
     * @return
     */
    int count();
}
