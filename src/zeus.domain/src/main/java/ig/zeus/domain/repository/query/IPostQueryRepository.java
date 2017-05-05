package ig.zeus.domain.repository.query;

import java.util.List;

import ig.archer.domain.repository.IRepository;
import ig.archer.infrastructure.data.PagingData;
import ig.zeus.domain.repository.viewmodel.PostViewModel;

public interface IPostQueryRepository extends IRepository<PostViewModel, Integer> {
	/**
	 * 查询所有
	 * 
	 * @return list
	 */
	List<PostViewModel> findAll();

	/**
	 * 分页查询
	 * 
	 * @param args
	 * @return
	 */
	List<PostViewModel> findPageData(PagingData args);

	/**
	 * 计数查询
	 * 
	 * @return
	 */
	int count();

	/**
	 * 根据部门id查询所有岗位
	 * 
	 * @param data
	 */
	List<PostViewModel> getAllPostByOrganID(int pageStart, int rowCount, int organID);
	/**
	 * 根据部门id查询所有岗位
	 * 
	 * @param 总数量
	 */
	int countByOrganID(int organID);

	List<PostViewModel> findSelectPostByOrganID(int organid);
}
