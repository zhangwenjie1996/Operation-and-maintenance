package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.MenuCommand;

/**
 * 菜单接口
 * 
 * @author Administrator
 *
 */
public interface IMenuApp {

	StateData<Boolean> remove(int id);

	StateData<Integer> add(MenuCommand menuCommand);

	StateData<Boolean> update(MenuCommand menuCommand);

}
