package com.yyl.gateshield.center.domain.service;

import com.yyl.gateshield.center.application.IApiService;
import com.yyl.gateshield.center.domain.model.ApiData;
import com.yyl.gateshield.center.domain.repository.IApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * API服务
 */
@Service
public class ApiServiceImpl implements IApiService {

    @Autowired
    private IApiRepository apiRepository;

    @Override
    public List<ApiData> queryHttpStatementList() {
        return apiRepository.queryHttpStatementList();
    }

}
