package datastructure.deque;


import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
@SelectClasses( { TestDeque.class, TestIterator.class } )
@SelectPackages("datastructure.deque")
public class AllTests {

}
