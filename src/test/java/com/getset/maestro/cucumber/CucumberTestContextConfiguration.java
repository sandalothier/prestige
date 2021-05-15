package com.getset.maestro.cucumber;

import com.getset.maestro.MaestroApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = MaestroApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
