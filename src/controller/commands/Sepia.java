package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents the sepia command.
 */
public class Sepia implements ImageCommands {
  private final String imageName;

  /**
   * Constructs the sepia command.
   * @param imageName the name of the image being filtered to sepia
   */
  public Sepia(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.sepia(this.imageName);
  }
}
