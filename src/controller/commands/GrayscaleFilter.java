package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents a command that filters the image to grayscale.
 */
public class GrayscaleFilter implements ImageCommands {
  private final String imageName;

  /**
   * Constructs the grayscale filter command.
   * @param imageName the name of the image being converted to grayscale
   */
  public GrayscaleFilter(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.grayscaleFilter(this.imageName);
  }
}
