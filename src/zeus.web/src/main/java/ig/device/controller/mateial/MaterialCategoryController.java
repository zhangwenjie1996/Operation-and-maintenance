package ig.device.controller.mateial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.IMaterialCategoryApp;
import ig.device.application.query.material.basis.MaterialCategoryQueryApp;
import ig.device.domain.service.command.material.MaterialCategoryCommand;
import ig.zeus.data.StateMessage;
/**
 * 物资类型Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/MaterialCategoryController")
public class MaterialCategoryController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaterialCategoryApp iMaterialCategoryApp;
	@Autowired
	private MaterialCategoryQueryApp materialCategoryQueryApp;
	
	/**
	 * 添加物资类型
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(MaterialCategoryCommand materialCategoryCommand){
		materialCategoryCommand.setAvailability((byte)1);
		StateData<Boolean> add=iMaterialCategoryApp.add(materialCategoryCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 修改物资类型
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(MaterialCategoryCommand materialCategoryCommand){
		materialCategoryCommand.setAvailability((byte)1);
		StateData<Boolean> update=iMaterialCategoryApp.update(materialCategoryCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除物资类型
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iMaterialCategoryApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询物资类型
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(materialCategoryQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的物资类型
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(materialCategoryQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据类别查询物资类型
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/findMaterialType", method = RequestMethod.POST)
	public @ResponseBody String findMaterialType(byte type){
		message = StateMessage.from(materialCategoryQueryApp.findMaterialType(type));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据类型,加载树
	 * 
	 */
	@RequestMapping(value = "/findCategoryTree", method = RequestMethod.GET)
	public @ResponseBody String findCategoryTree() {
		message = StateMessage.from(materialCategoryQueryApp.findCategoryTree());
		logger.debug(message.toString());
		return message.toString();
	}
	
	
}
