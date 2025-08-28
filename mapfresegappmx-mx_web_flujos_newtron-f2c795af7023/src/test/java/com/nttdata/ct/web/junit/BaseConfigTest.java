package com.nttdata.ct.web.junit;

import com.nttdata.ct.web.config.WebContextConfiguration;
import com.nttdata.ct.web.lib.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {WebContextConfiguration.class})
@SpringBootTest
public class BaseConfigTest {

    @Autowired
    public DriverManager manager;

    @BeforeEach
    public void init(){
        manager.initDriver();
    }

    @AfterEach
    public void tears(){
        manager.quitDriver();
    }

}
