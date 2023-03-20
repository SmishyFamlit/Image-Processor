import org.junit.Test;

import java.io.IOException;

import view.ImageProcessorView;

import static org.junit.Assert.assertEquals;

/**
 * Testing Image Processor view.
 */
public class ImageProcessorViewTest {

  ImageProcessorView view;

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidViewConstructor() {
    view = new ImageProcessorView(null);
  }

  //testing renderMessage
  @Test
  public void testRenderMessage() throws IOException {
    StringBuilder output = new StringBuilder();
    view = new ImageProcessorView(output);

    view.renderMessage("Hello");
    assertEquals("Hello", output.toString());
  }
}

