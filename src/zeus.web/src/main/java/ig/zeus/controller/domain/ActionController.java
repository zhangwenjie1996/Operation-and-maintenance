package ig.zeus.controller.domain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.type.State;
import ig.archer.infrastructure.log.ILogger;
import ig.zeus.application.command.IActionApp;
import ig.zeus.data.StateMessage;
import ig.zeus.domain.service.command.ActionCommand;
@Controller
@RequestMapping("/actionController")
public class ActionController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IActionApp iActionApp;
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(HttpServletRequest request, int id) {
		System.out.println(id);
		Integer flag = 0;
		if (id != 0) {
			flag=iActionApp.remove(id);
		}
		if(flag==1){
			message.setState(State.Success);
			message.setMessage("删除成功！");
		}else{
			message.setState(State.Failure);
			message.setMessage("删除失败！");
		}
		logger.debug(message.toString());
		return message;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request,ActionCommand actionCommand) {
		Integer flag = 0;
		if(actionCommand!=null){
			flag=iActionApp.add(actionCommand);
		}
		if(flag==1){
			message.setState(State.Success);
			message.setMessage("保存成功！");
		}else{
			message.setState(State.Failure);
			message.setMessage("保存失败！");
		}
		return message;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(HttpServletRequest request,ActionCommand actionCommand) {
		Integer flag = 0;
		if(actionCommand!=null){
			flag=iActionApp.update(actionCommand);
		}
		if(flag==1){
			message.setState(State.Success);
			message.setMessage("更新成功！");
		}else{
			message.setState(State.Failure);
			message.setMessage("更新失败！");
		}
		return message;
	}

}
