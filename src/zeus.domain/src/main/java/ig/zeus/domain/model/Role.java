package ig.zeus.domain.model;

import ig.archer.domain.object.identity.AggregateRoot;

public class Role extends AggregateRoot {

	/*
	 * PrivateVariable
	 */

	String roleName;
	private Byte roletype;
	int quota;//当前数量。
	
	
	/*
	 * Getter&Setter
	 */
	
	public int getQuota() {
		return quota;
	}



	public void setQuota(int quota) {
		this.quota = quota;
	}



	public String getRoleName() {
		return roleName;
	}



	public Byte getRoletype() {
		return roletype;
	}

	/**
	 * @param name
	 *            the name to set
	 * @throws Exception 
	 */
	public void setRoleName(String name) throws Exception {
		this.roleName = name;
//		this.RaiseEvent(new RoleUpdateEvent(this));
	}



	public void setRoletype(Byte roletype) throws Exception {
		this.roletype = roletype;
//		this.RaiseEvent(new RoleUpdateEvent(this));
	}
	
	/*
	 * 
	 * PublicMethod
	 * 
	 */
	
	public void dispose() {

	}
}
