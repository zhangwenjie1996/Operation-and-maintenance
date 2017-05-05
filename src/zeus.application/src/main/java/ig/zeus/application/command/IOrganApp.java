package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.OrganCommand;

/**
 * 部门服务接口
 * 
 * @author Administrator
 *
 */
public interface IOrganApp  {

	StateData<Boolean> remove(int id);

	StateData<Integer> add(OrganCommand organCommand);

	StateData<Boolean> update(OrganCommand organCommand);

	
}
