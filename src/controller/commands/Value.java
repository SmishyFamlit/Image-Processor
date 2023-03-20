package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents the value command for an image.
 */
public class Value implements ImageCommands {
  private final String imageName;

  /**
   * Constructs the value command.
   *
   * @param imageName the name of the image that you applying the value command to
   */
  public Value(String imageName) {
    this.imageName = imageName;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.value(this.imageName);
  }
}
