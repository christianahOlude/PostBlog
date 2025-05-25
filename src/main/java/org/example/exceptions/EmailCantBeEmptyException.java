package org.example.exceptions;

public class EmailCantBeEmpty extends RuntimeException {
  public EmailCantBeEmpty(String message) {
    super(message);
  }
}
