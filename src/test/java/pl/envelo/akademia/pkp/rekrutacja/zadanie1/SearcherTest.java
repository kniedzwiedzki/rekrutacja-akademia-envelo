package pl.envelo.akademia.pkp.rekrutacja.zadanie1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests for  Searcher.
 */
public class SearcherTest {

    Searcher zadanie1 = new Searcher();

    @Test
    public void testNumberFound() {
        String notFoundMessage = "Number not found but should be";
        int[] sortedNumbers = new int[]{16, 14, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        assertTrue(notFoundMessage, zadanie1.search(sortedNumbers, 2));
        assertTrue(notFoundMessage, zadanie1.search(sortedNumbers, 14));
        assertTrue(notFoundMessage, zadanie1.search(new int[]{7}, 7));
    }

    @Test
    public void testNumberNotFound() {
        String foundMessage = "Number found but should not be";
        int[] numeryDoPrzeszukania = new int[]{14, 12, 11, 7, 3};

        assertFalse(foundMessage, zadanie1.search(numeryDoPrzeszukania, 1));
    }
}
