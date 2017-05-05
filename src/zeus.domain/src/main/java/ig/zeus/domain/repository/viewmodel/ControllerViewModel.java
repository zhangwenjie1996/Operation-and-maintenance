package ig.zeus.domain.repository.viewmodel;

import org.dozer.Mapping;

public class ControllerViewModel {
	@Mapping("ID")
    private Integer controllerid;
	@Mapping("moduleid")
	private Integer moduleid;
	@Mapping("name")
	private String controllername;
	@Mapping("signature")
    private String signature;
    @Mapping("index")
    private Integer sequence;
    @Mapping("description")
    private String description;
	@Mapping("availability")
	private Boolean availability;
    public Integer getControllerid() {
        return controllerid;
    }

    public void setControllerid(Integer controllerid) {
        this.controllerid = controllerid;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getModuleid() {
        return moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

	public String getControllername() {
		return controllername;
	}

	public void setControllername(String controllername) {
		this.controllername = controllername;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}
	
}