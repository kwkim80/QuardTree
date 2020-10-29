package datastructure.deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestIterator {
	private Deque<Integer> deque;
	
	
	@BeforeEach
	void setUp() throws Exception {
		deque = new LinkedList<>();
	      assertNotNull(deque);
	      assertTrue(deque.isEmpty());
	}

	@AfterEach
	void tearDown() throws Exception {
		deque.clear();
		deque = null;
	}
	
	@Nested
	class NextMethodTest{
		@Test
		void testEdgeInNextMethodEmpty() {
			 Iterator<Integer> iterator = deque.iterator();
			assertThrows(NoSuchElementException.class, ()->iterator.next());
			 
			try {
				iterator.next();
				fail();
			} catch (NoSuchElementException e) {
				assertTrue(true);
			}
		}
		@Test
		void testEdgeNextMethodOne() {
			assertTrue(deque.offerFirst(1));
			Iterator<Integer> iterator = deque.iterator();
			assertEquals(1, iterator.next());
			
		}
		@Test
		void testNormalInNextMethod() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
			
			Iterator<Integer> iterator = deque.iterator();
			for(int i=testSize-1;i>=0;i--) assertEquals(i, iterator.next());
			 
		}
	
	}
	
	@Nested
	class RemoveMethodTest{
		@Test
		void testEdgeInRemoveEmpty() {
			 Iterator<Integer> iterator = deque.iterator();
			 assertThrows(IllegalStateException.class, ()->iterator.remove());
			 
			 try {
					iterator.remove();
					fail();
				} catch (IllegalStateException e) {
					assertTrue(true);
				}

		}
		@Test
		void testEdgeInRemoveOne() {
			assertTrue(deque.offerFirst(1));
			 Iterator<Integer> iterator = deque.iterator();
			 if (iterator.next()==1) iterator.remove();
			 assertTrue(deque.isEmpty());
		}
		@Test
		void testNormalInRemove() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
			
			Iterator<Integer> iterator = deque.iterator();
//			 for (Iterator<Integer> iter = deque.iterator(); iter.hasNext();)
			for(int i=testSize-1;i>=0;i--) 
				if(iterator.next()==i)
					iterator.remove();
			assertTrue(deque.isEmpty());
		}
		
		@Test
		void testErrorInRemoveMethod() {
			assertTrue(deque.offerFirst(1));
			assertTrue(deque.offerFirst(2));
			 Iterator<Integer> iterator = deque.iterator();
			 assertThrows(IllegalStateException.class, ()->iterator.remove());
			try {
				iterator.remove();
				fail();
			} catch (IllegalStateException e) {
				assertTrue(true);
			}

		}
	
	
	}
	
	@Nested
	class HasNextMethodTest{
		@Test
		void testEdgeInIteratorEmpty() {
			 Iterator<Integer> iterator = deque.iterator();
			 assertFalse(iterator.hasNext());
		}
		@Test
		void testEdgeInIteratorOne() {
			assertTrue(deque.offerFirst(1));
			
			 Iterator<Integer> iterator = deque.iterator();
			 assertTrue(iterator.hasNext());
		}
		@Test
		void testNormalInIterator() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
			
			Iterator<Integer> iterator = deque.iterator();
			int i=testSize;
			while(iterator.hasNext()) assertEquals(--i, iterator.next());
			 
		}
	
	}
}
