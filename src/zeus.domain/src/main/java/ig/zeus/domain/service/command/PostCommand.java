package ig.zeus.domain.service.command;

import org.dozer.Mapping;

public class PostCommand {
	@Mapping("ID")
	private Integer postid;
	@Mapping("organid")
	private Integer organid;
	@Mapping("postName")
	private String postname;
	@Mapping("standardnumber")
	private Integer standardnumber;
	@Mapping("description")
	private String description;
	@Mapping("availability")
	private boolean availability;

	public Integer getOrganid() {
		return organid;
	}

	public void setOrganid(Integer organid) {
		this.organid = organid;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname == null ? null : postname.trim();
	}

	public Integer getStandardnumber() {
		return standardnumber;
	}

	public void setStandardnumber(Integer standardnumber) {
		this.standardnumber = standardnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public PostCommand() {
	}

}