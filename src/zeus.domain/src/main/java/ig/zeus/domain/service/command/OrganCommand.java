package ig.zeus.domain.service.command;

import org.dozer.Mapping;

/**
 * 部门viewmodel
 * 
 * @author Administrator
 *
 */
public class OrganCommand {
	/*
	 * 属性
	 */
	@Mapping("ID")
	private Integer organid;
	@Mapping("parentorganid")
	private Integer parentorganid;
	@Mapping("coding")
	private String coding;
	@Mapping("organName")
	private String organname;
	@Mapping("shortname")
	private String shortname;
	@Mapping("sequence")
	private Integer sequence;
	@Mapping("category")
	private Byte category;
	@Mapping("governor")
	private String governor;
	@Mapping("availability")
	private boolean availability;
	@Mapping("discription")
	private String description;
	/*
	 * getter&setter
	 */

	public Integer getParentorganid() {
		return parentorganid;
	}

	public void setParentorganid(Integer parentorganid) {
		this.parentorganid = parentorganid;
	}

	public String getCoding() {
		return coding;
	}

	public void setCoding(String coding) {
		this.coding = coding == null ? null : coding.trim();
	}

	public String getOrganname() {
		return organname;
	}

	public void setOrganname(String organname) {
		this.organname = organname == null ? null : organname.trim();
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname == null ? null : shortname.trim();
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Byte getCategory() {
		return category;
	}

	public void setCategory(Byte category) {
		this.category = category;
	}

	public Integer getOrganid() {
		return organid;
	}

	public void setOrganid(Integer organid) {
		this.organid = organid;
	}

	public String getGovernor() {
		return governor;
	}

	public void setGovernor(String governor) {
		this.governor = governor;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}