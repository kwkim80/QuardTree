package datastructure.deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * Edge, 1)list empty, 2) list has one element
 * Normal, list has at least 4 elements
 * Error, if any mentioned in the LinkedList documentation, implement it
 * 
 * @author kw244
 *
 */

public class TestDeque {

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
	class OfferFirstMethodTest{
		
		@Test
		void testEdgeInOfferFirstEmpty() {
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
		}
		@Test
		void testEdgeInOfferFirstOne() {
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
			assertTrue(deque.offerFirst(2));
			assertEquals(2, deque.peekFirst());
		}
		@Test
		void testNormalInOfferFirst() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertEquals(i, deque.pollLast());
			}
	
		}
		
	
	}
	
	@Nested
	class OfferLastMethodTest{
		@Test
		void testEdgeInOfferLastEmpty() {
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
		}
		@Test
		void testEdgeInOfferLastOne() {
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
			assertTrue(deque.offerLast(2));
			assertEquals(2, deque.peekLast());
		}
		@Test
		void testNormalInOfferLast() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerLast(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertEquals(i, deque.pollFirst());
			}
		}
	}
	
	@Nested
	class PollFirsttMethodTest{
		@Test
		void testEdgeInPollFirstEmpty() {
			assertNull(deque.pollFirst());
		}
		@Test
		void testEdgeInPollFirstOne() {
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.pollFirst());
		}
		@Test
		void testNormalInPollFirst() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertEquals(i, deque.pollLast());
			}
		}
	}
	
	@Nested
	class pollLasttMethodTest{
		@Test
		void testEdgeInPollLastEmpty() {
			assertNull(deque.pollLast());
		}
		@Test
		void testEdgeInPollLastOne() {
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.pollLast());
		}
		@Test
		void testNormalInPollLast() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertEquals(i, deque.pollLast());
			}
		}
	}
	
	@Nested
	class PeekFirsttMethodTest{
		@Test
		void testEdgeInPeekFirstEmpty() {
			assertNull(deque.peekFirst());
		}
		@Test
		void testEdgeInPeekFirstOne() {
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
		}
		@Test
		void testNormalInPeekFirst() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerLast(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertEquals(i, deque.peekFirst());
				deque.removeFirst();
			}
		}
		
	}
	
	@Nested
	class PeekLasttMethodTest{
		@Test
		void testEdgeInPeekLastEmpty() {
			assertNull(deque.peekLast());
		}
		@Test
		void testEdgeInPeekLastOne() {
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
		}
		@Test
		void testNormalInPeekLast() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertEquals(i, deque.peekLast());
				deque.removeLast();
			}
		}
	}
	
	@Nested
	class RemoveFirstOccurrenceMethodTest{
		@Test
		void testEdgeInRemoveFirstOccurrenceEmpty() {
			assertFalse(deque.removeFirstOccurrence(1));
		}
		@Test
		void testEdgeInRemoveFirstOccurrenceOne() {
			assertTrue(deque.offerFirst(1));
			assertTrue(deque.removeFirstOccurrence(1));
			assertTrue(deque.offerFirst(2));
			assertFalse(deque.removeFirstOccurrence(1));
		}
		@Test
		void testNormalInRemoveFirstOccurrence() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertTrue(deque.removeFirstOccurrence(i));
			}
		}
	}
	
	@Nested
	class RemoveLastOccurrencetMethodTest{
		@Test
		void testEdgeInRemoveLastOccurrenceEmpty() {
			assertFalse(deque.removeLastOccurrence(1));
		}
		@Test
		void testEdgeInRemoveLastOccurrenceOne() {
			assertTrue(deque.isEmpty());
		
			assertTrue(deque.offerLast(1));
			assertTrue(deque.removeLastOccurrence(1));
			assertTrue(deque.offerLast(2));
			assertFalse(deque.removeLastOccurrence(1));
			
		}
		@Test
		void testNormalInRemoveLastOccurrence() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerLast(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertTrue(deque.removeLastOccurrence(i));
			}
		}
	}
	
	@Nested
	class ContainstMethodTest{
		@Test
		void testEdgeInContainsEmpty() {
			assertFalse(deque.contains(1));
		}
		@Test
		void testEdgeInContainsOne() {
			assertTrue(deque.offerFirst(1));
			assertTrue(deque.contains(1));
			assertFalse(deque.contains(2));
		}
		@Test
		void testNormalInContains() {
			for(int i=0;i<5;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<5;i++) {
				assertTrue(deque.contains(i));
			}
		}
	}
	
	@Nested
	class SizetMethodTest{
		@Test
		void testEdgeInSizesEmpty() {
			assertEquals(0, deque.size());
			
		}
		@Test
		void testEdgeInSizesOne() {
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.size());
			assertTrue(deque.offerFirst(1));
			assertEquals(2, deque.size());
		}
		@Test
		void testNormalInSizes() {
			int testSize=5;
			for(int i=0;i<testSize;i++) {
				assertTrue(deque.offerFirst(i));
			}
			
			//poll all of them to check the order
			for(int i=0;i<testSize;i++) {
				assertEquals(testSize-i, deque.size());
				assertEquals(i, deque.pollLast());
			}
			assertEquals(0, deque.size());
		}
	}
	
	@Nested
	class IsEmptytMethodTest{
		@Test
		void testEdgeInEmptyEmpty() {
			assertTrue(deque.isEmpty());
			
		}
		@Test
		void testEdgeInEmptyOne() {
			assertTrue(deque.offerFirst(1));
			assertFalse(deque.isEmpty());
		}
		@Test
		void testNormalInEmpty() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
	
			assertFalse(deque.isEmpty());

	
		}
	}
	
	@Nested
	class IsClearEmptytMethodTest{
		@Test
		void testEdgeInsizesEmpty() {
			deque.clear();
			assertTrue(deque.isEmpty());
		}
		@Test
		void testEdgeInsizesOne() {
			assertTrue(deque.offerFirst(1));
			deque.clear();
			assertTrue(deque.isEmpty());
		}
		@Test
		void testNormalInsizes() {
			int testSize=5;
			for(int i=0;i<testSize;i++) assertTrue(deque.offerFirst(i));
	
			deque.clear();
			assertTrue(deque.isEmpty());

	
		}
	}
	

	
}
