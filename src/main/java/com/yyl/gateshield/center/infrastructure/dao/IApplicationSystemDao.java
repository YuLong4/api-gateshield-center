package com.yyl.gateshield.center.infrastructure.dao;

import com.yyl.gateshield.center.infrastructure.po.ApplicationSystem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IApplicationSystemDao {

    void insert(ApplicationSystem applicationSystem);

}
