package pl.envelo.akademia.pkp.rekrutacja.zadanie1;

public class Searcher {

    boolean search(int[] numbers, int x) {

        int left = -1;
        int right = numbers.length;

        while (right > left + 1) {
            int middle = (left + right) / 2;
            if (numbers[middle] <= x) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return right < numbers.length && numbers[right] == x;
    }

}
