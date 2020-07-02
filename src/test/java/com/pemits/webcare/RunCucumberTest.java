package com.pemits.webcare;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Elvin Shrestha on 7/2/2020
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = {"pretty"})
public class RunCucumberTest {

}
