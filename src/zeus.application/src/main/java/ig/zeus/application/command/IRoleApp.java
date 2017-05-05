package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.RoleCommand;

/**
 * 角色接口
 * 
 * @author Administrator
 *
 */
public interface IRoleApp {
	StateData<Boolean> remove(int id);

	StateData<Integer> add(RoleCommand roleCommand);

	StateData<Boolean> update(RoleCommand roleCommand);

}
