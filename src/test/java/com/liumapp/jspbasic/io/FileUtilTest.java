package com.liumapp.jspbasic.io;

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase;

import java.io.File;

/** 
* FileUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>06/27/2017</pre> 
* @version 1.0 
*/ 
public class FileUtilTest extends TestCase {

public FileUtilTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

/** 
* 
* Method: listDirectory(File dir) 
* 
*/ 
public void testListDirectory() throws Exception { 
//TODO: Test goes here...
    FileUtil.listDirectory(new File("./"));
}



public static Test suite() { 
return new TestSuite(FileUtilTest.class); 
}



} 
