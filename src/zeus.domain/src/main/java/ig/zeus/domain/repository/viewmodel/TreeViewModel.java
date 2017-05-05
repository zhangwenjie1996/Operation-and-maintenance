package ig.zeus.domain.repository.viewmodel;

import java.util.ArrayList;
import java.util.List;

//首页加载树使用
public class TreeViewModel {
	private String id;
	private String parent;
	private String text;
	private List<TreeViewModel> children = new ArrayList<>();
	private String URL;
	private String iconStyle;
	private String key;
	private  String title;

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	/**
	 * @return the iconStyle
	 */
	public String getIconStyle() {
		return iconStyle;
	}

	/**
	 * @param iconStyle the iconStyle to set
	 */
	public void setIconStyle(String iconStyle) {
		this.iconStyle = iconStyle;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL
	 *            the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the children
	 */
	public List<TreeViewModel> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<TreeViewModel> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public TreeViewModel() {

	}
}
