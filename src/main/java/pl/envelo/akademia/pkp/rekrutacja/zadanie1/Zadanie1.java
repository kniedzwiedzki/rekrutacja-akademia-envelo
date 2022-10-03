package pl.envelo.akademia.pkp.rekrutacja.zadanie1;

public class Zadanie1 {


    public boolean search(int[] numbers, int x) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x) {
                return true;
            }
        }
        return false;
    }

}
