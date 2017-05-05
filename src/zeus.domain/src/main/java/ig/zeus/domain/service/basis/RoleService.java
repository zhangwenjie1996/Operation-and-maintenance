package ig.zeus.domain.service.basis;

import org.dozer.DozerBeanMapper;

import ig.zeus.domain.model.Account;
import ig.zeus.domain.model.Role;
import ig.zeus.domain.repository.command.IAccountRepository;
import ig.zeus.domain.repository.command.IRoleRepository;
import ig.zeus.domain.service.IRoleService;
import ig.zeus.domain.service.command.AccountCommand;
import ig.zeus.domain.service.command.RoleCommand;

public class RoleService implements IRoleService {
	private DozerBeanMapper dozer = new DozerBeanMapper();
	private IRoleRepository iRoleRepository;
	private Role role;
	private RoleCommand roleCommand;
	private IAccountRepository iAccountRepository;
	private Account account;

	/**
	 * @return the iAccountRepository
	 */
	public IAccountRepository getiAccountRepository() {
		return iAccountRepository;
	}

	/**
	 * @param iAccountRepository
	 *            the iAccountRepository to set
	 */
	public void setiAccountRepository(IAccountRepository iAccountRepository) {
		this.iAccountRepository = iAccountRepository;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	public IRoleRepository getiRoleRepository() {
		return iRoleRepository;
	}

	public void setiRoleRepository(IRoleRepository iRoleRepository) {
		this.iRoleRepository = iRoleRepository;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleCommand getRoleCommand() {
		return roleCommand;
	}

	public void setRoleCommand(RoleCommand roleCommand) {
		this.roleCommand = roleCommand;
	}

	@Override
	public int remove(Integer id) {
		return iRoleRepository.remove(id);
	}

	@Override
	public int add(RoleCommand entity) {
		role = dozer.map(entity, Role.class);
		iRoleRepository.add(role);
		return role.getID();
	}

	@Override
	public int update(RoleCommand entity) {
		role = dozer.map(entity, Role.class);
		return iRoleRepository.update(role);
	}

	// 增加一个账户返回主键
	@Override
	public int addAccount(AccountCommand accountCommand) {
		account = dozer.map(accountCommand, Account.class);
		this.iAccountRepository.add(account);
		return account.getID();
	}

	@Override
	public int addRoleAccount(int accountId, int roleId) {
		return this.iAccountRepository.addRoleAccount(accountId, roleId);
	}

	@Override
	public int updateAccount(AccountCommand accountCommand) {
		account = dozer.map(accountCommand, Account.class);
		return this.iAccountRepository.update(account);
	}

	@Override
	public int updateRoleAccount(int accountId, int roleId) {
		return this.iAccountRepository.updateRoleAccount(accountId, roleId);
	}

	@Override
	public int removeRoleAccount(int id) {
		return this.iAccountRepository.removeRoleAccount(id);
	}

	@Override
	public int removeAccount(int accountId) {
		return this.iAccountRepository.remove(accountId);
	}

}
