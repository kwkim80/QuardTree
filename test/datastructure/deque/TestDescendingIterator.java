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

public class TestDescendingIterator {
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
			 Iterator<Integer> deiterator = deque.descendingIterator();
			assertThrows(NoSuchElementException.class, ()->deiterator.next());
			
			try {
				deiterator.next();
				fail();
			} catch (NoSuchElementException e) {
				assertTrue(true);
			}
			 
		}
		@Test
		void testEdgeNextMethodOne() {
			assertTrue(deque.offerFirst(1));
			Iterator<Integer> deiterator = deque.descendingIterator();
			assertEquals(1, deiterator.next());
			
		}
		@Test
		void testNormalInNextMethod() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
			
			Iterator<Integer> deiterator = deque.descendingIterator();
			for(int i=0;i<testSize;i++) assertEquals(i, deiterator.next());
			 
		}
		
	
	
	}
	
	@Nested
	class RemoveMethodTest{
		@Test
		void testEdgeInRemoveEmpty() {
			 Iterator<Integer> deiterator = deque.descendingIterator();
			 assertThrows(IllegalStateException.class, ()->deiterator.remove());

			 try {
					deiterator.remove();
					fail();
				} catch (IllegalStateException e) {
					assertTrue(true);
				}
		}
		@Test
		void testEdgeInRemoveOne() {
			assertTrue(deque.offerFirst(1));
			 Iterator<Integer> deiterator = deque.descendingIterator();
			 if (deiterator.next()==1) deiterator.remove();
			 assertTrue(deque.isEmpty());
		}
		@Test
		void testNormalInRemove() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
			
			Iterator<Integer> deiterator = deque.descendingIterator();
			for(int i=0;i<testSize;i++)
				if(deiterator.next()==i)
					deiterator.remove();
			assertTrue(deque.isEmpty());
		}
		
		@Test
		void testErrorInRemoveMethod() {
			assertTrue(deque.offerFirst(1));
			assertTrue(deque.offerFirst(2));
			 Iterator<Integer> deiterator = deque.descendingIterator();
			 assertThrows(IllegalStateException.class, ()->deiterator.remove());
			try {
				deiterator.remove();
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
			 Iterator<Integer> deiterator = deque.iterator();
			 assertFalse(deiterator.hasNext());
		}
		@Test
		void testEdgeInIteratorOne() {
			assertTrue(deque.offerFirst(1));
			
			 Iterator<Integer> deiterator = deque.iterator();
			 assertTrue(deiterator.hasNext());
		}
		@Test
		void testNormalInIterator() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
			
			Iterator<Integer> deiterator = deque.iterator();
			int i=testSize;
			while(deiterator.hasNext()) assertEquals(--i, deiterator.next());
			 
		}
	
	}
}
