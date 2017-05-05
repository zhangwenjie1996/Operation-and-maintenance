package ig.device.controller.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.query.warehouse.IMaterialQueryApp;
import ig.device.domain.viewmodel.warehouse.queryObject.FindPageMaterial;
import ig.zeus.data.StateMessage;

/**
 * 
 * @author zjl
 * @version 0.0.1
 * 2016年11月22日 上午9:00:52
 */
@Controller
@RequestMapping("/Material")
public class MaterialController {

	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaterialQueryApp iMaterialQueryApp;
	
	
	
	/**
	 * 物资汇总条件查询
	 */
	@RequestMapping(value = "/findPage", method = RequestMethod.GET)
	public @ResponseBody String findPage(Integer current, Integer rowCount,FindPageMaterial findPageMaterial) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaterialQueryApp.findPage(data,findPageMaterial));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 物资出库条件查询
	 */
	@RequestMapping(value = "/findMaterialPage", method = RequestMethod.GET)
	public @ResponseBody String findMaterialPage(Integer current, Integer rowCount,FindPageMaterial findPageMaterial) {
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iMaterialQueryApp.findMaterialPage(data,findPageMaterial));
		logger.debug(message.toString());
		return message.toString();
	}
	
	

}
