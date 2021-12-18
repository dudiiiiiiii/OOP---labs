package agh.ics.oop;

import java.util.*;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private int num;
    private List<Grass> poss = new ArrayList<>();


    public GrassField(int num) {
        this.num = num;
        Random rand = new Random();

        for(int i=0; i< num; i++){
            int flag = 1;
            int one = (int)((Math.random()*2)-1);
            //System.out.println(one);
            Vector2d tmp = new Vector2d(rand.nextInt((int) Math.sqrt(num*10)), rand.nextInt((int) Math.sqrt(num*10)));
            for(Grass grass: this.poss) {
                if(grass.getPosition().equals(tmp)){
                    i--;
                    flag = 0;
                }
            }
            if(flag == 1) {
                Grass x = new Grass(tmp);
                this.poss.add(x);
                boundries.add(x, tmp);
            }
        }

        getGrass1();
    }

    public List<Grass> getGrass1(){
        positions = this.poss;
        return null;
    }

    public Map<Vector2d, Animal> getAn(){
        return animals;
    }

    public String toString() {
        Vector2d up = boundries.top();
        Vector2d down = boundries.bottom();

        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(down, up);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) != null) {
            return true;
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
}
