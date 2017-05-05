package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IRoleApp;
import ig.zeus.application.query.IRoleQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.service.command.RoleCommand;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IRoleApp iRoleApp;

	@Autowired
	private IRoleQueryApp iRoleQueryApp;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(HttpServletRequest request, int id) {
		message = StateMessage.from(iRoleApp.remove(id));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request, RoleCommand roleCommand) {
		message = StateMessage.from(iRoleApp.add(roleCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request, RoleCommand roleCommand) {
		message = StateMessage.from(iRoleApp.update(roleCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int roleid) {
		message = StateMessage.from(iRoleQueryApp.findById(roleid));
		logger.debug(message.toString());
		return message.toString();
	}

	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findPageData(int current, int rowCount) {
		message = StateMessage.from(iRoleQueryApp.findPageData(current,rowCount));
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/findAllSelect", method = RequestMethod.GET)
	public @ResponseBody String findAllSelect() {
		message = StateMessage.from(iRoleQueryApp.findAllSelect());
		logger.debug(message.toString());
		return message.toString();
	}
	
}
