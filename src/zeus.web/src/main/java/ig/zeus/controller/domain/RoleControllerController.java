package ig.zeus.controller.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/roleControllerController")
public class RoleControllerController {
//	@Autowired
//	private ILogger logger;
//	@Autowired
//	private StateMessage message;
//	@Autowired
//	private IPermissionApp iPremissionApp;
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public @ResponseBody Object delete(HttpServletRequest request, int roleid,int controllerid) {
//		Integer flag = 0;
//		if (roleid != 0&&controllerid!=0) {
//			flag=iPremissionApp.deleteRoleController(roleid, controllerid);
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
//	public @ResponseBody Object add(HttpServletRequest request,RoleControllerCommand roleControllerCommand) {
//		Integer flag = 0;
//		if(roleControllerCommand!=null){
//			flag=iPremissionApp.insertRoleController(roleControllerCommand);
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
//	public @ResponseBody Object update(HttpServletRequest request,RoleControllerCommand roleControllerCommand) {
//		Integer flag = 0;
//		if(roleControllerCommand!=null){
//			flag=iPremissionApp.updateRoleController(roleControllerCommand);
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
