package com.example.functionaljava.javafunctionalinterfaces;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    Predicate<Integer> esPar = new ValidarSiEsPar();

    boolean resultadoDeLaValidacion = Validacion.validar(7, esPar);

    System.out.println(resultadoDeLaValidacion);

    Stream.of(1, 2, 3, 4, 5, 6, 7)
      .filter(esPar)
      .forEach(x -> System.out.println(x));
  }

  public static class ValidarSiEsPar implements Predicate<Integer> {
    @Override
    public boolean test(Integer numeroAValidar) {
      return numeroAValidar % 2 == 0;
    }
  }

  /* Libreria */
  static class Validacion {
    public static boolean validar(Integer numeroAValidar, Predicate<Integer> comoValidar) {
      return comoValidar.test(numeroAValidar);
    }
  }

}
