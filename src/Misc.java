import javax.swing.JOptionPane;

public class Misc {

    public static Integer getInteger(String text) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(text));
        } catch (Exception exception) {
            showMessage("The value entered is wrong");
            return getInteger(text);
        }
    }

    public static String getString(String text) {
        return JOptionPane.showInputDialog(text);
    }

    public static Float getFloat(String text) {
        try {
            return Float.parseFloat(JOptionPane.showInputDialog(text));
        } catch (Exception exception) {
            showMessage("The value entered is wrong");
            return getFloat(text);
        }
    }

    public static void showMessage(String text) {
        JOptionPane.showMessageDialog(null, text);
    }
}
