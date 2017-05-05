package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.exception.SavedFailureException;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import ig.zeus.domain.repository.viewmodel.EmployeeViewModel;
/**
 * 账户仓储接口，定义了特有的仓储接口
 */
public interface IAccountQueryRepository extends IRepository<AccountViewModel, Integer> {

	/**
	 * 账户登录。
	 * 
	 * @param name
	 *            账户名。
	 * @param password
	 *            账户密码。
	 * @return 是否成功登出。
	 */
//	Account login(String name, String password);

	/**
	 * 账户登出。
	 * 
	 * @param name
	 *            账户名。
	 * @return 是否正常登出。
	 */
//	boolean logout(String name);

	/**
	 * 列出用户全部角色列表。
	 * 
	 * @return 角色列表。
	 */
//	List<Integer> listAccountRoles();

	
	
	/**
	 * 增加新的角色。
	 * 
	 * @param roleID
	 *            角色ID
	 * @return
	 * @throws SavedFailureException
	 */
	boolean addRole(int accountID, int roleID) throws SavedFailureException;

	boolean removeRole(int accountID, int roleID);
	
    /**
     * 查询所有的account
     * @return
     */
    List<AccountViewModel> findAll();
  
    /**
     * 根据id查询
     * @param name
     * @return
     */
    List<AccountViewModel> findByName(String name);
    /**
     * 分页查询
     * @param args
     * @return list<accountViewModel>
     */
   List<AccountViewModel> findPageData(PagingData args);
   /**
    * 计数
    * @return
    */
   int count();

   /**
    * 根据员工id查询账户信息和一个角色id
    * @return
    */
	AccountViewModel findByEmployeeId(int id);


}
