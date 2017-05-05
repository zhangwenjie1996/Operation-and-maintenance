package ig.zeus.domain.service.command;

import org.dozer.Mapping;

/**
 * 账户viewmodel
 * 
 * @author Administrator
 *
 */
public class AccountCommand {
	/*
	 * PrivateVariable
	 */
	@Mapping("ID")
	private Integer accountid;
	@Mapping("accountname")
	private String accountname;
	@Mapping("accountpass")
	private String accountpass;
	@Mapping("availability")
	private boolean availability;
	@Mapping("roleID")
	private Integer roleId;

	/*
	 * Getter&Setter
	 */
	/**
	 * @return the accountid
	 */
	public Integer getAccountid() {
		return accountid;
	}

	/**
	 * @param accountid
	 *            the accountid to set
	 */
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	/**
	 * @return the accountname
	 */
	public String getAccountname() {
		return accountname;
	}

	/**
	 * @param accountname
	 *            the accountname to set
	 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	/**
	 * @return the accountpass
	 */
	public String getAccountpass() {
		return accountpass;
	}

	/**
	 * @param accountpass
	 *            the accountpass to set
	 */
	public void setAccountpass(String accountpass) {
		this.accountpass = accountpass;
	}

	/**
	 * @return the availability
	 */
	public boolean isAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 *            the availability to set
	 */
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}