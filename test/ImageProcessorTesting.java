import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import model.ImageNotFoundException;
import model.Model;
import model.ImageProcessor;
import model.Pixel;

/**
 * Testing for ImageProcessor model.
 */
public class ImageProcessorTesting {

  Pixel red;
  Pixel green;

  Pixel purple;
  Pixel blue;

  Pixel red2;
  Pixel green2;

  Pixel purple2;
  Pixel blue2;

  Model model;
  HashMap<String, Pixel[][]> imageLibrary;
  Pixel[][] originalImage;
  Pixel[][] originalImage1;
  Pixel[][] hFlipImage;
  Pixel[][] vFlipImage;
  Pixel[][] brightnessImage;
  Pixel[][] darknessImage;
  Pixel[][] rGreyscaleImage;
  Pixel[][] gGreyscaleImage;
  Pixel[][] bGreyscaleImage;
  Pixel[][] valueImage;
  Pixel[][] intensityImage;
  Pixel[][] lumaImage;
  Pixel[][] blurImage;
  Pixel[][] sharpenImage;
  Pixel[][] grayscaleImage;
  Pixel[][] sepiaImage;


  @Before
  public void initData() {
    red = new Pixel(255, 0, 0);
    green = new Pixel(0, 255, 0);
    purple = new Pixel(155, 85, 212);
    blue = new Pixel(0, 0, 255);

    originalImage = new Pixel[][]{{this.red, this.green}, {this.purple, this.blue}};
  }

  //tests image processor constructor
  @Test
  public void testConstructor() {
    model = new ImageProcessor();
    assertEquals(model.getImageLibrary(), new HashMap<String, Pixel[][]>());
  }

  //helper method for testing - comparing each pixel in the array,returning true
  //if they are the same
  private boolean isSameImage(Pixel[][] changed, Pixel[][] expected) {
    int width = expected.length;
    int height = expected[0].length;
    for (int i = 0; i < width; i += 1) {
      for (int j = 0; j < height; j += 1) {
        assertEquals(expected[i][j].getRed(), changed[i][j].getRed());
        assertEquals(expected[i][j].getGreen(), changed[i][j].getGreen());
        assertEquals(expected[i][j].getBlue(), changed[i][j].getBlue());
      }
    }
    return true;
  }




