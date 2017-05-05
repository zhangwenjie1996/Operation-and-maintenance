package ig.zeus.application.command;

import ig.archer.infrastructure.data.StateData;
import ig.zeus.domain.service.command.SystemCommand;

public interface ISystemApp {

	StateData<Boolean> remove(int id);

	StateData<Integer> add(SystemCommand systemCommand);

	StateData<Boolean> update(SystemCommand systemCommand);
	
}
