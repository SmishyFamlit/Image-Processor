package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents the Luma command for an image.
 */
public class Luma implements ImageCommands {
  private final String imageName;

  /**
   * Constructs the Luma command.
   *
   * @param imageName the name of the image that you are applying the Luma command to
   */
  public Luma(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.luma(this.imageName);
  }
}
