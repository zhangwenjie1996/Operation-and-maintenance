package ig.zeus.data;

import com.google.gson.Gson;

import ig.archer.infrastructure.data.PagingData;
import ig.archer.infrastructure.data.serializable.IJsonSerializable;

/**
 * 可序列化的分页数据.</br>
 * 由服务传来的分页数据并没有序列化成json的功能,需要转换成本对象.
 * 
 * @author zjl
 * @version 0.0.1 2016年10月12日 上午9:50:32
 */
public class PagingDataSerializer extends PagingData implements IJsonSerializable {

	public PagingDataSerializer() {
		super();
	}

	public PagingDataSerializer(int current, int total, int rowCount, Object rows) {
		super(current, total, rowCount, rows);
	}

	public PagingDataSerializer(int current, int rowCount) {
		super(current, rowCount);
	}

	/**
	 * 根据父类对象,转换成当前分页数据对象,以实现序列化功能.
	 * 
	 * @param pagingData
	 * @return
	 */
	public static PagingDataSerializer from(PagingData pagingData) {
		return new PagingDataSerializer(pagingData.getCurrent(), pagingData.getTotal(), pagingData.getRowCount(),
				pagingData.getRows());
	}

	@Override
	public String toString() {

		return this.serialize();
	}

	@Override
	public String serialize() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
