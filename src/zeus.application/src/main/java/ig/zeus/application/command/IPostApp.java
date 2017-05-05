package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.PostCommand;

/**
 * 岗位服务接口
 * 
 * @author Administrator
 *
 */
public interface IPostApp  {

	StateData<Boolean> remove(int id);

	StateData<Integer> add(PostCommand postCommand);

	StateData<Boolean> update(PostCommand postCommand);
	
}
