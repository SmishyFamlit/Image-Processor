package model;

/**
 * Represents the extra filtering functions of the image processor.
 */
public interface ExtraFunctions {

  /**
   * Filters an image with a kernel.
   * @param imageName the name of the image being filtered
   * @param kernel the kernel to be passed through
   */
  void filtering(String imageName, double[][] kernel);

  /**
   * Grayscale filters an image.
   * @param imageName the name of the image being grayscale filtered
   */
  void grayscaleFilter(String imageName);

  /**
   * Filters an image to sepia.
   * @param imageName the name of the image being sepia filtered
   */
  void sepia(String imageName);
}
