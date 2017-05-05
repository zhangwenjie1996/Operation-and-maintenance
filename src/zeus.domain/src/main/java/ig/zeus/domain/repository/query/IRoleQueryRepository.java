package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.RoleViewModel;

/**
 * 角色仓储接口，定义了特有的仓储接口
 */
public interface IRoleQueryRepository extends IRepository<RoleViewModel, Integer> {
	/**
	 * 查询所有
	 * @return list
	 */
	List<RoleViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
	List<RoleViewModel> findPageData(PagingData args);
	/**
     * 计数查询
     * 
     * @return
     */
    int count();
	List<RoleViewModel> findAllSelect();
}
