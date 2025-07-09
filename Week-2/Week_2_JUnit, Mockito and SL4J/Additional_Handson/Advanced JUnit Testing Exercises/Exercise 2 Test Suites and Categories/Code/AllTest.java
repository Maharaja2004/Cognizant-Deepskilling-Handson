package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    SampleTest1.class,
    SampleTest2.class,
    EvenCheckerTest.class // You can add any of your existing test classes here
})
public class AllTest {

}
