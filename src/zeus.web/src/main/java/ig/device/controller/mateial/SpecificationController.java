package ig.device.controller.mateial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.ISpecificationApp;
import ig.device.application.query.material.basis.SpecificationQueryApp;
import ig.device.domain.service.command.material.SpecificationsCommand;
import ig.zeus.data.StateMessage;

/**
 * 规格Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/SpecificationController")
public class SpecificationController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private ISpecificationApp iSpecificationApp;
	@Autowired
	private SpecificationQueryApp specificationQueryApp;
	
	/**
	 * 添加规格
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(SpecificationsCommand specificationsCommand){
		StateData<Boolean> add=iSpecificationApp.add(specificationsCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改规格
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(SpecificationsCommand specificationsCommand){
		StateData<Boolean> update=iSpecificationApp.update(specificationsCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除规格
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iSpecificationApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询规格
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(specificationQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的规格
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(specificationQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据物资型号查询规格
	 * @return
	 */
	@RequestMapping(value = "/findMaterialModelId", method = RequestMethod.GET)
	public @ResponseBody String findMaterialModelId(int current, int rowCount,int materialModelID){
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(specificationQueryApp.findMaterialModel(data,materialModelID));
		logger.debug(message.toString());
		return message.toString();
	}
}
