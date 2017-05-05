package ig.device.controller.fault;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.fault.IStoppageInvoiceApp;
import ig.device.application.query.fault.IStoppageInvoiceQueryApp;
import ig.device.domain.service.command.fault.StoppageInvoiceCommand;
import ig.device.domain.type.formStateType;
import ig.device.domain.viewmodel.fault.StoppageInvoiceViewModel;
import ig.zeus.data.StateMessage;

/**
 * 故障单Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/StoppageInvoiceController")
public class StoppageInvoiceController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IStoppageInvoiceApp iStoppageInvoiceApp;
	@Autowired
	private IStoppageInvoiceQueryApp iStoppageInvoiceQueryApp;
	
	/**
	 * 添加故障单
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(StoppageInvoiceCommand stoppageInvoiceCommand){
		StateData<Boolean> add=iStoppageInvoiceApp.add(stoppageInvoiceCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 修改故障单
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(StoppageInvoiceCommand stoppageInvoiceCommand){
		StateData<Boolean> update=iStoppageInvoiceApp.update(stoppageInvoiceCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除故障单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id){
		StateData<Boolean> delete=iStoppageInvoiceApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id查询故障单
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(int id){
		message = StateMessage.from(iStoppageInvoiceQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 多条件查询故障单
	 * @return
	 */
	@RequestMapping(value = "/findFaultCondition", method = RequestMethod.GET)
	public @ResponseBody String findFaultCondition(int current, int rowCount, StoppageInvoiceViewModel stoppageInvoiceViewModel,int role){
		PagingData data = new PagingData(current, rowCount);
		if(role==1){
			stoppageInvoiceViewModel.setFaultState(null);
		}else if(role==2){
			stoppageInvoiceViewModel.setFaultState(formStateType.AlreadySubmit.ordinal());
		}else{
			stoppageInvoiceViewModel.setFaultState(9);
		}
		message = StateMessage.from(iStoppageInvoiceQueryApp.findFaultCondition(data, stoppageInvoiceViewModel));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
