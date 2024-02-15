package com.yyl.gateshield.center.test;

import com.yyl.gateshield.center.infrastructure.dao.IHttpStatementDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {

    @Autowired
    private IHttpStatementDao httpStatementDao;

    @Test
    public void test_dao(){
        System.out.println(httpStatementDao.queryHttpStatementList());
    }
}
