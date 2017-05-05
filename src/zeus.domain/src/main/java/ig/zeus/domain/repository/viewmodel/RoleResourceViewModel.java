package ig.zeus.domain.repository.viewmodel;

public class RoleResourceViewModel {
    private Integer resource;

    private Integer roleId;

    private Byte permission;


    /**
	 * @return the resource
	 */
	public Integer getResource() {
		return resource;
	}

	/**
	 * @param resource the resource to set
	 */
	public void setResource(Integer resource) {
		this.resource = resource;
	}

	

    /**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the permission
	 */
	public Byte getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(Byte permission) {
		this.permission = permission;
	}

	
}