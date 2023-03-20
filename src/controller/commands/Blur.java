package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

/**
 * A command that blurs an Image.
 */
public class Blur implements ImageCommands {
  private final String imageName;
  private final double[][] kernel;


  /**
   * Constructs the Blur command.
   *
   * @param imageName the name of the image being blurred
   */
  public Blur(String imageName) {
    this.imageName = imageName;
    this.kernel = new double[][]{{0.0625, 0.125, 0.0625}, {0.125, 0.25, 0.125},
      {0.0625, 0.125, 0.0625}};
  }

  @Override
  public void apply(Model m) throws FileNotFoundException {
    m.filtering(this.imageName, this.kernel);
  }
}
