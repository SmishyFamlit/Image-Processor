package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import model.Model;
import model.Pixel;
import view.JView;

/**
 * Controller to show the GUI of the program.
 */
public class GuiControllerImpl implements ActionListener {

  private final Model model;
  private final JView guiView;
  private String loadedName;

  /**
   * Controller to show the GUI of the program.
   *
   * @param model   imageProcessing model
   * @param guiView the GUI view
   */
  public GuiControllerImpl(Model model, JView guiView) {
    this.model = model;
    this.guiView = guiView;
    this.guiView.setListerner(this);
    this.loadedName = "";

  }


  @Override
  public void actionPerformed(ActionEvent e) {
    HashMap<String, Pixel[][]> imageLibrary = this.model.getImageLibrary();
    switch (e.getActionCommand()) {

      case "Load Button":
        String path = this.guiView.showFileExplorer();
        this.loadedName = this.guiView.showPopup();
        this.model.load(path, this.loadedName);
        this.guiView.setPixelImage(imageLibrary.get(this.loadedName));
        this.guiView.showImage(path);
        break;

      case "Horizontal Button":
        this.model.flip(this.loadedName, true);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        break;

      case "Vertical Button":
        this.model.flip(this.loadedName, false);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        break;

      case "Blur Button":
        this.model.filtering(this.loadedName, new double[][]{{0.0625, 0.125, 0.0625},
            {0.125, 0.25, 0.125},
            {0.0625, 0.125, 0.0625}});
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Sharpen Button":
        this.model.filtering(this.loadedName, new double[][]
            {{-0.125, -0.125, -0.125, -0.125, -0.125}, {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, 0.25, 1.0, 0.25, -0.125}, {-0.125, 0.25, 0.25, 0.25, -0.125},
            {-0.125, -0.125, -0.125, -0.125, -0.125}});
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Value Button":
        this.model.value(this.loadedName);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Intensity Button":
        this.model.intensity(this.loadedName);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Luma Button":
        this.model.luma(this.loadedName);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Grayscale Button":
        this.model.grayscaleFilter(this.loadedName);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Sepia Button":
        this.model.sepia(this.loadedName);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Brighten Button":
        this.model.brighten(this.loadedName, Integer.parseInt(this.guiView.showPopup()));
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Darken Button":
        this.model.brighten(this.loadedName, -1 *
                Integer.parseInt(this.guiView.showPopup()));
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Red Button":
        this.model.grayscale(this.loadedName, Model.Grayscale.Red);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Blue Button":
        this.model.grayscale(this.loadedName, Model.Grayscale.Blue);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Green Button":
        this.model.grayscale(this.loadedName, Model.Grayscale.Green);
        imageLibrary.put("newName", imageLibrary.get(this.loadedName));
        this.guiView.updateImage(imageLibrary.get("newName"));
        this.guiView.setPixelImage(imageLibrary.get("newName"));
        break;

      case "Save Button":
        try {
          this.model.save(imageLibrary.get(this.loadedName), this.guiView.saveFile());
        } catch (IOException ex) {
          throw new RuntimeException(ex);
        }
        break;
      default:
        break;
    }
  }
}
