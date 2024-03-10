package com.yyl.gateshield.center.infrastructure.dao;

import com.yyl.gateshield.center.domain.operation.model.vo.GatewayDistributionDataVO;
import com.yyl.gateshield.center.infrastructure.common.OperationRequest;
import com.yyl.gateshield.center.infrastructure.po.GatewayDistribution;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayDistributionDao {

    List<String> queryGatewayDistributionSystemIdList(String gatewayId);

    String queryGatewayDistribution(String systemId);

    List<GatewayDistribution> queryGatewayDistributionList();

    List<GatewayDistribution> queryGatewayDistributionListByPage(OperationRequest<GatewayDistributionDataVO> request);

    int queryGatewayDistributionListCountByPage(OperationRequest<GatewayDistributionDataVO> request);

}
