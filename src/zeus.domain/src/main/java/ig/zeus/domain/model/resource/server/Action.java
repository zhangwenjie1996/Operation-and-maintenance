package ig.zeus.domain.model.resource.server;

import ig.archer.infrastructure.exception.SavedFailureException;
import ig.zeus.domain.model.resource.Resource;
import ig.zeus.domain.type.ResourceType;

/**
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年8月11日 下午4:45:16
 */
public class Action extends Resource {
	/*
	 * Variable
	 */
	private Integer controllerid;

	/*
	 * Constructor
	 */
	public Action() {
		this.type = ResourceType.Action;
	}

	/*
	 * Getter&Setter
	 */
	public Integer getControllerid() {
		return controllerid;
	}

	public void setControllerid(Integer controllerid) {
		this.controllerid = controllerid;
	}

	/*
	 * Private Methods
	 */
	@Override
	public void addChidren(Resource child) throws SavedFailureException {

	}

	@Override
	public void removeChidren(Resource child) {
		

	}

	@Override
	public void updateChidren(Resource child) {
		

	}

	/*
	 * Public Methods
	 */
}
