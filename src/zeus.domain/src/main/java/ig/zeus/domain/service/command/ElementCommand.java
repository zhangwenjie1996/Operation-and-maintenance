package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class ElementCommand {
	@Mapping("ID")
    private Integer elementid;
	@Mapping("menuid")
    private Integer menuid;
	@Mapping("name")
    private String elementname;
	@Mapping("signature")
    private String signature;
	@Mapping("elementType")
    private Byte elementtype;
	@Mapping("availability")
    private Boolean availability;

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

  
    /**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Byte getElementtype() {
        return elementtype;
    }

    public void setElementtype(Byte elementtype) {
        this.elementtype = elementtype;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}