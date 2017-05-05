package ig.device.controller.patrol;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.patrol.IPatrolPlanApp;
import ig.device.application.query.patrol.IPatrolPlanQueryApp;
import ig.device.domain.service.command.patrol.plan.PatrolPlanCommand;
import ig.device.domain.viewmodel.patrol.PatrolPlanViewModel;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/PatrolPlan")
public class PatrolPlanController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IPatrolPlanQueryApp iPatrolPlanQueryApp;
	@Autowired
	private IPatrolPlanApp iPatrolPlanApp;

	// 时间转换器
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
		}
	/**
	 * 分页查询巡检计划
	 * 
	 * @param current
	 * @param rowCount
	 * @return
	 */
	@RequestMapping(value = "/findPlanByPageDate", method = RequestMethod.GET)
	public @ResponseBody String findPlanByPageDate(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolPlanQueryApp.findPageData(data));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检计划id查询详细巡检计划信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByPlanId", method = RequestMethod.GET)
	public @ResponseBody String findByPlanId(int patrolPlanID) {
		message = StateMessage.from(iPatrolPlanQueryApp.findById(patrolPlanID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新巡检计划
	 * 
	 * @param patrolPlanCommand
	 * @return
	 */
	@RequestMapping(value = "/updatePlan", method = RequestMethod.POST)
	public @ResponseBody String updatePlan(PatrolPlanCommand patrolPlanCommand) {
		System.out.println(patrolPlanCommand.getTaskEndTime());
		System.out.println(patrolPlanCommand.getTaskStartTime());
		message = StateMessage.from(iPatrolPlanApp.updatePatrolPlan(patrolPlanCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除巡检计划
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deletePlan", method = RequestMethod.GET)
	public @ResponseBody String deletePlan(int patrolPlanID) {
		message = StateMessage.from(iPatrolPlanApp.removePatrolPlan(patrolPlanID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 添加巡检计划
	 * 
	 * @param patrolPlanCommand
	 * @return
	 */
	@RequestMapping(value = "/addPlan", method = RequestMethod.POST)
	public @ResponseBody String addPlan(PatrolPlanCommand patrolPlanCommand) {
		message = StateMessage.from(iPatrolPlanApp.addPatrolPlan(patrolPlanCommand));
		logger.debug(message.toString());
		return message.toString();
	}
    /**
	 * 多条件查询巡检计划
	 * @param patrolPlanViewModel
	 * @return
	 */
	@RequestMapping(value = "/findByPlan", method = RequestMethod.GET)
	public @ResponseBody String findByPlan(int current, int rowCount,PatrolPlanViewModel patrolPlanViewModel) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolPlanQueryApp.findPageDataByPlan(data, patrolPlanViewModel));
		logger.debug(message.toString());
		return message.toString();
	}
}
