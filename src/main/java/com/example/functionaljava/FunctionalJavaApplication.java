package com.example.functionaljava;

public class FunctionalJavaApplication {

  public static void main(String[] args) {
    Button button = new Button();
    // cuando alguien de click, llama al método "action" del objeto hijo de "OnClickAction"
    button.onClick(new MostrarAlertaWrapper());

    // button.onAnything(new MostrarAlertaWrapperAll());
    // button.onAnything(() -> hacerAlgoEnClose(), () -> hacerAlgoEnWrite());

    // button.onClick(mostrarAlerta());
    button.click();

    button.close();

    button.write();
  }
  /*public static void mostrarAlerta() {
    Window.alert("Hola Mundo");
  }*/
  // Creo un hijo de OnClickAction
  public static class MostrarAlertaWrapper extends OnClickAction {
    @Override
    // Implemento la acción
    public void action() {
      Window.alert("Hola Mundo");
    }
  }

  public static class MostrarAlertaWrapperAll extends AllEventActions {
    @Override
    public void onWriting() {
      System.out.println("Write...");
    }
    @Override
    public void onClose() {
      System.out.println("Close...");
    }
  }

  /* Librería "Swing" */
  private static class Button {
    private OnClickAction eventoCuandoDenClick;
    private AllEventActions allEventActions;
    public void onClick(OnClickAction onclickAction) {
      this.eventoCuandoDenClick = onclickAction;
    }
    public void onAnything(AllEventActions allEventActions) {
      this.allEventActions = allEventActions;
    }
    public void click() {
      eventoCuandoDenClick.action();
    }
    public void write() {
      allEventActions.onWriting();
    }
    public void close() {
      allEventActions.onClose();
    }
  }
  private static abstract class OnClickAction {
    public abstract void action();
  }
  private static abstract class AllEventActions {
    public abstract void onWriting();
    public abstract void onClose();
  }

  private static class Window {
    public static void alert(String message) {
      System.out.println("Hola Mundo");
    }
  }

  private static class Auto {
    // Object members
    // 1) Fields - State
    private String color;
    private String placa;

    // Methods (Functions) Behavior
    public void arrancar() {
    }

    public void frenar() {
    }
  }

}
