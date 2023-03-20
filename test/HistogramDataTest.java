import org.junit.Test;

import model.Histogram;
import model.HistogramData;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the histogram.
 */
public class HistogramDataTest {
  Pixel pixel1;
  Pixel pixel2;
  Pixel pixel3;
  Pixel pixel4;

  Pixel[][] originalImage;
  int[] array;
  int[] newArray;

  private boolean isSameArray(int[] changed, int[] expected) {
    for (int i = 0; i < expected.length; i += 1) {
      assertEquals(expected[0], changed[0]);
      assertEquals(expected[1], changed[1]);
      assertEquals(expected[2], changed[2]);
      assertEquals(expected[3], changed[3]);
    }
    return true;
  }

  @Test
  public void testHistogramRed() {
    pixel1 = new Pixel(1, 2, 3);
    pixel2 = new Pixel(3, 1, 2);
    pixel3 = new Pixel(1, 2, 3);
    pixel4 = new Pixel(3, 2, 1);
    originalImage = new Pixel[][]{{this.pixel1, pixel2}, {this.pixel3, this.pixel4}};
    newArray = new HistogramData(originalImage, Histogram.HistogramColour.Red).getRedArray();
    array = new int[]{0, 2, 0, 2};

    assertTrue(isSameArray(newArray, array));
  }

  @Test
  public void testHistogramGreen() {
    pixel1 = new Pixel(1, 2, 3);
    pixel2 = new Pixel(3, 1, 2);
    pixel3 = new Pixel(1, 2, 3);
    pixel4 = new Pixel(3, 2, 1);
    originalImage = new Pixel[][]{{this.pixel1, pixel2}, {this.pixel3, this.pixel4}};
    newArray = new HistogramData(originalImage, Histogram.HistogramColour.Green).getGreenArray();
    array = new int[]{0, 1, 3, 0};

    assertTrue(isSameArray(newArray, array));
  }

  @Test
  public void testHistogramBlue() {
    pixel1 = new Pixel(1, 2, 3);
    pixel2 = new Pixel(3, 1, 2);
    pixel3 = new Pixel(1, 2, 3);
    pixel4 = new Pixel(3, 2, 1);
    originalImage = new Pixel[][]{{this.pixel1, pixel2}, {this.pixel3, this.pixel4}};
    newArray = new HistogramData(originalImage, Histogram.HistogramColour.Blue).getBlueArray();
    array = new int[]{0, 1, 1, 2};

    assertTrue(isSameArray(newArray, array));
  }

  @Test
  public void testHistogramIntensity() {
    pixel1 = new Pixel(1, 2, 3);
    pixel2 = new Pixel(3, 1, 2);
    pixel3 = new Pixel(1, 2, 3);
    pixel4 = new Pixel(3, 2, 1);
    originalImage = new Pixel[][]{{this.pixel1, pixel2}, {this.pixel3, this.pixel4}};
    newArray = new HistogramData(originalImage, Histogram.HistogramColour.Intensity).
            getIntensityArray();
    array = new int[]{0, 0, 4, 0};

    assertTrue(isSameArray(newArray, array));
  }

}
