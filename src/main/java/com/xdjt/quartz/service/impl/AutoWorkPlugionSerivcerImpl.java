package com.xdjt.quartz.service.impl;


import com.xdjt.quartz.entity.RestEntity;
import com.xdjt.quartz.service.IAutoWorkPluginService;
import com.xdjt.quartz.util.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 定时任务实现类
 */
@Service
public class AutoWorkPlugionSerivcerImpl implements IAutoWorkPluginService {

    @Autowired
    private RestEntity rest;

    /**
     * 打印输出信息
     * @param json
     */
    private String getPrintln(String json){
        StringBuffer pri = new StringBuffer();
        pri.append("请求参数：" + json);
        String sr = RestUtils.doPostJson(rest.getUrl(), json);
        pri.append("返回参数：" + sr +"BOM任务结束时间："+LocalDateTime.now());
        return  pri.toString();
    }

    /**
     * bom后台任务
     * @return
     */
    @Override
    public String BomService() {
        String sr = getPrintln(rest.getBomjson());
       return sr;
    }

    /**
     * wms物料分类服务
     * @return
     */
    @Override
    public String WmsMaterialClassService() {
        String sr = getPrintln(rest.getMaterialclassjson());
        return sr;
    }
    /**
     * wms物料服务
     * @return
     */
    @Override
    public String WmsMaterialService() {
        String sr =getPrintln(rest.getMaterialjson());
        return sr;
    }
    /**
     * wms物料包装服务
     * @return
     */
    @Override
    public String WmsMaterialPackService() {
        String sr =getPrintln(rest.getMaterialpackjson());
        return sr;
    }

    /**
     * wms计量单位服务
     * @return
     */
    @Override
    public String WmsMeasService() {
        String sr =getPrintln(rest.getMeasjson());
        return sr;
    }

    /**
     * wms组织服务
     * @return
     */
    @Override
    public String WmsOrgService() {
        String sr =getPrintln(rest.getOrgjson());
        return sr;
    }

    /**
     * wms人员服务
     * @return
     */
    @Override
    public String WmsPsnService() {
        String sr =getPrintln(rest.getPsnjson());
        return sr;
    }

    /**
     * wms往来单位服务
     * @return
     */
    @Override
    public String WmsExChangUnitService() {
        String sr =getPrintln(rest.getExchangunitjson());
        return sr;
    }

    /**
     * 物料统计口径服务
     * @return
     */
    @Override
    public String WmsCaliberService() {
        String sr =getPrintln(rest.getCaliberjson());
        return sr;
    }
    /**
     * wms发货单服务
     * @return
     */
    @Override
    public String WmsArriveorderService() {
        String sr =getPrintln(rest.getArriveorderjson());
        return sr;
    }
    /**
     * wms到货单服务
     * @return
     */
    @Override
    public String WmsDeliveryService() {
        String sr =getPrintln(rest.getDeliveryjson());
        return sr;
    }
}
