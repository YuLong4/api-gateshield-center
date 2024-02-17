package com.yyl.gateshield.center.application;

import com.yyl.gateshield.center.domain.manage.model.vo.GatewayServerVO;

import java.util.List;

/**
 * 网关配置服务
 */
public interface IConfigManageService {

    List<GatewayServerVO> queryGatewayServerList();

    boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress);

}
