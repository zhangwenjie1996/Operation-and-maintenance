package ig.zeus.domain.model.resource.server;

import ig.archer.infrastructure.exception.DeleteFailureException;
import ig.archer.infrastructure.exception.SavedFailureException;
import ig.archer.infrastructure.exception.UpdateFailureException;
import ig.zeus.domain.model.resource.Resource;
import ig.zeus.domain.type.ResourceType;

/**
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年8月11日 下午3:05:06
 */
public class Controller extends Resource {
	private Integer moduleid;
	
	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Controller() {
		this.type = ResourceType.Controller;
	}

	@Override
	public void addChidren(Resource child) throws SavedFailureException {
		if (chidren == null) {
			throw new SavedFailureException("该系统下没有操作对象！");
		}
		if (child instanceof Action) {
			try {
				Action action = (Action) child;
//				this.RaiseEvent(new ActionAddEvent(action));
				chidren.add(action);
			} catch (Exception e) {
				throw new SavedFailureException("处理目录元素添加事件失败！");
			}
		} else {
			throw new SavedFailureException("所添加的资源不是操作对象无法添加！");
		}
	}

	@Override
	public void removeChidren(Resource child) throws DeleteFailureException {
		
		if (chidren == null) {
			throw new DeleteFailureException("该系统下没有操作对象！");
		}
		if (child instanceof Action) {
			try {
				Action action = (Action) child;
//				this.RaiseEvent(new ActionDeleteEvent(action));
				chidren.remove(action);
			} catch (Exception e) {
				throw new DeleteFailureException("处理目录元素移除事件失败！");
			}
		} else {
			throw new DeleteFailureException("所移除的资源不是操作对象无法移除！");
		}
	}

	@Override
	public void updateChidren(Resource child) throws UpdateFailureException {
		
		if (chidren == null) {
			throw new UpdateFailureException("该系统下没有操作对象！");
		}
		if (child instanceof Action) {
			try {
				Action action = (Action) child;
//				this.RaiseEvent(new ActionUpdateEvent(action));
				chidren.set(3,action);
			} catch (Exception e) {
				throw new UpdateFailureException("处理目录元素更新事件失败！");
			}
		} else {
			throw new UpdateFailureException("所更新的资源不是操作对象无法更新！");
		}
	}
}
