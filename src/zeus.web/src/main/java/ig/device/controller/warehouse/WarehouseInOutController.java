package ig.device.controller.warehouse;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.warehouse.IWarehouseInOutApp;
import ig.device.application.query.warehouse.IWarehouseInOutQueryApp;
import ig.device.domain.service.command.warehouse.WarehouseInInvoiceCommand;
import ig.device.domain.service.command.warehouse.WarehouseInMaterialCommand;
import ig.device.domain.service.command.warehouse.WarehouseOutInvoiceCommand;
import ig.device.domain.service.command.warehouse.WarehouseOutMaterialCommand;
import ig.device.domain.viewmodel.warehouse.queryObject.ConditionInOutInvoice;
import ig.zeus.data.StateMessage;

/**
 * 
 * @author zjl
 * @version 0.0.1 2016年11月22日 下午2:54:13
 */
@Controller
@RequestMapping("/WarehouseInOut")
public class WarehouseInOutController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IWarehouseInOutApp iWarehouseInOutApp;
	@Autowired
	private IWarehouseInOutQueryApp iWarehouseInOutQueryApp;

	/**
	 * 新建入库单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/storageInInvoice", method = RequestMethod.POST)
	public @ResponseBody Object storageInInvoice(String invoice,String materials) {
		Gson gson = new Gson();  
		WarehouseInInvoiceCommand x = gson.fromJson(invoice, WarehouseInInvoiceCommand.class);		
		List<WarehouseInMaterialCommand> list = gson.fromJson(materials, new TypeToken<List<WarehouseInMaterialCommand>>(){}.getType());
		x.setWarehouseInMaterial(list);
		StateData<Integer> storageInInvoice = iWarehouseInOutApp.storageInInvoice(x);
		message = StateMessage.from(storageInInvoice);
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 审批入库
	 *
	 */
	@RequestMapping(value = "/approvalWarehouseInInvoice", method = RequestMethod.GET)
	public @ResponseBody Object approvalWarehouseInInvoice(int warehouseInInvoiceID, String description,
			@RequestParam(value = "invoiceState", required = false) Byte invoiceState, int createrID,
			String createrName, HttpSession httpSession) {
		if (description == null) {
			description = "";
		}
		if (invoiceState == null) {
			invoiceState = 2;
		}

		StateData<Boolean> approval = iWarehouseInOutApp.approvalWarehouseInInvoice(warehouseInInvoiceID, invoiceState,
				createrID, createrName, description);
		message = StateMessage.from(approval);

		logger.debug(message.toString());
		return message;
	}

	/**
	 * 新建入库单物资
	 * 
	 * @return
	 */
	@RequestMapping(value = "/storageInMaterial", method = RequestMethod.POST)
	public @ResponseBody Object storageInMaterial(WarehouseInMaterialCommand warehouseInMaterialCommand) {

		message = StateMessage.from(iWarehouseInOutApp.storageInMaterial(warehouseInMaterialCommand));

		logger.debug(message.toString());
		return message;
	}

	/**
	 * 更新入库单物资
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateStorageInMaterial", method = RequestMethod.POST)
	public @ResponseBody Object updateStorageInMaterial(WarehouseInMaterialCommand warehouseInMaterialCommand) {

		message = StateMessage.from(iWarehouseInOutApp.updateStorageInMaterial(warehouseInMaterialCommand));

		logger.debug(message.toString());
		return message;
	}

	/**
	 * 删除入库单物资
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteStorageInMaterial", method = RequestMethod.GET)
	public @ResponseBody Object deleteStorageInMaterial(int id) {

		message = StateMessage.from(iWarehouseInOutApp.deleteStorageInMaterial(id));

		logger.debug(message.toString());
		return message;
	}

	/*
	 * 出库
	 */

	/**
	 * 新建出库单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/storageOutInvoice", method = RequestMethod.POST)
	public @ResponseBody Object storageOutInvoice(String invoice,String materials) {
		Gson gson = new Gson();  
		WarehouseOutInvoiceCommand x = gson.fromJson(invoice, WarehouseOutInvoiceCommand.class);		
		List<WarehouseOutMaterialCommand> list = gson.fromJson(materials, new TypeToken<List<WarehouseOutMaterialCommand>>(){}.getType());
		x.setWarehouseOutMaterialCommands(list);
		StateData<Integer> storageOutInvoice = iWarehouseInOutApp.storageOutInvoice(x);
		message = StateMessage.from(storageOutInvoice);
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 审批出库
	 *
	 */
	@RequestMapping(value = "/approvalWarehouseOutInvoice", method = RequestMethod.GET)
	public @ResponseBody Object approvalWarehouseOutInvoice(int warehouseOutInvoiceID, String description,
			@RequestParam(value = "invoiceState", required = false) Byte invoiceState, int createrID,
			String createrName, HttpSession httpSession) {

		if (description == null) {
			description = "";
		}
		if (invoiceState == null) {
			invoiceState = 2;
		}

		StateData<Boolean> approval = iWarehouseInOutApp.approvalWarehouseOutInvoice(warehouseOutInvoiceID,
				invoiceState, createrID, createrName, description);
		message = StateMessage.from(approval);

		logger.debug(message.toString());
		return message;
	}

	/**
	 * 添加出库单物资
	 * 
	 */
	@RequestMapping(value = "/storageOutMaterial", method = RequestMethod.POST)
	public @ResponseBody Object storageOutMaterial(WarehouseOutMaterialCommand warehouseOutMaterialCommand) {

		message = StateMessage.from(iWarehouseInOutApp.storageOutMaterial(warehouseOutMaterialCommand));

		logger.debug(message.toString());
		return message;
	}

	/**
	 * 更新出库单物资
	 * 
	 * @return
	 */
	@RequestMapping(value = "/updateStorageOutMaterial", method = RequestMethod.POST)
	public @ResponseBody Object updateStorageOutMaterial(WarehouseOutMaterialCommand warehouseOutMaterialCommand) {

		message = StateMessage.from(iWarehouseInOutApp.updateStorageOutMaterial(warehouseOutMaterialCommand));

		logger.debug(message.toString());
		return message;
	}

	/**
	 * 删除出库单物资
	 * 
	 * @return
	 */
	@RequestMapping(value = "/deleteStorageOutMaterial", method = RequestMethod.GET)
	public @ResponseBody Object deleteStorageOutMaterial(int id) {

		message = StateMessage.from(iWarehouseInOutApp.deleteStorageOutMaterial(id));

		logger.debug(message.toString());
		return message;
	}

	/*
	 * 查询方法
	 */

	/**
	 * 根据ID,查询入库单
	 * 
	 */
	@RequestMapping(value = "/findStorageInInvoiceByID", method = RequestMethod.GET)
	public @ResponseBody String findStorageInInvoiceByID(int id) {
		message = StateMessage.from(iWarehouseInOutQueryApp.findStorageInInvoiceByID(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据ID,查询入库单物资
	 * 
	 */
	@RequestMapping(value = "/findStorageInMaterialByID", method = RequestMethod.GET)
	public @ResponseBody String findStorageInMaterialByID(int id) {
		message = StateMessage.from(iWarehouseInOutQueryApp.findStorageInMaterialByID(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据ID,查询出库单
	 * 
	 */
	@RequestMapping(value = "/findStorageOutInvoiceByID", method = RequestMethod.GET)
	public @ResponseBody String findStorageOutInvoiceByID(int id) {
		message = StateMessage.from(iWarehouseInOutQueryApp.findStorageOutInvoiceByID(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 根据ID,查询出库单物资
	 * 
	 */
	@RequestMapping(value = "/findStorageOutMaterialByID", method = RequestMethod.GET)
	public @ResponseBody String findStorageOutMaterialByID(int id) {
		message = StateMessage.from(iWarehouseInOutQueryApp.findStorageOutMaterialByID(id));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 条件查询入库单,
	 * 
	 * @param current
	 * @param rowCount
	 * @param storageIDs 仓库集合
	 * @param creatTime 开始时间
	 * @param endTime 结束时间
	 * @param storageInInvoiceID 入库单ID
	 * @param invoiceState 入库单状态
	 * @return
	 */
	@RequestMapping(value = "/findConditionPageStorageInInvoice", method = RequestMethod.GET)
	public @ResponseBody String findConditionPageStorageInInvoice(int current, int rowCount,ConditionInOutInvoice conditionInOutInvoice) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iWarehouseInOutQueryApp.findConditionPageStorageInInvoice(data,conditionInOutInvoice));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 条件查询出库单,
	 * 
	 * @param current
	 * @param rowCount
	 * @param storageIDs 仓库集合
	 * @param creatTime 开始时间
	 * @param endTime 结束时间
	 * @param storageOutInvoiceID 出库单ID
	 * @param invoiceState 出库单状态
	 * @return
	 */
	@RequestMapping(value = "/findConditionPageStorageOutInvoice", method = RequestMethod.GET)
	public @ResponseBody String findConditionPageStorageOutInvoice(int current, int rowCount,ConditionInOutInvoice conditionInOutInvoice) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iWarehouseInOutQueryApp.findConditionPageStorageOutInvoice(data,conditionInOutInvoice));
		logger.debug(message.toString());
		return message.toString();
	}
	
}
