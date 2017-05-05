package ig.device.controller.device;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.manage.IDeviceInfoApp;
import ig.device.application.query.manage.IDeviceInfoQueryApp;
import ig.device.domain.service.command.manage.DeviceInfoCommand;
import ig.device.domain.viewmodel.manage.DeviceInfoViewModel;
import ig.zeus.data.StateMessage;

/**
 * 设备管理
 * 
 * @author zjl
 * @version 0.0.1 2016年10月11日 下午4:35:46
 */
@Controller
@RequestMapping("/DeviceInfo")
public class DeviceInfoController {

	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IDeviceInfoApp iDeviceInfoApp;
	@Autowired
	private IDeviceInfoQueryApp iDeviceInfoQueryApp;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// true:鍏佽杈撳叆绌哄�硷紝false:涓嶈兘涓虹┖鍊�
    }
	
	
	/**
	 * 新建设备
	 * 
	 * @param deviceInfoCommand
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Object insert(DeviceInfoCommand deviceInfoCommand) {
		//获取设备编号
		String itemCode = deviceInfoCommand.getItemCode();

		if (itemCode != null && itemCode != "") {
			//根据设备编号查询设备数,若为0,则可以新建,若大于0,则设备编号存在不可新建设备
			int count = iDeviceInfoQueryApp.findByItemCode(itemCode);
			if (count ==0) {
				deviceInfoCommand.setOperateTime(new Date());
				message = StateMessage.from(iDeviceInfoApp.insert(deviceInfoCommand));
			}else{
				message = new StateMessage(State.Failure, "保存失败,设备编号已存在");
			}
		}else {
			message = new StateMessage(State.Failure, "保存失败,没有输入设备编号");
		}
		logger.debug(message.toString());
		return message;
	}
	/**
	 * 更新设备
	 * 
	 * @param deviceInfoCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody Object update(HttpServletRequest request,DeviceInfoCommand deviceInfoCommand) {
		
		String itemCode = deviceInfoCommand.getItemCode();
		Integer itemID = deviceInfoCommand.getItemID();
		
		if (itemCode != null && itemCode != "" && itemID != null) {
			int count = iDeviceInfoQueryApp.findByItemCode(itemCode);
			StateData<DeviceInfoViewModel> findByID = iDeviceInfoQueryApp.findByID(itemID);
			DeviceInfoViewModel data = findByID.getData();
			String itemCode2 = data.getItemCode();			
			/*
			 * 获取设备编号,根据设备编号查询设备数,有两种情况判断
			 * 		count 为0,则更新的设备编号不冲突
			 * 		count 为1,则要判断是不是设备编号仍为原设备编号,若是这可以更新
			 * 					不是原设备编号不能执行更新操作*/
			if (count == 0 || (count == 1 && itemCode2.equals(itemCode))) {
				message = StateMessage.from(iDeviceInfoApp.update(deviceInfoCommand));
			}else {
				message = new StateMessage(State.Failure, "更新失败,设备编号已存在");
			}
		}else {
			message = new StateMessage(State.Failure, "更新失败");
		}		
		logger.debug(message.toString());
		return message;
	}
	/**
	 * 删除设备
	 * 
	 * @param deviceInfoCommand
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(int id) {
		message = StateMessage.from(iDeviceInfoApp.delete(id));
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 批量更新设备状态
	 * 
	 * @param Map<K,V>   
	 * 		K : 设备详情ID
	 * 		v : 设备更新状态
	 * 
	 */
	@RequestMapping(value = "/updateMap", method = RequestMethod.POST)
	public @ResponseBody Object updateMap(List<DeviceInfoCommand> list) {
		StateData<Boolean> updateDeviceState = iDeviceInfoApp.updateDeviceState(list);
		message = StateMessage.from(updateDeviceState);
		logger.debug(message.toString());
		return message;
	}
	
	
	/**
	 * 根据设备ID,查询设备
	 * 
	 * @param id 设备ID
	 * @return
	 */
	@RequestMapping(value = "/findByID", method = RequestMethod.GET)
	public @ResponseBody String findByID(int id) {
		message = StateMessage.from(iDeviceInfoQueryApp.findByID(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 设备条件查询
	 * 
	 * @param current 
	 * @param rowCount
	 * @param deviceArea 区域集合
	 * @param deviceCategory 设备类型集合
	 * @param deviceState 设备状态
	 * @param deviceGrade 设备等级
	 * @param deviceOrgan 设备所属部门
	 * @param itemCode 设备编号
	 * @return
	 */
	@RequestMapping(value = "/findPage", method = RequestMethod.GET)
	public @ResponseBody String findPage(Integer current, Integer rowCount,
			@RequestParam(value="deviceArea",required=false) Integer[] deviceArea,
			@RequestParam(value="deviceCategory",required=false) Integer[] deviceCategory,
			@RequestParam(value="deviceState",required=false) Integer deviceState,
			@RequestParam(value="deviceGrade",required=false) Integer deviceGrade,
			@RequestParam(value="deviceOrgan",required=false) Integer[] deviceOrgan,
			@RequestParam(value="itemCode",required=false) String itemCode) {
		//判断前端传递过来的集合不为null,但其length为0,则为置为null
		if (deviceArea != null && deviceArea.length == 0) {
			deviceArea = null;
		}
		if (deviceCategory != null && deviceCategory.length == 0) {
			deviceCategory = null;
		}
		if (deviceOrgan != null && deviceOrgan.length == 0) {
			deviceOrgan = null;
		}
		//前端设备编号不填写查询,接收到的itemCode为"",所以要设为null
		if (itemCode != null && itemCode.length() == 0) {
			itemCode = null;
		}
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(iDeviceInfoQueryApp.findPage(data,deviceArea,deviceCategory,deviceState,deviceGrade, deviceOrgan,itemCode));
		logger.debug(message.toString());
		return message.toString();
	}
	

	
	
	
	
	
}
