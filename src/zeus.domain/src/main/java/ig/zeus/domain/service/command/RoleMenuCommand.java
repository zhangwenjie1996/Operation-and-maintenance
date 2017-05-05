package ig.zeus.domain.service.command;

public class RoleMenuCommand {
    private Integer menuid;

    private Integer roleid;

    private Byte menupermission;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
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