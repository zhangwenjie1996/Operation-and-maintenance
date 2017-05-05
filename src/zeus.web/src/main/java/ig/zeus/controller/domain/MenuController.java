package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IMenuApp;
import ig.zeus.application.query.IMenuQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.repository.viewmodel.AccountViewModel;
import ig.zeus.domain.service.command.MenuCommand;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMenuApp iMenuApp;
	@Autowired
	private IMenuQueryApp iMenuQueryApp;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(HttpServletRequest request, int id) {
		message = StateMessage.from(iMenuApp.remove(id));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request, MenuCommand menuCommand) {
		message = StateMessage.from(iMenuApp.add(menuCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request, MenuCommand menuCommand) {
		message = StateMessage.from(iMenuApp.update(menuCommand));
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public @ResponseBody String getAccountReportFindAll(int current, int rowCount) {
		message = StateMessage.from(this.iMenuQueryApp.findPageData(current, rowCount));
		logger.debug(message.toString());
		return message.toString();
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportById(int id) {
		message = StateMessage.from(iMenuQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}

	@RequestMapping(value = "/findMenuTree", method = RequestMethod.GET)
	public @ResponseBody String findMenuTree(int systemId) {
		message = StateMessage.from(iMenuQueryApp.findMenuTree(systemId));
		logger.debug(message.toString());
		return message.toString();
	}

	// 根据登陆人查询权限菜单
	@RequestMapping(value = "/findMenuTreeByRole", method = RequestMethod.GET)
	public @ResponseBody String findMenuTreeByRole(HttpSession session) {
		// 先默认查询系统为1 之后可以通过request获取
		int systemId = 1;
		AccountViewModel account = (AccountViewModel) session.getAttribute("account");
		message = StateMessage.from(iMenuQueryApp.findMenuTreeByRole(systemId, account));
		logger.debug(message.toString());
		return message.toString();
	}

}
