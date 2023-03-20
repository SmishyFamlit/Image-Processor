package model;

/**
 * Represents a pixel that has RGB values.
 */
public class Pixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Constructs the pixel.
   *
   * @param red   the red value of the pixel from [0 - 255]
   * @param green the green value of the pixel from [0 - 255]
   * @param blue  the blue value of the pixel from [0 - 255]
   * @throws IllegalArgumentException if the red, green or blue are less than 0 or greater than 255
   */
  public Pixel(int red, int green, int blue) throws IllegalArgumentException {
    if (red < 0 || blue < 0 || green < 0) {
      throw new IllegalArgumentException("rgb values cannot be less than 0");
    }

    if (red > 255 || blue > 255 || green > 255) {
      throw new IllegalArgumentException("rgb values cannot be less than 0");
    }
    this.red = red;
    this.blue = blue;
    this.green = green;
  }

  /**
   * Gets the red value of the RGB numbers.
   *
   * @return the red value integer
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Gets the green value of the RGB numbers.
   *
   * @return the green value integer
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Gets the blue value of the RGB numbers.
   *
   * @return the blue value integer
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * Sets the red number of RGB to value.
   *
   * @param value the value to set red to
   */
  public void setRed(int value) {
    this.red = value;
  }

  /**
   * Sets the green number of RGB to value.
   *
   * @param value the value to set green to
   */
  public void setGreen(int value) {
    this.green = value;
  }

  /**
   * Sets the blue number of RGB to value.
   *
   * @param value the value to set blue to
   */
  public void setBlue(int value) {
    this.blue = value;
  }

}
