package ig.zeus.domain.model;

import java.util.List;

import ig.archer.domain.object.identity.AggregateRoot;

/**
 * 用户类，为该领域的聚合根。
 * 
 * @author reize
 *
 */
public class Account extends AggregateRoot {

	/*
	 * PrivateVariable
	 */
	private Integer ID;
	private String accountname;
	private String accountpass;
	private int activeRole;
	private List<Integer> roles;
	private Integer roleID;
	/*
	 * Getter&Setter
	 */
	/**
	 * 获取账户当前角色
	 * 
	 * @return activeRole
	 */
	public int getActiveRole() {
		return activeRole;
	}

	/**
	 * 获取账户名称
	 * 
	 * @return activeRole
	 */
	public String getAccountname() {
		return accountname;
	}
	
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the roleID
	 */
	public Integer getRoleID() {
		return roleID;
	}

	/**
	 * @param roleID the roleID to set
	 */
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	/**
	 * 设置账户名称
	 * 
	 * @param accountname
	 */
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	/**
	 * 获取账户密码
	 * 
	 * @return activeRole
	 */
	public String getAccountpass() {
		return accountpass;
	}

	/**
	 * 设置账户密码
	 * 
	 * @param accountpass
	 */
	public void setAccountpass(String accountpass) {
		this.accountpass = accountpass;
	}

	/**
	 * 设置用户当前角色
	 * 
	 * @param activeRole
	 */
	public void setActiveRole(int activeRole) {
		this.activeRole = activeRole;
	}

	/**
	 * 设置账户角色
	 * 
	 * @param roles
	 */
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

	/**
	 * 获取账户角色list
	 * 
	 * @return the roles
	 */
	public List<Integer> getRoles() {
		return roles;
	}

	/*
	 * Constructors
	 */

	public Account() {

	}

	/*
	 * PublicMethod
	 */

	/**
	 * 为账户增加新角色。
	 * 
	 * @param roleID
	 *            新角色ID。
	 * @throws Exception
	 */
	public void addRole(int roleID) throws Exception {
		roles.add(roleID);
//		this.RaiseEvent(new ChangeRoleEvent(DataOperateType.Create, this.getID(), roleID));
	}

	/**
	 * 为账户移除某个角色。
	 * 
	 * @param roleID
	 *            角色ID。
	 * @throws Exception
	 */
	public void removeRole(int roleID) throws Exception {
		roles.remove(roleID);
//		this.RaiseEvent(new ChangeRoleEvent(DataOperateType.Remove, this.getID(), roleID));
	}
	//
	// /**
	// * 修改当前活动的角色。
	// *
	// * @param roleID 角色ID。
	// */
	// public void changeRole(int roleID) {
	// this.activeRole = roleID;
	// }

	public void dispose() {
		this.roles.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountname=" + accountname + ", accountpass=" + accountpass + ", activeRole=" + activeRole
				+ ", roles=" + roles + ", availability=]";
	}

}
