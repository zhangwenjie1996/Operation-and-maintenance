package ig.zeus.domain.model.permission;

import java.util.Arrays;
import java.util.List;

import ig.zeus.domain.model.resource.Resource;
import ig.zeus.domain.type.PermissionType;

/**
 * 访问授权中心，仅针对后台接口访问。
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年8月15日 上午9:26:36
 */
public class Authorization {

	/*
	 * Variable
	 */
	List<Resource> resources;
	PermissionPool permission;
	/*
	 * Getter&Setter
	 */

	/*
	 * Constructor
	 */

	/**
	 * @param resources
	 * @param permission
	 */
	public Authorization(List<Resource> resources, PermissionPool permission) {
		super();
		this.resources = resources;
		this.permission = permission;
	}

	/*
	 * Private Methods
	 */
	/**
	 * 查找列表有没有符合条件的资源文件，只查找当前层。
	 * 
	 * @param resources 带查找的资源。
	 * @param key 带查找的KEY。
	 * @return 找到返回ID,找不到返回-1。
	 */
	private Resource findKey(List<Resource> resources, String key) {
		for (Resource resource : resources) {
			if (resource.getSignature() != null && resource.getSignature().toLowerCase().equals(key.toLowerCase())) {
				return resource;
			}
		}
		return null;
	}

	/*
	 * Public Methods
	 */

	/**
	 * 验证是否有权限。
	 * 
	 * @param url
	 * @return
	 */
	public boolean validate(String url, int roleID) {
		List<String> keys = Arrays.asList(url.split("/"));// 拆分url为字符串组。

		boolean result = false;
		// 按照层次【模块/控制器/活动】的层次来分，起码需要一个层次
		if (keys.size() == 3) {
			List<Resource> data = resources;// 默认第一层为系统对象。

			int size = keys.size();
			int index = 0;// 取keys的索引。
			while (size > index) {
				Resource resource = this.findKey(data, keys.get(index));
				if (resource != null) { // null说明没找到资源
					// 查找有没有权限
					PermissionType type = permission.getPermission(resource.getType(), resource.getID(), roleID);
					if (type.greaterOrEqualThan(PermissionType.Access)) {
						result = true;
						data = resource.getChidren();
					} else {
						return false;
					}
					index++;
				} else
					return false;
			}

		}
		return result;// 若执行到这儿则是无权
	}

	public String getPermission(Object className) {
		return "ok";
	}

}
