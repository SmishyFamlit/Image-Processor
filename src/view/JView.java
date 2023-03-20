package view;

import java.awt.event.ActionListener;


import model.Pixel;

/**
 * View for GUI controller.
 */
public interface JView {

  /**
   * Set the listener for any action.
   * @param listener the ActionListener being set
   */
  void setListerner(ActionListener listener);

  /**
   * Shows the user the file explorer.
   * @return the path of the file you want to load
   */
  String showFileExplorer();

  /**
   * Shows a save window to popup.
   * @return the path to where you want to save the file
   */
  String saveFile();
  
  /**
   * Shows an image.
   * @param imagePath the path of the image that is being displayed to the screen.
   */
  void showImage(String imagePath);

  /**
   * Shows a pop-up that ask for text.
   */
  String showPopup();

  /**
   * Sets the displayed image the image being passed through.
   */
  void updateImage(Pixel[][] image);


  /**
   * Sets the double pixel array (image) for the histogram.
   */

  void setPixelImage(Pixel[][] array);

}
