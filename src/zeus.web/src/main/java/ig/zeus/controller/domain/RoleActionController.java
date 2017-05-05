package ig.zeus.controller.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/roleActionController")
public class RoleActionController {
//	@Autowired
//	private ILogger logger;
//	@Autowired
//	private StateMessage message;
//	@Autowired
//	private IPermissionApp iPremissionApp;
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public @ResponseBody Object delete(HttpServletRequest request, int roleid,int actionid) {
//		Integer flag = 0;
//		if (roleid != 0&&actionid!=0) {
//			flag=iPremissionApp.deleteRoleAction(roleid, actionid);
//		}
//		if(flag==1){
//			message.setState(State.Success);
//			message.setMessage("鍒犻櫎鎴愬姛锛�");
//		}else{
//			message.setState(State.Failure);
//			message.setMessage("鍒犻櫎澶辫触锛�");
//		}
//		logger.debug(message.toString());
//		return message;
//	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public @ResponseBody Object add(HttpServletRequest request,RoleActionCommand roleActionCommand) {
//		Integer flag = 0;
//		if(roleActionCommand!=null){
//			flag=iPremissionApp.insertRoleAction(roleActionCommand);
//		}
//		if(flag==1){
//			message.setState(State.Success);
//			message.setMessage("淇濆瓨鎴愬姛锛�");
//		}else{
//			message.setState(State.Failure);
//			message.setMessage("淇濆瓨澶辫触锛�");
//		}
//		return message;
//	}
//
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public @ResponseBody Object update(HttpServletRequest request,RoleActionCommand roleActionCommand) {
//		Integer flag = 0;
//		if(roleActionCommand!=null){
//			flag=iPremissionApp.updateRoleAction(roleActionCommand);
//		}
//		if(flag==1){
//			message.setState(State.Success);
//			message.setMessage("鏇存柊鎴愬姛锛�");
//		}else{
//			message.setState(State.Failure);
//			message.setMessage("鏇存柊澶辫触锛�");
//		}
//		return message;
//	}
}
