package ig.zeus.domain.repository.command;

import ig.archer.domain.repository.IRepository;
import ig.zeus.domain.model.user.User;

public interface IUserRepository extends IRepository<User, Integer> {

	int addEmployeeAccount(Integer employeeid, int accountId);

	// 删除员工账户信息
	int removeEmployeeAccount(int id);

	Integer findAccountId(int id);

}
