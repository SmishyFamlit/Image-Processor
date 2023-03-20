package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * Represents a command that sharpens images.
 */
public class Sharpen implements ImageCommands {
  private final String imageName;
  private final double[][] kernel;

  /**
   * Constructs the sharpen command.
   *
   * @param imageName the name of the image to be sharpened
   */
  public Sharpen(String imageName) {
    this.imageName = imageName;
    this.kernel = new double[][]
        {{-0.125, -0.125, -0.125, -0.125, -0.125}, {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, 0.25, 1.0, 0.25, -0.125}, {-0.125, 0.25, 0.25, 0.25, -0.125},
        {-0.125, -0.125, -0.125, -0.125, -0.125}};
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.filtering(this.imageName, this.kernel);
  }
}
