package com.xdjt.quartz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // 注册为组件
@EnableConfigurationProperties // 启用配置自动注入功能
@ConfigurationProperties(prefix = "xemc.rest") // 指定类对应的配置项前缀
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestEntity {
    private String url;
    private String bomjson;
    private String materialclassjson;
    private String materialjson;
    private String materialpackjson;
    private String measjson;
    private String orgjson;
    private String psnjson;
    private String exchangunitjson;
    private String caliberjson;
    private String arriveorderjson;
    private String deliveryjson;
    private String beginmateialjson;
    private String WMSMaterialFramejson;
}
