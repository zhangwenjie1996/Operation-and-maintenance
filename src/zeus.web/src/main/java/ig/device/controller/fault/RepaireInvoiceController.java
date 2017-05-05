package ig.device.controller.fault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.fault.IRepaireInvoiceApp;
import ig.device.application.query.fault.basis.RepaireInvoiceQueryApp;
import ig.device.domain.service.command.fault.RepaireInvoiceCommand;
import ig.device.domain.viewmodel.fault.RepaireInvoiceViewModel;
import ig.zeus.data.StateMessage;

/**
 * 维修单Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/RepaireInvoiceController")
public class RepaireInvoiceController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IRepaireInvoiceApp iRepaireInvoiceApp;
	@Autowired
	private RepaireInvoiceQueryApp RepaireInvoiceQueryApp;
	
	/**
	 * 添加维修单
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(RepaireInvoiceCommand repaireInvoiceCommand){
		StateData<Boolean> add=iRepaireInvoiceApp.add(repaireInvoiceCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改维修单
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(RepaireInvoiceCommand repaireInvoiceCommand){
		StateData<Boolean> update=iRepaireInvoiceApp.update(repaireInvoiceCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除维修单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iRepaireInvoiceApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询维修单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(RepaireInvoiceQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询所有的维修单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public @ResponseBody String findAll(){
		message = StateMessage.from(RepaireInvoiceQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据故障单id查询维修单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findFaultID", method = RequestMethod.GET)
	public @ResponseBody String findFaultID(int id){
		message = StateMessage.from(RepaireInvoiceQueryApp.findFaultID(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 多条件查询维修单
	 * @return
	 */
	@RequestMapping(value = "/findRepaireCondition", method = RequestMethod.GET)
	public @ResponseBody String findRepaireCondition(int current, int rowCount, RepaireInvoiceViewModel repaireInvoiceViewModel, int role){
		PagingData data = new PagingData(current, rowCount);
		if(role==3){
			repaireInvoiceViewModel.setRepairedState(null);
		}else if(role==5){
			repaireInvoiceViewModel.setRepairedState(null);
		}else{
			repaireInvoiceViewModel.setRepairedState(9);
		}
		message = StateMessage.from(RepaireInvoiceQueryApp.findRepaireCondition(data, repaireInvoiceViewModel));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
