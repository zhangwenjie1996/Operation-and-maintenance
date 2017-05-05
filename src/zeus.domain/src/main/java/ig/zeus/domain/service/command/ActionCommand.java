package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class ActionCommand {
	/*
	 * Variable
	 */
	@Mapping("ID")
	private Integer actionid;
	@Mapping("name")
	private String actionname;
	@Mapping("signature")
	private String signature;
	@Mapping("index")
	private Integer sequence;
	@Mapping("availability")
	private Boolean availability;
	@Mapping("description")
	private String description;
	@Mapping("controllerid")
	private Integer controllerid;

	/*
	 * Getter&Setter
	 */
	public Integer getActionid() {
		return actionid;
	}

	public void setActionid(Integer actionid) {
		this.actionid = actionid;
	}

	public String getActionname() {
		return actionname;
	}

	public void setActionname(String actionname) {
		this.actionname = actionname == null ? null : actionname.trim();
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

	public Boolean getAvailability() {
		return availability;
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

	public Integer getControllerid() {
		return controllerid;
	}

	public void setControllerid(Integer controllerid) {
		this.controllerid = controllerid;
	}
}