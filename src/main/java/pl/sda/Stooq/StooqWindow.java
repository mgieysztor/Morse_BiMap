package pl.sda.Stooq;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Michał on 19-01-2017.
 */
public class StooqWindow extends JFrame {
    public StooqWindow() throws HeadlessException{
        JWindow mainWindow = new JWindow();
        mainWindow.setLocation(0,0);
        mainWindow.setSize(600,400  );
//        mainWindow.setVisible(true);
        setLayout(null);
    }
}
