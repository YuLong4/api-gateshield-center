package com.yyl.gateshield.center.infrastructure.dao;

import com.yyl.gateshield.center.domain.operation.model.vo.ApplicationInterfaceDataVO;
import com.yyl.gateshield.center.infrastructure.common.OperationRequest;
import com.yyl.gateshield.center.infrastructure.po.ApplicationInterface;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 应用接口
 */
@Mapper
public interface IApplicationInterfaceDao {

    void insert(ApplicationInterface applicationInterface);

    List<ApplicationInterface> queryApplicationInterfaceList(String systemId);

    List<ApplicationInterface> queryApplicationInterfaceListByPage(OperationRequest<ApplicationInterfaceDataVO> request);

    int queryApplicationInterfaceListCountByPage(OperationRequest<ApplicationInterfaceDataVO> request);

}
