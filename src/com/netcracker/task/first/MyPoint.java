package com.netcracker.task.first;

public class MyPoint implements Comparable<MyPoint> {

    private int x = 0;
    private int y = 0;

    public MyPoint() {
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY(){
        int [] xy = {x,y};
        return xy;
    }

    public void setXY(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public double distance(int x,int y){
        return Math.sqrt(Math.pow((x-this.x),2)+Math.pow((y-this.y),2));
    }

    public double distance(MyPoint point){
        return Math.sqrt(Math.pow((point.x - this.x),2)+Math.pow((point.y - this.y),2));
    }

    public double distance(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof MyPoint)){
            return false;
        }
        MyPoint point = (MyPoint) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + x;
        result = 31*result + y;
        return result;
    }

    @Override
    public int compareTo(MyPoint o) {
        double epsilon = 0.00001d;
        if (Math.abs(Math.sqrt(x*x+y*y) - Math.sqrt(o.x*o.x+o.y*o.y)) < epsilon){
            return 0;
        }
        else if (Math.sqrt(x*x+y*y) - Math.sqrt(o.x*o.x+o.y*o.y) < 0){
            return -1;
        }
        else {
            return 1;
        }
    }
}
