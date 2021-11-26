import java.awt.*;

class Rectangle extends Figure {
    protected int length=0;
    protected int width=0;

    public Rectangle(int px, int py, Color c){
        super(px,py,c);
    }

    public int getlength() {
        return length;
    }

    public int getwidth() {
        return width;
    }

    public double getPerimeter() {
        return 2 * (width + length);
    }

    public double getSurface() { return width * length; }

    public void setBoundingBox(int widthBB, int heightBB) {
        this.width = widthBB;
        this.length = heightBB;
    }

    public void draw(Graphics g){
        g.setColor(c);
        if (width > 0 && length > 0) {
            g.fillRect(p.getX(),p.getY(), width, length);
        }
        else if (width > 0 && length < 0) {
            g.fillRect(p.getX(),p.getY() + length, width, -length);
        }
        else if (width < 0 && length > 0) {
            g.fillRect(p.getX()+width,p.getY(), -width, length);
        }
        else {
            g.fillRect(p.getX() + width, p.getY() + length, -width, -length);
        }
    }

    @Override
    public String toString() {
        return "Rectangle { color=" + c + ", " + p + ", length=" + length + ", width=" + width + "} \n" ;
    }
}

