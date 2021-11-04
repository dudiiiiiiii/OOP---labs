package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return "orientation - " + this.orientation + " | position (" + this.position.x + ", " + this.position.y + ")";
    }

    public boolean isAt(Vector2d position) {
        if( this.position.x == position.x && this.position.y == position.y) {
            return true;
        }
        return false;
    }

    public boolean orient(MapDirection orientt) {
        if(orientt == this.orientation){
            return true;
        }
        return false;
    }

    public void move(MoveDirection direction){
        if(direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        }
        else if(direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        }
        else if(direction == MoveDirection.FORWARD) {
            if (this.position.add(this.orientation.toUnitVector()).precedes(new Vector2d(4, 4))
                    && this.position.add(this.orientation.toUnitVector()).follows(new Vector2d(0, 0))) {
                this.position = this.position.add(this.orientation.toUnitVector());
            }
        }
        else {
            if(this.position.subtract(this.orientation.toUnitVector()).precedes(new Vector2d(4,4))
                    && this.position.subtract(this.orientation.toUnitVector()).follows(new Vector2d(0,0))){
                this.position = this.position.subtract(this.orientation.toUnitVector());
            }
        }
    }


}
