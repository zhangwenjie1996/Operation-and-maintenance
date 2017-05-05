package ig.zeus.data;

import ig.archer.infrastructure.data.StateData;
import ig.archer.infrastructure.data.type.State;

/**
 * 
 * @author reize
 * @version 0.0.1
 * @since 2016年9月6日 下午3:47:35
 */
public class StateMessage extends JsonSerializable {

	private State state;

	private String message;

	private Object data;
	
	/**
	 * @return 返回 state 字段的值。
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state 设置  state 字段。
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * @return 返回 message 字段的值。
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message 设置  message 字段。
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return 返回 data 字段的值。
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data 设置  data 字段。
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @param state
	 * @param message
	 * @param data
	 */
	public StateMessage(State state, String message, Object data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}

	/**
	 * @param state
	 * @param message
	 */
	public StateMessage(State state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	/**
	 * @param state
	 */
	public StateMessage(State state) {
		super();
		this.state = state;
	}
	
	/**
	 * 根据StateData<?>对象,转换成当前状态消息对象,以实现序列化功能.
	 * 
	 * @param data
	 * @see ig.archer.infrastructure.data.StateData
	 * @return
	 */
	public static StateMessage from(StateData<?> data){
		return new StateMessage(data.getState(), data.getMessage(), data.getData());
	}
	
	/**
	 * @param state
	 */
	public StateMessage() {
		
	}
}
