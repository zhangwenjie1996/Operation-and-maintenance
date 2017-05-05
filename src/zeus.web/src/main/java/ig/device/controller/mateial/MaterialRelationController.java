package ig.device.controller.mateial;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.basis.MaterialRelationApp;
import ig.device.domain.service.command.material.MaterialRelationCommand;
import ig.zeus.data.StateMessage;

/**
 * 物资型号配件关联Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/MaterialRelationController")
public class MaterialRelationController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private MaterialRelationApp materialRelationApp;
	
	/**
	 * 添加物资型号配件关联
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(HttpServletRequest request,@RequestBody List<MaterialRelationCommand> materialRelationCommands){
		StateData<Boolean> add=materialRelationApp.add(materialRelationCommands);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改物资型号配件关联
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(MaterialRelationCommand materialRelationCommand){
		StateData<Boolean> update=materialRelationApp.update(materialRelationCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除物资型号配件关联
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(Integer materialRelationID){
		StateData<Boolean> delete=materialRelationApp.remove(materialRelationID);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
}
