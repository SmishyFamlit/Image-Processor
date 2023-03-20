package model;

import java.io.IOException;
import java.util.HashMap;

/**
 * This interface represents the operation offered by the image processing model.
 * One object of this model represents a photo editing class.
 */
public interface Model extends ExtraFunctions {

  /**
   * Represents the grayscale components that can be inputted into the grayscale method.
   */
  enum Grayscale {
    Red, Green, Blue
  }

  /**
   * Loads a file to be manipulated.
   * @param filename the name of the file being loaded
   * @param name the name you want to give the file
   * @throws IllegalStateException if the file can't be loaded
   */
  void load(String filename, String name) throws IllegalStateException;

  /**
   * Saves an image as a PPM.
   *
   * @param image the image to be saved
   */
  void save(Pixel[][] image, String path) throws IOException, IllegalArgumentException;
  /**
   * Flips the images horizontally or vertically.
   *
   * @param imageName  the name of the image being flipped
   * @param horizontal if true flips the image horizontally, else flips it vertically
   * @throws ImageNotFoundException if the image can't be located in the HashMap
   */

  void flip(String imageName, boolean horizontal) throws ImageNotFoundException;

  /**
   * Makes an image brighter or darker.
   *
   * @param imageName       the name of the image being brightened
   * @param brightnessValue the value to change the brightness of the image, negative to
   *                        darken the image, positive to brighten
   * @throws ImageNotFoundException if the image can't be located in the HashMap
   */
  void brighten(String imageName, int brightnessValue)
          throws ImageNotFoundException;

  /**
   * Turns an image into grayscale depending on what color grayscale you want between r, g or b.
   *
   * @param imageName the image being made into grayscale
   * @param color     which color of the RGB you want to grayscale
   * @throws ImageNotFoundException if the image can't be located in the HashMap
   */
  void grayscale(String imageName, Grayscale color) throws ImageNotFoundException;

  /**
   * Gets the value of an image.
   *
   * @param imageName the name of the image to get the value of
   * @throws ImageNotFoundException if the image can't be located in the HashMap
   */
  void value(String imageName) throws ImageNotFoundException;

  /**
   * Gets the intensity of an image.
   *
   * @param imageName the name of the image to get the intensity of
   * @throws ImageNotFoundException if the image can't be located in the HashMap
   */
  void intensity(String imageName) throws ImageNotFoundException;

  /**
   * Gets the luma of an image.
   *
   * @param imageName the name of the image
   * @throws ImageNotFoundException if the image can't be located in the HashMap
   */
  void luma(String imageName) throws ImageNotFoundException;

  HashMap<String, Pixel[][]> getImageLibrary();

}
