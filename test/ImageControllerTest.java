import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;

import controller.ImageController;
import model.Pixel;
import view.ImageProcessorView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Represents test for the controller.
 */
public class ImageControllerTest {

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

  @Test
  public void testLoadPPM() throws FileNotFoundException {
    StringReader input = new StringReader("load res/red/redPPM.ppm red");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    //makes own picture and puts in imageLibrary
    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    Pixel red = new Pixel(255, 0, 0);
    Pixel[][] originalImage = new Pixel[][]{{red, red, red, red}, {red, red, red, red}};
    imageLibrary.put("originalImage", originalImage);

    ImageController controller = new ImageController(model, view, input);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPPM.ppm", "red");
    Pixel[][]fileImage = imageLibrary.get("red");

    //compares the image taken from file to the manually made array.
    assertTrue(isSameImage(fileImage, originalImage));
  }

  @Test
  public void testLoadPNG() throws FileNotFoundException {
    StringReader input = new StringReader("load res/red/redPNG.png red");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    //makes own picture and puts in imageLibrary
    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    Pixel red = new Pixel(255, 0, 0);
    Pixel[][] originalImage = new Pixel[][]{{red, red, red, red}, {red, red, red, red}};
    imageLibrary.put("originalImage", originalImage);

    ImageController controller = new ImageController(model, view, input);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPNG.png", "red");
    Pixel[][]fileImage = imageLibrary.get("red");

    //compares the image taken from file to the manually made array.
    assertTrue(isSameImage(fileImage, originalImage));
  }

  @Test
  public void testLoadJPG() throws FileNotFoundException {
    StringReader input = new StringReader("load res/red/redJPG.jpg red");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    //makes own picture and puts in imageLibrary
    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    Pixel red = new Pixel(254, 0, 0);
    Pixel[][] originalImage = new Pixel[][]{{red, red, red, red}, {red, red, red, red}};
    imageLibrary.put("originalImage", originalImage);

    ImageController controller = new ImageController(model, view, input);

    //loads the fileImage int imagelibrary
    model.load("res/red/redJPG.jpg", "red");
    Pixel[][]fileImage = imageLibrary.get("red");

    //compares the image taken from file to the manually made array.
    assertTrue(isSameImage(fileImage, originalImage));
  }

  @Test
  public void testLoadBMP() throws FileNotFoundException {
    StringReader input = new StringReader("load res/red/redBMP.bmp red");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    //makes own picture and puts in imageLibrary
    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    Pixel red = new Pixel(255, 0, 0);
    Pixel[][] originalImage = new Pixel[][]{{red, red, red, red}, {red, red, red, red}};
    imageLibrary.put("originalImage", originalImage);

    ImageController controller = new ImageController(model, view, input);

    //loads the fileImage int imagelibrary
    model.load("res/red/redBMP.bmp", "red");
    Pixel[][]fileImage = imageLibrary.get("red");

    //compares the image taken from file to the manually made array.
    assertTrue(isSameImage(fileImage, originalImage));
  }


