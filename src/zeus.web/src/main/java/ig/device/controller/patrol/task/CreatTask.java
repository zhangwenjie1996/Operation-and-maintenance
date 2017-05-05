package ig.device.controller.patrol.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ig.device.application.commandhandler.patrol.IPatrolPlanApp;

public class CreatTask {
	@Autowired
	private IPatrolPlanApp iPatrolPlanApp;

	public void creatTask() {
		try {
			Date currt = new Date();
			iPatrolPlanApp.creatTask(currt);
		} catch (Exception e) {

		} finally {

		}

	}
}
