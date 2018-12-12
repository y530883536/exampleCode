package EnumTest;
/**
 * 用户类型枚举  1:APP注册用户  2:后台管理员
 * @author yechangfeng
 *
 */
public enum DeviceStateEnum {

	ONLINE("Online",Byte.valueOf("1")),OFFLINE("Offline",Byte.valueOf("2"));

	private String name;
	private Byte value;

	DeviceStateEnum(String name, Byte value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Byte getValue(){
		return value;
	}
}
