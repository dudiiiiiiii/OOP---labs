package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){
        return "orientation - " + this.orientation + " | position " + this.position;
    }

    public boolean isAt(Vector2d position) {
        if( this.position.equals(position)) {
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
        Vector2d newPosition = this.position;
        if(direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        }
        else if(direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        }
        else if(direction == MoveDirection.FORWARD) {
            newPosition = this.position.add(this.orientation.toUnitVector());
        }
        else {
            newPosition = this.position.subtract(this.orientation.toUnitVector());

        }
        if (newPosition.precedes(new Vector2d(4, 4))
                && newPosition.follows(new Vector2d(0, 0))) {
            this.position = newPosition;;
        }
    }


}
