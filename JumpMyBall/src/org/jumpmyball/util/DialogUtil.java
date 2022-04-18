package org.jumpmyball.util;

import javax.swing.*;
import java.awt.*;

public class DialogUtil extends JFrame {

    public static void showError(Component component, String text) {
        JOptionPane.showMessageDialog(component, text, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

}
