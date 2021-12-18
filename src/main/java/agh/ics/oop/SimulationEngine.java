package agh.ics.oop;

import javafx.application.Platform;

import java.util.*;

public class SimulationEngine implements IEngine,Runnable{
    private List<MoveDirection> moves;
    private IWorldMap map;
    private List<Vector2d> starters;
    private List<Animal> animals = new ArrayList<>();
    private List<IUpdateAnimals> positionsObserver = new ArrayList<>();
    private int moveDelay;

    public SimulationEngine(List<MoveDirection> moves, IWorldMap map, List<Vector2d> starters) {
        this.moves = moves;
        this.map = map;
        this.starters = starters;
    }
    public void addObserver(IUpdateAnimals observer) {
        this.positionsObserver.add(observer);
    }

    public void removeObserver(IUpdateAnimals observer) {
        this.positionsObserver.remove(observer);
    }

    public void setMoveDelay(int delay){ this.moveDelay = delay;}

    public void setMoves(List<MoveDirection> list){ this.moves = list;}

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

            for(IUpdateAnimals observ: positionsObserver){
                observ.positionChanged();
            }

            try{
                Thread.sleep(moveDelay);
            }
            catch(InterruptedException except){
                System.out.println("Exception");
            }

        }
    }

}
