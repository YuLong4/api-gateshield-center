package com.yyl.gateshield.center.interfaces;

import com.yyl.gateshield.center.application.IConfigManageService;
import com.yyl.gateshield.center.application.IMessageService;
import com.yyl.gateshield.center.domain.manage.model.aggregates.ApplicationSystemRichInfo;
import com.yyl.gateshield.center.domain.manage.model.vo.GatewayServerVO;
import com.yyl.gateshield.center.infrastructure.common.ResponseCode;
import com.yyl.gateshield.center.infrastructure.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 网关配置管理；服务分组、网关注册、服务关联
 * 1. 查询网关服务配置项信息：/wg/admin/config/queryServerConfig
 * 2. 注册网关服务节点：/wg/admin/config/registerGateway
 */
@RestController
@RequestMapping("/wg/admin/config")
public class GatewayConfigManage {

    private Logger logger = LoggerFactory.getLogger(GatewayConfigManage.class);

    @Autowired
    private IConfigManageService configManageService;

    @Autowired
    private IMessageService messageService;

    @GetMapping(value = "queryServerConfig", produces = "application/json;charset=utf-8")
    public Result<List<GatewayServerVO>> queryServerConfig(){
        try {
            logger.info("查询网关服务配置项信息");
            List<GatewayServerVO> gatewayServerVOList = configManageService.queryGatewayServerList();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), gatewayServerVOList);
        } catch (Exception e) {
            logger.error("查询网关服务配置项信息异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    /*
    注册网关服务节点
     */
    @PostMapping(value = "registerGateway", produces = "application/json;charset=utf-8")
    public Result<Boolean> registerGatewayServerNode(@RequestParam String groupId, @RequestParam String gatewayId, @RequestParam String gatewayName, @RequestParam String gatewayAddress) {
        try {
            logger.info("注册网关服务节点 gatewayId：{} gatewayName：{} gatewayAddress：{}", gatewayId, gatewayName, gatewayAddress);
            boolean res = configManageService.registerGatewayServerNode(groupId, gatewayId, gatewayName, gatewayAddress);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), res);
        } catch (Exception e) {
            logger.error("注册网关服务节点异常", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), false);
        }
    }

    /**
     * TODO 开发完成续应用注册后，开发这部分
     */
    @PostMapping(value = "distributionGateway")
    public void distributionGatewayServerNode(@RequestParam String groupId, @RequestParam String gatewayId) {

    }

    @PostMapping(value = "queryApplicationSystemRichInfo", produces = "application/json;charset=utf-8")
    public Result<ApplicationSystemRichInfo> queryApplicationSystemRichInfo(@RequestParam String gatewayId, @RequestParam String systemId) {
        try {
            logger.info("查询分配到网关下的待注册系统信息(系统、接口、方法) gatewayId：{}", gatewayId);
            ApplicationSystemRichInfo applicationSystemRichInfo = configManageService.queryApplicationSystemRichInfo(gatewayId, systemId);
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), applicationSystemRichInfo);
        } catch (Exception e) {
            logger.error("查询分配到网关下的待注册系统信息(系统、接口、方法)异常 gatewayId：{}", gatewayId, e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }

    @PostMapping(value = "queryRedisConfig", produces = "application/json;charset=utf-8")
    public Result<Map<String, String>> queryRedisConfig(){
        try {
            logger.info("查询配置中心Reids配置信息");
            Map<String, String> redisConfig = messageService.queryRedisConfig();
            return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getInfo(), redisConfig);
        } catch (Exception e) {
            logger.error("查询配置中心Redis配置信息失败", e);
            return new Result<>(ResponseCode.UN_ERROR.getCode(), e.getMessage(), null);
        }
    }
}
