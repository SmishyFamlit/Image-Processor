package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents the load command for the images.
 */

public class Load implements ImageCommands {

  private final String filename;
  private final String imageName;

  /**
   * Constructs the load command.
   * @param filename the file location of the image
   * @param imageName the image being applied to the file
   */
  public Load(String filename, String imageName) {
    this.filename = filename;
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.load(this.filename, this.imageName);
  }
}
