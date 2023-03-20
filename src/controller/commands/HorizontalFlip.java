package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents a HorizontalFlip command.
 */
public class HorizontalFlip implements ImageCommands {
  private final String imageName;

  /**
   * Constructs a horizontal flip command.
   *
   * @param imageName the name of the image being flipped horizontally
   */
  public HorizontalFlip(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.flip(this.imageName, true);
  }
}
