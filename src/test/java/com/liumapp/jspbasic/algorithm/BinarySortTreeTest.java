package com.liumapp.jspbasic.algorithm;

import junit.framework.Test; 
import junit.framework.TestSuite; 
import junit.framework.TestCase;

import java.util.Random;

/** 
* BinarySortTree Tester. 
* 
* @author <Authors name> 
* @since <pre>06/28/2017</pre> 
* @version 1.0 
*/ 
public class BinarySortTreeTest extends TestCase { 
public BinarySortTreeTest(String name) { 
super(name); 
} 

public void setUp() throws Exception { 
super.setUp(); 
} 

public void tearDown() throws Exception { 
super.tearDown(); 
} 

public void testMain() throws Exception {
    BinarySortTree tree = new BinarySortTree(50);
    Random rand = new Random();
    for(int i=0;i<20;i++) {
        tree.insert(rand.nextInt(100));
    }
    tree.print();
}

/** 
* 
* Method: find(int target) 
* 
*/ 
public void testFind() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: predecessor() 
* 
*/ 
public void testPredecessor() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: successor() 
* 
*/ 
public void testSuccessor() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insert(int target) 
* 
*/ 
public void testInsert() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete(int target) 
* 
*/ 
public void testDeleteTarget() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: delete() 
* 
*/ 
public void testDelete() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: print() 
* 
*/ 
public void testPrint() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: toString() 
* 
*/ 
public void testToString() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getParent() 
* 
*/ 
public void testGetParent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setParent(BinarySortTree parent) 
* 
*/ 
public void testSetParent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getLeftChild() 
* 
*/ 
public void testGetLeftChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setLeftChild(BinarySortTree leftChild) 
* 
*/ 
public void testSetLeftChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getRightChild() 
* 
*/ 
public void testGetRightChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setRightChild(BinarySortTree rightChild) 
* 
*/ 
public void testSetRightChild() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getValue() 
* 
*/ 
public void testGetValue() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setValue(int value) 
* 
*/ 
public void testSetValue() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: locateNodes() 
* 
*/ 
public void testLocateNodes() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BinarySortTree.getClass().getMethod("locateNodes"); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: printBlank(int length) 
* 
*/ 
public void testPrintBlank() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BinarySortTree.getClass().getMethod("printBlank", int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 


public static Test suite() { 
return new TestSuite(BinarySortTreeTest.class); 
} 
} 
