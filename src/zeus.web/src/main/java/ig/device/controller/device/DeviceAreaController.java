package ig.device.controller.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.manage.IDeviceAreaApp;
import ig.device.application.query.manage.IDeviceAreaQueryApp;
import ig.device.domain.service.command.manage.DeviceAreaCommand;
import ig.zeus.data.StateMessage;

/**
 * 设备位置添加
 * 
 * @author zjl
 * @version 0.0.1 2016年10月11日 下午4:35:24
 */
@Controller
@RequestMapping("/DeviceArea")
public class DeviceAreaController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IDeviceAreaApp iDeviceAreaApp;
	@Autowired
	private IDeviceAreaQueryApp iDeviceAreaQueryApp;

	/**
	 * 新建位置
	 * 
	 * @param deviceAreaCommand
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Object insert(DeviceAreaCommand deviceAreaCommand) {
		Integer supStorageID = deviceAreaCommand.getSupStorageID();
		//获取supStorageID
		if (supStorageID == null) {
			deviceAreaCommand.setSupStorageID(1);
		}
		StateData<Boolean> insert = iDeviceAreaApp.insert(deviceAreaCommand);
		message = StateMessage.from(insert);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 更新位置
	 * 
	 * @param deviceAreaCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(DeviceAreaCommand deviceAreaCommand) {
		StateData<Boolean> update = iDeviceAreaApp.update(deviceAreaCommand);
		message = StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 删除位置
	 * 
	 * @param deviceAreaID
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int deviceAreaID) {
		StateData<Boolean> delete = iDeviceAreaApp.delete(deviceAreaID);
		message = StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 查询仓库
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByID", method = RequestMethod.GET)
	public @ResponseBody String findByID(int storageID) {
		message = StateMessage.from(iDeviceAreaQueryApp.findByID(storageID));
		logger.debug(message.toString());
		return message.toString();
	}

	/**
	 * 分页查询,根据父级仓库ID,查询其子级仓库
	 * 
	 * @param current
	 * @param rowCount
	 * @param supID
	 * @return
	 */
	@RequestMapping(value = "/findAllPage", method = RequestMethod.GET)
	public @ResponseBody String findAllPage(int current, int rowCount, int supID) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iDeviceAreaQueryApp.findAllPage(data, supID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据设备位置,加载树
	 * 
	 */
	@RequestMapping(value = "/findTreeByDeviceArea", method = RequestMethod.GET)
	public @ResponseBody String findTreeByDeviceArea() {
		message = StateMessage.from(iDeviceAreaQueryApp.findTreeByDeviceArea());
		logger.debug(message.toString());
		return message.toString();
	}
	

}
