package view;

import java.io.IOException;

/**
 * Represents a view for the imageProcessorModel.
 */
public interface View {

  /**
   * Renders a message to the output.
   *
   * @param message the message that is being rendered
   * @throws IOException if there is corruption or trouble appending the message
   */
  void renderMessage(String message) throws IOException;

}
