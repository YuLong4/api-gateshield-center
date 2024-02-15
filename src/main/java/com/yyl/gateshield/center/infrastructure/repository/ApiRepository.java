package com.yyl.gateshield.center.infrastructure.repository;

import com.yyl.gateshield.center.domain.model.ApiData;
import com.yyl.gateshield.center.domain.repository.IApiRepository;
import com.yyl.gateshield.center.infrastructure.dao.IHttpStatementDao;
import com.yyl.gateshield.center.infrastructure.po.HttpStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApiRepository implements IApiRepository {

    @Autowired
    private IHttpStatementDao httpStatementDao;

    @Override
    public List<ApiData> queryHttpStatementList() {
        List<HttpStatement> httpStatements = httpStatementDao.queryHttpStatementList();
        List<ApiData> apiDataList = new ArrayList<>();
        for(HttpStatement httpStatement : httpStatements){
            ApiData apiData = new ApiData();
            apiData.setApplication(httpStatement.getApplication());
            apiData.setInterfaceName(httpStatement.getInterfaceName());
            apiData.setMethodName(httpStatement.getMethodName());
            apiData.setParameterType(httpStatement.getParameterType());
            apiData.setUri(httpStatement.getUri());
            apiData.setHttpCommandType(httpStatement.getHttpCommandType());
            apiData.setAuth(httpStatement.getAuth());
            apiDataList.add(apiData);
        }
        return apiDataList;
    }

}
