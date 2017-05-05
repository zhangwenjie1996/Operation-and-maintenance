package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.SystemViewModel;
import ig.zeus.domain.repository.viewmodel.TreeListViewModel;

/*
 *系统仓储接口，定义了特有的仓储接口
 */
public interface ISystemQueryRespository extends IRepository<SystemViewModel, Integer> {
	/**
	 * 查询所有
	 * @return list
	 */
	List<SystemViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
	List<SystemViewModel> findPageData(PagingData args);
	/**
	 * 分页查询
	 * 
	 * @return
	 */
    int count();
    
	/**查询系统下拉框使用
	 * @return
	 */
	List<SystemViewModel> findAllSelect();
	/**
	 * 
	 * 查询系统树
	 * */
	List<TreeListViewModel> findSystemTree();
}
