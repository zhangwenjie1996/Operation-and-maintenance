package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.ControllerViewModel;

public interface IControllerQueryRepository extends IRepository<ControllerViewModel, Integer> {
	/**
	 * 查询所有
	 * @return list
	 */
	List<ControllerViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
    List<ControllerViewModel> findPageData(PagingData args);
    /**
     * 计数查询
     * 
     * @return
     */
    int count();
}
