package model;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;

/**
 * Represents a class that manipulates image with certain commands.
 */
public class ImageProcessor implements Model {
  private final HashMap<String, Pixel[][]> imageLibrary;


  /**
   * Constructs the ImageProcessor that makes a new imageLibrary which is where all the
   * manipulated images will be located.
   */
  public ImageProcessor() {
    this.imageLibrary = new HashMap<>();


  }

  @Override
  public void load(String filename, String name) throws IllegalStateException {
    System.out.println(name);
    File image = new File(filename);
    System.out.println(image);
    Scanner sc;
    Pixel[][] loadedImage;
    BufferedImage buffImg;
    if (!filename.endsWith(".ppm")) {
      try {
        buffImg = ImageIO.read(image);
      } catch (IOException e) {
        throw new IllegalStateException("File couldn't be read");
      }
      System.out.println(buffImg);
      loadedImage = new Pixel[buffImg.getHeight()][buffImg.getWidth()];
      for (int y = 0; y < buffImg.getHeight(); y++) {
        for (int x = 0; x < buffImg.getWidth(); x++) {
          Color c = new Color(buffImg.getRGB(x, y));
          loadedImage[y][x] = new Pixel(c.getRed(), c.getGreen(), c.getBlue());
        }
      }
    } else {

      try {
        sc = new Scanner(new FileInputStream(filename));
      } catch (FileNotFoundException e) {
        throw new IllegalStateException("file can't be found");
      }

      StringBuilder builder = new StringBuilder();
      //read the file line by line, and populate a string. This will throw away any comment lines
      while (sc.hasNextLine()) {
        String s = sc.nextLine();
        if (s.charAt(0) != '#') {
          builder.append(s).append(System.lineSeparator());
        }
      }

      //now set up the scanner to read from the string we just built
      sc = new Scanner(builder.toString());

      String token;

      token = sc.next();
      if (!token.equals("P3")) {
        System.out.println("Invalid PPM file: plain RAW file should begin with P3");
      }
      int width = sc.nextInt();
      int height = sc.nextInt();
      sc.next();

      loadedImage = new Pixel[height][width];
      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          loadedImage[row][col] = new Pixel(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
      }
    }
    this.imageLibrary.put(name, loadedImage);
  }

  @Override
  public void save(Pixel[][] image, String path) throws IOException, IllegalArgumentException {

    System.out.println(path);

    if (!path.endsWith(".ppm")
        && !path.endsWith(".bmp")
        && !path.endsWith(".png")
        && !path.endsWith(".jpg")) {
      throw new IllegalArgumentException("File must end with an image extension");
    }

    if (!path.endsWith("ppm")) {
      BufferedImage bfImage = new BufferedImage(image[0].length, image.length,
              BufferedImage.TYPE_INT_RGB);
      for (int y = 0; y < bfImage.getHeight(); y++) {
        for (int x = 0; x < bfImage.getWidth(); x++) {
          Color c = new Color(image[y][x].getRed(), image[y][x].getGreen(), image[y][x].getBlue());
          int bfColor = c.getRGB();
          bfImage.setRGB(x, y, bfColor);
        }
      }
      ImageIO.write(bfImage, path.substring(path.length() - 3), new File(path));
    } else {
      FileImageOutputStream fs = new FileImageOutputStream(new File(path));

      fs.write(("P3\n" + image[0].length + " " + image.length + "\n" + "255\n").getBytes());
      for (Pixel[] pixels : image) {
        for (int col = 0; col < image[0].length; col++) {
          fs.write((pixels[col].getRed() + "\n").getBytes());
          fs.write((pixels[col].getGreen() + "\n").getBytes());
          fs.write((pixels[col].getBlue() + "\n").getBytes());
        }
      }
    }
  }

  @Override
  public void flip(String imageName, boolean horizontal) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = this.imageLibrary.get(imageName);

    int height = image.length;
    int width = image[0].length;

