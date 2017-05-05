package ig.device.controller.miantain;

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
import ig.device.application.commandhandler.maintain.IMaintainRouteApp;
import ig.device.application.query.maintain.IMaintainRouteQueryApp;
import ig.device.domain.service.command.maintain.MaintainRouteCommand;
import ig.device.domain.service.command.maintain.MaintainRouteDeviceCommand;
import ig.zeus.data.StateMessage;
@Controller
@RequestMapping("/MaintainRoute")
public class MaintainRouteController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaintainRouteQueryApp iMaintainRouteQueryApp;
	@Autowired
	private IMaintainRouteApp iMaintainRouteApp;
	/**
	 * 查询所有保养小组
	 * @return
	 */
	@RequestMapping(value = "/findAllMaintainRoute", method = RequestMethod.GET)
	public @ResponseBody String findAllMaintainRoute() {
		message = StateMessage.from(iMaintainRouteQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 查询所有路线树
	 * @return
	 */
	@RequestMapping(value = "/findMaintainRouteTree", method = RequestMethod.GET)
	public @ResponseBody String findMaintainRouteTree() {
		message = StateMessage.from(iMaintainRouteQueryApp.findRouteTree());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据保养小组id查询所有小组成员
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByMaintainRouteId", method = RequestMethod.GET)
	public @ResponseBody String findByMaintainRouteId(int maintainRouteID,int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainRouteQueryApp.findByRouteId(maintainRouteID,data));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 根据保养路线id查询保养路线详细信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findMaintainRouteById", method = RequestMethod.GET)
	public @ResponseBody String findMaintainRouteById(int maintainRouteID) {
		message = StateMessage.from(iMaintainRouteQueryApp.findById(maintainRouteID));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据保养路线id查询保养路下所有设备
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findListByMaintainRouteId", method = RequestMethod.GET)
	public @ResponseBody String findListByMaintainRouteId(int maintainRouteID) {
		message = StateMessage.from(iMaintainRouteQueryApp.findListByRouteId(maintainRouteID));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 添加保养路线
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addMaintainRoute", method = RequestMethod.GET)
	public @ResponseBody String addMaintainRoute(MaintainRouteCommand maintainRouteCommand) {
		message = StateMessage.from(iMaintainRouteApp.addMaintainRoute(maintainRouteCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 更新保养路线
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateMaintainRoute", method = RequestMethod.GET)
	public @ResponseBody String updateMaintainRoute(MaintainRouteCommand maintainRouteCommand) {
		message = StateMessage.from(iMaintainRouteApp.updateMaintainRoute(maintainRouteCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 删除保养路线
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteMaintainRoute", method = RequestMethod.GET)
	public @ResponseBody String deleteMaintainRoute(int MaintainGroupID) {
		message = StateMessage.from(iMaintainRouteApp.removeMaintainRoute(MaintainGroupID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 批量添加保养路线设备
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addMaintainRouteDevice", method = RequestMethod.POST)
	public @ResponseBody String addMaintainRouteDevice(HttpServletRequest request,@RequestBody  List<MaintainRouteDeviceCommand> maintainRouteDeviceCommands) {
		message = StateMessage.from(iMaintainRouteApp.addMaintainRoutDevice(maintainRouteDeviceCommands));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 更新保养路线设备
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateMaintainRouteDevice", method = RequestMethod.POST)
	public @ResponseBody String updateMaintainRouteDevice(MaintainRouteDeviceCommand maintainRouteDeviceCommand) {
		message = StateMessage.from(iMaintainRouteApp.updateMaintainRoutDevice(maintainRouteDeviceCommand));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 删除保养路线设备
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteMaintainRouteDevice", method = RequestMethod.GET)
	public @ResponseBody String deleteMaintainRouteDevice(int id) {
		message = StateMessage.from(iMaintainRouteApp.removeMaintainRoutDevice(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新保养路线设备
	 * @param MaintainGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateSequence", method = RequestMethod.POST)
	public @ResponseBody String updateSequence(HttpServletRequest request,@RequestBody  List<MaintainRouteDeviceCommand> maintainRouteDeviceCommands) {
		message = StateMessage.from(iMaintainRouteApp.updateSequence(maintainRouteDeviceCommands));
		logger.debug(message.toString());
		return message.toString();
	}
}
