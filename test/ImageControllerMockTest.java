import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.StringReader;

import controller.ImageController;

import model.ImageProcessor;
import model.Pixel;
import view.ImageProcessorView;

import static org.junit.Assert.assertTrue;

/**
 * Testing for controller Mock, mainly to test manipulateImage method.
 */
public class ImageControllerMockTest {


  //Tests if commands in manipulateImage go to the correct methods in model
  @Test
  public void testManipulateImageLoad() throws FileNotFoundException {
    StringReader input = new StringReader("load res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("res/red/redPPM.ppm has been loaded as red"));
  }

  @Test
  public void testManipulateImageSave() throws FileNotFoundException {
    StringReader input = new StringReader("save red res/red/redPPM.ppm\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageController controller = new ImageController(model,
            new ImageProcessorView(output), input);
    Pixel red = new Pixel(255, 0, 0);
    Pixel[][] redImage = new Pixel[][]{{red, red, red, red}, {red, red, red, red}};
    //model.save(redImage, "res/red/redPPM.ppm");
    controller.manipulateImages();

    assertTrue(output.toString().contains("res/red/redPPM.ppm has been loaded as red"));
  }

  //horizontal flip
  @Test
  public void testManipulateImageHFlip() throws FileNotFoundException {
    StringReader input = new StringReader("horizontal-flip res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' was flipped horizontally"));
  }

  //vertical flip
  @Test
  public void testManipulateImageVFlip() throws FileNotFoundException {
    StringReader input = new StringReader("vertical-flip res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' was flipped vertically"));
  }

  //brighten
  @Test
  public void testManipulateImageBrightness() throws FileNotFoundException {
    StringReader input = new StringReader("brighten res/red/redPPM.ppm 10 red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image was brightened by 10"));
  }

  //darken
  @Test
  public void testManipulateImageDarken() throws FileNotFoundException {
    StringReader input = new StringReader("brighten res/red/redPPM.ppm -10 red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image was darkened by -10"));
  }

  //grayscale red
  @Test
  public void testManipulateImageRGreyScale() throws FileNotFoundException {
    StringReader input = new StringReader("grayscale red res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' was greyscaled to Red"));
  }

  //grayscale green
  @Test
  public void testManipulateImageGGreyScale() throws FileNotFoundException {
    StringReader input = new StringReader("grayscale green res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' was greyscaled to Green"));
  }

  //grayscale blue
  @Test
  public void testManipulateImageBGreyScale() throws FileNotFoundException {
    StringReader input = new StringReader("grayscale blue res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' was greyscaled to Blue"));
  }

  //value
  @Test
  public void testManipulateImageValue() throws FileNotFoundException {
    StringReader input = new StringReader("value res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().
            contains("image: 'res/red/redPPM.ppm' has changed to value RGB colors"));
  }

  //intensity
  @Test
  public void testManipulateImageIntensity() throws FileNotFoundException {
    StringReader input = new StringReader("intensity res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains(
            "image: 'res/red/redPPM.ppm' has changed to intensity RGB colors"));
  }

  //luma
  @Test
  public void testManipulateImageLuma() throws FileNotFoundException {
    StringReader input = new StringReader("luma res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().
            contains("image: 'res/red/redPPM.ppm' has changed to luma RGB colors"));
  }

  //blur
  @Test
  public void testManipulateImageBlur() throws FileNotFoundException {
    StringReader input = new StringReader("blur res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' has been blurred"));
  }

  //luma
  @Test
  public void testManipulateImageSharpen() throws FileNotFoundException {
    StringReader input = new StringReader("sharpen res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' has been sharpened"));
  }

  //luma
  @Test
  public void testManipulateImageGrayscaleFilter() throws FileNotFoundException {
    StringReader input = new StringReader("grayscale-filter res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' has grayscale filter"));
  }

  //sepia
  @Test
  public void testManipulateImageSepia() throws FileNotFoundException {
    StringReader input = new StringReader("sepia res/red/redPPM.ppm red\nquit");
    StringBuilder output = new StringBuilder();
    ImageProcessor model = new ImageProcessor();
    ImageController controller = new ImageController(new ImageProcessorMock(output),
            new ImageProcessorView(output), input);
    model.load("res/red/redPPM.ppm", "red");
    controller.manipulateImages();

    assertTrue(output.toString().contains("image: 'res/red/redPPM.ppm' has sepia filter"));
  }

}
