package ig.device.controller.miantain;

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
import ig.device.application.commandhandler.maintain.IMaintainPlanApp;
import ig.device.application.query.maintain.IMaintainPlanQueryApp;
import ig.device.domain.service.command.maintain.MaintainPlanCommand;
import ig.device.domain.viewmodel.maintain.MaintainPlanViewModel;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/MaintainPlan")
public class MaintainPlanController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaintainPlanQueryApp iMaintainPlanQueryApp;
	@Autowired
	private IMaintainPlanApp iMaintainPlanApp;

	// 时间转换器
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
		}
	/**
	 * 分页查询保养计划
	 * 
	 * @param current
	 * @param rowCount
	 * @return
	 */
	@RequestMapping(value = "/findMaintainPlanByPageDate", method = RequestMethod.GET)
	public @ResponseBody String findMaintainPlanByPageDate(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainPlanQueryApp.findPageData(data));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据保养计划id查询详细保养计划信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByMaintainPlanId", method = RequestMethod.GET)
	public @ResponseBody String findByMaintainPlanId(int maintainPlanID) {
		message = StateMessage.from(iMaintainPlanQueryApp.findById(maintainPlanID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新保养计划
	 * 
	 * @param patrolPlanCommand
	 * @return
	 */
	@RequestMapping(value = "/updateMaintainPlan", method = RequestMethod.POST)
	public @ResponseBody String updateMaintainPlan(MaintainPlanCommand maintainPlanCommand) {
		message = StateMessage.from(iMaintainPlanApp.updateMaintainPlan(maintainPlanCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除保养计划
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteMaintainPlan", method = RequestMethod.GET)
	public @ResponseBody String deleteMaintainPlan(int maintainPlanID) {
		message = StateMessage.from(iMaintainPlanApp.removeMaintainPlan(maintainPlanID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 添加保养计划
	 * 
	 * @param patrolPlanCommand
	 * @return
	 */
	@RequestMapping(value = "/addMaintainPlan", method = RequestMethod.POST)
	public @ResponseBody String addMaintainPlan(MaintainPlanCommand maintianPlanCommand) {
		message = StateMessage.from(iMaintainPlanApp.addMaintainPlan(maintianPlanCommand));
		logger.debug(message.toString());
		return message.toString();
	}

    /**
	 * 多条件查询保养计划
	 * @param patrolPlanViewModel
	 * @return
	 */
	@RequestMapping(value = "/findByMaintainPlan", method = RequestMethod.GET)
	public @ResponseBody String findByMaintainPlan(int current, int rowCount,MaintainPlanViewModel maintainPlanViewModel) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainPlanQueryApp.findPageDataByPlan(data, maintainPlanViewModel));
		logger.debug(message.toString());
		return message.toString();
	}
}
