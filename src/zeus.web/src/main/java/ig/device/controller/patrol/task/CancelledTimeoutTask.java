package ig.device.controller.patrol.task;

import org.springframework.beans.factory.annotation.Autowired;

import ig.device.application.commandhandler.patrol.IPatrolTaskApp;

public class CancelledTimeoutTask {
	@Autowired
	private IPatrolTaskApp iPatrolTaskApp;

	public void changeTimeoutTask() {
		try {

			iPatrolTaskApp.changeTimeoutTask();
		} catch (Exception e) {
		} finally {

		}
	}

}
