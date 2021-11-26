import java.awt.*;

public class Square extends Rectangle{

    public Square(int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int  heightBB,  int  widthBB) {
        this.length = heightBB;
        this.width = heightBB;
    }

    @Override
    public String toString() {
        return "Square { color=" + c + p + ", length=" + length + ", width=" + width + "} \n";
    }
}
