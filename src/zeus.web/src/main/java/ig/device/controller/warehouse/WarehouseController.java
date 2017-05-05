package ig.device.controller.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.warehouse.IWarehouseApp;
import ig.device.application.query.warehouse.IWarehouseQueryApp;
import ig.device.domain.service.command.warehouse.WarehouseCommand;
import ig.zeus.data.StateMessage;

/**
 * 设备位置添加
 * 
 * @author zjl
 * @version 0.0.1 2016年10月11日 下午4:35:24
 */
@Controller
@RequestMapping("/Warehouse")
public class WarehouseController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IWarehouseApp iWarehouseApp;
	@Autowired
	private IWarehouseQueryApp iWarehouseQueryApp;
	
	/**
	 * 加载仓库树
	 * 
	 */
	@RequestMapping(value = "/findTreeByWarehouse", method = RequestMethod.GET)
	public @ResponseBody String findTreeByWarehouse() {
		message = StateMessage.from(iWarehouseQueryApp.findTreeByWarehouse());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 查询仓库
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByID", method = RequestMethod.GET)
	public @ResponseBody String findByID(int storageID) {
		message = StateMessage.from(iWarehouseQueryApp.findByID(storageID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 新建仓库
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Object insert(WarehouseCommand warehouseCommand) {
		StateData<Boolean> insert = iWarehouseApp.insert(warehouseCommand);
		message = StateMessage.from(insert);
		logger.debug(message.toString());
		return message;
	}
	/**
	 * 更新仓库
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(WarehouseCommand warehouseCommand) {
		StateData<Boolean> insert = iWarehouseApp.update(warehouseCommand);
		message = StateMessage.from(insert);
		logger.debug(message.toString());
		return message;
	}
	/**
	 * 删除仓库
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int storageID) {
		StateData<Boolean> insert = iWarehouseApp.delete(storageID);
		message = StateMessage.from(insert);
		logger.debug(message.toString());
		return message;
	}
	
	
	
	
}
