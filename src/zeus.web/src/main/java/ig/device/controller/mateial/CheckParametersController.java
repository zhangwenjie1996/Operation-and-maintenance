package ig.device.controller.mateial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.ICheckParametersApp;
import ig.device.application.query.material.ICheckParametersQueryApp;
import ig.device.domain.service.command.material.CheckParametersCommand;
import ig.device.domain.service.command.material.ModelParameterCommand;
import ig.zeus.data.StateMessage;

/**
 * 巡检参数Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/CheckParametersController")
public class CheckParametersController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private ICheckParametersApp iCheckParametersApp;
	@Autowired
	private ICheckParametersQueryApp iCheckParametersQueryApp;
	
	/**
	 * 添加巡检参数
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(CheckParametersCommand checkParametersCommand){
		StateData<Boolean> add=iCheckParametersApp.add(checkParametersCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改巡检参数
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(CheckParametersCommand checkParametersCommand){
		StateData<Boolean> update=iCheckParametersApp.update(checkParametersCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除巡检参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iCheckParametersApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询巡检参数
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(Integer id){
		message = StateMessage.from(iCheckParametersQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的巡检参数
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(iCheckParametersQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据物资型号查询巡检参数
	 * @return
	 */
	@RequestMapping(value = "/findMaterialModelId", method = RequestMethod.GET)
	public @ResponseBody String findMaterialModelId(int current, int rowCount,Integer materialModelID){
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iCheckParametersQueryApp.findMaterialModel(data,materialModelID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
