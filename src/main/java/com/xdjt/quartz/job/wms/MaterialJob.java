package com.xdjt.quartz.job.wms;

import cn.hutool.core.date.DateUtil;
import com.xdjt.quartz.job.base.BaseAutoPluginWork;
import com.xdjt.quartz.job.base.BaseJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 物料job
 */
@Slf4j
public class MaterialJob extends BaseAutoPluginWork implements BaseJob {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        String flag = super.service.WmsMaterialService();
        log.warn("wms物料 Job 执行时间: {}", DateUtil.now()+" "+flag);
    }
}
