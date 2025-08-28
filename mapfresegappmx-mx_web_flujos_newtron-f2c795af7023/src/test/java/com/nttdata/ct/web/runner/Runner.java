package com.nttdata.ct.web.runner;

import com.nttdata.ct.web.ddt.CucumberCSVSupport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberCSVSupport.class)
//@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"html:target/cucumber/cucumber-report.html", "json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features",
        glue = {"com.nttdata.ct.web.hooks", "com.nttdata.ct.web.glue"},

        tags = "@Colision_DMP,DED,DJA,LEO,LEO"


)
public class Runner {}