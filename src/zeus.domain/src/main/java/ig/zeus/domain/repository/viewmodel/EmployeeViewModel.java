package ig.zeus.domain.repository.viewmodel;

public class EmployeeViewModel {
	private Integer employeeid;
	private Integer organid;
	private Integer postid;
	private String employeename;
	private String sex;
	private String birthday;
	private String identitycard;
	private String nativeplace;
	private String address;
	private String phone;
	private String cellphone;
	private String politicsstatus;
	private String createdate;
	private String availability;
	private String description;
	private String organname;
	private String postname;
	private String roleName;
	private String accountName;

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getPostname() {
		return postname;
	}

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

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

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

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the identitycard
	 */
	public String getIdentitycard() {
		return identitycard;
	}

	/**
	 * @param identitycard
	 *            the identitycard to set
	 */
	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}

	/**
	 * @return the nativeplace
	 */
	public String getNativeplace() {
		return nativeplace;
	}

	/**
	 * @param nativeplace
	 *            the nativeplace to set
	 */
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the cellphone
	 */
	public String getCellphone() {
		return cellphone;
	}

	/**
	 * @param cellphone
	 *            the cellphone to set
	 */
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	/**
	 * @return the politicsstatus
	 */
	public String getPoliticsstatus() {
		return politicsstatus;
	}

	/**
	 * @param politicsstatus
	 *            the politicsstatus to set
	 */
	public void setPoliticsstatus(String politicsstatus) {
		this.politicsstatus = politicsstatus;
	}

	/**
	 * @return the createdate
	 */
	public String getCreatedate() {
		return createdate;
	}

	/**
	 * @param createdate
	 *            the createdate to set
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
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

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}