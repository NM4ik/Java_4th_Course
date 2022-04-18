package ru.jokerMask.utl;

import javax.swing.*;
import java.awt.*;

public class DialogUtil {
    public static void showError(Component component, String text) {
        JOptionPane.showMessageDialog(component, text, "Ошибка", JOptionPane.ERROR_MESSAGE);
    }

    public static void showInfo(Component component, String text) {
        JOptionPane.showMessageDialog(component, text, "Информация", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showWarn(Component component, String text) {
        JOptionPane.showMessageDialog(component, text, "Предупреждение", JOptionPane.WARNING_MESSAGE);
    }
}
