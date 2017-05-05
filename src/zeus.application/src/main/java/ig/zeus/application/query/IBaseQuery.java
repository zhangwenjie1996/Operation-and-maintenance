package ig.zeus.application.query;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 * @param <E>
 *            泛型E表示实体，继承该类时，E泛型就是当前实体?
 */
public interface IBaseQuery<E> {

	/**
	 * 根据ID获取用户的表?
	 * 
	 * @param Id
	 * @return
	 */
	public E findById(int id);

	/**
	 * 根据一个实体获取全部报表
	 * @return
	 */
	public List<E> findAll();

}
