package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;

    public Animal(){
    }

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public String toString(){
        return switch (this.orientation) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public boolean orient(MapDirection orientt) {
        return orientt == this.orientation;
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
        if (this.map.canMoveTo(newPosition)) {
            this.position = newPosition;;
        }
    }
}
