package ig.device.controller.mateial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.IMaintainApproachApp;
import ig.device.application.query.material.IMaintainApproachQueryApp;
import ig.device.domain.service.command.material.MaintainApproachCommand;
import ig.zeus.data.StateMessage;

/**
 * 保养操作Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/MaintainApproachController")
public class MaintainApproachController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaintainApproachApp iMaintainApproachApp;
	@Autowired
	private IMaintainApproachQueryApp iMaintainApproachQueryApp;
	
	/**
	 * 添加保养操作
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(MaintainApproachCommand maintainApproachCommand){
		StateData<Boolean> add=iMaintainApproachApp.add(maintainApproachCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改保养操作
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(MaintainApproachCommand maintainApproachCommand){
		StateData<Boolean> update=iMaintainApproachApp.update(maintainApproachCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除保养操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iMaintainApproachApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询保养操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(iMaintainApproachQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的保养操作
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(iMaintainApproachQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据物资型号查询保养操作
	 * @return
	 */
	@RequestMapping(value = "/findMaterialModelId", method = RequestMethod.GET)
	public @ResponseBody String findMaterialModelId(int current, int rowCount,int materialModelID){
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaintainApproachQueryApp.findMaterialModel(data,materialModelID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
