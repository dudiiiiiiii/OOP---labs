package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    private IWorldMap map;
    private List<IPositionChangeObserver> positions = new ArrayList<>();

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

            positionChanged(this.position, newPosition);
            this.position = newPosition;
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.positions.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.positions.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for(IPositionChangeObserver x: positions) {
            x.positionChanged(oldPosition, newPosition);
        }
    }
}
