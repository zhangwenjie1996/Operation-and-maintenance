package ig.device.controller.miantain.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import ig.device.application.commandhandler.maintain.IMaintainPlanApp;


public class CreatMaintainTask {
	@Autowired
	private IMaintainPlanApp iMaintainPlanApp;

	public void creatMaintainTask() {
		try {
			Date currt = new Date();
			iMaintainPlanApp.creatTask(currt);
		} catch (Exception e) {

		} finally {

		}

	}
}
