package ig.zeus.domain.model.resource;

import java.util.List;

import ig.archer.domain.object.identity.Entity;
import ig.archer.infrastructure.exception.DeleteFailureException;
import ig.archer.infrastructure.exception.SavedFailureException;
import ig.archer.infrastructure.exception.UpdateFailureException;
import ig.zeus.domain.type.ResourceType;

/**
 * 实体，继承本类表示对象为权限系统中的资源。
 * 
 * @author reize
 *
 * @param <TChildren> 子元素的类型。
 */
public abstract class Resource extends Entity {

	/*
	 * PrivateVariable
	 */
	protected String name;
	protected String signature;
	protected int index;
	protected ResourceType type;
	protected String description;
	protected List<Resource> chidren;


	/*
	 * Getter&Setter
	 */

	/**
	 * 获取资源名称。
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置资源名称。
	 * 
	 * @return
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 返回 signature 字段的值。
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature 设置 signature 字段。
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	/**
	 * @return 返回 type 字段的值。
	 */
	public ResourceType getType() {
		return type;
	}

	/**
	 * 获取资源序号。
	 * 
	 * @return this index
	 * 
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * 设置资源序号。
	 * 
	 * @param index 资源序号
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * 获取资源描述。
	 * 
	 * @return this description 资源描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 设置资源描述。
	 * 
	 * @param description 资源描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 返回 chidren 字段的值。
	 */
	public List<Resource> getChidren() {
		return chidren;
	}

	/**
	 * @param chidren 设置 chidren 字段。
	 */
	public void setChidren(List<Resource> chidren) {
		this.chidren = chidren;
	}

	/*
	 * Public Methods
	 */
	
	/**
	 * 添加子元素。
	 * @param child 子元素。
	 * @throws Exception 抛出异常信息。
	 */
	public abstract void addChidren(Resource child) throws SavedFailureException;
	/**
	 * 移出子元素
	 * @param child
	 * @throws DeleteFailureException
	 */
	public abstract void removeChidren(Resource child) throws DeleteFailureException;
	/**
	 * 更新子元素
	 * @param child
	 * @throws UpdateFailureException
	 */
	public abstract void updateChidren(Resource child) throws UpdateFailureException;
	
	/**
	 * 返回资源的签名（Signature）字段。
	 */
	@Override
	public String toString() {
		return this.getSignature();
	}
	
	
	static{
		
	
	}
}
