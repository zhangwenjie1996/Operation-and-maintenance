package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IOrganApp;
import ig.zeus.application.query.IOrganQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.service.command.OrganCommand;

@Controller
@RequestMapping("/organ")
public class OrganController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IOrganApp iOrganApp;

	@Autowired
	private IOrganQueryApp iOrganQueryApp;

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(HttpServletRequest request, @RequestParam("organID") int id) {
		message = StateMessage.from(iOrganApp.remove(id));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request, OrganCommand organCommand) {
		message = StateMessage.from(iOrganApp.add(organCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request, OrganCommand organCommand) {
		message = StateMessage.from(iOrganApp.update(organCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportById(@RequestParam("organID") int id) {
		message = StateMessage.from(iOrganQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}

	@RequestMapping(value = "/getOrganListTree", method = RequestMethod.GET)
	public @ResponseBody String getOrganListTree() {
		message = StateMessage.from(iOrganQueryApp.findOrganListTree());
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/getOrganTree", method = RequestMethod.GET)
	public @ResponseBody String getOrganTree() {
		message = StateMessage.from(iOrganQueryApp.findOrganTree());
		logger.debug(message.toString());
		return message.toString();
	}
}
