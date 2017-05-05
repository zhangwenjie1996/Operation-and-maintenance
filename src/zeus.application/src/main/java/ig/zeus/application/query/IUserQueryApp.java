package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import ig.zeus.domain.repository.viewmodel.EmployeeViewModel;

/**
 * 用户服务接口
 * 
 * @author Administrator
 *
 */
public interface IUserQueryApp  {
	StateData<PagingData> findPageData(PagingData args,EmployeeViewModel viewModel);

	StateData<EmployeeViewModel> findById(Integer id);

	StateData<AccountViewModel> findAccountByEmployeeId(Integer id);

	StateData<List<EmployeeViewModel>> findEmployeeByOrganID(Integer organID);
}
