package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {
    private Vector2d lowerLeft;
    private Vector2d upperRight;
    private List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width, height);
    }

    public List<Animal> getAn() {
        return this.animals;
    }

    public String toString(){

        MapVisualizer mapcos = new MapVisualizer(this);
        System.out.println(mapcos.draw(this.lowerLeft, this.upperRight));
        return " ";
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position) && position.precedes(this.upperRight);
    }
//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        return !isOccupied(position) && position.follows(this.lowerLeft) && position.precedes(this.upperRight);
//    }
//
//    @Override
//    public boolean place(Animal animal) {
//        if (canMoveTo(animal.getPosition())) {
//            this.animals.add(animal);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean isOccupied(Vector2d position) {
//        for (Animal animal : this.animals) {
//            if (animal.isAt(position)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public Object objectAt(Vector2d position) {
//
//        for(Animal animal: this.animals) {
//            if(animal.isAt(position)) {
//                return animal;
//            }
//        }
//        return null;
//    }

}
