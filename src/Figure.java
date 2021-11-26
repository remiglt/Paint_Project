import java.awt.*;
import java.awt.Color;

abstract class Figure implements java.io.Serializable{

    protected Color c;
    protected Point p;

    public Figure(int x, int y, Color c)
    {
        this.p = new Point(x,y);
        this.c = c;
    }

    public abstract void setBoundingBox (int heightBB, int widthBB);

    public abstract void draw (Graphics g);

    public abstract double getPerimeter();

    public abstract double getSurface();

    @Override
    public String toString() {
        return "Figure { Origin : ("+ p.getX() + "," + p.getY() + "), Color :" + c + "}";
    }
}
