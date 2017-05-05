package ig.device.controller.fault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.fault.IOperatorLogApp;
import ig.device.application.query.fault.basis.OperatorLogQueryApp;
import ig.device.domain.service.command.fault.OperatorLogCommand;
import ig.zeus.data.StateMessage;

/**
 * 操作记录Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/OperatorLogController")
public class OperatorLogController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IOperatorLogApp iOperatorLogApp;
	@Autowired
	private OperatorLogQueryApp OperatorLogQueryApp;
	
	/**
	 * 添加操作记录
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(OperatorLogCommand operatorLogCommand){
		StateData<Boolean> add=iOperatorLogApp.add(operatorLogCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改操作记录
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(OperatorLogCommand operatorLogCommand){
		StateData<Boolean> update=iOperatorLogApp.update(operatorLogCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除操作记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iOperatorLogApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据故障单id查询操作记录
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findFaultId", method = RequestMethod.GET)
	public @ResponseBody String findFaultId(int faultid){
		message = StateMessage.from(OperatorLogQueryApp.findFaultId(faultid));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
