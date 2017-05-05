package ig.zeus.domain.model.resource.server;

import ig.archer.infrastructure.exception.DeleteFailureException;
import ig.archer.infrastructure.exception.SavedFailureException;
import ig.archer.infrastructure.exception.UpdateFailureException;
import ig.zeus.domain.model.resource.Resource;
import ig.zeus.domain.type.ResourceType;

/**
 * 资源聚合根，模块。
 * 
 * @author reize
 * @version 0.0.1 2016年8月11日 下午4:44:28
 */
public class Module extends Resource {

	public Module() {
		this.type = ResourceType.Module;
	}

	/*
	 * Getter&Setter
	 */

	@Override
	public void addChidren(Resource child) throws SavedFailureException {
		if (chidren == null) {
			throw new SavedFailureException("该系统下没有控制器对象！");
		}
		if (child instanceof Controller) {
			try {
				chidren.add(child);
			} catch (Exception e) {
				throw new SavedFailureException("处理目录元素添加事件失败！");
			}
		} else {
			throw new SavedFailureException("所添加的资源不是控制器对象无法添加！");
		}
	}

	@Override
	public void removeChidren(Resource child) throws DeleteFailureException {
		
		if (chidren == null) {
			throw new DeleteFailureException("该系统下没有控制器对象！");
		}
		if (child instanceof Controller) {
			try {
				chidren.remove(child);
			} catch (Exception e) {
				throw new DeleteFailureException("处理目录元素移除事件失败！");
			}
		} else {
			throw new DeleteFailureException("所移除的资源不是控制器对象无法移除！");
		}
	}

	@Override
	public void updateChidren(Resource child) throws UpdateFailureException {
		
		if (chidren == null) {
			throw new UpdateFailureException("该系统下没有控制器对象！");
		}
		if (child instanceof Controller) {
			try {
				Controller controller = (Controller) child;
//				this.RaiseEvent(new ControllerUpdateEvent(controller));
				chidren.set(2, controller);
			} catch (Exception e) {
				throw new UpdateFailureException("处理目录元素更新事件失败！");
			}
		} else {
			throw new UpdateFailureException("所更新的资源不是控制器对象无法更新！");
		}
	}

}
