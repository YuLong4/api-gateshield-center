package com.yyl.gateshield.center.infrastructure.dao;

import com.yyl.gateshield.center.domain.operation.model.vo.GatewayServerDetaiDatalVO;
import com.yyl.gateshield.center.infrastructure.common.OperationRequest;
import com.yyl.gateshield.center.infrastructure.po.GatewayServerDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGatewayServerDetailDao {

    void insert(GatewayServerDetail gatewayServerDetail);

    GatewayServerDetail queryGatewayServerDetail(GatewayServerDetail gatewayServerDetail);

    boolean updateGatewayStatus(GatewayServerDetail gatewayServerDetail);

    List<GatewayServerDetail> queryGatewayServerDetailList();

    List<GatewayServerDetail> queryGatewayServerDetailListByPage(OperationRequest<GatewayServerDetaiDatalVO> request);

    int queryGatewayServerDetailListCountByPage(OperationRequest<GatewayServerDetaiDatalVO> request);

}
