package ig.zeus.data;

import com.google.gson.Gson;

import ig.archer.infrastructure.data.serializable.IJsonSerializable;

public class JsonSerializable implements IJsonSerializable {

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
