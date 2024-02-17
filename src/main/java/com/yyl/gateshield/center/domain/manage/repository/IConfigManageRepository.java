package com.yyl.gateshield.center.domain.manage.repository;

import com.yyl.gateshield.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.yyl.gateshield.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

/**
 * 网关配置仓储服务
 */
public interface IConfigManageRepository {

    List<GatewayServerVO> queryGatewayServerList();

    boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress, Integer status);

    GatewayServerDetailVO queryGatewayServerDetail(String gatewayId, String gatewayAddress);

    boolean updateGatewayStatus(String gatewayId, String gatewayAddress, Integer available);

}
