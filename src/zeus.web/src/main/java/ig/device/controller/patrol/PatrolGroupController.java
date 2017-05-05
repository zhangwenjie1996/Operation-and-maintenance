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
import ig.device.application.commandhandler.patrol.IPatrolGroupApp;
import ig.device.application.query.patrol.IPatrolGroupQueryApp;
import ig.device.domain.service.command.patrol.PatrolGroupCommand;
import ig.device.domain.service.command.patrol.PatrolGroupMemberCommand;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/PatrolGroup")
public class PatrolGroupController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IPatrolGroupQueryApp iPatrolGroupQueryApp;
	@Autowired
	private IPatrolGroupApp iPatrolGroupApp;

	/**
	 * 查询所有巡检小组
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findAllGroup", method = RequestMethod.GET)
	public @ResponseBody String findAllGroup() {
		message = StateMessage.from(iPatrolGroupQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检小组id查询所有小组成员
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByGroupId", method = RequestMethod.GET)
	public @ResponseBody String findByGroupId(int patrolGroupID, int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolGroupQueryApp.findByGroupId(patrolGroupID, data));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据巡检小组id查询巡检小组详细信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findGroupById", method = RequestMethod.GET)
	public @ResponseBody String findGroupById(int patrolGroupID) {
		message = StateMessage.from(iPatrolGroupQueryApp.findById(patrolGroupID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 添加巡检小组
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addGroup", method = RequestMethod.GET)
	public @ResponseBody String addGroup(PatrolGroupCommand patrolGroupCommand) {
		message = StateMessage.from(iPatrolGroupApp.addPatrolGroup(patrolGroupCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新巡检小组
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateGroup", method = RequestMethod.GET)
	public @ResponseBody String updateGroup(PatrolGroupCommand patrolGroupCommand) {
		message = StateMessage.from(iPatrolGroupApp.updatePatrolGroup(patrolGroupCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除巡检小组
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
	public @ResponseBody String deleteGroup(int patrolGroupID) {
		message = StateMessage.from(iPatrolGroupApp.removePatrolGroup(patrolGroupID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 批量添加巡检小组成员
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/addGroupMember", method = RequestMethod.POST)
	public @ResponseBody String addGroupMember(HttpServletRequest request,@RequestBody List<PatrolGroupMemberCommand> patrolGroupMemberCommands) {
		message = StateMessage.from(iPatrolGroupApp.addPatrolGroupMember(patrolGroupMemberCommands));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 更新巡检小组成员
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/updateGroupMember", method = RequestMethod.POST)
	public @ResponseBody String updateGroupMember(PatrolGroupMemberCommand patrolGroupMemberCommand) {
		message = StateMessage.from(iPatrolGroupApp.updatePatrolGroupMember(patrolGroupMemberCommand));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 删除巡检小组成员
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/deleteGroupMember", method = RequestMethod.GET)
	public @ResponseBody String deleteGroupMember(int id) {
		message = StateMessage.from(iPatrolGroupApp.removePatrolGroupMember(id));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据小组id查询所有小组成员
	 * 
	 * @param patrolGroupCommand
	 * @return
	 */
	@RequestMapping(value = "/findListByGroupId", method = RequestMethod.GET)
	public @ResponseBody String findListByGroupId(int patrolGroupID) {
		message = StateMessage.from(iPatrolGroupQueryApp.findListByGroupId(patrolGroupID));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 通过巡检成员名字查询巡检小组成员列表
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/findByMemberName", method = RequestMethod.POST)
	public @ResponseBody String findByMemberName(String name, int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPatrolGroupQueryApp.findByMemberName(data, name));
		logger.debug(message.toString());
		return message.toString();
	}
}
