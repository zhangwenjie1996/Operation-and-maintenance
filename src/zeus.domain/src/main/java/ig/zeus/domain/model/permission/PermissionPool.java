package ig.zeus.domain.model.permission;

import java.util.HashMap;
import java.util.Map;

import ig.archer.infrastructure.bus.IBus;
import ig.zeus.domain.model.permission.Permission.PermissionID;
import ig.zeus.domain.type.PermissionType;
import ig.zeus.domain.type.ResourceType;

/**
 * 权限信息。
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年8月11日 下午5:10:17
 */
public class PermissionPool {

	/*
	 * Variable
	 */
	private Map<ResourceType, Map<Integer, Permission>> permissions;// 资源权限，第一层资源类型，第二层key为资源ID，value为权限类型

	/*
	 * Getter&Setter
	 */

	/*
	 * Constructor
	 */

	/**
	 * @param bus
	 */
	public PermissionPool(IBus bus) {
		super();
	}

	/*
	 * Private Methods
	 */

	/*
	 * Public Methods
	 */

	/**
	 * 获取权限信息。
	 * 
	 * @param resourceType 资源类型。
	 * @param resourceID 资源ID。
	 * @return 权限类型。
	 */
	public PermissionType getPermission(ResourceType resourceType, int resourceID, int roleID) {
		int hash = new PermissionID(roleID, resourceID).hashCode();
		if (permissions.containsKey(resourceType)) {
			Map<Integer, Permission> resourcePermission = permissions.get(resourceType);
			if (resourcePermission.containsKey(hash)) {
				return resourcePermission.get(hash).getPermissionType();
			}
		}
		return PermissionType.Forbbiden;
	}

	/**
	 * 添加权限。
	 * 
	 * @param resourceType 资源类型。
	 * @param resourceID 资源ID。
	 * @param permission 权限。
	 */
	public void addPermission(ResourceType resourceType, Permission permission) throws Exception {
		if (this.permissions == null)
			this.permissions = new HashMap<ResourceType, Map<Integer, Permission>>();

		Map<Integer, Permission> resourcePermission = this.permissions.getOrDefault(resourceType,
				new HashMap<Integer, Permission>());
		resourcePermission.put(permission.hashCode(), permission);
		this.permissions.put(resourceType, resourcePermission);
	}

	/**
	 * 移除权限。
	 * 
	 * @param resourceType 资源类型。
	 * @param resourceID 资源ID。
	 * @param permission 权限。
	 */
	public void removePermission(ResourceType resourceType, int resourceID, int roleID) throws Exception {
		if (this.permissions == null)
			throw new Exception("权限信息没有初始化！");

		if (this.permissions.containsKey(resourceType)) {
			Map<Integer, Permission> resoucePermission = this.permissions.get(resourceType);
			int hash = new PermissionID(roleID, resourceID).hashCode();
			if (resoucePermission.containsKey(hash)) {
				resoucePermission.remove(hash);
			}
		}
	}

	/**
	 * 更新权限。
	 * 
	 * @param resourceType 资源类型。
	 * @param resourceID 资源ID。
	 * @param permission 权限。
	 */
	public void updatePermission(ResourceType resourceType, int resourceID, int roleID) throws Exception {
		if (this.permissions == null)
			throw new Exception("权限信息没有初始化！");

		if (this.permissions.containsKey(resourceType)) {
			Map<Integer, Permission> resoucePermission = this.permissions.get(resourceType);
			int hash = new PermissionID(roleID, resourceID).hashCode();
			if (resoucePermission.containsKey(hash)) {
				resoucePermission.get(hash);
			}
		}
	}
}
