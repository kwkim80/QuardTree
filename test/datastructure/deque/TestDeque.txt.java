package datastructure.deque;

import static org.junit.Assert.assertFalse;
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
 * 
 * @author kw244
 *
 */

public class TestDeque {

	private Deque<Integer> deque;
	
	
	@BeforeEach
	void setUp() throws Exception {
		deque=new LinkedList<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		deque=null;
	}
	
	@Nested
	class OfferFirstMethodTest{
		
		@Test
		void testEdgeInOfferFirstEmpty() {
			assertTrue(deque.isEmpty());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
		}
		@Test
		void testEdgeInOfferFirstOne() {
			assertTrue(deque.isEmpty());
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
			assertTrue(deque.isEmpty());
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
		}
		@Test
		void testEdgeInOfferLastOne() {
			assertTrue(deque.isEmpty());
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
			assertTrue(deque.isEmpty());
			assertNull(deque.pollFirst());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekLast());
		}
		@Test
		void testEdgeInPollFirstOne() {
			assertTrue(deque.isEmpty());
			assertNull(deque.pollFirst());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.pollFirst());
			assertTrue(deque.offerFirst(2));
			assertEquals(2, deque.pollFirst());
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
			assertTrue(deque.isEmpty());
			assertNull(deque.pollLast());
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.pollLast());
		}
		@Test
		void testEdgeInPollLastOne() {
			assertTrue(deque.isEmpty());
			assertNull(deque.pollLast());
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.pollLast());
			assertTrue(deque.offerLast(2));
			assertEquals(2, deque.pollLast());
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
			assertTrue(deque.isEmpty());
			assertNull(deque.peekFirst());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
		}
		@Test
		void testEdgeInPeekFirstOne() {
			assertTrue(deque.isEmpty());
			assertNull(deque.peekFirst());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
			assertTrue(deque.offerFirst(2));
			assertEquals(2, deque.peekFirst());
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
			assertTrue(deque.isEmpty());
			assertNull(deque.peekLast());
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
		}
		@Test
		void testEdgeInPeekLastOne() {
			assertTrue(deque.isEmpty());
			assertNull(deque.peekLast());
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
			assertTrue(deque.offerLast(2));
			assertEquals(2, deque.peekLast());
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
			assertTrue(deque.isEmpty());
			assertFalse(deque.removeFirstOccurrence(1));
			assertTrue(deque.offerFirst(1));
			assertTrue(deque.removeFirstOccurrence(1));
		}
		@Test
		void testEdgeInRemoveFirstOccurrenceOne() {
			assertTrue(deque.isEmpty());
			assertFalse(deque.removeFirstOccurrence(1));
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
			assertTrue(deque.offerFirst(2));
			assertTrue(deque.removeFirstOccurrence(2));
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
			assertTrue(deque.isEmpty());
			assertFalse(deque.removeLastOccurrence(1));
			assertTrue(deque.offerLast(1));
			assertTrue(deque.removeLastOccurrence(1));
		}
		@Test
		void testEdgeInRemoveLastOccurrenceOne() {
			assertTrue(deque.isEmpty());
			assertFalse(deque.removeLastOccurrence(1));
			assertTrue(deque.offerLast(1));
			assertEquals(1, deque.peekLast());
			assertTrue(deque.offerLast(2));
			assertTrue(deque.removeLastOccurrence(2));
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
			assertTrue(deque.isEmpty());
			assertFalse(deque.contains(1));
			assertTrue(deque.offerFirst(1));
			assertTrue(deque.contains(1));
		}
		@Test
		void testEdgeInContainsOne() {
			assertTrue(deque.isEmpty());
			assertFalse(deque.contains(1));
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.peekFirst());
			assertTrue(deque.offerFirst(2));
			assertTrue(deque.contains(2));
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
		void testEdgeInsizesEmpty() {
			assertTrue(deque.isEmpty());
			assertEquals(0, deque.size());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.size());
		}
		@Test
		void testEdgeInsizesOne() {
			assertTrue(deque.isEmpty());
			assertEquals(0, deque.size());
			assertTrue(deque.offerFirst(1));
			assertEquals(1, deque.size());
			assertTrue(deque.offerFirst(1));
			assertEquals(2, deque.size());
		}
		@Test
		void testNormalInsizes() {
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
		void testEdgeInsizesEmpty() {
			assertTrue(deque.isEmpty());
			assertTrue(deque.offerFirst(1));
			assertFalse(deque.isEmpty());
			assertEquals(1, deque.pollLast());
			assertTrue(deque.isEmpty());
		}
		@Test
		void testEdgeInsizesOne() {
			assertTrue(deque.isEmpty());
			assertTrue(deque.offerFirst(1));
			assertFalse(deque.isEmpty());
			assertTrue(deque.offerFirst(2));
			assertFalse(deque.isEmpty());
		}
		@Test
		void testNormalInsizes() {
			int testSize=5;
			for(int i=0;i<testSize;i++) {
				assertTrue(deque.offerFirst(i));
				assertFalse(deque.isEmpty());
			}
			
			//poll all of them to check the order
			for(int i=0;i<testSize;i++) {
				assertFalse(deque.isEmpty());
				assertEquals(i, deque.pollLast());
			}
			
			assertTrue(deque.isEmpty());
		}
	}

	
}
