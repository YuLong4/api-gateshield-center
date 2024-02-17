package com.yyl.gateshield.center.domain.manage.service;

import com.yyl.gateshield.center.application.IConfigManageService;
import com.yyl.gateshield.center.domain.manage.model.vo.GatewayServerDetailVO;
import com.yyl.gateshield.center.domain.manage.model.vo.GatewayServerVO;
import com.yyl.gateshield.center.domain.manage.repository.IConfigManageRepository;
import com.yyl.gateshield.center.infrastructure.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网关配置服务
 */
@Service
public class ConfigManageServiceImpl implements IConfigManageService {

    @Autowired
    private IConfigManageRepository configManageRepository;

    @Override
    public List<GatewayServerVO> queryGatewayServerList() {
        return configManageRepository.queryGatewayServerList();
    }

    @Override
    public boolean registerGatewayServerNode(String groupId, String gatewayId, String gatewayName, String gatewayAddress) {
        //查询节点是否已存在
        GatewayServerDetailVO gatewayServerDetailVO = configManageRepository.queryGatewayServerDetail(gatewayId, gatewayAddress);
        if (gatewayServerDetailVO == null){
            try {
                return configManageRepository.registerGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress, Constants.GatewayStatus.Available);
            } catch (DuplicateKeyException e){
                return configManageRepository.updateGatewayStatus(gatewayId, gatewayAddress, Constants.GatewayStatus.Available);
            }
        }
        return configManageRepository.updateGatewayStatus(gatewayId, gatewayAddress, Constants.GatewayStatus.Available);
    }
}
