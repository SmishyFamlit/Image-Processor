package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents a vertical flip command for an image.
 */
public class VerticalFlip implements ImageCommands {
  private final String imageName;

  /**
   * Constructs the vertical flip command for an image.
   *
   * @param imageName the name of the image that the vertical flip command will be applied to
   */
  public VerticalFlip(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.flip(this.imageName, false);
  }
}
