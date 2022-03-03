package com.xdjt.quartz.job.base;

import com.xdjt.quartz.service.IAutoWorkPluginService;

import javax.annotation.Resource;

/**
 * 后台任务父类
 */
public class BaseAutoPluginWork {
    @Resource
    protected IAutoWorkPluginService service;
}
