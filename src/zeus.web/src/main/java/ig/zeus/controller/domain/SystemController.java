package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.ISystemApp;
import ig.zeus.application.query.ISystemQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.service.command.SystemCommand;

@Controller
@RequestMapping("/system")
public class SystemController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private ISystemApp iSystemApp;
	@Autowired
	private ISystemQueryApp iSystemQueryApp;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(HttpServletRequest request, int id) {
		message = StateMessage.from(iSystemApp.remove(id));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request, SystemCommand systemCommand) {
		message = StateMessage.from(iSystemApp.add(systemCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request, SystemCommand systemCommand) {
		message = StateMessage.from(iSystemApp.update(systemCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findPageData(int current, int rowCount) {
		message = StateMessage.from(iSystemQueryApp.findPageData(current, rowCount));
		logger.debug(message.toString());
		return message.toString();
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportById(int id) {
		message = StateMessage.from(iSystemQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/findAllSelect", method = RequestMethod.GET)
	public @ResponseBody String findAllSelect() {
		message = StateMessage.from(iSystemQueryApp.findAllSelect());
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/findSystemTree", method = RequestMethod.GET)
	public @ResponseBody String findSystemTree() {
		message = StateMessage.from(iSystemQueryApp.findSystemTree());
		logger.debug(message.toString());
		return message.toString();
	}
	
}
