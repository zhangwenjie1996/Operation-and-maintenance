package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IElementApp;
import ig.zeus.application.query.IElementQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.service.command.ElementCommand;

@Controller
@RequestMapping("/element")
public class ElementController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IElementApp iElementApp;
	@Autowired
	private IElementQueryApp iElementQueryApp;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(HttpServletRequest request, int elementid) {
		message = StateMessage.from(iElementApp.remove(elementid));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request, ElementCommand elementCommand) {
		message = StateMessage.from(iElementApp.add(elementCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request, ElementCommand elementCommand) {
		message = StateMessage.from(iElementApp.update(elementCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/findAllByMenuId", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportFindAll(int current, int rowCount, int menuId,int roleid) {
		message = StateMessage.from(iElementQueryApp.findAllByMenuId(current, rowCount, menuId,roleid));
		logger.debug(message.toString());
		return message.toString();
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportById(int elementid) {
		message = StateMessage.from(iElementQueryApp.findById(elementid));
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/findElementTree", method = RequestMethod.GET)
	public @ResponseBody String findElementTree(int menuId) {
		message = StateMessage.from(iElementQueryApp.findElementTree(menuId));
		logger.debug(message.toString());
		return message.toString();
	}

}
