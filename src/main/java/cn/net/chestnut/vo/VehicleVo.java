package cn.net.chestnut.vo;

import cn.net.chestnut.annotation.ExcelExportField;
import cn.net.chestnut.constants.DriverVehicleStatus;
import lombok.Data;

import java.util.Date;

/**
 * @description: 车辆
 * @Author: tarzan
 * @Date: 2017/10/26 11:02
 **/
@Data
public class VehicleVo {
    @ExcelExportField(name = "车牌号", index = 1)
    private String plateNumber;
    @ExcelExportField(name = "车型", index = 2)
    private String vehicleTpye;
    @ExcelExportField(name = "车长", index = 3)
    private Double vehicleLength;
    @ExcelExportField(name = "道路运输许可证", index = 4,width = 16)
    private String transportLicense;
    @ExcelExportField(name = "司机姓名", index = 5)
    private String driverName;// 行驶证挂副本照片
    @ExcelExportField(name = "手机号", index = 6)
    private String driverPhone;// 行驶证挂副本照片
    @ExcelExportField(name = "备注", index = 7)
    private String remark;
    @ExcelExportField(name = "车辆状态", index = 8,enumClass = DriverVehicleStatus.class,
        enumField ="status",enumShowField = "name")
//    @ExcelExportField(name = "车辆状态", index = 8,valueMap = "{\"0\":\"审核中\",\"1\":\"正常\",\"2\":\"审核失败\"}")
    private Integer checkStatus;
    @ExcelExportField(name = "添加时间", index = 9,width = 18)
    private Date createTime;
    @ExcelExportField(name = "车辆识别代码", index = 10)
    private String vehicleDiscernCode;//车辆识别代码
    @ExcelExportField(name = "发动机号码", index = 11)
    private String engineNumber;//发动机编号
    @ExcelExportField(name = "所属公司", index = 12)
    private String affiliatedCompanies;//挂靠公司
    @ExcelExportField(name = "车辆定位系统", index = 13)
    private String gpsName;//定位系统
}
