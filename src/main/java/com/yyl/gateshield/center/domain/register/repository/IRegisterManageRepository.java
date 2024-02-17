package com.yyl.gateshield.center.domain.register.repository;

import com.yyl.gateshield.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationSystemVO;

/**
 * 接口注册仓储服务
 */
public interface IRegisterManageRepository {

    void registerApplication(ApplicationSystemVO applicationSystemVO);

    void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO);

    void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO);

}
