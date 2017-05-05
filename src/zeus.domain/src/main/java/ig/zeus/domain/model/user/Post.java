package ig.zeus.domain.model.user;

import java.util.ArrayList;
import java.util.List;

import ig.archer.domain.object.identity.Entity;

/**
 * 岗位实体类
 * 
 * @author Administrator
 *
 */
public class Post extends Entity {
	/**
	 * 属性
	 */
	private Integer organid;
	private String postName;
	private String description;
	private Integer standardnumber;
	private List<User> userList = new ArrayList<User>();
	private Organ organ;
	private Object user;
	private int ID;

	/**
	 * 默认构造
	 */
	public Post() {
	}

	/**
	 * 获取用户岗位信息
	 * 
	 * @return
	 */
	public List<User> getUserList() {
		return userList;
	}

	public Integer getOrganid() {
		return organid;
	}

	public void setOrganid(Integer organid) {
		this.organid = organid;
	}

	public Integer getStandardnumber() {
		return standardnumber;
	}

	public void setStandardnumber(Integer standardnumber) {
		this.standardnumber = standardnumber;
	}

	public Object getUser() {
		return user;
	}

	public void setUser(Object user) {
		this.user = user;
	}

	/**
	 * 设置用户岗位信息
	 * 
	 * @param userList
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	/**
	 * 获取岗位名称
	 * 
	 * @return
	 */
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * 设置岗位名称
	 * 
	 * @param postName
	 */

	public String getPostName() {
		return postName;
	}

	/**
	 * 获取岗位描述
	 * 
	 * @return
	 */

	public String getDescription() {
		return description;
	}

	/**
	 * 设置岗位描述
	 * 
	 * @param discription
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取岗位部门
	 * 
	 * @return
	 */
	public Organ getOrgan() {
		return organ;
	}

	/**
	 * 设置岗位部门
	 * 
	 * @param organ
	 */
	public void setOrgan(Organ organ) {
		this.organ = organ;
	}

	/**
	 * 获取岗位id
	 */
	public Integer getID() {

		return ID;
	}

	/**
	 * 设置岗位id
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
	// public void addUser(User user) throws SavedFailureException {
	// if (user == null) {
	// throw new SavedFailureException("该岗位下没有用户对象！");
	// }
	// if (user instanceof User) {
	// try {
	// this.RaiseEvent(new UserEvent().addEvent(user));
	// this.userList.add(user);
	// } catch (Exception e) {
	// throw new SavedFailureException("处理岗位添加用户失败！");
	// }
	// } else {
	// throw new SavedFailureException("所更新的子元素不是用户对象无法更新 ！");
	// }
	// }

}
