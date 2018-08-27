package cn.net.chestnut.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  车辆审核状态
 * 2017-11-10 17:23:13
 * @author tarzan
 *
 */
@Getter
@AllArgsConstructor
public enum DriverVehicleStatus {
	WAIT_AUDIT(0,"审核中"),
	PASS(1,"正常"),
	FAIL(2,"审核失败"),
	INVAILD(3,"删除");
	private Integer status;
	private String name;
}
