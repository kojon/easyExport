package cn.net.chestnut.controller;

import cn.net.chestnut.constants.DriverVehicleStatus;
import cn.net.chestnut.util.ExcelExportTools;
import cn.net.chestnut.vo.VehicleVo;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 导出excel
 *
 * @author tarzan
 */
@Controller
public class ExportController {
    private static Logger logger = LoggerFactory.getLogger(ExportController.class);

    @Value("${export.path}")
    private String path;

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void vehicleList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SXSSFWorkbook wb=null;
        OutputStream os=null;
        try {
            String ctxPath =  path+"export/";
            List<VehicleVo> vehicleList = fillVehicles();
            String fileName = System.currentTimeMillis() + ".xls";
            String filePath=ctxPath + fileName;
            ExcelExportTools excelExportTools = new ExcelExportTools();
            excelExportTools.makeFile(filePath);
            os = response.getOutputStream();
            wb= excelExportTools.exportExcel(vehicleList,VehicleVo.class);
            this.setResponseHeader(response, fileName);
            wb.write(os);
            wb.dispose();
            os.flush();
        } catch (Exception e) {
            logger.error("异常：", e);
        }finally {
            if (wb != null) {
                wb.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private List<VehicleVo> fillVehicles() throws Exception{
        List<VehicleVo> vehicleList = new ArrayList<>();
        VehicleVo vehicleVo=new VehicleVo();
        vehicleVo.setPlateNumber("123456");
        vehicleVo.setVehicleTpye("平板");
        vehicleVo.setVehicleLength(6.8);
        vehicleVo.setTransportLicense("1234567899876543212");
        vehicleVo.setDriverName("kojon");
        vehicleVo.setDriverPhone("13888888888");
        vehicleVo.setRemark(null);
        vehicleVo.setCheckStatus(DriverVehicleStatus.PASS.getStatus());
        vehicleVo.setCreateTime(DateUtils.parseDate("2018-06-29 10:47:09","yyyy-MM-dd hh:mm:ss"));
        vehicleVo.setVehicleDiscernCode("XN7867");
        vehicleVo.setEngineNumber("1111111");
        vehicleVo.setAffiliatedCompanies("小板栗");
        vehicleVo.setGpsName("北斗");
        vehicleList.add(vehicleVo);

        vehicleVo=new VehicleVo();
        vehicleVo.setPlateNumber("654321");
        vehicleVo.setVehicleTpye("四桥单车");
        vehicleVo.setVehicleLength(13.5);
        vehicleVo.setTransportLicense("98767876545678");
        vehicleVo.setDriverName("tarzan");
        vehicleVo.setDriverPhone("15888888888");
        vehicleVo.setRemark("好人一生平安");
        vehicleVo.setCheckStatus(DriverVehicleStatus.WAIT_AUDIT.getStatus());
        vehicleVo.setCreateTime(DateUtils.parseDate("2018-04-17 16:56:59","yyyy-MM-dd hh:mm:ss"));
        vehicleVo.setVehicleDiscernCode("XN1234");
        vehicleVo.setEngineNumber("222222");
        vehicleVo.setAffiliatedCompanies("小板栗");
        vehicleVo.setGpsName("百度");
        vehicleList.add(vehicleVo);
        return vehicleList;
    }
}
