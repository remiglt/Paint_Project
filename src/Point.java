public class Point implements java.io.Serializable
{
    private int X=0;
    private int Y=0;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Point(int a, int b){
        X = a;
        Y = b;
    }

    @Override
    public String toString() {
        return "Point (" + getX() + "," + getY() + ')';
    }

}
