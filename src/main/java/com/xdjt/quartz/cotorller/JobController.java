package com.xdjt.quartz.cotorller;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.xdjt.quartz.common.ApiResponse;
import com.xdjt.quartz.entity.JobAndTrigger;
import com.xdjt.quartz.entity.JobForm;
import com.xdjt.quartz.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * Job Controller
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-26 13:23
 */
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {
    @Resource
    private JobService jobService;

    /**
     * 保存定时任务
     */
    @PostMapping
    public ResponseEntity<ApiResponse> addJob(@Valid JobForm form) {
        try {
            jobService.addJob(form);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.msg(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(ApiResponse.msg("操作成功"), HttpStatus.CREATED);
    }

    /**
     * 删除定时任务
     */
    @DeleteMapping
    public ResponseEntity<ApiResponse> deleteJob(JobForm form) throws SchedulerException {
        if (StrUtil.hasBlank(form.getJobGroupName(), form.getJobClassName())) {
            return new ResponseEntity<>(ApiResponse.msg("参数不能为空"), HttpStatus.BAD_REQUEST);
        }

        jobService.deleteJob(form);
        return new ResponseEntity<>(ApiResponse.msg("删除成功"), HttpStatus.OK);
    }

    /**
     * 暂停定时任务
     */
    @PutMapping(params = "pause")
    public ResponseEntity<ApiResponse> pauseJob(JobForm form) throws SchedulerException {
        if (StrUtil.hasBlank(form.getJobGroupName(), form.getJobClassName())) {
            return new ResponseEntity<>(ApiResponse.msg("参数不能为空"), HttpStatus.BAD_REQUEST);
        }

        jobService.pauseJob(form);
        return new ResponseEntity<>(ApiResponse.msg("暂停成功"), HttpStatus.OK);
    }

    /**
     * 恢复定时任务
     */
    @PutMapping(params = "resume")
    public ResponseEntity<ApiResponse> resumeJob(JobForm form) throws SchedulerException {
        if (StrUtil.hasBlank(form.getJobGroupName(), form.getJobClassName())) {
            return new ResponseEntity<>(ApiResponse.msg("参数不能为空"), HttpStatus.BAD_REQUEST);
        }

        jobService.resumeJob(form);
        return new ResponseEntity<>(ApiResponse.msg("恢复成功"), HttpStatus.OK);
    }

    /**
     * 修改定时任务，定时时间
     */
    @PutMapping(params = "cron")
    public ResponseEntity<ApiResponse> cronJob(@Valid JobForm form) {
        try {
            jobService.cronJob(form);
        } catch (Exception e) {
            return new ResponseEntity<>(ApiResponse.msg(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(ApiResponse.msg("修改成功"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse> jobList(Integer currentPage, Integer pageSize) {
        if (ObjectUtil.isNull(currentPage)) {
            currentPage = 1;
        }
        if (ObjectUtil.isNull(pageSize)) {
            pageSize = 10;
        }
        PageInfo<JobAndTrigger> all = jobService.list(currentPage, pageSize);
        return ResponseEntity.ok(ApiResponse.ok(Dict.create().set("total", all.getTotal()).set("data", all.getList())));
    }

}