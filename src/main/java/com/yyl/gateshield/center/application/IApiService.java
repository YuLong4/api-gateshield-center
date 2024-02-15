package com.yyl.gateshield.center.application;

import com.yyl.gateshield.center.domain.model.ApiData;

import java.util.List;

/**
 * API服务
 */
public interface IApiService {

    List<ApiData> queryHttpStatementList();

}
