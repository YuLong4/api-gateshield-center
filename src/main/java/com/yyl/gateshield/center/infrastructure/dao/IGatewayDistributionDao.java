package com.yyl.gateshield.center.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayDistributionDao {

    List<String> queryGatewayDistributionSystemIdList();

    String queryGatewayDistribution(String systemId);
}
