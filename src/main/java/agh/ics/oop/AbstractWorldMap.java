package agh.ics.oop;

import java.util.*;


abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected MapBoundry boundries = new MapBoundry();
    protected List<Grass> positions = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupiedA(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(),animal);
            animal.addObserver(this);
            boundries.add(animal, animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition() + " is not legal move specification");
        //return false;
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
        boundries.positionChanged(oldPosition, newPosition);
    }

    @Override
    public Vector2d up(){
        return boundries.top();
    }

    @Override
    public Vector2d down(){
        return boundries.bottom();
    }

    @Override
    public Map<Vector2d, Animal> getAnimalList(){
        return this.animals;
    }

    @Override
    public List<Grass> getGrass(){
        return this.positions;
    }
}
