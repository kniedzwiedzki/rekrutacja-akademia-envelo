package pl.envelo.akademia.pkp.rekrutacja;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Testy jednostkowe do Zadanie2.
 */
public class Zadanie2Test {

    Zadanie2 zadanie2 = new Zadanie2();

    @Test
    public void testPobierzCytat() {
        final Cytat nowyCytat = zadanie2.pobierzCytat();

        assertNotNull(nowyCytat);
        assertNotNull(nowyCytat.getCytat());
        System.out.println("cytat: " + nowyCytat.getCytat());
    }

}
