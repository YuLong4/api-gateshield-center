package com.yyl.gateshield.center.infrastructure.dao;

import com.yyl.gateshield.center.infrastructure.po.HttpStatement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 网关接口映射信息表DAO
 */
@Mapper
public interface IHttpStatementDao {

    List<HttpStatement> queryHttpStatementList();

}
