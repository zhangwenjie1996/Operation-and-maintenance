package ig.device.controller.mateial;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;
import ig.archer.infrastructure.log.ILogger;
import ig.device.application.commandhandler.material.IMaterialModelApp;
import ig.device.application.query.material.IMaterialModelQueryApp;
import ig.device.domain.service.command.material.MaterialModelCommand;
import ig.device.domain.viewmodel.material.MaterialModelViewModel;
import ig.zeus.data.StateMessage;
/**
 * 物资型号Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/MaterialModelController")
public class MaterialModelController {
	@Autowired
	private ILogger logger;
	@Autowired
	private StateMessage message;
	@Autowired
	private IMaterialModelQueryApp imaterialModelQueryApp;
	@Autowired
	private IMaterialModelApp iMaterialModelApp;
	
	/**
	 * 添加物资型号
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Object add(MaterialModelCommand materialModelCommand){
		StateData<Boolean> add=iMaterialModelApp.add(materialModelCommand);
		message=StateMessage.from(add);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 添加物资型号
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody Object insert(MaterialModelCommand materialModelCommand){
		//判断是否是第一次保存   （点击新增第一次报存acailability字段是0）   不是第一次保存就做修改操作（acailability字段改为1）
		if(materialModelCommand.getMaterialModelID()==0 || "".equals(materialModelCommand.getMaterialModelID())){
			int materialModelID=iMaterialModelApp.insert(materialModelCommand);
			//根据acailability字段判断是点击的保存还是新增
			if(materialModelID>0){
				if(materialModelCommand.getAvailability()==(byte)0){
					message = StateMessage.from(imaterialModelQueryApp.findById2(materialModelID));
				}else{
					message=StateMessage.from(imaterialModelQueryApp.findById(materialModelID));
				}
			}else{
				message = new StateMessage(State.Failure, "对不起,保存失败,请重新进行操作!");
			}
			logger.debug(message.toString());
			
		}else{
			materialModelCommand.setAvailability((byte)1);
			StateData<Boolean> update=iMaterialModelApp.update(materialModelCommand);
			if(update.getState().equals(State.Success)){
				message=StateMessage.from(imaterialModelQueryApp.findById(materialModelCommand.getMaterialModelID()));
			}else{
				message = new StateMessage(State.Failure, "对不起,保存失败,请重新进行操作!");
			}
			
			logger.debug(message.toString());
		}
		return message;
	}
	
	

	/**
	 * 修改物资型号
	 * @param materialCategoryCommand
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Object update(MaterialModelCommand materialModelCommand){
		StateData<Boolean> update=iMaterialModelApp.update(materialModelCommand);
		message=StateMessage.from(update);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id删除物资型号
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(Integer id){
		StateData<Boolean> delete=iMaterialModelApp.remove(id);
		message=StateMessage.from(delete);
		logger.debug(message.toString());
		return message;
	}
	
	/**
	 * 根据id分页查询物资型号
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByIdPage", method = RequestMethod.POST)
	public @ResponseBody String findByIdPage(int current, int rowCount,int id){
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(imaterialModelQueryApp.findByIdPage(data,id));
		logger.debug(message.toString());
		return message.toString();
	}
	/**
	 * 根据id连表查询物资型号
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByIdRelation", method = RequestMethod.GET)
	public @ResponseBody String findByIdRelation(Integer id,Integer supMaterialModelID){
		message = StateMessage.from(imaterialModelQueryApp.findByIdRelation(id,supMaterialModelID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据id查询物资型号
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET)
	public @ResponseBody String findById(Integer id){
		message = StateMessage.from(imaterialModelQueryApp.findById(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	/**
	 * 查询所有的物资类型
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public @ResponseBody String findAll(){
		message = StateMessage.from(imaterialModelQueryApp.findAll());
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 根据设备id查询物资型号
	 * @return
	 */
	@RequestMapping(value = "/findSupMaterialModelID", method = RequestMethod.GET)
	public @ResponseBody String findSupMaterialModelID(int current, int rowCount,int supMaterialModelID){
		PagingData data = new PagingData(current, rowCount);
		message = StateMessage.from(imaterialModelQueryApp.findSupMaterialModelID(data,supMaterialModelID));
		logger.debug(message.toString());
		return message.toString();
	}
	
	/**
	 * 多条件查询物资型号
	 * @return
	 */
	@RequestMapping(value = "/findMultiCondition", method = RequestMethod.GET)
	public @ResponseBody String findMultiCondition(int current, int rowCount,MaterialModelViewModel materialModelViewModel){
		try {
			if(materialModelViewModel.getMaterialModelName()!=null && !"".equals(materialModelViewModel.getMaterialModelName())){
				materialModelViewModel.setMaterialModelName(new String(materialModelViewModel.getMaterialModelName().getBytes("iso-8859-1"),"utf-8"));
			}else if(materialModelViewModel.getMaterialModelCode()!=null && !"".equals(materialModelViewModel.getMaterialModelCode())){
				materialModelViewModel.setMaterialModelCode(new String(materialModelViewModel.getMaterialModelCode().getBytes("iso-8859-1"),"utf-8"));
			}else if(materialModelViewModel.getProviderName()!=null && !"".equals(materialModelViewModel.getProviderName())){
				materialModelViewModel.setProviderName(new String(materialModelViewModel.getProviderName().getBytes("iso-8859-1"),"utf-8"));
			}
			PagingData data = new PagingData(current, rowCount);
			message = StateMessage.from(imaterialModelQueryApp.findMultiCondition(data, materialModelViewModel));
			logger.debug(message.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return message.toString();
	}
	
	/**
	 * 根据id和类型表链表查询
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findByIdCategory", method = RequestMethod.GET)
	public @ResponseBody String findByIdCategory(Integer id){
		message = StateMessage.from(imaterialModelQueryApp.findByIdCategory(id));
		logger.debug(message.toString());
		return message.toString();
	}
	
	
	
}
