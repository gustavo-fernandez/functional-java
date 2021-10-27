package com.example.functionaljava.application;

import com.example.functionaljava.libreriawindow.Button;

public class VentanaAplicacion {

  public static void main(String[] args) {
    Button button = new Button();
    button.setOnClickAction(
      () -> System.out.println("Hola, has hecho clic")
    ); // Lambda expression derivada de OnClickAction
    button.setOnCloseAction(
      () -> System.out.println("Adios mundo cruel")
    ); // Implementación de OnCloseAction

    // Llamada de usuario
    button.click();
    button.close();
  }

}
