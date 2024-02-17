package com.yyl.gateshield.center.domain.register.service;

import com.yyl.gateshield.center.application.IRegisterManageService;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationInterfaceMethodVO;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationInterfaceVO;
import com.yyl.gateshield.center.domain.register.model.vo.ApplicationSystemVO;
import com.yyl.gateshield.center.domain.register.repository.IRegisterManageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterManageServiceImpl implements IRegisterManageService {

    @Autowired
    private IRegisterManageRepository registerManageRepository;

    @Override
    public void registerApplication(ApplicationSystemVO applicationSystemVO) {
        registerManageRepository.registerApplication(applicationSystemVO);
    }

    @Override
    public void registerApplicationInterface(ApplicationInterfaceVO applicationInterfaceVO) {
        registerManageRepository.registerApplicationInterface(applicationInterfaceVO);
    }

    @Override
    public void registerApplicationInterfaceMethod(ApplicationInterfaceMethodVO applicationInterfaceMethodVO) {
        registerManageRepository.registerApplicationInterfaceMethod(applicationInterfaceMethodVO);
    }
}
