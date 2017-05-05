package ig.zeus.domain.service.command;

public class RoleElementCommand {
    private Integer elementid;

    private Integer roleid;

    private Integer actionid;

    private Byte actionpermission;

    public Integer getElementid() {
        return elementid;
    }

    public void setElementid(Integer elementid) {
        this.elementid = elementid;
    }

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

    public Byte getActionpermission() {
        return actionpermission;
    }

    public void setActionpermission(Byte actionpermission) {
        this.actionpermission = actionpermission;
    }
}