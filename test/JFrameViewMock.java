import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Pixel;
import view.JView;

/**
 * JFrameView mock for testing.
 */
public class JFrameViewMock extends JFrame implements JView  {

  private StringBuilder log;


  /**
   * Constructs the JFrameView Mock.
   * @param log stringbuilder
   */
  public JFrameViewMock(StringBuilder log) {
    this.log = log;
  }

  @Override
  public void setListerner(ActionListener listener) {
    this.log.append("listener has been set");
  }

  @Override
  public String showFileExplorer() {
    this.log.append("file explorer is showing");
    return null;
  }

  @Override
  public String saveFile() {
    this.log.append("file of path taken");
    return null;
  }

  @Override
  public void showImage(String imagePath) {
    this.log.append("is shown on gui");
  }

  @Override
  public String showPopup() {
    this.log.append("pop up shown");
    return null;
  }

  @Override
  public void updateImage(Pixel[][] image) {
    this.log.append("has been updated");
  }


  @Override
  public void setPixelImage(Pixel[][] array) {
    this.log.append("image set in histogram");
  }
}
