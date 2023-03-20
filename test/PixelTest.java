import org.junit.Before;
import org.junit.Test;

import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * Represents test for pixels.
 */
public class PixelTest {
  Pixel redPixel; //represents a red pixel
  Pixel greenPixel; //represents a green pixel
  Pixel bluePixel; //represents a blue pixel

  //initializes the variables
  @Before
  public void init() {
    this.redPixel = new Pixel(255, 0,0);
    this.greenPixel = new Pixel(0,255,0);
    this.bluePixel = new Pixel(0,0,255);
  }


  // test pixel constructor
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidFileVFlip() {
    redPixel = new Pixel(255, 260, 0);
  }

  //test the get methods
  @Test
  public void testGetMethods() {
    assertEquals(255, redPixel.getRed());
    assertEquals(0, redPixel.getGreen());
    assertEquals(0, redPixel.getBlue());
  }

  //test the set methods
  @Test
  public void testSetMethods() {
    assertEquals(255, redPixel.getRed());
    assertEquals(0, redPixel.getGreen());
    assertEquals(0, redPixel.getBlue());

    redPixel.setRed(0);
    redPixel.setGreen(0);
    redPixel.setBlue(0);

    assertEquals(0, redPixel.getRed());
    assertEquals(0, redPixel.getGreen());
    assertEquals(0, redPixel.getBlue());
  }
}