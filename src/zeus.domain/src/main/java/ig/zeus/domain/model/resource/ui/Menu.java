package ig.zeus.domain.model.resource.ui;

import java.util.List;

import ig.archer.infrastructure.IDisposable;
import ig.archer.infrastructure.exception.DeleteFailureException;
import ig.archer.infrastructure.exception.SavedFailureException;
import ig.archer.infrastructure.exception.UpdateFailureException;
import ig.zeus.domain.model.resource.Resource;

/**
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年8月11日 下午3:39:25
 */
public class Menu extends Resource implements IDisposable {
	/*
	 * Variable
	 */
	private String url;// 菜单 url地址
	private String iconstyle;
	private List<Element> elements;// 菜单元素
	private Integer systemid;
	private Integer parentmenuid;
	/*
	 * Getter&Setter
	 */
	
	
	/**
	 * @return 返回 url 字段的值。
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @return the iconstyle
	 */
	public String getIconstyle() {
		return iconstyle;
	}

	/**
	 * @param iconstyle the iconstyle to set
	 */
	public void setIconstyle(String iconstyle) {
		this.iconstyle = iconstyle;
	}

	public Integer getSystemid() {
		return systemid;
	}

	public void setSystemid(Integer systemid) {
		this.systemid = systemid;
	}

	public Integer getParentmenuid() {
		return parentmenuid;
	}

	public void setParentmenuid(Integer parentmenuid) {
		this.parentmenuid = parentmenuid;
	}

	/**
	 * @param url 设置 url 字段。
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return 返回 elements 字段的值。
	 */
	public List<Element> getElements() {
		return elements;
	}

	/**
	 * @param elements 设置 elements 字段。
	 */
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	/*
	 * Constructor
	 */

	/*
	 * Private Methods
	 */

	/*
	 * Public Methods
	 */

	/**
	 * 添加页面元素。
	 * 
	 * @param menu 页面元素元素。
	 * @throws SavedFailureException 保存失败异常。
	 */
	public void addElement(Element element) throws SavedFailureException {
		if (this.elements == null)
			throw new NullPointerException("菜单元素列表为空，无法添加元素！");
		try {
//			this.RaiseEvent(new ElementAddEvent(element));
			this.elements.add(element);
		} catch (Exception e) {
			throw new SavedFailureException("处理页面元素添加事件失败！");
		}
	}

	/**
	 * 添加子目录。
	 * 
	 * @param child 目录元素。
	 * @throws SavedFailureException 保存失败异常。
	 */
	@Override
	public void addChidren(Resource child) throws SavedFailureException {
		if (this.chidren == null) {
			throw new SavedFailureException("该目录下没有目录对象！");
		}
		if (child instanceof Menu) {
			try {
				Element element= (Element) child;
//				this.RaiseEvent(new ElementAddEvent(element));
				this.chidren.add(element);
			} catch (Exception e) {
				throw new SavedFailureException("处理目录元素添加事件失败！");
			}
		} else {
			throw new SavedFailureException("所添加的子元素不是目录对象无法添加！");
		}
	}

	public void dispose() {
		chidren.clear();
		elements.clear();
	}

	@Override
	public void removeChidren(Resource child) throws DeleteFailureException {
		
		if (this.chidren == null) {
			throw new DeleteFailureException("该目录下没有目录对象！");
		}
		if (child instanceof Menu) {
			try {
				Element element= (Element) child;
//				this.RaiseEvent(new ElementDeleteEvent(element));
				this.chidren.remove(element);
			} catch (Exception e) {
				throw new DeleteFailureException("处理目录元素添加事件失败！");
			}
		} else {
			throw new DeleteFailureException("所添加的子元素不是目录对象无法添加！");
		}
		
	}

	@Override
	public void updateChidren(Resource child) throws UpdateFailureException {
		
		if (this.chidren == null) {
			throw new UpdateFailureException("该目录下没有目录对象！");
		}
		if (child instanceof Menu) {
			try {
				Element element= (Element) child;
//				this.RaiseEvent(new ElementUpdateEvent(element));
				this.chidren.set(2,element);
			} catch (Exception e) {
				throw new UpdateFailureException("处理目录元素添加事件失败！");
			}
		} else {
			throw new UpdateFailureException("所添加的子元素不是目录对象无法添加！");
		}
	}
}
