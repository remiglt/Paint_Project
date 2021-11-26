import java.awt.*;

public class Ellipse extends Figure{
    protected int SemiAxisX =0;
    protected int SemiAxisY =0;

    public Ellipse(int px, int py, Color c) {
        super(px,py,c);
    }

    public double getPerimeter() {
        return 2*Math.PI*(Math.sqrt((Math.pow(SemiAxisX, 2)+Math.pow(SemiAxisY, 2))/2));
    }

    public double getSurface() {
        return Math.PI * SemiAxisY * SemiAxisX;
    }

    public int getSemiAxisX(Ellipse ellipse){
        return ellipse.SemiAxisX;
    }

    public int getSemiAxisY(Ellipse ellipse){
        return ellipse.SemiAxisY;
    }

    public void setSemiAxisX(int axisX){
        if (axisX > 0){
            this.SemiAxisX = axisX;
        }
    }
    public void setSemiAxisY(int axisY){
        if (axisY > 0){
            this.SemiAxisY = axisY;
        }
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        this.SemiAxisX = heightBB;
        this.SemiAxisY = widthBB;
    }

    public void draw(Graphics g) {
        g.setColor(c);
        if (SemiAxisX > 0 && SemiAxisY > 0) {
            g.fillOval(p.getX(),p.getY(), SemiAxisX, SemiAxisY);
        }
        else if (SemiAxisX > 0 && SemiAxisY < 0) {
            g.fillOval(p.getX(),p.getY() + SemiAxisY, SemiAxisX, -SemiAxisY);
        }
        else if (SemiAxisX < 0 && SemiAxisY > 0) {
            g.fillOval(p.getX()+SemiAxisX,p.getY(), -SemiAxisX, SemiAxisY);
        }
        else {
            g.fillOval(p.getX() + SemiAxisX, p.getY() + SemiAxisY, -SemiAxisX, -SemiAxisY);
        }
    }

    @Override
    public String toString() {
        return "Ellipse { SemiAxisX=" + SemiAxisX + ", SemiAxisY=" + SemiAxisY + ", Color =" + c + ", " + p + "} \n";
    }
}
