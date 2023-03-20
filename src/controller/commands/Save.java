package controller.commands;

import java.io.IOException;

import model.Model;
import model.Pixel;

/**
 * Represents the save command for the model.
 */
public class Save implements ImageCommands {
  private final Pixel[][] image;
  private final String path;

  /**
   * Constructs the save command.
   * @param image the image being saved
   * @param path the location it is being saved to
   */
  public Save(Pixel[][] image, String path) {
    this.image = image;
    this.path = path;
  }

  @Override
  public void apply(Model m) throws IOException {
    m.save(this.image, this.path);
  }
}
