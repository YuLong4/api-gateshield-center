package com.yyl.gateshield.center.infrastructure.dao;

import com.yyl.gateshield.center.infrastructure.po.ApplicationInterface;
import org.apache.ibatis.annotations.Mapper;

/**
 * 应用接口
 */
@Mapper
public interface IApplicationInterfaceDao {

    void insert(ApplicationInterface applicationInterface);

}
