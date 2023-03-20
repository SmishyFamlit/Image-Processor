package view;

import java.io.IOException;

/**
 * Represents the view for the imageProcessorModel.
 */
public class ImageProcessorView implements View {
  private final Appendable output;

  /**
   * Constructs a view for the mode.
   *
   * @param output where the output messages will be displayed
   */
  public ImageProcessorView(Appendable output) {
    this.output = output;
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try {
      this.output.append(message);
    } catch (IOException e) {
      throw new IOException();
    }
  }
}
