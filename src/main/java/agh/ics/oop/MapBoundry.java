package agh.ics.oop;


import javax.naming.event.ObjectChangeListener;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapBoundry implements IPositionChangeObserver{


    Comparator<Vector2d> comparatorx = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d first, Vector2d second) {
            if(first.x.equals(second.x)){
                return first.y.compareTo(second.y);
            }
            else{
                return first.x.compareTo(second.x);
            }
        }
    };

    Comparator<Vector2d> comparatory = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d first, Vector2d second) {
            if(first.y.equals(second.y)){
                return first.x.compareTo(second.x);
            }
            else{
                return first.y.compareTo(second.y);
            }
        }
    };

    private SortedMap<Vector2d, Object> objectsX = new TreeMap<>(comparatorx);
    private SortedMap<Vector2d, Object> objectsY = new TreeMap<>(comparatory);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Object objX = objectsX.get(oldPosition);
        Object objY = objectsY.get(oldPosition);
        objectsX.remove(oldPosition);
        objectsY.remove(oldPosition);
        objectsX.put(newPosition, objX);
        objectsY.put(newPosition, objY);
    }

    public void add(Object obj, Vector2d pos) {
        objectsX.put(pos, obj);
        objectsY.put(pos, obj);
    }

    public Vector2d top(){
        Vector2d topX = objectsX.lastKey();
        Vector2d topY = objectsY.lastKey();
        return topX.upperRight(topY);
    }

    public Vector2d bottom(){
        Vector2d bottomX = objectsX.firstKey();
        Vector2d bottomY = objectsY.firstKey();
        return bottomX.lowerLeft(bottomY);
    }
}
