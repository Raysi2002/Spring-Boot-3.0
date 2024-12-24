// PositionNotFoundException.java
package com.raysi.springboot3.exceptions;

// Custom exception class that extends the base Exception class.
public class PositionNotFoundException extends Exception {

  // Default constructor
  public PositionNotFoundException() {
    super(); // Calls the default constructor of the parent Exception class.
  }

  // Constructor that accepts a custom error message
  public PositionNotFoundException(String message) {
    super(message); // Passes the custom message to the parent Exception class.
  }

  // Constructor that accepts a custom message and a cause (another throwable).
  public PositionNotFoundException(String message, Throwable cause) {
    super(message, cause); // Passes the message and cause to the parent Exception class.
  }

  // Constructor that accepts only a cause.
  public PositionNotFoundException(Throwable cause) {
    super(cause); // Passes the cause to the parent Exception class.
  }

  // Constructor with additional parameters for advanced exception handling.
  protected PositionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // enableSuppression: Whether suppression is enabled or disabled.
    // writableStackTrace: Whether the stack trace should be writable.
  }
}