package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class RoleControllerCommand {
	@Mapping("roleId")
    private Integer roleid;
	@Mapping("resourceId")
    private Integer controllerid;
	@Mapping("permission")
    private Byte menupermission;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getControllerid() {
        return controllerid;
    }

    public void setControllerid(Integer controllerid) {
        this.controllerid = controllerid;
    }

    public Byte getMenupermission() {
        return menupermission;
    }

    public void setMenupermission(Byte menupermission) {
        this.menupermission = menupermission;
    }
}