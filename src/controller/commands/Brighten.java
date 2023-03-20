package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents the brightened command in the model.
 */
public class Brighten implements ImageCommands {
  private final String imageName;
  private final int value;

  /**
   * Constructs the brightened command.
   *
   * @param imageName the name of the image that will be brightened
   * @param value     the amount that will be brightened
   */
  public Brighten(String imageName, int value) {
    this.imageName = imageName;
    this.value = value;
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.brighten(this.imageName, this.value);
  }
}
