import java.io.InputStreamReader;

import controller.GuiControllerImpl;
import model.ImageProcessor;
import model.Model;
import view.JFrameView;
import view.JView;
import controller.ImageController;
import view.ImageProcessorView;
import view.View;
import controller.Controller;


/**
 * Main Method, runs the code.
 */
public class Main {

  /**
   * Main method, runs the code.
   * @param args script commands that passes through
   */
  public static void main(String[] args) {
    if (args.length == 4) {
      if (args[0].equals("java") && args[1].equals("-jar") && args[2].equals("image-processing.jar")
              && args[3].equals("-text")) {
        Model m = new ImageProcessor();
        View v = new ImageProcessorView(System.out);
        Controller c = new ImageController(m, v,new InputStreamReader(System.in));
        c.manipulateImages();
      }
    } else {
      if (args[0].equals("java") && args[1].equals("-jar") &&
              args[2].equals("image-processing.jar")) {
        Model m = new ImageProcessor();
        JView v = new JFrameView("Image Processor");
        GuiControllerImpl c = new GuiControllerImpl(m, v);
      }
    }
  }
}