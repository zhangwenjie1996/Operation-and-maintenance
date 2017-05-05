package ig.zeus.domain.repository.viewmodel;

public class PostViewModel {
	private Integer postid;
	private Integer organid;
	private String postname;
	private Integer standardnumber;
	private String description;
	private String availability;
	private String organname;

	/**
	 * @return the organname
	 */
	public String getOrganname() {
		return organname;
	}

	/**
	 * @param organname
	 *            the organname to set
	 */
	public void setOrganname(String organname) {
		this.organname = organname;
	}

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

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public PostViewModel() {
	}

}