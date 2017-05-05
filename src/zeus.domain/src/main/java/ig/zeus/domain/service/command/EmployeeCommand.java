package ig.zeus.domain.service.command;

import java.util.Date;

import org.dozer.Mapping;

public class EmployeeCommand {
	@Mapping("ID")
	private Integer employeeid;
	@Mapping("organid")
	private Integer organid;
	@Mapping("postid")
	private Integer postid;
	@Mapping("userName")
	private String employeename;
	@Mapping("sex")
	private Byte sex;
	@Mapping("birthday")
	private Date birthday;
	@Mapping("identitycard")
	private String identitycard;
	@Mapping("nativeplace")
	private String nativeplace;
	@Mapping("address")
	private String address;
	@Mapping("phone")
	private String phone;
	@Mapping("cellphone")
	private String cellphone;
	@Mapping("politicsstatus")
	private Byte politicsstatus;
	@Mapping("createdate")
	private Date createdate;
	@Mapping("availability")
	private boolean availability;
	@Mapping("description")
	private String description;

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Integer getOrganid() {
		return organid;
	}

	public void setOrganid(Integer organid) {
		this.organid = organid;
	}

	public Integer getPostid() {
		return postid;
	}

	public void setPostid(Integer postid) {
		this.postid = postid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename == null ? null : employeename.trim();
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentitycard() {
		return identitycard;
	}

	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard == null ? null : identitycard.trim();
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace == null ? null : nativeplace.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone == null ? null : cellphone.trim();
	}

	public Byte getPoliticsstatus() {
		return politicsstatus;
	}

	public void setPoliticsstatus(Byte politicsstatus) {
		this.politicsstatus = politicsstatus;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
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
		this.description = description == null ? null : description.trim();
	}
}