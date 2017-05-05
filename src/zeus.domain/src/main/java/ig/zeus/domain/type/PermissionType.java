package ig.zeus.domain.type;

/**
 * 权限类型。
 * 
 * @author reize
 * @version 0.0.1 2016年8月12日 上午10:37:54
 */
public enum PermissionType {
	/**
	 * 禁止
	 */
	Forbbiden,

	/**
	 * 访问
	 */
	Access,

	/**
	 * 操作
	 */
	Execution,

	/**
	 * 返回条件
	 */
	Condition;

	/**
	 * 判断是否大于指定的权限类型。
	 * @param type
	 * @return
	 */
	public boolean greaterOrEqualThan(PermissionType type) {
		return this.ordinal() >= type.ordinal();
	}
}
