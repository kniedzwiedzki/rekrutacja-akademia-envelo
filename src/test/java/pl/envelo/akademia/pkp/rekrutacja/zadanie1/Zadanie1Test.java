package pl.envelo.akademia.pkp.rekrutacja.zadanie1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testy jednostkowe do Zadanie1.
 */
public class Zadanie1Test {

    Zadanie1 zadanie1 = new Zadanie1();

    @Test
    public void testNumerJestwTablicy() {
        int[] numeryDoPrzeszukania = new int[]{14, 12, 11, 7, 3};
        int szukanyNumer = 7;
        final boolean czyZnaleziono = zadanie1.search(numeryDoPrzeszukania, szukanyNumer);
        assertTrue("Nie odnaleziono podanej liczby", czyZnaleziono);
    }

    @Test
    public void testNumeruNieMawTablicy() {
        int[] numeryDoPrzeszukania = new int[]{14, 12, 11, 7, 3};
        int numerKtoregoNiema = 1;
        final boolean czyZnaleziono = zadanie1.search(numeryDoPrzeszukania, numerKtoregoNiema);
        assertFalse("Odnaleziono podaną liczbę pomimo że nie ma jej w zbiorze", czyZnaleziono);
    }
}
