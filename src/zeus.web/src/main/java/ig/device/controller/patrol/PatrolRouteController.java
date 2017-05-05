package ig.device.controller.patrol;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.patrol.IPatrolRouteApp;
import ig.device.application.query.patrol.IPatrolRouteQueryApp;
import ig.device.domain.service.command.patrol.PatrolRouteCommand;
import ig.device.domain.service.command.patrol.PatrolRouteDeviceCommand;
import ig.zeus.data.StateMessage;
@Controller
@RequestMapping("/PatrolRoute")
public class PatrolRouteController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IPatrolRouteQueryApp iPatrolRouteQueryApp;
	@Autowired
	private IPatrolRouteApp iPatrolRouteApp;
	/**
	 * 查询所有巡检小组
	 * @return
	 */
	@RequestMapping(value = "/findAllRoute", method = RequestMethod.GET)
	public @ResponseBody String findAllRoute() {
		message = StateMessage.from(iPatrolRouteQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 查询所有路线树
	 * @return
	 */
	@RequestMapping(value = "/findRouteTree", method = RequestMethod.GET)
	public @ResponseBody String findRouteTree() {
		message = StateMessage.from(iPatrolRouteQueryApp.findRouteTree());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据巡检小组id查询所有小组成员
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByRouteId", method = RequestMethod.GET)
	public @ResponseBody String findByRouteId(int patrolRouteID,int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolRouteQueryApp.findByRouteId(patrolRouteID,data));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 根据巡检路线id查询巡检路线详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findRouteById", method = RequestMethod.GET)
	public @ResponseBody String findRouteById(int patrolRouteID) {
		message = StateMessage.from(iPatrolRouteQueryApp.findById(patrolRouteID));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据巡检路线id查询巡检路下所有设备
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findListByRouteId", method = RequestMethod.GET)
	public @ResponseBody String findListByRouteId(int patrolRouteID) {
		message = StateMessage.from(iPatrolRouteQueryApp.findListByRouteId(patrolRouteID));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 添加巡检路线
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addRoute", method = RequestMethod.GET)
	public @ResponseBody String addRoute(PatrolRouteCommand patrolRouteCommand) {
		message = StateMessage.from(iPatrolRouteApp.addPatrolRoute(patrolRouteCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 更新巡检路线
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateRoute", method = RequestMethod.GET)
	public @ResponseBody String updateRoute(PatrolRouteCommand patrolRouteCommand) {
		message = StateMessage.from(iPatrolRouteApp.updatePatrolRoute(patrolRouteCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 删除巡检路线
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteRoute", method = RequestMethod.GET)
	public @ResponseBody String deleteRoute(int patrolGroupID) {
		message = StateMessage.from(iPatrolRouteApp.removePatrolRoute(patrolGroupID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 批量添加巡检路线设备
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addRouteDevice", method = RequestMethod.POST)
	public @ResponseBody String addRouteDevice(HttpServletRequest request,@RequestBody  List<PatrolRouteDeviceCommand> patrolRouteDeviceCommands) {
		message = StateMessage.from(iPatrolRouteApp.addPatrolRoutDevice(patrolRouteDeviceCommands));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 更新巡检路线设备
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateRouteDevice", method = RequestMethod.POST)
	public @ResponseBody String updateRouteDevice(PatrolRouteDeviceCommand patrolRouteDeviceCommand) {
		message = StateMessage.from(iPatrolRouteApp.updatePatrolRoutDevice(patrolRouteDeviceCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 删除巡检路线设备
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteRouteDevice", method = RequestMethod.GET)
	public @ResponseBody String deleteRouteDevice(int id) {
		message = StateMessage.from(iPatrolRouteApp.removePatrolRoutDevice(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检设备名称查询相关信息 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/findByDeviceName", method = RequestMethod.POST)
	public @ResponseBody String findByDeviceName(String name,int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolRouteQueryApp.findByDeviceName(data,name));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 更新巡检路线设备
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateSequence", method = RequestMethod.POST)
	public @ResponseBody String updateSequence(HttpServletRequest request,@RequestBody  List<PatrolRouteDeviceCommand> patrolRouteDeviceCommands) {
		message = StateMessage.from(iPatrolRouteApp.updateSequence(patrolRouteDeviceCommands));
		logger.debug(message.toString());
		return message.toString();
	}
}
