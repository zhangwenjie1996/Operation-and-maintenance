package ig.device.controller.mateial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.IUnitsApp;
import ig.device.application.query.material.basis.UnitsQueryApp;
import ig.device.domain.service.command.material.UnitsCommand;
import ig.zeus.data.StateMessage;

/**
 * 单位Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/UnitsController")
public class UnitsController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IUnitsApp iUnitsApp;
	@Autowired
	private UnitsQueryApp unitsQueryApp;
	
	/**
	 * 添加单位
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(UnitsCommand unitsCommand){
		StateData<Boolean> add=iUnitsApp.add(unitsCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改单位
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(UnitsCommand unitsCommand){
		StateData<Boolean> update=iUnitsApp.update(unitsCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除单位
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iUnitsApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询规格
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(unitsQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的规格
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(unitsQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	
}
