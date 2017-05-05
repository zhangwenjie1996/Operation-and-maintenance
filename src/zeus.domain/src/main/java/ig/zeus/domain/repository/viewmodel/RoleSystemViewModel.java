package ig.zeus.domain.repository.viewmodel;

public class RoleSystemViewModel {
    private Integer systemid;

    private Integer roleid;

    private Byte menupermission;

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