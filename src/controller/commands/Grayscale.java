package controller.commands;

import java.io.FileNotFoundException;

import model.Model;

import static model.Model.Grayscale.Blue;
import static model.Model.Grayscale.Green;
import static model.Model.Grayscale.Red;

/**
 * Represents the grayscale command.
 */
public class Grayscale implements ImageCommands {
  private final String imageName;
  private final String grayscaleColor;

  /**
   * Constructs the grayscale command.
   *
   * @param imageName      the name of the image being turned into a grayscale
   * @param grayscaleColor the type of grayscale component you want (r,g,b)
   */
  public Grayscale(String imageName, String grayscaleColor) {
    this.imageName = imageName;
    this.grayscaleColor = grayscaleColor;
  }


  @Override
  public void apply(Model m) throws FileNotFoundException {
    switch (this.grayscaleColor) {
      case "red":
        m.grayscale(this.imageName, Red);
        break;

      case "green":
        m.grayscale(this.imageName, Green);
        break;

      case "blue":
        m.grayscale(this.imageName, Blue);
        break;

      default:
        throw new FileNotFoundException(); //TODO might want to fix this.
    }
  }
}
