package ig.device.controller.fault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.fault.IRepairedMaterielApp;
import ig.device.application.query.fault.basis.RepairedMaterielQueryApp;
import ig.device.domain.service.command.fault.RepairedMaterielCommand;
import ig.zeus.data.StateMessage;

/**
 * 故障单Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/RepairedMaterielController")
public class RepairedMaterielController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IRepairedMaterielApp iRepairedMaterielApp;
	@Autowired
	private RepairedMaterielQueryApp RepairedMaterielQueryApp;
	
	/**
	 * 添加维修物料
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(RepairedMaterielCommand repairedMaterielCommand){
		StateData<Boolean> add=iRepairedMaterielApp.add(repairedMaterielCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改维修物料
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(RepairedMaterielCommand repairedMaterielCommand){
		StateData<Boolean> update=iRepairedMaterielApp.update(repairedMaterielCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除维修物料
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iRepairedMaterielApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询维修物料
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(RepairedMaterielQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的维修物料
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(RepairedMaterielQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据故障单id查询维修物料
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findFaultId", method = RequestMethod.GET)
	public @ResponseBody String findFaultId(int id){
		message = StateMessage.from(RepairedMaterielQueryApp.findFaultId(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据维修单id查询维修物料
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findRepairedId", method = RequestMethod.GET)
	public @ResponseBody String findRepairedId(int id){
		message = StateMessage.from(RepairedMaterielQueryApp.findRepairedId(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
