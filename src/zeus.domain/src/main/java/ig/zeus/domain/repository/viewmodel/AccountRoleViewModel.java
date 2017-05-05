package ig.zeus.domain.repository.viewmodel;

public class AccountRoleViewModel {
	private Integer accountid;
	private Integer roleid;
	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public AccountRoleViewModel(Integer accountid, Integer roleid) {
		super();
		this.accountid = accountid;
		this.roleid = roleid;
	}

}
