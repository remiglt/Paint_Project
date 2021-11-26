import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {

    private Color c;
    private String NameFigure;
    private Figure currentFigure;
    protected int x;
    protected int y;
    public ArrayList<Figure> list = new ArrayList<>();

    public void setColor(Color c) {
        this.c = c;
    }

    public void setName(String NameFigure) {
        this.NameFigure = NameFigure;
    }

    public Drawing(){
        super(new GridLayout(0,1));
        this.c=Color.BLACK;
        this.NameFigure="Rectangle";
        this.setBackground(Color.WHITE);
        this.addMouseListener(this); /*We add both listeners in order to know when the mouse is being pressed and when it is dragged*/
        this.addMouseMotionListener(this);
    }

    public void save(String File) {
        try {
            FileOutputStream fileOut = new FileOutputStream(File);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            System.out.println(File + " est sauvegardé");
        } catch (Exception e) {
            System.out.println("Problèmos");
            e.printStackTrace();

        }
    }


    public void open(String File) {
        try {
            FileInputStream fileIn = new FileInputStream(File);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Figure>) in.readObject();
            System.out.println(File + " est ouvert");
            in.close();
            fileIn.close();
            repaint();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        for (Figure f : list){
            f.draw(g);
        }

    }
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        if (NameFigure.equals("Rectangle")){
            currentFigure = new Rectangle(x, y, c);
            this.list.add(currentFigure);
            System.out.println(list);
        }
        if (NameFigure.equals("Ellipse")){
            currentFigure = new Ellipse(x, y, c);
            this.list.add(currentFigure);
            System.out.println(list);
        }
        if (NameFigure.equals("Square")){
            currentFigure = new Square(x, y, c);
            this.list.add(currentFigure);
            System.out.println(list);
        }
        if (NameFigure.equals("Circle")){
            currentFigure = new Circle(x, y, c);
            this.list.add(currentFigure);
            System.out.println(list);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        currentFigure.setBoundingBox(e.getX() - x, e.getY() - y);
        list.add(list.size() - 1, currentFigure);
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

}
