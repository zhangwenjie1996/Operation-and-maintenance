package ig.zeus.domain.service;

import ig.zeus.domain.service.command.AccountCommand;
import ig.zeus.domain.service.command.RoleCommand;

/**
 * 角色接口
 * 
 * @author Administrator
 *
 */
public interface IRoleService extends IBaseService<RoleCommand> {

	/**
	 * 添加一个账户
	 */
	int addAccount(AccountCommand accountCommand);

	/**
	 * 添加一个账户角色关系
	 */
	int addRoleAccount(int accountId, int roleId);

	/**
	 * 更新一个账户信息
	 */
	int updateAccount(AccountCommand accountCommand);

	/**
	 * 更新一个账户角色关系
	 */
	int updateRoleAccount(int accountId, int roleId);

	/**
	 * 删除账户角色信息
	 */
	int removeRoleAccount(int id);

	/**
	 * 
	 * 删除账户信息
	 */
	int removeAccount(int accountId);

}
