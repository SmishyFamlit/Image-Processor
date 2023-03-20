package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import controller.commands.Blur;
import controller.commands.Brighten;
import controller.commands.Grayscale;
import controller.commands.HorizontalFlip;
import controller.commands.ImageCommands;
import controller.commands.Intensity;
import controller.commands.Load;
import controller.commands.Luma;
import controller.commands.GrayscaleFilter;
import controller.commands.Save;
import controller.commands.Sepia;
import controller.commands.Sharpen;
import controller.commands.Value;
import controller.commands.VerticalFlip;
import model.ImageNotFoundException;
import model.Model;
import model.Pixel;
import view.View;


/**
 * Represents an implementation of the controller.
 */
public class ImageController implements Controller {


  private final Model imageModel;
  private final View imageView;
  private Readable input;

  /**
   * Constructs the controller impl.
   *
   * @param imageModel the model passed through
   * @param imageView  the view passed through
   * @param input      the input passed through
   * @throws IllegalArgumentException if any of the args are null
   */
  public ImageController(Model imageModel, View imageView
          , Readable input) throws IllegalArgumentException {
    if (imageModel == null || imageView == null || input == null) {
      throw new IllegalArgumentException("Arguments can't be of type null");
    }

    this.imageModel = imageModel;
    this.imageView = imageView;
    this.input = input;

  }

  /**
   * Constructs the ImageController, only taking in 2 parameters.
   * @param imageModel the imageProcessor model
   * @param imageView the image view
   * @throws IllegalArgumentException when model or view are null
   */
  public ImageController(Model imageModel, View imageView)
          throws IllegalArgumentException {
    if (imageModel == null || imageView == null) {
      throw new IllegalArgumentException("Arguments can't be of type null");
    }

    this.imageModel = imageModel;
    this.imageView = imageView;

  }


  /**
   * Is the controller to manipulate images.
   *
   * @throws IllegalStateException if the IOException is thrown
   */
  public void manipulateImages() throws IllegalStateException {
    Scanner sc = new Scanner(this.input);

    ImageCommands cmd = null;
    boolean isQuit = false;
    String help = "These are the commands:\n" +
                  "load <filename> <image-name>\n" +
                  "save <image-name> <filepath>\n" +
                  "horizontal-flip <image-name> <new-image-name>\n" +
                  "vertical-flip <image-name> <new-image-name>\n" +
                  "luma <image-name> <new-image-name>\n" +
                  "value <image-name> <new-image-name>\n" +
                  "intensity <image-name> <new-image-name>\n" +
                  "brighten <image-name> <value> <new-image-name>\n" +
                  "darken <image-name> <value> <new-image-name>\n" +
                  "grayscale <RGB component> <image-name> <new-image-name>\n" +
                  "grayscale-filter <image-name> <new-image-name>\n" +
                  "sepia <image-name> <new-image-name>\n" +
                  "blur <image-name> <new-image-name>\n" +
                  "sharpen <image-name> <new-image-name>\n" +
                  "quit\n" +
                  "--help\n";
    renderAndThrowMessage("for a list of the following commands type \"--help\"");
    while (!isQuit) {
      HashMap<String, Pixel[][]> imageLibrary = this.imageModel.getImageLibrary();

      String command = sc.next();
      String originalName = "";
      String printedMsg = "";
      switch (command) {
        case "--help":
          renderAndThrowMessage(help);
          break;
        case "quit":
          renderAndThrowMessage("program has been terminated");
          return;

        case "load":
          originalName = sc.next();
          String nameLoadedAs = sc.next();
          cmd = new Load(originalName, nameLoadedAs);
          printedMsg = originalName + " has been loaded as " + nameLoadedAs;
          break;

        case "save":
          originalName = sc.next();
          String path = sc.next();
          cmd = new Save(imageLibrary.get(originalName), path);
          break;

        case "horizontal-flip":
          originalName = sc.next();
          cmd = new HorizontalFlip(originalName);
          printedMsg = originalName + " has been flipped horizontally";

          break;

        case "vertical-flip":
          originalName = sc.next();
          cmd = new VerticalFlip(originalName);
          printedMsg = originalName + " has been flipped vertically";

          break;

        case "brighten":
          int bValue;
          originalName = sc.next();
          bValue = sc.nextInt();
          cmd = new Brighten(originalName, bValue);
          if (bValue < 0) {
            printedMsg = originalName + " has been darkened by " + Math.abs(bValue);
          } else {
            printedMsg = originalName + " has been brightened by " + bValue;
          }
          break;

        case "grayscale":
          String grayScaleType = sc.next();
          originalName = sc.next();
          cmd = new Grayscale(originalName, grayScaleType);
          printedMsg = originalName + " has been changed to specified grayscale" +
                       " components";
          break;

        case "value":
          originalName = sc.next();
          cmd = new Value(originalName);
          printedMsg = originalName + " has been changed to the value RGB colors";
          break;

        case "intensity":
          originalName = sc.next();
          cmd = new Intensity(originalName);
          printedMsg = originalName + " has been changed to the intensity RGB colors";
          break;

        case "luma":
          originalName = sc.next();
          cmd = new Luma(originalName);
          printedMsg = originalName + " has been changed to the luma RGB colors";
          break;

        case "blur":
          originalName = sc.next();
          cmd = new Blur(originalName);
          printedMsg = originalName + " has been blurred";
          break;

        case "sharpen":
          originalName = sc.next();
          cmd = new Sharpen(originalName);
          printedMsg = originalName + " has been sharpened";
          break;

        case "grayscale-filter":
          originalName = sc.next();
          cmd = new GrayscaleFilter(originalName);
          printedMsg = originalName + " has been filtered to grayscale";
          break;

        case "sepia":
          originalName = sc.next();
          cmd = new Sepia(originalName);
          printedMsg = originalName + " has been transformed to sepia";
          break;

        default:
          renderAndThrowMessage("Command \"" + command + "\" can't be found, try again");
          cmd = null;
          sc.nextLine();
          break;
      }

      if (cmd != null) {
        try {
          cmd.apply(this.imageModel);
          renderAndThrowMessage(printedMsg);
          imageLibrary.put(sc.next(), imageLibrary.get(originalName));
          sc.nextLine();
          cmd = null;
        } catch (FileNotFoundException e) {
          renderAndThrowMessage("File path is incorrect try again");
          sc.nextLine();
        } catch (ImageNotFoundException e) {
          renderAndThrowMessage(originalName + " can't be found, try again");
          sc.nextLine();
        } catch (IllegalArgumentException e) {
          renderAndThrowMessage("value is incorrect, try again");
          sc.nextLine();
        } catch (NullPointerException e) {
          renderAndThrowMessage("image can't be found, try again");
        } catch (IllegalStateException e) {
          renderAndThrowMessage("File location can't be found, try again");
        } catch (IOException ignored) {

        }
      }
    }
  }

  private void renderAndThrowMessage(String message) {
    try {
      this.imageView.renderMessage(message + "\n");
    } catch (IOException e) {
      throw new IllegalStateException("This can't be done");
    }
  }
}
