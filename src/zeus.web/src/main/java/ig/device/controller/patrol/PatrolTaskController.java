package ig.device.controller.patrol;

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
import ig.device.application.commandhandler.patrol.IPatrolTaskApp;
import ig.device.application.query.patrol.IPatrolDeviceQueryApp;
import ig.device.application.query.patrol.IPatrolTaskQueryApp;
import ig.device.domain.service.command.patrol.task.PatrolDeviceCommand;
import ig.device.domain.service.command.patrol.task.PatrolDeviceDetailsCommand;
import ig.device.domain.service.command.patrol.task.PatrolTaskCommand;
import ig.device.domain.viewmodel.patrol.PatrolTaskViewModel;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/PatrolTask")
public class PatrolTaskController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IPatrolTaskQueryApp iPatrolTaskQueryApp;
	@Autowired
	private IPatrolDeviceQueryApp iPatrolDeviceQueryApp;
	@Autowired
	private IPatrolTaskApp iPatrolTaskApp;

	
	// 时间转换器
			@InitBinder
			public void initBinder(WebDataBinder binder) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				dateFormat.setLenient(false);
				binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:允许输入空值，false:不能为空值
			}
	/**
	 * 分页查询巡检任务
	 * 
	 * @param current
	 * @param rowCount
	 * @return
	 */
	@RequestMapping(value = "/findTaskPageData", method = RequestMethod.GET)
	public @ResponseBody String findTaskPageData(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolTaskQueryApp.findPageData(data));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检任务id查询详细巡检任务信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findTaskById", method = RequestMethod.GET)
	public @ResponseBody String findTaskById(int id) {
		message = StateMessage.from(iPatrolTaskQueryApp.findTaskById(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检任务id查询详细巡检小组成员信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findMemberByTaskId", method = RequestMethod.GET)
	public @ResponseBody String findMemberByTaskId(int current, int rowCount,int patrolTaskID) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolTaskQueryApp.findMemberByTaskId(data,patrolTaskID));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据巡检任务id查询详细巡检小组成员信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findALLMemberByTaskId", method = RequestMethod.GET)
	public @ResponseBody String findAllMemberByTaskId(int id) {
		message = StateMessage.from(iPatrolTaskQueryApp.findAllMemberByTaskId(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检任务id查询详细巡检设备信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findPatrolDeviceByPatrolTaskId", method = RequestMethod.GET)
	public @ResponseBody String findPatrolDeviceByPatrolTaskId(int current, int rowCount,int id) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolDeviceQueryApp.findPatrolDeviceByPatrolTaskId(data,id));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据巡检任务id查询详细巡检设备信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findAllDeviceByPatrolTaskId", method = RequestMethod.GET)
	public @ResponseBody String findAllDeviceByPatrolTaskId(int id) {
		message = StateMessage.from(iPatrolDeviceQueryApp.findAllDeviceByPatrolTaskId(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据巡检设备id查询详细设备信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findDeviceById", method = RequestMethod.GET)
	public @ResponseBody String findDeviceById(int id) {
		message = StateMessage.from(iPatrolDeviceQueryApp.findDeviceById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据巡检详情id查询详细巡检详情信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findDeviceDetailsById", method = RequestMethod.GET)
	public @ResponseBody String findDeviceDetailsById(int id) {
		message = StateMessage.from(iPatrolDeviceQueryApp.findDeviceDetailsById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据巡检设备id查询详细巡检设备详情信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByDeviceId", method = RequestMethod.GET)
	public @ResponseBody String findByDeviceId(int current, int rowCount,int id) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolDeviceQueryApp.findByDeviceId(data, id));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据巡检设备id查询详细巡检设备详情信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findAllByDeviceId", method = RequestMethod.GET)
	public @ResponseBody String findAllByDeviceId(int id) {
		message = StateMessage.from(iPatrolDeviceQueryApp.findAllByPatrolDeviceId(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 添加巡检任务
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public @ResponseBody String addTask(PatrolTaskCommand patrolTaskCommand) {
		message = StateMessage.from(iPatrolTaskApp.addTask(patrolTaskCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新巡检任务
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public @ResponseBody String updateTask(PatrolTaskCommand patrolTaskCommand) {
		message = StateMessage.from(iPatrolTaskApp.updateTask(patrolTaskCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除巡检任务
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteTask", method = RequestMethod.GET)
	public @ResponseBody String deleteTask(int id) {
		message = StateMessage.from(iPatrolTaskApp.removeTask(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 添加巡检设备
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addPatrolDevice", method = RequestMethod.POST)
	public @ResponseBody String addPatrolDevice(PatrolDeviceCommand patrolDeviceCommand) {
		message = StateMessage.from(iPatrolTaskApp.addPatrolDevice(patrolDeviceCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新巡检设备
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updatePatrolDevice", method = RequestMethod.POST)
	public @ResponseBody String updatePatrolDevice(PatrolDeviceCommand patrolDeviceCommand) {
		message = StateMessage.from(iPatrolTaskApp.updatePatrolDevice(patrolDeviceCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除巡检设备
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/removePatrolDevice", method = RequestMethod.POST)
	public @ResponseBody String removePatrolDevice(int id) {
		message = StateMessage.from(iPatrolTaskApp.removePatrolDevice(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 添加巡检设备详情
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addPatrolDeviceDetails", method = RequestMethod.POST)
	public @ResponseBody String addPatrolDeviceDetails(PatrolDeviceDetailsCommand patrolDeviceDetailsCommand) {
		message = StateMessage.from(iPatrolTaskApp.addPatrolDeviceDetails(patrolDeviceDetailsCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新巡检设备详情
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updatePatrolDeviceDetails", method = RequestMethod.POST)
	public @ResponseBody String updatePatrolDeviceDetails(PatrolDeviceDetailsCommand patrolDeviceDetailsCommand) {
		message = StateMessage.from(iPatrolTaskApp.updatePatrolDeviceDetails(patrolDeviceDetailsCommand));
		logger.debug(message.toString());
		return message.toString(); 
	}

	/**
	 * 删除巡检设备详情
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/removePatrolDeviceDetails", method = RequestMethod.GET)
	public @ResponseBody String removePatrolDeviceDetails(int id) {
		message = StateMessage.from(iPatrolTaskApp.removePatrolDeviceDetails(id));
		logger.debug(message.toString());
		return message.toString();
	}

	
	/**
	 * 多条件查询
	 * @param patrolReportCommand
	 * @return
	 */
	@RequestMapping(value = "/findPageDataByTask", method = RequestMethod.GET)
	public @ResponseBody String findPageDataByTask(int current, int rowCount,PatrolTaskViewModel patrolTaskViewModel) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolTaskQueryApp.findPageDataByTask(data, patrolTaskViewModel));
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
		message = StateMessage.from(iPatrolTaskQueryApp.findTaskByEmployeeID(employeeid));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 领取任务
	 * @param httpSession
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/getTask", method = RequestMethod.GET)
	public @ResponseBody String getTask(HttpSession httpSession,Byte state,String userName,Integer patrolTaskID) {
		Date date=new Date();
		PatrolTaskCommand patrolTaskCommand=new PatrolTaskCommand();
		patrolTaskCommand.setState(state);
		patrolTaskCommand.setPatrolTime(date);
		patrolTaskCommand.setFunctionary(userName);
		patrolTaskCommand.setPatrolTaskID(patrolTaskID);
		message = StateMessage.from(iPatrolTaskApp.getTask(patrolTaskCommand));
		logger.debug(message.toString());
		return message.toString();
	}
}
