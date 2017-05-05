package ig.zeus.domain.service.command;

public class RoleSystemCommand {
	
	private Integer systemid;
	private Integer roleid;

	private Byte menupermission;

	public RoleSystemCommand() {
		super();
	}

	public RoleSystemCommand(int roleid, int systemid) {
		this.systemid = systemid;
		this.roleid = roleid;
	}

	public Integer getSystemid() {
		return systemid;
	}

	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Byte getMenupermission() {
		return menupermission;
	}

	public void setMenupermission(Byte menupermission) {
		this.menupermission = menupermission;
	}
}