package agh.ics.oop;

import java.util.*;


abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
//    protected List<Animal> animals = new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedA(position) && position.follows(new Vector2d(0,0));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    public boolean isOccupiedA(Vector2d pos) {
        return this.animals.get(pos) != null;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if(objectAt(position) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

        if(this.animals.get(position) != null) {
            return this.animals.get(position);
        }
        return null;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animal);
    }
}
