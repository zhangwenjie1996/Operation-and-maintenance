package ig.device.controller.miantain.task;

import org.springframework.beans.factory.annotation.Autowired;

import ig.device.application.commandhandler.maintain.IMaintainTaskApp;



public class CancelledTimeoutMaintainTask {
	@Autowired
	private IMaintainTaskApp iMaintainTaskApp;

	public void changeTimeoutMaintainTask() {
		try {

			iMaintainTaskApp.changeTimeoutTask();
		} catch (Exception e) {
		} finally {

		}
	}

}
