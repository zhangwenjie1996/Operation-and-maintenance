package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IPostApp;
import ig.zeus.application.query.IPostQueryApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.service.command.PostCommand;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IPostApp iPostApp;
	@Autowired
	private IPostQueryApp iPostQueryApp;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(HttpServletRequest request, int id) {
		StateData<Boolean> del = iPostApp.remove(id);
		message = StateMessage.from(del);
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request, PostCommand postCommand) {
		StateData<Integer> del = iPostApp.add(postCommand);
		message = StateMessage.from(del);
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request, PostCommand postCommand) {
		StateData<Boolean> del = iPostApp.update(postCommand);
		message = StateMessage.from(del);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 鏌ユ壘鍒嗛〉宀椾綅淇℃伅
	 * 
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportFindAll(int current, int rowCount) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iPostQueryApp.findPageData(data));
		logger.debug(message.toString());
		return message.toString();
	}

	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String getAccountReportById(@RequestParam("id") int id) {
		message = StateMessage.from(iPostQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}

	// 鏍规嵁缁勭粐鏈烘瀯id鏌ヨ涓嬪睘鎵�鏈夊矖浣嶄俊鎭�(鍒嗛〉)
	@RequestMapping(value = "/findAllPostByOrganID", method = RequestMethod.GET)
	public @ResponseBody String getAllPostByOrganID(int current, int rowCount, int organID) {
		message = StateMessage.from(iPostQueryApp.getAllPostByOrganID(current, rowCount, organID));
		logger.debug(message.toString());
		return message.toString();
	}
	@RequestMapping(value = "/findSelectPostByOrganID", method = RequestMethod.GET)
	public @ResponseBody String findSelectPostByOrganID(int organid) {
		message = StateMessage.from(iPostQueryApp.findSelectPostByOrganID(organid));
		logger.debug(message.toString());
		return message.toString();
	}
}
