package ig.zeus.domain.model.resource;

import java.util.List;

import ig.archer.domain.object.IAggregateRoot;
import ig.archer.infrastructure.exception.DeleteFailureException;
import ig.archer.infrastructure.exception.SavedFailureException;
import ig.archer.infrastructure.exception.UpdateFailureException;
import ig.zeus.domain.model.resource.server.Module;
import ig.zeus.domain.model.resource.ui.Menu;

/**
 * 聚合根
 * @author reize
 * @version 0.0.1
 * @since 2016年8月16日 上午9:42:18
 */
public class System extends Resource implements IAggregateRoot<Integer>{
	/*
	 * Variable
	 */
	private String url;
	List<Menu> menus;//children是controller,menus是菜单

	/*
	 * Getter&Setter
	 */

	/*
	 * Constructor
	 */

	/*
	 * Private Methods
	 */

	/*
	 * Public Methods
	 */

	@Override
	public void addChidren(Resource child) throws SavedFailureException {
		if (chidren == null) {
			throw new SavedFailureException("该系统下没有控制器对象！");
		}
		if (child instanceof Module) {
			try {
				Module module = (Module) child;
//				this.RaiseEvent(new ModuleAddEvent(module));
				chidren.add(module);
			} catch (Exception e) {
				throw new SavedFailureException("处理目录元素添加事件失败！");
			}
		} else {
			throw new SavedFailureException("所添加的资源不是控制器对象无法添加！");
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 添加子目录。
	 * 
	 * @param menu 目录元素。
	 * @throws SavedFailureException 保存失败异常。
	 */
	public void addMenu(Menu menu) throws SavedFailureException {
		if (menus == null) {
			throw new SavedFailureException("该目录下没有目录对象！");
		}
		if (menu instanceof Menu) {
			try {
//				this.RaiseEvent(new MenuAddEvent(menu));
				this.menus.add(menu);
			} catch (Exception e) {  
				throw new SavedFailureException("处理目录元素更新事件失败！");
			}
		} else {
			throw new SavedFailureException("所更新的子元素不是目录对象无法更新 ！");
		}
	}
	public void deleteMenu(Menu menu) throws DeleteFailureException {
		if (menus == null) {
			throw new DeleteFailureException("该目录下没有目录对象！");
		}
		if (menu instanceof Menu) {
			try {
//				this.RaiseEvent(new MenuDeleteEvent(menu));
				this.menus.remove(menu);
			} catch (Exception e) {
				throw new DeleteFailureException("处理目录元素更新事件失败！");
			}
		} else {
			throw new DeleteFailureException("所更新的子元素不是目录对象无法更新 ！");
		}
	}
	public void updateMenu(Menu menu) throws UpdateFailureException {
		if (menus == null) {
			throw new UpdateFailureException("该目录下没有目录对象！");
		}
		if (menu instanceof Menu) {
			try {
//				this.RaiseEvent(new MenuUpdateEvent(menu));
				this.menus.set(0,menu);
			} catch (Exception e) {
				throw new UpdateFailureException("处理目录元素更新事件失败！");
			}
		} else {
			throw new UpdateFailureException("所更新的子元素不是目录对象无法更新 ！");
		}
	}
	@Override
	public void removeChidren(Resource child) throws DeleteFailureException {
		
		if(child==null){
			throw new DeleteFailureException("该目录下没有模块对象！");
		}
		if (child instanceof Module) {
			try {
				Module module = (Module) child;
//				this.RaiseEvent(new ModuleDeleteEvent(module));
				chidren.remove(module);
			} catch (Exception e) {
				throw new DeleteFailureException("处理目录元素移除事件失败！");
			}
		} else {
			throw new DeleteFailureException("所移除的资源不是模块对象无法移除！");
		}
	}

	@Override
	public void updateChidren(Resource child) throws UpdateFailureException {
		
		if(child==null){
			throw new UpdateFailureException("该目录下没有模块对象！");
		}
		if (child instanceof Module) {
			try {
				Module module = (Module) child;
//				this.RaiseEvent(new ModuleUpdateEvent(module));
				chidren.set(1, module);
			} catch (Exception e) {
				throw new UpdateFailureException("处理目录元素移除事件失败！");
			}
		} else {
			throw new UpdateFailureException("所移除的资源不是模块对象无法移除！");
		}
	}

	public void dispose() {
		
		
	}
}
