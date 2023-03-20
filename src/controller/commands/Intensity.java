package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents the intensity command for an image.
 */
public class Intensity implements ImageCommands {
  private final String imageName;

  /**
   * Constructs the intensity command.
   *
   * @param imageName the name of the image that you are applying the intensity command to
   */
  public Intensity(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.intensity(this.imageName);
  }
}
