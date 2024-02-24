package com.yyl.gateshield.center.domain.manage.service;

import com.alibaba.fastjson.JSON;
import com.yyl.gateshield.center.application.IConfigManageService;
import com.yyl.gateshield.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import com.yyl.gateshield.center.domain.manage.model.vo.*;
import com.yyl.gateshield.center.domain.manage.repository.IConfigManageRepository;
import com.yyl.gateshield.center.infrastructure.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 网关配置服务
 */
@Service
public class ConfigManageServiceImpl implements IConfigManageService {

    private Logger logger = LoggerFactory.getLogger(ConfigManageServiceImpl.class);

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

    @Override
    public ApplicationSystemRichInfo queryApplicationSystemRichInfo(String gatewayId, String systemId) {
        // 1. 查询出网关ID对应的关联系统ID集合。也就是一个网关ID会被分配一些系统RPC服务注册进来，需要把这些服务查询出来。
        List<String> systemIdList = new ArrayList<>();
        logger.info("systemId: " + systemId);
        if(systemId == null || systemId.equals("")) {
            //没指定systemId就去查数据库
            logger.info("没指定systemId就去查数据库");
            systemIdList = configManageRepository.queryGatewayDistributionSystemIdList(gatewayId);
        } else {
            //指定了systemId就直接添加
            logger.info("指定了systemId就直接添加");
            systemIdList.add(systemId);
        }
        logger.info("systemIdList: " + JSON.toJSONString(systemIdList));
        // 2. 查询系统ID对应的系统列表信息
        List<ApplicationSystemVO> applicationSystemVOList = configManageRepository.queryApplicationSystemList(systemIdList);
        // 3. 查询系统下的接口信息
        for (ApplicationSystemVO applicationSystemVO : applicationSystemVOList) {
            List<ApplicationInterfaceVO> applicationInterfaceVOList = configManageRepository.queryApplicationInterfaceList(applicationSystemVO.getSystemId());
            for(ApplicationInterfaceVO applicationInterfaceVO : applicationInterfaceVOList) {
                List<ApplicationInterfaceMethodVO> applicationInterfaceMethodVOList = configManageRepository.queryApplicationInterfaceMethodList(applicationSystemVO.getSystemId(), applicationInterfaceVO.getInterfaceId());
                applicationInterfaceVO.setMethodList(applicationInterfaceMethodVOList);
            }
            applicationSystemVO.setInterfaceList(applicationInterfaceVOList);
        }
        return new ApplicationSystemRichInfo(gatewayId, applicationSystemVOList);
    }

    @Override
    public String queryGatewayDistribution(String systemId) {
        return configManageRepository.queryGatewayDistribution(systemId);
    }
}
