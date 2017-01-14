package pl.sda;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

import static com.sun.xml.internal.ws.util.VersionUtil.compare;

/**
 * Created by RENT on 2017-01-12.
 */
public class PersonWindow extends JFrame {
    public PersonWindow() throws HeadlessException {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLayout(null);
        JButton button = new JButton("Kliknij mnie");
        button.setSize(200, 50);
        button.setLocation(0, 0);
        add(button);

        JTextField textField = new JTextField();
        textField.setSize(100, 50);
        textField.setLocation(0, 50);
        add(textField);

        JList <Person> jList = new JList<>();
        jList.setSize(500,150);
        jList.setLocation(0,100);
        add(jList);

        java.util.List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Waldemar", "Mickiewicz", 1960));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1970));
        personList.add(new Person("Franciszek", "Mickiewicz", 1970));
        personList.add(new Person("Łukasz", "Mickiewicz", 1970));
        personList.add(new Person("Edward", "Wojciechowski", 1970));
        personList.add(new Person("Adam", "Kowalski", 1970));

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(500,20));
        textArea.setLocation(0,280);
        textArea.setSize(500,100);

        add(textArea);
        textArea.repaint();
//        List list = new ArrayList(); //to jest lista z klasy java.util przechowująca obiekty jakiekolwiek
        List <Person> list = new ArrayList();
        list.add(new Person("Adam","Adamski",1970));



        //zadania po kliknięciu na listę niech na dole w JLabel, albo textarea i tam ładnie wyświetli dane podświetlonej osoby
        //4 przyciski sortuj po imieniu, nazwisku, dacie urodzenia, po wszystkim
        //jComboBox jako wybór metody sortowania



        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()){
                    Object object = jList.getSelectedValue();
                    Person person = (Person)object;
                    textArea.setText(person.toComplexString());


                    System.out.println(object);
                }
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        //poniższe przetestować/przeanalizować
        Object[] objects = personList.toArray();
        Person[] persons = personList.toArray(new Person[personList.size()]);

        jList.setListData(persons);



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