    Pixel[][] imageClone = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        imageClone[i][j] = new Pixel(image[i][j].getRed(),
                image[i][j].getGreen(), image[i][j].getBlue());
      }
    }
    if (horizontal) {
      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          image[row][col] = new Pixel(imageClone[row][width - 1 - col].getRed(),
                  imageClone[row][width - 1 - col].getGreen(),
                  imageClone[row][width - 1 - col].getBlue());
        }
      }
    } else {
      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          image[row][col] = new Pixel(imageClone[height - 1 - row][col].getRed(),
                  imageClone[height - 1 - row][col].getGreen(),
                  imageClone[height - 1 - row][col].getBlue());
        }
      }
    }
  }

  //TODO Document the no clamping
  @Override
  public void brighten(String imageName, int brightnessValue)
          throws ImageNotFoundException, IllegalArgumentException {
    imageNotFound(imageName);
    Pixel[][] image = this.imageLibrary.get(imageName);


    for (Pixel[] pixels : image) {
      for (int col = 0; col < image[0].length; col++) {

        if (brightnessValue < 0) {
          pixels[col].setRed(Math.max(pixels[col].getRed() + brightnessValue, 0));
          pixels[col].setGreen(Math.max(pixels[col].getGreen() + brightnessValue, 0));
          pixels[col].setBlue(Math.max(pixels[col].getBlue() + brightnessValue, 0));
        } else {
          pixels[col].setRed(Math.min(pixels[col].getRed() + brightnessValue, 255));
          pixels[col].setGreen(Math.min(pixels[col].getGreen() + brightnessValue, 255));
          pixels[col].setBlue(Math.min(pixels[col].getBlue() + brightnessValue, 255));
        }
      }
    }
  }

  @Override
  public void grayscale(String imageName, Grayscale color) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = this.imageLibrary.get(imageName);

    for (Pixel[] pixels : image) {
      for (int col = 0; col < image[0].length; col++) {
        switch (color) {
          case Red:
            pixels[col].setGreen(pixels[col].getRed());
            pixels[col].setBlue(pixels[col].getRed());
            break;

          case Green:
            pixels[col].setRed(pixels[col].getGreen());
            pixels[col].setBlue(pixels[col].getGreen());
            break;

          case Blue:
            pixels[col].setRed(pixels[col].getBlue());
            pixels[col].setGreen(pixels[col].getBlue());
            break;
          default:
            throw new IllegalStateException();
        }
      }
    }
  }

  @Override
  public void value(String imageName) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = this.imageLibrary.get(imageName);

    for (Pixel[] pixels : image) {
      for (int col = 0; col < image[0].length; col++) {
        int maxValue = Math.max(pixels[col].getRed(), Math.max(pixels[col].getGreen(),
                pixels[col].getBlue()));

        pixels[col].setRed(maxValue);
        pixels[col].setGreen(maxValue);
        pixels[col].setBlue(maxValue);
      }
    }
  }

  @Override
  public void intensity(String imageName) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = this.imageLibrary.get(imageName);

    for (Pixel[] pixels : image) {
      for (int col = 0; col < image[0].length; col++) {
        int avg = (pixels[col].getRed() + pixels[col].getGreen() + pixels[col].getBlue()) / 3;

        pixels[col].setRed(avg);
        pixels[col].setGreen(avg);
        pixels[col].setBlue(avg);
      }
    }
  }

  @Override
  public void luma(String imageName) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = this.imageLibrary.get(imageName);

    for (Pixel[] pixels : image) {
      for (int col = 0; col < image[0].length; col++) {
        double avg = 0.2126 * pixels[col].getRed() + 0.7152 * pixels[col].getGreen()
                     + 0.0722 * pixels[col].getBlue();
        int avgRounded = (int) Math.round(avg);

        pixels[col].setRed(avgRounded);
        pixels[col].setGreen(avgRounded);
        pixels[col].setBlue(avgRounded);
      }
    }
  }

  @Override
  public HashMap<String, Pixel[][]> getImageLibrary() {
    return this.imageLibrary;
  }

  private void imageNotFound(String imageName) {
    if (this.imageLibrary.get(imageName) == null) {
      throw new ImageNotFoundException(imageName + " cannot be found");
    }
  }

  @Override
  public void filtering(String imageName, double[][] kernel) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = imageLibrary.get(imageName);


    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        filteringHelp(image, row, col, kernel);
      }
    }
  }

  private void filteringHelp(Pixel[][] image, int row, int col, double[][] kernel) {


    double sumProductRed = 0;
    double sumProductGreen = 0;
    double sumProductBlue = 0;


    for (int kRow = 0; kRow < kernel.length; kRow++) {
      for (int kCol = 0; kCol < kernel.length; kCol++) {
        try {
          sumProductRed += kernel[kRow][kCol] * image[row + kRow - 1][col + kCol - 1].getRed();
          sumProductGreen += kernel[kRow][kCol] * image[row + kRow - 1][col + kCol - 1].getGreen();
          sumProductBlue += kernel[kRow][kCol] * image[row + kRow - 1][col + kCol - 1].getBlue();
        } catch (IndexOutOfBoundsException ignored) {
        }

      }
    }

    int finalRed = Math.min(255, (int) Math.round(sumProductRed));
    finalRed = Math.max(0, finalRed);

    int finalGreen = Math.min(255, (int) Math.round(sumProductGreen));
    finalGreen = Math.max(0, finalGreen);

    int finalBlue = Math.min(255, (int) Math.round(sumProductBlue));
    finalBlue = Math.max(0, finalBlue);

    image[row][col].setRed(Math.round(finalRed));
    image[row][col].setGreen(Math.round(finalGreen));
    image[row][col].setBlue(Math.round(finalBlue));
  }

  @Override
  public void grayscaleFilter(String imageName) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = imageLibrary.get(imageName);


    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        grayscaleFilterHelp(image, row, col);
      }
    }
  }

  private void grayscaleFilterHelp(Pixel[][] image, int row, int col) {
    double[] fakeKernel = {0.2126, 0.7152, 0.0722};

    double sumProductRed = 0;
    double sumProductGreen = 0;
    double sumProductBlue = 0;

    sumProductRed += fakeKernel[0] * image[row][col].getRed();
    sumProductGreen += fakeKernel[1] * image[row][col].getGreen();
    sumProductBlue += fakeKernel[2] * image[row][col].getBlue();


    image[row][col].setRed((int) (Math.round(sumProductRed + sumProductGreen + sumProductBlue)));
    image[row][col].setGreen((int) (Math.round(sumProductRed + sumProductGreen + sumProductBlue)));
    image[row][col].setBlue((int) (Math.round(sumProductRed + sumProductGreen + sumProductBlue)));

  }

  @Override
  public void sepia(String imageName) throws ImageNotFoundException {
    imageNotFound(imageName);
    Pixel[][] image = imageLibrary.get(imageName);

    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        sepiaHelper(image, row, col);
      }
    }
  }

  private void sepiaHelper(Pixel[][] image, int row, int col) {
    double[][] fakeKernel =
        {{0.393, 0.769, 0.189},
        {0.349, 0.686, 0.168},
        {0.272, 0.534, 0.131}};

    int red = image[row][col].getRed();
    int green = image[row][col].getGreen();
    int blue = image[row][col].getBlue();

    for (int kRow = 0; kRow < 3; kRow++) {

      double sumProductRed = fakeKernel[kRow][0] * red;
      double sumProductGreen = fakeKernel[kRow][1] * green;
      double sumProductBlue = fakeKernel[kRow][2] * blue;

      int finalNumber =
              Math.min(255, (int) Math.round(sumProductRed + sumProductGreen + sumProductBlue));
      finalNumber = Math.max(0, finalNumber);

      switch (kRow) {
        case 0:
          image[row][col].setRed(finalNumber);
          break;

        case 1:
          image[row][col].setGreen(finalNumber);
          break;

        case 2:
          image[row][col].setBlue(finalNumber);
          break;

        default:
          break;
      }
    }
  }
}
