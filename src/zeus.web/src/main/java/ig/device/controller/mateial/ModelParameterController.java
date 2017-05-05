package ig.device.controller.mateial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.IModelParameterApp;
import ig.device.application.query.material.basis.ModelParameterQueryApp;
import ig.device.domain.service.command.material.ModelParameterCommand;
import ig.zeus.data.StateMessage;

/**
 * 参数Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/ModelParameterController")
public class ModelParameterController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IModelParameterApp iModelParameterApp;
	@Autowired
	private ModelParameterQueryApp modelParameterQueryApp;
	
	/**
	 * 添加参数
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(ModelParameterCommand modelParameterCommand){
		StateData<Boolean> add=iModelParameterApp.add(modelParameterCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改参数
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(ModelParameterCommand modelParameterCommand){
		StateData<Boolean> update=iModelParameterApp.update(modelParameterCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iModelParameterApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(modelParameterQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的参数
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(modelParameterQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据物资型号查询参数
	 * @return
	 */
	@RequestMapping(value = "/findMaterialModelId", method = RequestMethod.GET)
	public @ResponseBody String findMaterialModelId(int current, int rowCount,int materialModelID){
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(modelParameterQueryApp.findMaterialModel(data,materialModelID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
