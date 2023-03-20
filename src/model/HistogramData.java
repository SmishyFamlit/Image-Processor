package model;

/**
 * Collects the histogram data.
 */
public class HistogramData implements Histogram {
  Pixel[][] image;
  int[] red;
  int[] green;
  int[] blue;
  int[] intensity;

  /**
   * Constructs the histogram data.
   * @param image image to collect the data
   * @param colour specific colour of the pixel, red, green, blue, intensity
   */
  public HistogramData(Pixel[][] image, HistogramColour colour) {
    this.image = image;
    this.red = new int[256];
    this.green = new int[256];
    this.blue = new int[256];
    this.intensity = new int[256];
    getArray(this.image, colour);


  }


  /**
   * Makes an array of integers of the specified colour from the given image to make a histogram.
   *
   * @param image  the given image
   * @param colour the colour of the values
   * @return array of integers
   */
  public int[] getArray(Pixel[][] image, HistogramColour colour) {
    for (Pixel[] pixels : image) {
      for (int i = 0; i < image[0].length; i++) {
        switch (colour) {
          case Red:
            this.red[pixels[i].getRed()] ++;
            break;
          case Green:
            this.green[pixels[i].getGreen()] ++;
            break;
          case Blue:
            this.blue[pixels[i].getBlue()] ++;
            break;
          case Intensity:
            this.intensity[(pixels[i].getRed() + pixels[i].getGreen() +
                    pixels[i].getBlue()) / 3] ++;
            break;
          default:
            break;
        }
      }
    }
    return null;
  }

  public int[] getRedArray() {
    return this.red;
  }

  public int[] getGreenArray() {
    return this.green;
  }

  public int[] getBlueArray() {
    return this.blue;
  }

  public int[] getIntensityArray() {
    return this.intensity;
  }



}