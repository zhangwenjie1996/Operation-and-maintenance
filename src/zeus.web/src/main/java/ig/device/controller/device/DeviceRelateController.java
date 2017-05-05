package ig.device.controller.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.query.manage.IDeviceQueryApp;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/DeviceRelate")
public class DeviceRelateController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IDeviceQueryApp iDeviceQueryApp;

	/**
	 * 物资类型树
	 * 
	 */
	@RequestMapping(value = "/findAllMaterialCategory", method = RequestMethod.GET)
	public @ResponseBody Object findAllMaterialCategory() {
		message = StateMessage.from(iDeviceQueryApp.findAllMaterialCategory());
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 
	 * 
	 */
	@RequestMapping(value = "/findAllMaterialModel", method = RequestMethod.GET)
	public @ResponseBody Object findAllMaterialModel(Integer current, Integer rowCount, String categoryID) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iDeviceQueryApp.findAllMaterialModel(data, categoryID));
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 统计设备型号数量
	 * 
	 */
	@RequestMapping(value = "/findModelKind", method = RequestMethod.GET)
	public @ResponseBody Object findModelKind(Integer storageID) {
		message = StateMessage.from(iDeviceQueryApp.findModelKind(storageID));
		logger.debug(message.toString());
		return message;
	}

	/**
	 * 统计设备型号数量
	 * 
	 */
	@RequestMapping(value = "/findDeviceState", method = RequestMethod.GET)
	public @ResponseBody Object findDeviceState(Integer[] deviceArea) {
		// 判断前端传递过来的集合不为null,但其length为0,则为置为null
		if (deviceArea != null && deviceArea.length == 0) {
			deviceArea = null;
		}
		message = StateMessage.from(iDeviceQueryApp.findDeviceState(deviceArea));
		logger.debug(message.toString());
		return message;
	}
	/**
	 * 统计设备等级数量
	 * 
	 */
	@RequestMapping(value = "/findDeviceGrade", method = RequestMethod.GET)
	public @ResponseBody Object findDeviceGrade(Integer[] deviceArea) {
		// 判断前端传递过来的集合不为null,但其length为0,则为置为null
		if (deviceArea != null && deviceArea.length == 0) {
			deviceArea = null;
		}
		message = StateMessage.from(iDeviceQueryApp.findDeviceGrade(deviceArea));
		logger.debug(message.toString());
		return message;
	}

}
