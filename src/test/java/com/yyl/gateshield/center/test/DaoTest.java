package com.yyl.gateshield.center.test;

import com.yyl.gateshield.center.infrastructure.dao.IApplicationSystemDao;
import com.yyl.gateshield.center.infrastructure.po.ApplicationSystem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {

    @Autowired
    private IApplicationSystemDao applicationSystemDao;

    @Test
    public void test_queryApplicationSystemList(){
        List<String> req = new ArrayList<>();
        List<ApplicationSystem> applicationSystems = applicationSystemDao.queryApplicationSystemList(req);
        for (ApplicationSystem applicationSystem : applicationSystems) {
            System.out.println(applicationSystem.getSystemId());
        }
    }
}
