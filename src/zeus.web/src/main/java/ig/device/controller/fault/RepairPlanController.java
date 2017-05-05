package ig.device.controller.fault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.fault.IRepairPlanApp;
import ig.device.application.query.fault.basis.RepairPlanQueryApp;
import ig.device.domain.service.command.fault.RepairPlanCommand;
import ig.zeus.data.StateMessage;

/**
 * 维修计划Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/RepairPlanController")
public class RepairPlanController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IRepairPlanApp iRepairPlanApp;
	@Autowired
	private RepairPlanQueryApp RepairPlanQueryApp;
	
	/**
	 * 添加维修计划
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(RepairPlanCommand repairPlanCommand){
		StateData<Boolean> add=iRepairPlanApp.add(repairPlanCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改维修计划
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(RepairPlanCommand repairPlanCommand){
		StateData<Boolean> update=iRepairPlanApp.update(repairPlanCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除维修计划
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iRepairPlanApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询维修计划
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(RepairPlanQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据维修单id查询维修计划
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findRepairedId", method = RequestMethod.GET)
	public @ResponseBody String findRepairedId(int repairedId){
		message = StateMessage.from(RepairPlanQueryApp.findRepairedId(repairedId));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
}
