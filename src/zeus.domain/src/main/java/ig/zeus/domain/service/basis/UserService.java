package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.Account;
import ig.zeus.domain.model.user.User;
import ig.zeus.domain.repository.command.IAccountRepository;
import ig.zeus.domain.repository.command.IUserRepository;
import ig.zeus.domain.service.IUserService;
import ig.zeus.domain.service.command.EmployeeCommand;

public class UserService implements IUserService {
	private DozerBeanMapper dozer = new DozerBeanMapper();

	// 对员工操作
	private IUserRepository iUserRepository;
	private User user;

	public IUserRepository getiUserRepository() {
		return iUserRepository;
	}

	public void setiUserRepository(IUserRepository iUserRepository) {
		this.iUserRepository = iUserRepository;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int remove(Integer id) {
		iUserRepository.remove(id);
		// 查找账户id
		Integer accountId = this.iUserRepository.findAccountId(id);
		if (accountId != null) {
			// 删除员工账户信息
			this.iUserRepository.removeEmployeeAccount(id);
			return accountId;
		} else {
			return 0;
		}
	}

	@Override
	public int add(EmployeeCommand entity) {
		user = dozer.map(entity, User.class);
		 iUserRepository.add(user);
		return user.getID();
	}

	@Override
	public int update(EmployeeCommand entity) {
		user = dozer.map(entity, User.class);
		return iUserRepository.update(user);
	}

	// 对账户操作
	private IAccountRepository iAccountRepository;
	private Account account;

	public IAccountRepository getiAccountRepository() {
		return iAccountRepository;
	}

	public void setiAccountRepository(IAccountRepository iAccountRepository) {
		this.iAccountRepository = iAccountRepository;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int addEmployeeAccount(int employeeid, int accountId) {
		return this.iUserRepository.addEmployeeAccount(employeeid, accountId);
	}

	// @Override
	// public int removeEmployeeAccount(int id) {
	// return this.iUserRepository.removeEmployeeAccount(id);
	// }
}
