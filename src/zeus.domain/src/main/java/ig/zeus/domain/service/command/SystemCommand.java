package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class SystemCommand {
	@Mapping("ID")
	private Integer systemid;
	@Mapping("name")
	private String systemname;
	@Mapping("signature")
	private String signature;
	@Mapping("url")
	private String url;
	@Mapping("description")
	private String description;
	@Mapping("availability")
	private Boolean availability;

	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname == null ? null : systemname.trim();
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature == null ? null : signature.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getSystemid() {
		return systemid;
	}

	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

}