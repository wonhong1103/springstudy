package com.ict.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// JUnitTest를 한번에 하기
@RunWith(Suite.class)
@SuiteClasses({Ex02_Test.class, Ex02_Test2.class, Ex03_Test.class})
public class AllTests {

}
