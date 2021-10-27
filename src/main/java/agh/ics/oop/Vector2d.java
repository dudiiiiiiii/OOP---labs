 package agh.ics.oop;

 public class Vector2d {
     public int x;
     public int y;

     public Vector2d(int x, int y){
         this.x = x;
         this.y = y;
     }

     public String toString(){
         return "("+Integer.toString(this.x)+","+Integer.toString(this.y)+")";
     }

     public boolean precedes(Vector2d other){
         if(this.x <= other.x && this.y <= other.y) {
             return true;
         }
         return false;
     }

     public boolean follows(Vector2d other){
         if(this.x >= other.x && this.y >= other.y) {
             return true;
         }
         return false;
     }

     public Vector2d upperRight(Vector2d other) {
         if(this.x >= other.x) {
             int x = this.x;
         }
         else{
             int x = other.x;
         }
         if(this.y >= other.y) {
             int y = this.y;
         }
         else{
             int y = other.y;
         }
         return new Vector2d(x, y);
     }

     public Vector2d lowerLeft(Vector2d other) {
         if(this.x <= other.x) {
             int x = this.x;
         }
         else{
             int x = other.x;
         }
         if(this.y <= other.y) {
             int y = this.y;
         }
         else{
             int y = other.y;
         }
         return new Vector2d(x, y);
     }

     public Vector2d add(Vector2d other) {
         return new Vector2d(this.x + other.x, this.y + other.y);
     }

     public Vector2d subtract(Vector2d other){
         return new Vector2d(this.x - other.x, this.y - other.y);
     }

     public boolean equals(Object other) {
         if (this == other)
             return true;
         if (!(other instanceof Vector2d))
             return false;
         Vector2d that = (Vector2d) other;
         return false;
     }

     Vector2d opposite() {
         return new Vector2d(-this.x, -this.y);
     }
 }

 enum MoveDirection {
     FORWARD,
     BACKWARD,
     RIGHT,
     LEFT
 }

 enum MapDirection {
     NORTH,
     SOUTH,
     WEST,
     EAST;

     public String toString() {
         switch(this){
             case NORTH : return "Północ";
             case SOUTH : return "Południe";
             case WEST : return "Zachód";
             case EAST : return "Wschód";
             default: return "Błąd";
         }
     }

     public MapDirection next() {
         switch(this){
             case NORTH : return EAST;
             case SOUTH : return WEST;
             case WEST : return NORTH;
             case EAST : return SOUTH;
             default: return EAST;
         }
     }

     public MapDirection previous() {
         switch(this){
             case NORTH : return WEST;
             case SOUTH : return EAST;
             case WEST : return SOUTH;
             case EAST : return NORTH;
             default: return EAST;
         }
     }

     public Vector2d toUnitVector(){
         switch(this){
             case NORTH : return new Vector2d(0,1);
             case SOUTH : return new Vector2d(0,-1);
             case WEST : return new Vector2d(-1,0);
             case EAST : return new Vector2d(1,0);
             default: return new Vector2d(0,0);
         }
     }
 }
