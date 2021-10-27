package com.example.functionaljava.libreriawindow;

import com.example.functionaljava.libreriawindow.actions.OnClickAction;
import com.example.functionaljava.libreriawindow.actions.OnCloseAction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Button {

  private String color;
  private OnClickAction onClickAction;
  private OnCloseAction onCloseAction;

  public void click() {
    if (onClickAction == null) {
      System.out.println("onClickAction not implemented");
      return;
    }
    // definido por el usuario
    onClickAction.onClick();
  }

  public void close() {
    if (onCloseAction == null) {
      System.out.println("onCloseAction not implemented");
      return;
    }
    // definido por el usuario
    onCloseAction.onClose();
  }

}
