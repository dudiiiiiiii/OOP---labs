package agh.ics.oop;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "("+Integer.toString(this.x)+","+Integer.toString(this.y)+")";
    }

    public boolean precedes(Vector2d other){
        if(this.x <= other.x && this.y <= other.y) {
            return true;
        }
        return false;
    }

    public boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y) {
            return true;
        }
        return false;
    }

    public Vector2d upperRight(Vector2d other) {
        if(this.x >= other.x) {
            int x = this.x;
        }
        else{
            int x = other.x;
        }
        if(this.y >= other.y) {
            int y = this.y;
        }
        else{
            int y = other.y;
        }
        return Vector2d(x, y);
    }
}
