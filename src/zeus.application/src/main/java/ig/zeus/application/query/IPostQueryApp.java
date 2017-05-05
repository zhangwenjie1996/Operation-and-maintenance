package ig.zeus.application.query;

import java.util.List;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.repository.viewmodel.PostViewModel;

/**
 * 岗位服务接口
 * 
 * @author Administrator
 *
 */
public interface IPostQueryApp  {
	StateData<PagingData> findPageData(PagingData args);
	/**
	 * 根据部门id查询所有岗位
	 * */
	StateData<PagingData> getAllPostByOrganID(int current, int rowCount, int organID);
	StateData<PostViewModel> findById(int id);
	StateData<List<PostViewModel>> findSelectPostByOrganID(int organid);
}
