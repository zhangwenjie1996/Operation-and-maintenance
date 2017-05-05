package ig.device.controller.warehouse.task;

import org.springframework.beans.factory.annotation.Autowired;

import ig.device.application.commandhandler.warehouse.IWarehouseApp;
/**
 * 库存报警
 * @author zjl
 * @version 0.0.1
 * 2016年12月1日 上午9:05:32
 */
public class MaterialAmountWarnTask {

	@Autowired
	private IWarehouseApp iWarehouseApp;
	
	public void amountWarnTask() {
		try {
			//执行
			//iWarehouseApp.materialAmountWarnTask();

		} catch (Exception e) {

		} finally {

		}

	}
	
	
	
}
