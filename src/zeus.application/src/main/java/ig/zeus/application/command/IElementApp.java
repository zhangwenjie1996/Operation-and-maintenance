package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.ElementCommand;

/**
 * 页面组件接口
 * 
 * @author Administrator
 *
 */
public interface IElementApp  {

	StateData<Boolean> remove(int id);

	StateData<Integer> add(ElementCommand elementCommand);

	StateData<Boolean> update(ElementCommand elementCommand);
	
}
