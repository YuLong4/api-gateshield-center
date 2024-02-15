package com.yyl.gateshield.center.interfaces;

import com.yyl.gateshield.center.application.IApiService;
import com.yyl.gateshield.center.domain.model.ApiData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 网关接口服务
 */
@RestController
@RequestMapping("/api")
public class ApiGatewayController {

    private Logger logger = LoggerFactory.getLogger(ApiGatewayController.class);

    @Autowired
    private IApiService apiService;

    @RequestMapping(value = "list", produces = "application/json;charset=utf-8")
    public List<ApiData> getAnswerMap(){
        return apiService.queryHttpStatementList();
    }

}
