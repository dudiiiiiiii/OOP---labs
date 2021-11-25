package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;


abstract class AbstractWorldMap implements IWorldMap{
    protected List<Animal> animals = new ArrayList<>();



    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) && position.follows(new Vector2d(0,0));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

        for(Animal animal: this.animals) {
            if(animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
}
