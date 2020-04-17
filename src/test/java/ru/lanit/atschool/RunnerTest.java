/**
 * Класс для запуска тестов
 * Автор Васильев И.Н. atcc@mail.ru
 * 02.12.2018
 */
package ru.lanit.atschool;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@CucumberOptions(
        features = {"src/test/resources/features"},
        tags = "@MyFirstAutoTest",
        glue = {"ru.lanit.atschool.steps"})

public class RunnerTest extends AbstractTestNGCucumberTests {

    /**
     * Логирование установки параметров
     */
    public static Logger log;

    static {
        Properties.setProperties();
        log = LogManager.getLogger(RunnerTest.class);
        log.info("Настройки установлены");
    }
}
