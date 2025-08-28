package com.nttdata.ct.web.hooks;
import com.nttdata.ct.web.util.CucumberHook;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;


@CucumberContextConfiguration
public class Hooks extends CucumberHook {

    /**
     * Inicia el driver ANTES de cada escenario
     */
    @Before(order = 0)
    public void initDriver() {
        manager.initDriver();
    }

    /**
     * Establece el escenario actual ANTES de ser ejecutado
     * @param scenario Representa al escenario que se esta ejecutando en el momento
     */
    @Before(order = 1)
    public void setUp(Scenario scenario) {
        manageScenario.setScenario(scenario);
    }

    /**
     * Cierra el Driver DESPUES de cada escenario
     */
    @After
    public void tearsDown() {
        manager.quitDriver();
    }

}