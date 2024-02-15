package com.yyl.gateshield.center.domain.repository;

import com.yyl.gateshield.center.domain.model.ApiData;

import java.util.List;

/**
 * APi仓储
 */
public interface IApiRepository {

    List<ApiData> queryHttpStatementList();

}
