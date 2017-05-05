package ig.zeus.domain.repository.viewmodel;

/**
 * 角色veiwmodel
 * 
 * @author Administrator
 *
 */
public class RoleViewModel {
	/*
	 * PrivateVariable
	 */
	private Integer roleid;
	private String rolename;
	private Byte roletype;
	private Integer quota;
	private String availability;
	/*
	 * Getter&Setter
	 */

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename == null ? null : rolename.trim();
	}

	public Byte getRoletype() {
		return roletype;
	}

	public void setRoletype(Byte roletype) {
		this.roletype = roletype;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 *            the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

}