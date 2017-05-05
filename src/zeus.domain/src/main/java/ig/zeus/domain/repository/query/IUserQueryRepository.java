package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.EmployeeViewModel;

public interface IUserQueryRepository extends IRepository<EmployeeViewModel, Integer> {

	/**
	 * 查询所有
	 * 
	 * @return list
	 */
	List<EmployeeViewModel> findAll();
	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
    List<EmployeeViewModel> findPageData(PagingData args);
    /**
     * 计数查询
     * 
     * @return
     */
    int count(EmployeeViewModel viewModel);
	/**
	 * 根据部门ID,获取员工集合
	 * @param organID
	 * @return
	 */
    List<EmployeeViewModel> findEmployeeByOrganID(Integer organID);
}
