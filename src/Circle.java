import java.awt.*;

public class Circle extends Ellipse{

    public Circle(int px, int py, Color c) {
        super(px, py, c);
    }

    public double getSurface() {
        return Math.PI* super.SemiAxisX * super.SemiAxisY ;
    }

    public double getPerimeter() {
        return 2*Math.PI*this.SemiAxisX;
    }

    public void setSemiAxisY(int axisY){
        if (axisY > 0){
            this.SemiAxisY = axisY;
        }
    }
    public void setSemiAxisX(int AxisX){
        if (AxisX > 0){
            this.SemiAxisX = AxisX;
        }
    }
    public void setBoundingBox(int heightBB, int widthBB) {
        this.SemiAxisX = heightBB;
        this.SemiAxisY = heightBB;
    }

    @Override
    public String toString() {
        return "Circle { SemiAxisX=" + SemiAxisX + ", SemiAxisY=" + SemiAxisY + ", Color =" + c + ", "+ p + "} \n";
    }

}
