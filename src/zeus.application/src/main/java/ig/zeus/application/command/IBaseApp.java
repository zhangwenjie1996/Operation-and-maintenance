package ig.zeus.application.command;

/**
 * 服务接口
 * 
 * @author Administrator
 *
 * @param <T>
 */
public interface IBaseApp<T> {
	/**
	 * 删除方法
	 * 
	 * @param id
	 */
	public int remove(Integer id);

	/**
	 * 保存方法
	 * 
	 * @param entity
	 */
	public int add(T entity);
	/**
	 * 修改方法
	 * @param entity
	 * @return
	 */
	public int update(T entity);
}
