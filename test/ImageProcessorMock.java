import java.io.IOException;
import java.util.HashMap;

import model.ImageNotFoundException;
import model.Model;
import model.Pixel;

/**
 * Mock for ImageProcessor model, used for testing.
 */
public class ImageProcessorMock implements Model {

  private StringBuilder log;
  private HashMap<String, Pixel[][]> imageLibrary;


  public ImageProcessorMock(StringBuilder log) {
    this.log = log;
    this.imageLibrary = new HashMap<>();
  }


  @Override
  public void load(String filename, String name) throws IllegalStateException {
    this.log.append(filename + "has been loaded as" + name);
  }

  @Override
  public void save(Pixel[][] image, String path) throws IOException, IllegalArgumentException {
    this.log.append(image + "has been saved to" + path);
  }

  @Override
  public void flip(String imageName, boolean horizontal) throws ImageNotFoundException {
    if (horizontal) {
      this.log.append("image: '" + imageName + "' was flipped horizontally\n");
    } else {
      this.log.append("image: '" + imageName + "' was flipped vertically\n");
    }
  }

  @Override
  public void brighten(String imageName, int brightnessValue) {
    if (brightnessValue < 0) {
      this.log.append(String.format("image was darkened by %d\n", brightnessValue));
    } else {
      this.log.append(String.format("image was brightened by %d\n", brightnessValue));
    }
  }


  @Override
  public void grayscale(String imageName, Grayscale color) {
    this.log.append("image: '" + imageName + "' was greyscaled to " + color + "\n");
  }

  @Override
  public void value(String imageName) {
    this.log.append("image: '" + imageName + "' has changed to value RGB colors\n");
  }

  @Override
  public void intensity(String imageName) {
    this.log.append("image: '" + imageName + "' has changed to intensity RGB colors\n");
  }

  @Override
  public void luma(String imageName) {
    this.log.append("image: '" + imageName + "' has changed to luma RGB colors\n");
  }

  @Override
  public HashMap<String, Pixel[][]> getImageLibrary() {
    this.log.append("HashMap called\n");
    return imageLibrary;
  }

  @Override
  public void filtering(String imageName, double[][] kernel) {
    this.log.append("image: '" + imageName + "' has been blurred\n");
    this.log.append("image: '" + imageName + "' has been sharpened\n");
  }

  @Override
  public void grayscaleFilter(String imageName) {
    this.log.append("image: '" + imageName + "' has grayscale filter\n");
  }

  @Override
  public void sepia(String imageName) {
    this.log.append("image: '" + imageName + "' has sepia filter\n");
  }
}


