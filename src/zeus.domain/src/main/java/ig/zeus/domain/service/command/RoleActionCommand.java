package ig.zeus.domain.service.command;

public class RoleActionCommand {
    private Integer roleid;

    private Integer actionid;

    private Byte menupermission;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getActionid() {
        return actionid;
    }

    public void setActionid(Integer actionid) {
        this.actionid = actionid;
    }

    public Byte getMenupermission() {
        return menupermission;
    }

    public void setMenupermission(Byte menupermission) {
        this.menupermission = menupermission;
    }
}