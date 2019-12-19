package processing.app.javax.swing.filechooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class SaveErrorMessage{
  private JFrame frame;

  public SaveErrorMessage(String message, JButton buttonBrowse) {
    showSaveFileDialog(message);
  }

  private void showSaveFileDialog(String message) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify the name");
    int userSelection = fileChooser.showSaveDialog(frame);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
      File fileToSave = fileChooser.getSelectedFile();
      try {
        File newTextFile = new File(fileToSave.getAbsolutePath());
        FileWriter fw = new FileWriter(newTextFile);
        fw.write(message);
        fw.close();
      } catch (IOException iox) {
        iox.printStackTrace();
      }
    }
  }
}
