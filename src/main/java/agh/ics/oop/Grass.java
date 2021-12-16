package agh.ics.oop;

public class Grass implements IMapElement{
    private Vector2d position;

    public Grass(Vector2d position) {
        this.position = position;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public String toString() {
        return "*";
    }

    @Override
    public String getDirection(String dir) {
        switch(dir) {
            case "*" -> {
                return "src/main/resources/grass.png";
            }
            default -> {
                return "none";
            }
        }
    }
}
