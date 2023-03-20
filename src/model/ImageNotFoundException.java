package model;

/**
 * This class represents an exception that the image register is not located in the hashMap.
 */
public class ImageNotFoundException extends RuntimeException {

  /**
   * Constructs the ImageNotFoundException.
   *
   * @param message the messages to display when this exception is thrown
   */
  public ImageNotFoundException(String message) {
    super(message);
  }

}
