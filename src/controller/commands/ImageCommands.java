package controller.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Model;

/**
 * Represents commands that could be applied to an image.
 */
public interface ImageCommands {
  /**
   * Represents an apply method for the commands.
   *
   * @param m the ImageProcessingModel
   * @throws FileNotFoundException if the
   */
  void apply(Model m) throws IOException;
}
