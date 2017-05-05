package ig.zeus.domain.service;

import ig.zeus.domain.service.command.EmployeeCommand;

/**
 * 用户服务接口
 * 
 * @author Administrator
 *
 */
public interface IUserService extends IBaseService<EmployeeCommand> {
	/**
	 * 增加账户员工信息
	 * */
	int addEmployeeAccount(int employeeid, int accountId);
	/**
	 * 删除账户员工信息
	 * */
//	int removeEmployeeAccount(int id);

}
