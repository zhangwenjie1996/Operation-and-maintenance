package ig.zeus.domain.repository.viewmodel;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 账户viewmodel
 * 
 * @author Administrator
 *
 */
public class AccountViewModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * PrivateVariable
	 */
	private Integer accountid;
	private String accountname;
	private String accountpass;
	private boolean availability;
	private Integer employeeid;
	private Integer organid;
	private Integer postid;
	private String employeename;
	// 角色id(一对一关系)
	private Integer roleId;

	private String date;
	public AccountViewModel(){
		super();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.date =simpleDateFormat.format(new Date());
	}
	
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
	 * @return the employeeid
	 */
	public Integer getEmployeeid() {
		return employeeid;
	}

	/**
	 * @param employeeid
	 *            the employeeid to set
	 */
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	/**
	 * @return the organid
	 */
	public Integer getOrganid() {
		return organid;
	}

	/**
	 * @param organid
	 *            the organid to set
	 */
	public void setOrganid(Integer organid) {
		this.organid = organid;
	}

	/**
	 * @return the postid
	 */
	public Integer getPostid() {
		return postid;
	}

	/**
	 * @param postid
	 *            the postid to set
	 */
	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	/**
	 * @return the employeename
	 */
	public String getEmployeename() {
		return employeename;
	}

	/**
	 * @param employeename
	 *            the employeename to set
	 */
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
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

	/**
	 * @return 返回 date。
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date 设置 date 字段。
	 */
	public void setDate(String date) {
		this.date =date;
	}

}