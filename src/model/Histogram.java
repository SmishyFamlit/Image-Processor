package model;

/**
 * Interface for the Histogram.
 */
public interface Histogram {

  /**
   * Types of colours the histogram can be.
   */
  enum HistogramColour {
    Red, Green, Blue, Intensity
  }


  /**
   * Makes an array of integers of the specified colour from the given image to make a histogram.
   *
   * @param image  the given image
   * @param colour the colour of the values
   * @return array of integers
   */
  int[] getArray(Pixel[][] image, HistogramColour colour);

}