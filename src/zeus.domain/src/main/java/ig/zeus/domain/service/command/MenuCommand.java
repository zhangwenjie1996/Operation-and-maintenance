package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class MenuCommand {
	@Mapping("ID")
    private Integer menuid;
	@Mapping("systemid")
    private Integer systemid;
	@Mapping("parentmenuid")
    private Integer parentmenuid;
	@Mapping("name")
    private String menuname;
	@Mapping("index")
    private Integer sequence;
	@Mapping("iconstyle")
    private String iconstyle;
	@Mapping("url")
    private String urladdress;
	@Mapping("signature")
    private String signature;
	@Mapping("description")
    private String description;

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getSystemid() {
        return systemid;
    }

    public void setSystemid(Integer systemid) {
        this.systemid = systemid;
    }

    public Integer getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(Integer parentmenuid) {
        this.parentmenuid = parentmenuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getIconstyle() {
        return iconstyle;
    }

    public void setIconstyle(String iconstyle) {
        this.iconstyle = iconstyle == null ? null : iconstyle.trim();
    }

    public String getUrladdress() {
        return urladdress;
    }

    public void setUrladdress(String urladdress) {
        this.urladdress = urladdress == null ? null : urladdress.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}