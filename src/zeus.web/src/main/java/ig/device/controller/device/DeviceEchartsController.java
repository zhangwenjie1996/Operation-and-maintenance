package ig.device.controller.device;

import java.awt.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.log.ILogger;
import ig.device.application.query.manage.IDeviceQueryApp;
import ig.zeus.data.MatrixToLogoImageWriter;
import ig.zeus.data.StateMessage;

@Controller
@RequestMapping("/DeviceEcharts")
public class DeviceEchartsController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IDeviceQueryApp iDeviceQueryApp;

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
	/**
	 * 二维码生成方法
	 * 
	 */
	@RequestMapping(value = "/createQrCode", method = RequestMethod.GET)
	public @ResponseBody Object createQrCode(Integer[] id) {
        
		String [] strs = {"百度:123","谷歌:123"};
        
        
        try {
        	
			MatrixToLogoImageWriter.encodeText("你好",strs,"E:",6, Color.BLACK, 18,"");
        
        } catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}
	
	
	

}
