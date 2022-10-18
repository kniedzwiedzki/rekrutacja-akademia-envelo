package pl.envelo.akademia.pkp.rekrutacja;

import java.util.NoSuchElementException;
import java.util.Scanner;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.MemoryQuoteStorage;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.Quote;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.QuoteFetcher;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.MemorizedQuotesFullException;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.NewQuotesNotAvailableException;
import pl.envelo.akademia.pkp.rekrutacja.zadanie2.quote.exception.QuoteServerException;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final QuoteFetcher quoteFetcher = new QuoteFetcher(new MemoryQuoteStorage());
        try {
            while (true) {
                System.out.println("Podaj komendę:");
                String userInput = scanner.nextLine();
                if (userInput.equals("next")) {
                    try {
                        final Quote quote = quoteFetcher.fetchQuote();
                        System.out.println("Pobrany cytat: " + quote.getQuote());
                    } catch (QuoteServerException e) {
                        System.err.println("Wystąpił błąd po stronie serwera cytatów.");
                    }
                } else {
                    System.out.println("Komenda nie obsługiwana.");
                }
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.out.println("Konsola została zamknięta.");
        } catch (NewQuotesNotAvailableException e) {
            System.err.println("Brak nowych cytatów, lub liczba rekursywnych wywołań przekroczona.");
        } catch (MemorizedQuotesFullException e) {
            System.err.println("Liczba cytatów zapisanych w pamięci przekroczyła limit.");
        }
    }
}
