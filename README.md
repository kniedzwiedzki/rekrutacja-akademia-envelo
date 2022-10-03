# Rekrutacja Akademia envelo

Repozytorium zawiera rozwiązanie zadań rekrutacyjnych:

1. Mając tablicę int[] numbers, wypełnioną liczbami całkowitymi i posortowaną malejąco ( `numbers[i] > numbers[i+1]` ), sprawdź czy występuje w niej liczba int x. Metoda powinna zwracać wartość `TRUE`, jeśli dana liczba występuje oraz FALSE w przeciwnym wypadku. W rozwiązaniu zależy nam na jak najmniejszej złożoności obliczeniowej (priorytet) oraz pamięciowej. Podaj szacowaną złożoność obliczeniową oraz pamięciową. Poniżej sygnatura metody do napisania.

```java
private boolean search(int[] numbers, int x){}
```

2. Napisz program, który wykorzysta API Kanye Rest https://kanye.rest/ by każdorazowo zaproponować nową perełkę mądrości od Kanye Westa. Program powinien być obsługiwany z poziomu konsoli i obsługiwać komendę "next" by wywołać następny cytat. Program nie potrzebuje oprawy graficznej. Zwróć uwagę na poprawną architekturę aplikacji oraz na czystość kodu. 

3. Dla chętnych, za dodatkowe punkty: dodaj zapisywanie cytatów w pamięci, by upewnić się, że każdy kolejny cytat jest nowy.

### Wymagania

- Apache Maven 3.6.3
- Java > 1.8

### Kompilacja wraz z testami

```bash
 mvn clean package
```

### Uruchomienie

```bash
mvn exec:java -Dexec.mainClass="pl.envelo.akademia.pkp.rekrutacja.App" 
```

Aby zamknąć program należy zamknąć konsole `CTRL+D`