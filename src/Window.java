import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    Drawing draw = new Drawing();

    public Window(String Title, int x, int y) {
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);


        Container contentPanel = this.getContentPane();

        //Menu Bar

        JMenuBar m = new JMenuBar();
        JMenu menu1 = new JMenu("File");

        JMenuItem New = new JMenuItem("New");
        New.addActionListener(this);
        menu1.add(New);

        JMenuItem Open = new JMenuItem("Open");
        Open.addActionListener(this);
        menu1.add(Open);

        JMenuItem Save = new JMenuItem("Save");
        Save.addActionListener(this);
        menu1.add(Save);

        JMenuItem Quit = new JMenuItem("Quit");
        Quit.addActionListener(this);
        menu1.add(Quit);

        JMenu menu2 = new JMenu("About");

        JMenuItem Author = new JMenuItem("Author");
        Author.addActionListener(this);
        menu2.add(Author);

        m.add(menu1);
        m.add(menu2);

        this.setJMenuBar(m);

        //Color Panel

        JPanel ColorPanel = new JPanel();
        ColorPanel.setLayout(new GridLayout(2, 4));

        JButton black = new JButton("Black");
        black.addActionListener(this);
        black.setBackground(Color.black);
        ColorPanel.add(black);

        JButton yellow = new JButton("Red");
        yellow.addActionListener(this);
        yellow.setBackground(Color.red);
        ColorPanel.add(yellow);

        JButton red = new JButton("Green");
        red.addActionListener(this);
        red.setBackground(Color.green);
        ColorPanel.add(red);

        JButton pink = new JButton("Blue");
        pink.addActionListener(this);
        pink.setBackground(Color.blue);
        ColorPanel.add(pink);

        JButton green = new JButton("Yellow");
        green.addActionListener(this);
        green.setBackground(Color.yellow);
        ColorPanel.add(green);

        JButton purple = new JButton("Pink");
        purple.addActionListener(this);
        purple.setBackground(Color.pink);
        ColorPanel.add(purple);

        JButton blue = new JButton("Magenta");
        blue.addActionListener(this);
        blue.setBackground(Color.magenta);
        ColorPanel.add(blue);

        JButton orange = new JButton("Orange");
        orange.addActionListener(this);
        orange.setBackground(Color.orange);
        ColorPanel.add(orange);

        //Figure Panel

        JPanel FigurePanel = new JPanel();
        FigurePanel.setLayout(new GridLayout(2, 2));

        JButton Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(this);
        FigurePanel.add(Rectangle);

        JButton Ellipse = new JButton("Ellipse");
        Ellipse.addActionListener(this);
        FigurePanel.add(Ellipse);

        JButton Square = new JButton("Square");
        Square.addActionListener(this);
        FigurePanel.add(Square);

        JButton Circle = new JButton("Circle");
        Circle.addActionListener(this);
        FigurePanel.add(Circle);

        JPanel South = new JPanel();
        South.setLayout(new GridLayout(1, 2));
        South.add(ColorPanel);
        South.add(FigurePanel);
        contentPanel.add(South, "South");
        contentPanel.add(draw, "Center");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            //Colors Buttons
            case "Black":
                draw.setColor(Color.BLACK);
                System.out.println("Black is selected");
                break;
            case "Red":
                System.out.println("Red is selected");
                draw.setColor(Color.RED);
                break;
            case "Green":
                System.out.println("Green is selected");
                draw.setColor(Color.GREEN);
                break;
            case "Blue":
                System.out.println("Blue is selected");
                draw.setColor(Color.BLUE);
                break;
            case "Yellow":
                System.out.println("Yellow is selected");
                draw.setColor(Color.YELLOW);
                break;
            case "Pink":
                System.out.println("Pink is selected");
                draw.setColor(Color.PINK);
                break;
            case "Magenta":
                System.out.println("Purple is selected");
                draw.setColor(Color.MAGENTA);
                break;
            case "Orange":
                System.out.println("Orange is selected");
                draw.setColor(Color.ORANGE);
                break;
            //Figures Buttons
            case "Ellipse":
                System.out.println("Ellipse is selected");
                draw.setName("Ellipse");
                //System.out.println(draw.getCurrent_figure() + " " + draw.getColor());
                break;
            case "Rectangle":
                System.out.println("Rectangle is selected");
                draw.setName("Rectangle");
                //System.out.println(draw.getCurrent_figure() + " " + draw.getColor());
                break;
            case "Square":
                System.out.println("Square is selected");
                draw.setName("Square");
                //System.out.println(draw.getCurrent_figure() + " " + draw.getColor());
                break;
            case "Circle":
                System.out.println("Circle is selected");
                draw.setName("Circle");
                //System.out.println(draw.getCurrent_figure() + " " + draw.getColor());
                break;
            //Menu Buttons
            case "Open":
                System.out.println("Open is selected");
                JFileChooser chooser = new JFileChooser();
                int userSelection = chooser.showOpenDialog(this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String file = chooser.getSelectedFile().getAbsolutePath();
                    draw.open(file);
                } else {
                    System.out.println("Open is cancelled");
                }
                System.out.println("Open is selected");
                break;
            case "Save":
                System.out.println("Save is selected");
                JFileChooser chooser2 = new JFileChooser();
                int userSelection2 = chooser2.showSaveDialog(this);
                if (userSelection2 == JFileChooser.APPROVE_OPTION) {
                    String fileToSave = chooser2.getSelectedFile().getAbsolutePath();
                    draw.save(fileToSave);
                } else {
                    System.out.println("Save is cancelled");
                }
                System.out.println("Save is selected");
                break;
            case "New":
                System.out.println("New is selected");
                draw.list.clear();
                repaint();
                break;
            case "Author":
                System.out.println("Author is selected");
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog(info, "Authors: Rémi Glémet", "About us", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Quit":
                System.out.println("Quit is selected");
                System.out.println("New");
                draw.list.clear();
                System.exit(0);
                break;
        }
    }
}