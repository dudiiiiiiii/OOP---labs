package agh.ics.oop;

import java.util.*;

public class SimulationEngine implements IEngine{
    private List<MoveDirection> moves;
    private IWorldMap map;
    private List<Vector2d> starters;
    private List<Animal> animals = new ArrayList<>();

    public SimulationEngine(List<MoveDirection> moves, IWorldMap map, List<Vector2d> starters) {
        this.moves = moves;
        this.map = map;
        this.starters = starters;
    }


    @Override
    public void run() {

        for(int i=0; i<this.starters.size(); i++) {
            Animal temp = new Animal(this.map, this.starters.get(i));
            if (this.map.place(temp)) {
                this.animals.add(temp);
            }
        }

        List<MoveDirection> moves1 = new ArrayList<>(this.moves);
        int n = moves1.size();
        int k = this.animals.size();

        for(int i=0; i< n; i++) {
            this.animals.get(i%k).move(moves1.get(i));

        }
    }
}
