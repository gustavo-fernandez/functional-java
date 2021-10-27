package com.example.functionaljava.application;

import com.example.functionaljava.libreriawindow.Button;
import com.example.functionaljava.libreriawindow.actions.OnClickAction;
import com.example.functionaljava.libreriawindow.actions.OnCloseAction;

public class VentanaAplicacion {

  public static void main(String[] args) {
    Button button = new Button();
    button.setOnClickAction(new OnClickAction() {
      public void onClick() {
        System.out.println("Hola, has hecho clic");
      }
    }); // Implementación de OnClickAction
    button.setOnCloseAction(new DecirAdiosCuandoPulsanClose()); // Implementación de OnCloseAction

    // Llamada de usuario
    button.click();
    button.close();
  }

  static class DecirAdiosCuandoPulsanClose implements OnCloseAction {
    @Override
    public void onClose() {
      System.out.println("Adios, has hecho clic en el boton 'close'");
    }
  }

}
