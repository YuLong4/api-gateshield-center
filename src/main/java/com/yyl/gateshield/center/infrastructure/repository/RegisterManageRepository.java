package com.yyl.gateshield.center.infrastructure.repository;

import com.yyl.gateshield.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationSystemVO;
import com.yyl.gateshield.center.domain.register.repository.IRegisterManageRepository;
import com.yyl.gateshield.center.infrastructure.dao.IApplicationInterfaceDao;
import com.yyl.gateshield.center.infrastructure.dao.IApplicationInterfaceMethodDao;
import com.yyl.gateshield.center.infrastructure.dao.IApplicationSystemDao;
import com.yyl.gateshield.center.infrastructure.po.ApplicationInterface;
import com.yyl.gateshield.center.infrastructure.po.ApplicationInterfaceMethod;
import com.yyl.gateshield.center.infrastructure.po.ApplicationSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 接口注册仓储服务
 */
@Component
public class RegisterManageRepository implements IRegisterManageRepository {

    @Autowired
    private IApplicationInterfaceDao applicationInterfaceDao;

    @Autowired
    private IApplicationInterfaceMethodDao applicationInterfaceMethodDao;

    @Autowired
    private IApplicationSystemDao applicationSystemDao;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        ApplicationSystem applicationSystem = new ApplicationSystem();
        applicationSystem.setSystemId(applicationSystemVO.getSystemId());
        applicationSystem.setSystemName(applicationSystemVO.getSystemName());
        applicationSystem.setSystemType(applicationSystemVO.getSystemType());
        applicationSystem.setSystemRegistry(applicationSystemVO.getSystemRegistry());
        applicationSystemDao.insert(applicationSystem);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        ApplicationInterface applicationInterface = new ApplicationInterface();
        applicationInterface.setSystemId(applicationInterfaceVO.getSystemId());
        applicationInterface.setInterfaceId(applicationInterfaceVO.getInterfaceId());
        applicationInterface.setInterfaceName(applicationInterfaceVO.getInterfaceName());
        applicationInterface.setInterfaceVersion(applicationInterfaceVO.getInterfaceVersion());
        applicationInterfaceDao.insert(applicationInterface);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        ApplicationInterfaceMethod applicationInterfaceMethod = new ApplicationInterfaceMethod();
        applicationInterfaceMethod.setSystemId(applicationInterfaceMethodVO.getSystemId());
        applicationInterfaceMethod.setInterfaceId(applicationInterfaceMethodVO.getInterfaceId());
        applicationInterfaceMethod.setMethodId(applicationInterfaceMethodVO.getMethodId());
        applicationInterfaceMethod.setMethodName(applicationInterfaceMethodVO.getMethodName());
        applicationInterfaceMethod.setParameterType(applicationInterfaceMethodVO.getParameterType());
        applicationInterfaceMethod.setUri(applicationInterfaceMethodVO.getUri());
        applicationInterfaceMethod.setHttpCommandType(applicationInterfaceMethodVO.getHttpCommandType());
        applicationInterfaceMethod.setAuth(applicationInterfaceMethodVO.getAuth());
        applicationInterfaceMethodDao.insert(applicationInterfaceMethod);
    }
}
