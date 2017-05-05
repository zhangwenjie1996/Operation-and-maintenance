package ig.zeus.domain.model.resource.ui;

import ig.archer.infrastructure.exception.SavedFailureException;
import ig.zeus.domain.model.resource.Resource;

/**
 * 页面组件。
 *
 */
public class Element extends Resource {

	/**
	 * 组件类型。
	 *
	 */
	private Byte elementType;
	private Integer menuid;
	
	public Integer getMenuid() {
		return menuid;
	}

	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}
	
	/**
	 * @return the elementType
	 */
	public Byte getElementType() {
		return elementType;
	}

	/**
	 * @param elementType the elementType to set
	 */
	public void setElementType(Byte elementType) {
		this.elementType = elementType;
	}

	/**
	 * 添加子组件。
	 * 
	 * @param child
	 *            目录元素。
	 * @throws SavedFailureException
	 *             保存失败异常。
	 */
	@Override
	public void addChidren(Resource child) throws SavedFailureException {
//		if (chidren == null) {
//			throw new SavedFailureException("该目录下没有组件对象！");
//		}
//		if (child instanceof Element) {
//			try {
//				Element element = (Element) child;
//				this.RaiseEvent(new ElementAddEvent(element));
//				chidren.add(element);
//			} catch (Exception e) {
//				throw new SavedFailureException("处理目录元素添加事件失败！");
//			}
//		} else {
//			throw new SavedFailureException("所添加的目录不是组件对象无法添加！");
//		}
	}

	@Override
	public void removeChidren(Resource child) {
		
		
	}

	@Override
	public void updateChidren(Resource child) {
		
		
	}
}
