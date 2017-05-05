package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class ModuleCommand {
	@Mapping("ID")
	private Integer moduleid;
	@Mapping("name")
    private String modulename;
	@Mapping("signature")
    private String signature;
	@Mapping("index")
    private Integer sequence;
	@Mapping("description")
    private String description;
	@Mapping("availability")
	private Boolean availability;

   

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }


    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Boolean getAvailability() {
		return availability;
	}

	

	
}