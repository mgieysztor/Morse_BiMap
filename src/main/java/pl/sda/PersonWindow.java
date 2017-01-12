package pl.sda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

/**
 * Created by RENT on 2017-01-12.
 */
public class PersonWindow extends JFrame {
    public PersonWindow() throws HeadlessException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(null);
        JButton button = new JButton("Kliknij mnie");
        button.setSize(200, 50);
        button.setLocation(0, 0);
        add(button);

        JTextField textField = new JTextField();
        textField.setSize(100, 50);
        textField.setLocation(0, 50);
        add(textField);

        JList jList = new JList<>();
        jList.setSize(500,200);
        jList.setLocation(0,100);
        add(jList);

        java.util.List personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Waldemar", "Mickiewicz", 1960));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1970));
        personList.add(new Person("Franciszek", "Mickiewicz", 1970));
        personList.add(new Person("Łukasz", "Mickiewicz", 1970));
        personList.add(new Person("Edward", "Wojciechowski", 1970));
        personList.add(new Person("Adam", "Kowalski", 1970));

        //zadania po kliknięciu na listę niech na dole w JLabel, albo textarea i tam ładnie wyświetli dane podświetlonej osoby
        //4 przyciski sortuj po imieniu, nazwisku, dacie urodzenia, po wszystkim

        jList.setListData(personList.toArray());
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (textField.getText().isEmpty()) {

                    textField.setText("CZESC!");
                } else {
                    textField.setText("");

                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        new PersonWindow();
    }
}
