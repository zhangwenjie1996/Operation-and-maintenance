package ig.device.controller.miantain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
import ig.device.application.commandhandler.maintain.IMaintainTaskApp;
import ig.device.application.query.maintain.IMaintainTaskQueryApp;
import ig.device.domain.service.command.maintain.MaintainDeviceCommand;
import ig.device.domain.service.command.maintain.MaintainTaskCommand;
import ig.device.domain.viewmodel.maintain.MaintainTaskViewModel;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/MaintainTask")
public class MaintainTaskController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaintainTaskQueryApp iMaintainTaskQueryApp;
	@Autowired
	private IMaintainTaskApp iMaintainTaskApp;
	 
	
	// 时间转换器
			@InitBinder
			public void initBinder(WebDataBinder binder) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateFormat.setLenient(false);
				binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
			}
	/**
	 * 分页查询保养任务
	 * 
	 * @param current
	 * @param rowCount
	 * @return
	 */
	@RequestMapping(value = "/findTaskPageData", method = RequestMethod.GET)
	public @ResponseBody String findTaskPageData(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainTaskQueryApp.findPageData(data));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据保养任务id查询详细保养任务信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findTaskById", method = RequestMethod.GET)
	public @ResponseBody String findTaskById(int maintainTaskID) {
		message = StateMessage.from(iMaintainTaskQueryApp.findTaskById(maintainTaskID));
		logger.debug(message.toString());
		return message.toString();
	}

	
	/**
	 * 根据保养任务id查询详细保养小组成员信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findMemberByTaskId", method = RequestMethod.GET)
	public @ResponseBody String findMemberByTaskId(int current, int rowCount,int MaintainTaskID) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainTaskQueryApp.findMemberByTaskId(data,MaintainTaskID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新保养任务
	 * 
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public @ResponseBody String updateTask(MaintainTaskCommand MaintainTaskCommand) {
		message = StateMessage.from(iMaintainTaskApp.updateTask(MaintainTaskCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public @ResponseBody String addTask(MaintainTaskCommand MaintainTaskCommand) {
		message = StateMessage.from(iMaintainTaskApp.addTask(MaintainTaskCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除保养任务
	 * 
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public @ResponseBody String deleteTask(int maintainTaskID) {
		message = StateMessage.from(iMaintainTaskApp.removeTask(maintainTaskID));
		logger.debug(message.toString());
		return message.toString();
	}


	/**
	 * 更新保养设备
	 * 
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateMaintainDevice", method = RequestMethod.POST)
	public @ResponseBody String updateMaintainDevice(MaintainDeviceCommand MaintainDeviceCommand) {
		message = StateMessage.from(iMaintainTaskApp.updateMaintainDevice(MaintainDeviceCommand));
		logger.debug(message.toString());
		return message.toString();
	}


	/**
	 * 多条件查询
	 * 
	 * @param MaintainReportCommand
	 * @return
	 */
	@RequestMapping(value = "/findPageDataByTask", method = RequestMethod.GET)
	public @ResponseBody String findPageDataByTask(int current, int rowCount,MaintainTaskViewModel MaintainTaskViewModel) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainTaskQueryApp.findPageDataByTask(data, MaintainTaskViewModel));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 查询登陆用户的任务（只加载当天的任务）
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/findTaskByEmployeeID", method = RequestMethod.GET)
	public @ResponseBody String findTaskByEmployeeID(HttpSession httpSession,Integer employeeid) {
		message = StateMessage.from(iMaintainTaskQueryApp.findTaskByEmployeeID(employeeid));
		logger.debug(message.toString());
		return message.toString();
	}
}
