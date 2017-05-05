package ig.zeus.domain.repository.viewmodel;

public class RoleControllerViewModel {
    private Integer roleid;

    private Integer controllerid;

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