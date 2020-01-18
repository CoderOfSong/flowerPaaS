package com.sdl.common.base.service;/*
package com.sdl.common.base.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * @program flowerPaaS
 * @description: 通用service
 * @author: songdeling
 * @create: 2019/12/25 10:28
 *//*

public abstract class BaseService<T> {

    //private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Resource
    private BaseMapper<T> baseMapper;

    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;

    public PageInfo selectByStatmentPage(String statement, int pageNum, int pageSize) {
        return selectByStatmentPage(statement, null, pageNum, pageSize, null);
    }

    public PageInfo selectByStatmentPage(String statement, int pageNum, int pageSize, String orderBy) {
        return selectByStatmentPage(statement, null, pageNum, pageSize, orderBy);
    }

    public PageInfo selectByStatmentPage(String statement, Object parameter, int pageNum, int pageSize) {
        return selectByStatmentPage(statement, parameter, pageNum, pageSize, null);
    }

    public PageInfo selectByStatmentPage(String statement, Object parameter, int pageNum, int pageSize, String orderBy) {

        if (null == orderBy) {
            PageHelper.startPage(pageNum, pageSize);
        } else {
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }

        List<Object> list;

        if (null == parameter) {
            list = sqlSessionTemplate.selectList(statement);
        } else {
            list = sqlSessionTemplate.selectList(statement, parameter);
        }

        PageInfo pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    public PageInfo<T> selectByExamplePage(Example example, int pageNum, int pageSize) {
        return selectByExamplePage(example, pageNum, pageSize, null);
    }

    public PageInfo<T> selectByExamplePage(Example example, int pageNum, int pageSize, String orderBy) {

        if (null == orderBy) {
            PageHelper.startPage(pageNum, pageSize);
        } else {
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }

        List<T> list = baseMapper.selectByExample(example);
        PageInfo<T> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

    public PageInfo<T> selectAllByPage(int pageNum, int pageSize) {
        return selectAllByPage(pageNum, pageSize, null);
    }

    public PageInfo<T> selectAllByPage(int pageNum, int pageSize, String orderBy) {

        if (null == orderBy) {
            PageHelper.startPage(pageNum, pageSize);
        } else {
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }

        List<T> list = baseMapper.selectAll();
        PageInfo<T> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }

}
*/
