package com.api.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/main/resources/Features/ExcelData.feature"},
		glue = {"com.api.cucumber.stepdfn"},
		dryRun = false,
		monochrome = true
		)
public class ExcelRunner {

}