  //////////////////////PPM -> other//////////////////////////////////////////////
  @Test
  public void testSavePPM1PPM() throws IOException {
    StringReader input = new StringReader("load res/red/redPPM.ppm red");
    StringReader input2 = new StringReader("save red res/red/redNEW.ppm");
    StringReader input3 = new StringReader("load res/red/redNEW.ppm redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPPM.ppm", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.ppm");
    model.load("res/red/redNEW.ppm", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSavePPM1PNG() throws IOException {
    StringReader input = new StringReader("load res/red/redPPM.ppm red");
    StringReader input2 = new StringReader("save red res/red/redNEW.png");
    StringReader input3 = new StringReader("load res/red/redNEW.png redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPPM.ppm", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.png");
    model.load("res/red/redNEW.png", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSavePPM1JPG() throws IOException {
    StringReader input = new StringReader("load res/red/redPPM.ppm red");
    StringReader input2 = new StringReader("save red res/red/redNEW.jpg");
    StringReader input3 = new StringReader("load res/red/redNEW.jpg redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPPM.ppm", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.jpg");
    model.load("res/red/redNEW.jpg", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSavePPM1BMP() throws IOException {
    StringReader input = new StringReader("load res/red/redPPM.ppm red");
    StringReader input2 = new StringReader("save red res/red/redNEW.bmp");
    StringReader input3 = new StringReader("load res/red/redNEW.bmp redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPPM.ppm", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.bmp");
    model.load("res/red/redNEW.bmp", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  //////////////////////PNG -> other//////////////////////////////////////////////
  @Test
  public void testSavePNG1PPM() throws IOException {
    StringReader input = new StringReader("load res/red/redPNG.png red");
    StringReader input2 = new StringReader("save red res/red/redNEW.ppm");
    StringReader input3 = new StringReader("load res/red/redNEW.ppm redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPNG.png", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.ppm");
    model.load("res/red/redNEW.ppm", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSavePNG1PNG() throws IOException {
    StringReader input = new StringReader("load res/red/redPNG.png red");
    StringReader input2 = new StringReader("save red res/red/redNEW.png");
    StringReader input3 = new StringReader("load res/red/redNEW.png redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPNG.png", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.png");
    model.load("res/red/redNEW.png", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSavePNG1JPG() throws IOException {
    StringReader input = new StringReader("load res/red/redPNG.png red");
    StringReader input2 = new StringReader("save red res/red/redNEW1.jpg");
    StringReader input3 = new StringReader("load res/red/redNEW1.jpg redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPNG.png", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW1.jpg");
    model.load("res/red/redNEW1.jpg", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSavePNG1BMP() throws IOException {
    StringReader input = new StringReader("load res/red/redPNG.png red");
    StringReader input2 = new StringReader("save red res/red/redNEW.bmp");
    StringReader input3 = new StringReader("load res/red/redNEW.bmp redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redPNG.png", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.bmp");
    model.load("res/red/redNEW.bmp", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  //////////////////////JPG -> other//////////////////////////////////////////////
  @Test
  public void testSaveJPG1PPM() throws IOException {
    StringReader input = new StringReader("load res/red/redJPG.jpg red");
    StringReader input2 = new StringReader("save red res/red/redNEW.ppm");
    StringReader input3 = new StringReader("load res/red/redNEW.ppm redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redJPG.jpg", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.ppm");
    model.load("res/red/redNEW.ppm", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSaveJPG1PNG() throws IOException {
    StringReader input = new StringReader("load res/red/redJPG.jpg red");
    StringReader input2 = new StringReader("save red res/red/redNEW.png");
    StringReader input3 = new StringReader("load res/red/redNEW.png redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redJPG.jpg", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.png");
    model.load("res/red/redNEW.png", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSaveJPG1JPG() throws IOException {
    StringReader input = new StringReader("load res/red/redJPG.jpg red");
    StringReader input2 = new StringReader("save red res/red/redNEW.jpg");
    StringReader input3 = new StringReader("load res/red/redNEW.jpg redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redJPG.jpg", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.jpg");
    model.load("res/red/redNEW.jpg", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSaveJPG1BMP() throws IOException {
    StringReader input = new StringReader("load res/red/redJPG.jpg red");
    StringReader input2 = new StringReader("save red res/red/redNEW.bmp");
    StringReader input3 = new StringReader("load res/red/redNEW.bmp redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redJPG.jpg", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.bmp");
    model.load("res/red/redNEW.bmp", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  //////////////////////BMP -> other//////////////////////////////////////////////
  @Test
  public void testSaveBMP1PPM() throws IOException {
    StringReader input = new StringReader("load res/red/redBMP.bmp red");
    StringReader input2 = new StringReader("save red res/red/redNEW.ppm");
    StringReader input3 = new StringReader("load res/red/redNEW.ppm redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redBMP.bmp", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.ppm");
    model.load("res/red/redNEW.ppm", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSaveBMP1PNG() throws IOException {
    StringReader input = new StringReader("load res/red/redBMP.bmp red");
    StringReader input2 = new StringReader("save red res/red/redNEW.png");
    StringReader input3 = new StringReader("load res/red/redNEW.png redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redBMP.bmp", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.png");
    model.load("res/red/redNEW.png", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSaveBMP1JPG() throws IOException {
    StringReader input = new StringReader("load res/red/redBMP.bmp red");
    StringReader input2 = new StringReader("save red res/red/redNEW.jpg");
    StringReader input3 = new StringReader("load res/red/redNEW.jpg redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redBMP.bmp", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.jpg");
    model.load("res/red/redNEW.jpg", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testSaveBMP1BMP() throws IOException {
    StringReader input = new StringReader("load res/red/redBMP.bmp red");
    StringReader input2 = new StringReader("save red res/red/redNEW.bmp");
    StringReader input3 = new StringReader("load res/red/redNEW.bmp redNEW");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);

    HashMap<String, Pixel[][]> imageLibrary = model.getImageLibrary();
    ImageController controller = new ImageController(model, view, input);
    ImageController controller2 = new ImageController(model, view, input2);
    ImageController controller3 = new ImageController(model, view, input3);

    //loads the fileImage int imagelibrary
    model.load("res/red/redBMP.bmp", "red");
    Pixel[][]firstImage = imageLibrary.get("red");
    model.save(firstImage, "res/red/redNEW.bmp");
    model.load("res/red/redNEW.bmp", "redNEW");
    Pixel[][]secondImage = imageLibrary.get("redNEW");

    assertTrue(isSameImage(firstImage, secondImage));
  }

  @Test
  public void testInvalidFile() throws IllegalStateException {
    StringReader input = new StringReader("load random/redBMP.bmp red");
    StringBuilder output = new StringBuilder();
    ImageProcessorMock model = new ImageProcessorMock(output);
    ImageProcessorView view = new ImageProcessorView(output);
    ImageController controller = new ImageController(model, view, input);

    try {
      model.load("random/redBMP.bmp", "red");
      fail("IllegalStateException not found");
    }
    catch (IllegalStateException e) {
      e.getStackTrace();
    }
  }


}



