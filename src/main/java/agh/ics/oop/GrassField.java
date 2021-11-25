package agh.ics.oop;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private int num;
    private List<Grass> poss = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();

    public GrassField(int num) {
        this.num = num;
        Random rand = new Random();

        for(int i=0; i< num; i++){
            int flag = 1;
            Vector2d tmp = new Vector2d(rand.nextInt((int) Math.sqrt(num*10)), rand.nextInt((int) Math.sqrt(num*10)));
            for(Grass grass: this.poss) {
                if(grass.getPosition().equals(tmp)){
                    i--;
                    flag = 0;
                }
            }
            if(flag == 1) {
                this.poss.add(new Grass(tmp));
            }
        }
    }

    public List<Animal> getAn() {
        return this.animals;
    }

    public String toString() {
        System.out.println(this.animals);
        System.out.println(this.poss);
        Vector2d top = new Vector2d(0,0);
        for(Grass vec: poss){
            top = vec.getPosition().upperRight(top);
        }
        for(Animal ani: animals){
            top = ani.getPosition().upperRight(top);
        }
        MapVisualizer mapp = new MapVisualizer(this);
        System.out.println(mapp.draw(new Vector2d(0,0), top));
        return " ";
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean x = super.isOccupied(position);
        if(x) {
            return true;
        }

        for(Grass gr: this.poss) {
            if(gr.getPosition().equals(position)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if (object != null) {
            return object;
        }

        for(Grass gr: this.poss) {
            if(gr.getPosition().equals(position)) {
                return gr;
            }
        }

        return null;
    }
//    public boolean isOccupieda(Vector2d position) {
//        for (Animal animal : this.animals) {
//            if (animal.isAt(position)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        return !isOccupieda(position) && position.follows(new Vector2d(0,0));
//    }
//
//    @Override
//    public boolean place(Animal animal) {
//
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
//        for(Grass gr: this.poss) {
//            if(gr.getPosition().equals(position)) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public Object objectAt(Vector2d position) {
//        for(Animal animal: this.animals) {
//            if(animal.isAt(position)) {
//                return animal;
//            }
//        }
//
//        for(Grass gr: this.poss) {
//            if(gr.getPosition().equals(position)) {
//                return gr;
//            }
//        }
//
//        return null;
//    }


}
