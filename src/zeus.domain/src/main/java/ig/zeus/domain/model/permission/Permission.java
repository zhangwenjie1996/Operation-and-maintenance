package ig.zeus.domain.model.permission;

import ig.archer.domain.object.AggregateRoot;
import ig.zeus.domain.model.permission.Permission.PermissionID;
import ig.zeus.domain.type.PermissionType;

public class Permission extends AggregateRoot<PermissionID> {
	byte permission;

	/**
	 * @return the permission
	 */
	public byte getPermission() {
		return permission;
	}

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(byte permission) {
		this.permission = permission;
	}

	/**
	 * @return 返回权限的枚举类型。
	 */
	public PermissionType getPermissionType() {
		return PermissionType.values()[permission];
	}

	/**
	 * 根据权限枚举类型设备权限字段。
	 * 
	 * @param permission 枚举类型的权限信息。
	 */
	public void setPermissionType(PermissionType permission) {
		this.permission = (byte) permission.ordinal();
	}

	public Permission() {

	}

	/**
	 * 唯一构造函数，保证实例字段不为空。
	 * 
	 * @param roleID
	 * @param resourceID
	 */
	public Permission(int roleID, int resourceID, PermissionType type) {
		super();
		PermissionID id = new PermissionID(roleID, resourceID);
		this.setID(id);
		this.setPermissionType(type);
	}
	public Permission(int roleID, int resourceID, byte type) {
		super();
		PermissionID id = new PermissionID(roleID, resourceID);
		this.setID(id);
		this.permission=type;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Permission) {
			return obj.hashCode() == this.hashCode();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getID().hashCode();
	}

	@Override
	public void dispose() {

	}

	/**
	 * 权限主键信息
	 * 
	 * @author reize
	 * @version 0.0.1
	 * @since 2016年10月11日 下午2:14:39
	 */
	public static class PermissionID {

		int roleID;
		int resourceID;

		/**
		 * @return the roleID
		 */
		public int getRoleID() {
			return roleID;
		}

		/**
		 * @param RoleID the RoleID to set
		 */
		public void setRoleID(int roleID) {
			this.roleID = roleID;
		}

		/**
		 * @return 返回 resourceID 字段的值。
		 */
		public int getResourceID() {
			return resourceID;
		}

		/**
		 * @param resourceID 设置 resourceID 字段。
		 */
		public void setResourceID(int resourceID) {
			this.resourceID = resourceID;
		}

		/**
		 * 唯一构造函数，保证实例字段不为空。
		 * 
		 * @param roleID
		 * @param resourceID
		 */
		public PermissionID(int roleID, int resourceID) {
			super();
			this.roleID = roleID;
			this.resourceID = resourceID;
		}

		@Override
		public int hashCode() {
			return String.format("%d%d", roleID, resourceID).hashCode();
		}

	}
}
