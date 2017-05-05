package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.AccountCommand;
import ig.zeus.domain.service.command.EmployeeCommand;

/**
 * 用户服务接口
 * 
 * @author Administrator
 *
 */
public interface IUserApp {

	StateData<Boolean> removeEmployee(Integer id);

	StateData<Integer> addEmployee(EmployeeCommand entity);

	StateData<Boolean> updateEmployee(EmployeeCommand entity);

	StateData<Boolean> addAccount(AccountCommand accountCommand, Integer employeeid);

	StateData<Boolean> updateAccount(AccountCommand accountCommand, int employeeid);

}
