package ig.zeus.domain.repository.viewmodel;

public class ElementViewModel {
    private Integer elementid;
    private Integer menuid;
    private String elementname;
    private String signature;
    private Byte elementtype;
    private String availability;
    private String roleid;
    private String permission;

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getPermission() {
        return permission;
    }

    public String getRoleid() {
        return roleid;
    }

    public Integer getElementid() {
        return elementid;
    }

    public void setElementid(Integer elementid) {
        this.elementid = elementid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getElementname() {
        return elementname;
    }

    public void setElementname(String elementname) {
        this.elementname = elementname == null ? null : elementname.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Byte getElementtype() {
        return elementtype;
    }

    public void setElementtype(Byte elementtype) {
        this.elementtype = elementtype;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

}