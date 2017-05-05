package ig.zeus.domain.repository.command;

import ig.archer.domain.repository.IRepository;
import ig.zeus.domain.model.Account;

/**
 * 账户仓储接口，定义了特有的仓储接口
 */
/**
 * @author Administrator
 *
 */
public interface IAccountRepository extends IRepository<Account, Integer> {

	/**
	 * 添加账户角色。
	 * 
	 * @param accountID
	 * @param roleID
	 */
	int addRole(int accountID, int roleID);

	/**
	 * 移除账户角色。
	 * 
	 * @param accountID
	 * @param roleID
	 */
	int removeRole(int accountID, int roleID);

	/**
	 * 根据名字查询
	 * 
	 * @param name
	 * @return
	 */
	Account findByName(String name);

	/**
	 * 增加角色账户信息
	 * @author wxf
	 * @param 
	 * @return
	 */

	int addRoleAccount(int accountId, int roleId);

	/**
	 * 更新角色账户信息
	 * @param arc
	 * @return
	 */
	int updateRoleAccount(int accountId, int roleId);
	//删除角色账户关系
	int removeRoleAccount(int id);
}
