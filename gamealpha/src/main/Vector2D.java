package main;

public class Vector2D {
    public double x,y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double length(){
        return Math.sqrt(x*x + y*y);
    }

    public void setLength(double length){
        double origLength = this.length();
        if (origLength != 0) {
        double scale = length/origLength;
        this.x = this.x * scale;
        this.y = this.y * scale;
        }
    }
    public void setLengthOne(){
        if(this.length()!=1.0) {
            this.setLength(1.0);
        }
    }
}
