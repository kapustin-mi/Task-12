package cs.vsu.ru.kapustin;

import javax.swing.*;

public class ErrorMessages {

    public static void showErrorMessage(int errorCode) {
        String message = null;

        if (errorCode == 0) {
            message = "Unable to save image to selected file.";
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
