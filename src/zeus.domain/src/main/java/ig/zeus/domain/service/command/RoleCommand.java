package ig.zeus.domain.service.command;

import org.dozer.Mapping;

/**
 * 角色veiwmodel
 * 
 * @author Administrator
 *
 */
public class RoleCommand  {
	/*
	 * PrivateVariable
	 */
	@Mapping("ID")
	private Integer roleid;
	@Mapping("roleName")
	private String rolename;
	@Mapping("roletype")
	private Byte roletype;
	@Mapping("quota")
	private Integer quota;
	@Mapping("availability")
	private Boolean availability;
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

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	
}