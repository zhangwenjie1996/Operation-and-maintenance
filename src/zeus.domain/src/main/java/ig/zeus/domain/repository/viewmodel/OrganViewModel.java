package ig.zeus.domain.repository.viewmodel;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门viewmodel
 * 
 * @author Administrator
 *
 */
public class OrganViewModel {
	/*
	 * 属性
	 */
	private Integer organid;
	private Integer parentorganid;
	private String coding;
	private String organname;
	private String shortname;
	private Integer sequence;
	private Byte category;
	private String governor;
	private String availability;
	private String description;

	private List<OrganViewModel> organViewModels = new ArrayList<>();

	/*
	 * getter&setter
	 */

	/**
	 * @return the organViewModels
	 */
	public List<OrganViewModel> getOrganViewModels() {
		return organViewModels;
	}

	/**
	 * @param organViewModels
	 *            the organViewModels to set
	 */
	public void setOrganViewModels(List<OrganViewModel> organViewModels) {
		this.organViewModels = organViewModels;
	}

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

	/**
	 * @return the availability	
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability
	 *            the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}