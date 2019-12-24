package com.sdl.common.base.mapper;

import com.sdl.common.entity.Schedule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program flowerPaaS
 * @description: 定时任务mapper
 * @author: songdeling
 * @create: 2019/12/24 11:49
 */
public interface ScheduleMapper {
    @Select("select id, name, cron, app_name appName, class_name className, method, valid from sys_schedule where valid=1 and app_name=#{appName} order by id")
    List<Schedule> getScheduleListByAppName(String appName);
}
