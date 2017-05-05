package ig.zeus.domain.model.user;

import java.util.Date;

import ig.archer.domain.object.IAggregateRoot;
import ig.archer.domain.object.identity.Entity;

/**
 * 用户实体类 聚合根
 * 
 * @author Administrator
 *
 */
public class User extends Entity implements IAggregateRoot<Integer> {
	/**
	 * 属性
	 */
	private String userName;
	private String userPass;
	private String phone;
	private Byte sex;
	private Integer organid;
	private Integer postid;
	private Date birthday;
	private String identitycard;
	private String nativeplace;
	private String address;
	private String cellphone;
	private Byte politicsstatus;
	private Date createdate;
	private String description;
	private Integer ID;

	/**
	 * 默认构造方法
	 */
	public User() {
		this.getLogger().debug("create user");
	}

	/**
	 * 构造方法
	 * 
	 * @param userName
	 * @param userPass
	 * @param phone
	 * @param sex
	 * @param organ
	 * @param post
	 */

	/**
	 * 获取id值
	 */
	public Integer getID() {

		return this.ID;
	}

	/**
	 * 设置id
	 */
	public void setID(Integer id) {
		this.ID = id;

	}

	/**
	 * 获取有效性
	 */
	public boolean getAvailability() {

		return super.getAvailability();
	}

	/**
	 * 设置有效性
	 */
	public void setAvailability(boolean availability) {
		super.setAvailability(availability);

	}

	/**
	 * 获取用户名称
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置用户名称
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取用户密码
	 * 
	 * @return
	 */
	public String getUserPass() {
		return userPass;
	}

	/**
	 * 设置用户密码
	 * 
	 * @param userPass
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	/**
	 * 获取用户电话
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置用户电话号码
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
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
		this.identitycard = identitycard;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 释放资源
	 */
	public void dispose() {

	}

}
