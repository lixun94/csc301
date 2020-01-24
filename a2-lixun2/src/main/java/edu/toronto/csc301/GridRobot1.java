<<<<<<< HEAD
/**package edu.toronto.csc301;

public class GridRobot1 implements IGridRobot {

    private IBasicRobot basicRobot;
    private int size;

    public GridRobot1(IBasicRobot basicRobot, int size){
        if(basicRobot == null){
            throw new NullPointerException();
        }
        if (size <= 0){
            throw new IllegalArgumentException();
        }
        if (basicRobot.getXCoordinate() != 0 || basicRobot.getYCoordinate() !=0){
            if(Math.abs(basicRobot.getXCoordinate()) < size || Math.abs(basicRobot.getYCoordinate()) < size ){
                throw new IllegalArgumentException();
            }
        }
        if (basicRobot.getRotation() %90 != 0){
            throw new IllegalArgumentException();
        }
        this.basicRobot = (BasicRobot)basicRobot;
        this.size = size;
    }


    @Override
    public GridCell getLocation() {
        if (this.basicRobot.getXCoordinate() == 0 & this.basicRobot.getYCoordinate() ==0){
            return GridCell.at(0,0);
        }
        else{
            int a = (int) (this.basicRobot.getXCoordinate()/this.size);
            int b = (int) (this.basicRobot.getYCoordinate()/this.size);
            return GridCell.at(a,b);
        }
    }

    @Override
    public Direction getFacingDirection() {
        switch (this.basicRobot.getRotation()) {
            case 0:
                return Direction.NORTH;
            case 90:
                return Direction.EAST;
            case 180:
                return Direction.SOUTH;
            case 270:
                return Direction.WEST;
            default:
                return null;
        }
    }


    @Override
    public void step(Direction direction) {
        switch (direction) {
            case NORTH:
                ((BasicRobot) this.basicRobot).setYCoordinate(size);
            case SOUTH:
                ((BasicRobot) this.basicRobot).setYCoordinate(-1 * size);
            case EAST:
                ((BasicRobot) this.basicRobot).setYCoordinate(size);
            case WEST:
                ((BasicRobot) this.basicRobot).setYCoordinate(-1 * size);
        }

    }

    @Override
    public void face(Direction direction) {
        switch (direction){
            case NORTH:
                ((BasicRobot) this.basicRobot).setRotation(0);
            case EAST:
                ((BasicRobot) this.basicRobot).setRotation(90);
            case SOUTH:
                ((BasicRobot) this.basicRobot).setRotation(180);
            case WEST:
                ((BasicRobot) this.basicRobot).setRotation(270);

        }

    }
}
**/

=======
>>>>>>> 30f159cefe79d9ff6ed56b91f9ab83180b662e2a
package edu.toronto.csc301;



public class GridRobot1 implements IGridRobot {



    private IBasicRobot basicrobot;

    private int cellsize;


    public GridRobot1(IBasicRobot basicrobot, int cellsize){

        if (basicrobot == null){

            throw new NullPointerException();

        }

        if (cellsize <= 0){

            throw new IllegalArgumentException();

        }

        if (basicrobot.getXCoordinate() != 0 || basicrobot.getYCoordinate() != 0){

            if (Math.abs(basicrobot.getXCoordinate()) < cellsize || Math.abs(basicrobot.getYCoordinate()) < cellsize){

                throw new IllegalArgumentException();

            }

        }

        if (basicrobot.getRotation() % 90 != 0){

            throw new IllegalArgumentException();

        }

        this.basicrobot = (BasicRobot)basicrobot;

        this.cellsize = cellsize;

    }


    @Override

    public GridCell getLocation() {

        if (this.basicrobot.getXCoordinate() == 0 & this.basicrobot.getYCoordinate() == 0){

            return GridCell.at(0,0);

        }else{

            int a = (int) (this.basicrobot.getXCoordinate()/this.cellsize);

            int b = (int) (this.basicrobot.getYCoordinate()/this.cellsize);

            return GridCell.at(a, b);

        }

    }


    @Override

    public Direction getFacingDirection() {

        if (this.basicrobot.getRotation() == 0){

            return Direction.NORTH;

        }else if (this.basicrobot.getRotation() == 90){

            return Direction.EAST;

        }else if (this.basicrobot.getRotation() == 180){

            return Direction.SOUTH;

        }else if (this.basicrobot.getRotation() == 270){

            return Direction.WEST;

        }

        return null;

    }


    @Override

    public void step(Direction direction) {

        if (direction == Direction.NORTH){

            ((BasicRobot) this.basicrobot).setYCoordinate(cellsize);

        }else if (direction == Direction.SOUTH){

            ((BasicRobot) this.basicrobot).setYCoordinate(-1 * cellsize);

        }else if (direction == Direction.EAST){

            ((BasicRobot) this.basicrobot).setXCoordinate(cellsize);

        }else if (direction == Direction.WEST){

            ((BasicRobot) this.basicrobot).setXCoordinate(-1 * cellsize);

        }


    }


    @Override

    public void face(Direction direction) {

        switch (direction) {

            case NORTH:

                ((BasicRobot) this.basicrobot).setRotation(0);

                break;

            case EAST:

                ((BasicRobot) this.basicrobot).setRotation(90);;

                break;

            case SOUTH:

                ((BasicRobot) this.basicrobot).setRotation(180);;

                break;

            case WEST:

                ((BasicRobot) this.basicrobot).setRotation(270);;

                break;

        }

    }


}