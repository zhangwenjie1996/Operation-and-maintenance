package ig.zeus.domain.model.user;

import java.util.ArrayList;
import java.util.List;

import ig.archer.domain.object.identity.AggregateRoot;

/**
 * 部门实体类 聚合根
 * 
 * @author Administrator
 *
 */
public class Organ extends AggregateRoot {
	/**
	 * 属性
	 */
	private String organName;
	private List<Organ> chidren;
	private String discription;
	private List<User> userList = new ArrayList<User>();
	private String coding;
	private String shortname;
	private Integer parentorganid;
	private Integer sequence;
	private Byte category;
	private String governor;
	private Integer ID;

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD
	 *            the iD to set
	 */
	public void setID(Integer iD) {
		this.ID = iD;
	}

	/**
	 * 默认构造
	 */
	public Organ() {
	}

	/**
	 * 有参构造
	 * 
	 * @param organName
	 * @param chidren
	 * @param discription
	 * @param userList
	 */
	public Organ(String organName, List<Organ> chidren, String discription, List<User> userList, String coding,
			String shortname, Integer parentorganid, Integer sequence, Byte category, String governor) {
		super();
		this.organName = organName;
		this.chidren = chidren;
		this.discription = discription;
		this.userList = userList;
		this.coding = coding;
		this.shortname = shortname;
		this.parentorganid = parentorganid;
		this.sequence = sequence;
		this.category = category;
		this.governor = governor;
	}

	/**
	 * 获取部门名称
	 * 
	 * @return
	 */
	public String getOrganName() {
		return organName;
	}

	/**
	 * 
	 * @return parentorganid
	 */
	public Integer getParentorganid() {
		return parentorganid;
	}

	/**
	 * 
	 * @param parentorganid
	 */
	public void setParentorganid(Integer parentorganid) {
		this.parentorganid = parentorganid;
	}

	/**
	 * 设置部门名称
	 * 
	 * @param organName
	 */
	public void setOrganName(String organName) {
		this.organName = organName;
	}

	/**
	 * 获取部门父节点
	 * 
	 * @return chidren
	 */
	public List<Organ> getChidren() {
		return chidren;
	}

	/**
	 * 设置部门父节点
	 * 
	 * @param chidren
	 */
	public void setChidren(List<Organ> chidren) {
		this.chidren = chidren;
	}

	/**
	 * 获取用户集合
	 * 
	 * @return userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * 设置用户集合
	 * 
	 * @param userList
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * 获取部门描述
	 * 
	 * @return discription
	 */
	public String getDiscription() {
		return discription;
	}

	/**
	 * 设置部门描述
	 * 
	 * @param discription
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	/**
	 * 
	 * @return coding
	 */
	public String getCoding() {
		return coding;
	}

	/**
	 * 
	 * @param coding
	 */
	public void setCoding(String coding) {
		this.coding = coding;
	}

	/**
	 * 
	 * @return shortname
	 */
	public String getShortname() {
		return shortname;
	}

	/**
	 * 
	 * @param shortname
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	/**
	 * 
	 * @return sequence
	 */
	public Integer getSequence() {
		return sequence;
	}

	/**
	 * 
	 * @param sequence
	 */
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	/**
	 * 
	 * @return category
	 */
	public Byte getCategory() {
		return category;
	}

	/**
	 * 
	 * @param category
	 */
	public void setCategory(Byte category) {
		this.category = category;
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
	 * 释放资源
	 */
	public void dispose() {

	}

	public String getGovernor() {
		return governor;
	}

	public void setGovernor(String governor) {
		this.governor = governor;
	}

}