  //tests if images can flip horizontally
  @Test
  public void testHorizontalFlip() {

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    hFlipImage = new Pixel[][]{{this.green, this.red}, {this.blue, this.purple}};
    model.flip("originalImage", true);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, hFlipImage));

  }

  //tests if images can flip Vertically
  @Test
  public void testVerticalFlip() {

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    vFlipImage = new Pixel[][]{{this.purple, this.blue}, {this.red, this.green}};
    model.flip("originalImage", false);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, vFlipImage));

  }

  //tests if images can brighten
  @Test
  public void testBrightness() {
    red = new Pixel(100, 0, 0);
    green = new Pixel(0, 100, 0);
    purple = new Pixel(155, 85, 212);
    blue = new Pixel(0, 0, 100);
    originalImage = new Pixel[][]{{this.red, this.green}, {this.purple, this.blue}};

    red2 = new Pixel(110, 10, 10);
    green2 = new Pixel(10, 110, 10);
    purple2 = new Pixel(165, 95, 222);
    blue2 = new Pixel(10, 10, 110);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    brightnessImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.brighten("originalImage", 10);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, brightnessImage));

  }

  //tests if images can brighten, when 1 is at 255 others should keep increasing
  @Test
  public void testBrightnessMax() {
    red = new Pixel(255, 0, 0);
    green = new Pixel(0, 100, 0);
    purple = new Pixel(155, 85, 212);
    blue = new Pixel(0, 0, 100);
    originalImage = new Pixel[][]{{this.red, this.green}, {this.purple, this.blue}};

    red2 = new Pixel(255, 10, 10);
    green2 = new Pixel(10, 110, 10);
    purple2 = new Pixel(165, 95, 222);
    blue2 = new Pixel(10, 10, 110);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    brightnessImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.brighten("originalImage", 10);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, brightnessImage));

  }

  //tests if images can darken
  @Test
  public void testDarken() {
    red = new Pixel(100, 10, 10);
    green = new Pixel(10, 100, 10);
    purple = new Pixel(155, 85, 212);
    blue = new Pixel(10, 10, 100);
    originalImage = new Pixel[][]{{this.red, this.green}, {this.purple, this.blue}};

    red2 = new Pixel(90, 0, 0);
    green2 = new Pixel(0, 90, 0);
    purple2 = new Pixel(145, 75, 202);
    blue2 = new Pixel(0, 0, 90);


    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    darknessImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.brighten("originalImage", -10);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    //assertEquals(model, darknessImage);
    assertTrue(isSameImage(changedImage, darknessImage));

  }

  //tests if images can darken, when 1 is at 0 others should keep decreasing
  @Test
  public void testDarkenMin() {
    red = new Pixel(255, 0, 0);
    green = new Pixel(0, 255, 0);
    purple = new Pixel(155, 85, 212);
    blue = new Pixel(0, 0, 255);
    originalImage = new Pixel[][]{{this.red, this.green}, {this.purple, this.blue}};

    red2 = new Pixel(245, 0, 0);
    green2 = new Pixel(0, 245, 0);
    purple2 = new Pixel(145, 75, 202);
    blue2 = new Pixel(0, 0, 245);


    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    darknessImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.brighten("originalImage", -10);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    //assertEquals(model, darknessImage);
    assertTrue(isSameImage(changedImage, darknessImage));

  }

  //tests if images can greyscale red
  @Test
  public void testRGreyscale() {
    red2 = new Pixel(255, 255, 255);
    green2 = new Pixel(0, 0, 0);
    purple2 = new Pixel(155, 155, 155);
    blue2 = new Pixel(0, 0, 0);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    rGreyscaleImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.grayscale("originalImage", Model.Grayscale.Red);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, rGreyscaleImage));
  }

  //tests if images can greyscale green
  @Test
  public void testGGreyscale() {

    red2 = new Pixel(0, 0, 0);
    green2 = new Pixel(255, 255, 255);
    purple2 = new Pixel(85, 85, 85);
    blue2 = new Pixel(0, 0, 0);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    gGreyscaleImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.grayscale("originalImage", Model.Grayscale.Green);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, gGreyscaleImage));

  }

  //tests if images can greyscale blue
  @Test
  public void testBGreyscale() {

    red2 = new Pixel(0, 0, 0);
    green2 = new Pixel(0, 0, 0);
    purple2 = new Pixel(212, 212, 212);
    blue2 = new Pixel(255, 255, 255);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    bGreyscaleImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.grayscale("originalImage", Model.Grayscale.Blue);
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, bGreyscaleImage));

  }

  //tests if images can modify to value
  @Test
  public void testValue() {
    purple = new Pixel(212, 212, 212);
    blue = new Pixel(255, 255, 255);


    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    valueImage = new Pixel[][]{{this.blue, this.blue}, {this.purple, this.blue}};
    model.value("originalImage");
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, valueImage));

  }

  //tests if images can modify to value
  @Test
  public void testIntensity() {
    purple = new Pixel(150, 150, 150);
    blue = new Pixel(85, 85, 85);
    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    intensityImage = new Pixel[][]{{this.blue, this.blue}, {this.purple, this.blue}};
    model.intensity("originalImage");
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, intensityImage));

  }

  //tests if images can modify to value
  @Test
  public void testLuma() {
    red2 = new Pixel(54, 54, 54);
    green2 = new Pixel(182, 182, 182);
    purple2 = new Pixel(109, 109, 109);
    blue2 = new Pixel(18, 18, 18);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    lumaImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.luma("originalImage");
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, lumaImage));

  }

  @Test
  public void testBLur() {
    red2 = new Pixel(83, 43, 42);
    green2 = new Pixel(20, 74, 50);
    purple2 = new Pixel(50, 31, 93);
    blue2 = new Pixel(14, 16, 84);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    blurImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.filtering("originalImage",
            new double[][]{{0.0625, 0.125, 0.0625},
              {0.125, 0.25, 0.125},
              {0.0625, 0.125, 0.0625}});
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, blurImage));
  }

  @Test
  public void testSharpen() {
    red2 = new Pixel(103, 85, 255);
    green2 = new Pixel(0, 43, 5);
    purple2 = new Pixel(26, 5, 84);
    blue2 = new Pixel(0, 0, 21);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    sharpenImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.filtering("originalImage",
            new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
              {-0.125, 0.25, 0.25, 0.25, -0.125},
              {-0.125, 0.25, 1.0, 0.25, -0.125},
              {-0.125, 0.25, 0.25, 0.25, -0.125},
              {-0.125, -0.125, -0.125, -0.125, -0.125}});
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, sharpenImage));
  }

  @Test
  public void testGrayscale() {
    red2 = new Pixel(54, 54, 54);
    green2 = new Pixel(182, 182, 182);
    purple2 = new Pixel(109, 109, 109);
    blue2 = new Pixel(18, 18, 18);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    grayscaleImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.grayscaleFilter("originalImage");
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, grayscaleImage));
  }

  @Test
  public void testSepia() {
    red2 = new Pixel(100, 89, 69);
    green2 = new Pixel(196, 175, 136);
    purple2 = new Pixel(166, 148, 115);
    blue2 = new Pixel(48, 43, 33);

    model = new ImageProcessor();
    imageLibrary = this.model.getImageLibrary();
    imageLibrary.put("originalImage", originalImage);
    sepiaImage = new Pixel[][]{{this.red2, this.green2}, {this.purple2, this.blue2}};
    model.sepia("originalImage");
    Pixel[][]changedImage = this.imageLibrary.get("originalImage");

    assertTrue(isSameImage(changedImage, sepiaImage));
  }


  //tests if illegal argument is thrown when file doesn't exist in horizontal flip method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileHFlip() {
    model = new ImageProcessor();
    model.flip("randomFile", true);
  }

  //tests if illegal argument is thrown when file doesn't exist in vertical flip method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileVFlip() {
    model = new ImageProcessor();
    model.flip("randomFile", false);
  }

  //tests if illegal argument is thrown when file doesn't exist in brightness method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileBrightness() {
    model = new ImageProcessor();
    model.brighten("randomFile", 10);
  }

  //tests if illegal argument is thrown when file doesn't exist in dark method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileDarken() {
    model = new ImageProcessor();
    model.brighten("randomFile", -10);
  }

  //tests if illegal argument is thrown when file doesn't exist in grayscale method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileGrayscale() {
    model = new ImageProcessor();
    model.grayscale("randomFile", Model.Grayscale.Red);
  }

  //tests if illegal argument is thrown when file doesn't exist in value method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileValue() {
    model = new ImageProcessor();
    model.value("randomFile");
  }

  //tests if illegal argument is thrown when file doesn't exist in intensity method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileIntensity() {
    model = new ImageProcessor();
    model.intensity("randomFile");
  }

  //tests if illegal argument is thrown when file doesn't exist in luma method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileLuma() {
    model = new ImageProcessor();
    model.luma("randomFile");
  }

  //tests if illegal argument is thrown when file doesn't exist in blur method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileBlur() {
    model = new ImageProcessor();
    model.filtering("randomFile",
            new double[][]{{0.0625, 0.125, 0.0625},
              {0.125, 0.25, 0.125},
              {0.0625, 0.125, 0.0625}});
  }

  //tests if illegal argument is thrown when file doesn't exist in sharpen method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileSharpen() {
    model = new ImageProcessor();
    model.filtering("randomFile",
            new double[][]{{-0.125, -0.125, -0.125, -0.125, -0.125},
              {-0.125, 0.25, 0.25, 0.25, -0.125},
              {-0.125, 0.25, 1.0, 0.25, -0.125},
              {-0.125, 0.25, 0.25, 0.25, -0.125},
              {-0.125, -0.125, -0.125, -0.125, -0.125}});
  }

  //tests if illegal argument is thrown when file doesn't exist in grayscale method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileGrayscaleFilter() {
    model = new ImageProcessor();
    model.grayscaleFilter("randomFile");
  }

  //tests if illegal argument is thrown when file doesn't exist in sepia method
  @Test(expected = ImageNotFoundException.class)
  public void testInvalidFileSepia() {
    model = new ImageProcessor();
    model.sepia("randomFile");
  }



}


