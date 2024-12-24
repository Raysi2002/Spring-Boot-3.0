package com.raysi.springboot3.exceptions;

public class PositionNotFoundException extends Exception {

  public PositionNotFoundException() {
    super();
  }

  public PositionNotFoundException(String message) {
    super(message);
  }

  public PositionNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public PositionNotFoundException(Throwable cause) {
    super(cause);
  }

  protected PositionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
