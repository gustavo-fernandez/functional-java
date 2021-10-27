package com.example.functionaljava.javafunctionalinterfaces;

import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.SneakyThrows;

public class Main02 {

  public static void main(String[] args) {
    // Predicate -> boolean test(T t) -> Recibe un valor y evalua a true o false
    // Consumer -> void accept(T t) -> Hace algo con algún valor
    // Supplier -> T get() -> Emite un valor
    // Function -> T apply(R r) -> Recibe un valor y retorna otra

    /*
    Stream.of(1, 2, 3, 4)
      .filter((i) -> i % 2 == 0);

    Stream.of(1, 2, 3, 4)
      .forEach((i) -> System.out.println(i));

    Stream.generate(() -> 1);

    Stream.of(1, 2, 3, 4)
      .map((i) -> i * 2);
    */

    /*Optional<Integer> primero = Stream.of(1, 2, 3, 4) // Generador
      .peek(i -> System.out.println("se tomo el numero: " + i)) // Operador Intermedio
      .filter(i -> i % 10 == 0) // Operador Intermedio
      .peek(i -> System.out.println("peek: " + i)) // Operador Intermedio
      .findAny();*/
    // System.out.println(primero);

    // collect(Collector)
    // reduce(...)
    // forEach(Consumer<T>)
    // allMatch(Predicate<T>)
    // anyMatch(Predicate<T>)
    // noneMatch(Predicate<T>)
    // findFirst()
    // findAny()

    Stream.generate(new GeneradorRandom())
      .parallel()
      .peek(randomNumber -> randomSleep(randomNumber))
      .findAny();
  }

  @SneakyThrows
  private static final void randomSleep(int randomNumber) {
    int sleepTime = new Random().nextInt(4_000) + 1_000;
    System.out.println(
      Thread.currentThread().getName() + " El numero " + randomNumber + " esta durmiendo por " + sleepTime + " milisegundos");
    Thread.sleep(sleepTime);
  }

  static class GeneradorRandom implements Supplier<Integer> {
    @Override
    public Integer get() {
      int random = new Random().nextInt(100);
      System.out.println("Random " + random);
      return random;
    }
  }

}
