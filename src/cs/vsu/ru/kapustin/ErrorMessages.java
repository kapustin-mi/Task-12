package cs.vsu.ru.kapustin;

import javax.swing.*;

public class ErrorMessages {

    public static void showErrorMessage(int errorCode) {
        String message = null;

        if (errorCode == 0) {
            message = "It is impossible to perform the action, because there is no picture.";
        }
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
