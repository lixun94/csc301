<<<<<<< HEAD
/**package edu.toronto.csc301;

public class GridRobot2 extends BasicRobot implements IGridRobot {

    private GridCell gridCell;
    private Direction direction;
    private int size;

    public GridRobot2(GridCell gridCell, IGridRobot.Direction direction, int size) {
        super(gridCell.x * size , gridCell.y * size);
        if(size <0){
            throw new IllegalArgumentException();
        }
        if(direction == null){
            throw new NullPointerException();
        }
        this.gridCell = GridCell.at(gridCell.x, gridCell.y);
        this.direction = direction;
        this.size = size;

        switch (direction){
            case NORTH:
                this.setRotation(0);
            case EAST:
                this.setRotation(90);
            case SOUTH:
                this.setRotation(180);
            case WEST:
                this.setRotation(270);
        }

    }



    @Override
    public GridCell getLocation() {
        return this.gridCell;
    }

    @Override
    public Direction getFacingDirection() {
        switch (this.getRotation()){
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
                this.gridCell =GridCell.at(this.gridCell.x, this.gridCell.y +1);
            case SOUTH:
                this.gridCell =GridCell.at(this.gridCell.x, this.gridCell.y -1);
            case EAST:
                this.gridCell =GridCell.at(this.gridCell.x +1 , this.gridCell.y);
            case WEST:
                this.gridCell =GridCell.at(this.gridCell.x -1, this.gridCell.y);
        }
        this.setXCoordinate((int) (-1 * this.getXCoordinate() + this.gridCell.x * this.size));
        this.setYCoordinate((int) (-1 * this.getYCoordinate() + this.gridCell.y * this.size));

    }

    @Override
    public void face(Direction direction) {
        switch (direction){
            case NORTH:
                this.setRotation(0);
            case EAST:
                this.setRotation(90);
            case SOUTH:
                this.setRotation(180);
            case WEST:
                this.setRotation(270);

        }

    }
}
**/

=======
>>>>>>> 30f159cefe79d9ff6ed56b91f9ab83180b662e2a
package edu.toronto.csc301;



public class GridRobot2 extends BasicRobot implements IGridRobot {

    private GridCell gridcell;

    private Direction direction;

    private int cellsize;


    public GridRobot2(GridCell gridcell, IGridRobot.Direction direction, int size) {

        super(gridcell.x * size, gridcell.y * size);

        if (!(size > 0)){

            throw new IllegalArgumentException();

        }

        if (direction == null){

            throw new NullPointerException();

        }


        this.gridcell = GridCell.at(gridcell.x, gridcell.y);

        this.direction = direction;

        this.cellsize = size;


        if(this.direction == Direction.NORTH){

            this.setRotation(0);

        }else if (this.direction == Direction.SOUTH){

            this.setRotation(180);

        }else if (this.direction == Direction.WEST){

            this.setRotation(270);

        }else if (this.direction == Direction.EAST){

            this.setRotation(90);

        }

    }


    public GridCell getLocation() {

        return this.gridcell;

    }


    public Direction getFacingDirection() {

        if (this.getRotation() == 0){

            return Direction.NORTH;

        }else if (this.getRotation() == 90){

            return Direction.EAST;

        }else if (this.getRotation() == 180){

            return Direction.SOUTH;

        }else if (this.getRotation() == 270){

            return Direction.WEST;

        }

        return null;

    }


    public void step(Direction direction) {

        if (direction == Direction.NORTH){

            this.gridcell = GridCell.at(this.gridcell.x, this.gridcell.y + 1);

        }else if (direction == Direction.EAST){

            this.gridcell = GridCell.at(this.gridcell.x + 1, this.gridcell.y);

        }else if (direction == Direction.SOUTH){

            this.gridcell = GridCell.at(this.gridcell.x, this.gridcell.y - 1);

        }else if (direction == Direction.WEST){

            this.gridcell = GridCell.at(this.gridcell.x - 1, this.gridcell.y);

        }

        this.setXCoordinate((int) (-1*this.getXCoordinate() + this.gridcell.x * this.cellsize));

        this.setYCoordinate((int) (-1*this.getYCoordinate() + this.gridcell.y * this.cellsize));

    }


    public void face(Direction direction) {

        if (direction == Direction.NORTH){

            this.setRotation(0);

        }else if (direction == Direction.SOUTH){

            this.setRotation(180);

        }else if (direction == Direction.EAST){

            this.setRotation(90);

        }else if (direction == Direction.WEST){

            this.setRotation(270);

        }


    }


    @Override

    public void rotateRight(int degrees) {

// TODO Auto-generated method stub

        if (degrees % 90 != 0){

            throw new IllegalArgumentException();

        }

        int relative_degree = ((this.getRotation() + 360) + degrees % 360) % 360;

        if (relative_degree == 0){

            this.direction = Direction.NORTH;

        }else if (relative_degree == 90){

            this.direction = Direction.EAST;

        }else if (relative_degree == 180){

            this.direction = Direction.SOUTH;

        }else if (relative_degree == 270){

            this.direction = Direction.WEST;

        }

        this.setRotation(relative_degree);

    }


    @Override

    public void rotateLeft(int degrees) {

// TODO Auto-generated method stub

        if (degrees % 90 != 0){

            throw new IllegalArgumentException();

        }

        int relative_degree = ((this.getRotation() + 360) - degrees % 360) % 360;

        if (relative_degree == 0){

            this.direction = Direction.NORTH;

        }else if (relative_degree == 90){

            this.direction = Direction.EAST;

        }else if (relative_degree == 180){

            this.direction = Direction.SOUTH;

        }else if (relative_degree == 270){

            this.direction = Direction.WEST;

        }

        this.setRotation(relative_degree);

    }


    @Override

    public void moveForward(int millimeters) {

// TODO Auto-generated method stub

        if (millimeters % this.cellsize != 0){

            throw new IllegalArgumentException();

        }

        if (this.direction == Direction.NORTH){

            this.setYCoordinate(millimeters);

            this.gridcell = GridCell.at(this.gridcell.x, this.gridcell.y + millimeters/this.cellsize);

        }else if (this.direction == Direction.EAST){

            this.setXCoordinate(millimeters);

            this.gridcell = GridCell.at(this.gridcell.x + millimeters/this.cellsize, this.gridcell.y);

        }else if (this.direction == Direction.SOUTH){

            this.setYCoordinate(-1*millimeters);

            this.gridcell = GridCell.at(this.gridcell.x, this.gridcell.y - millimeters/this.cellsize);

        }else if (this.direction == Direction.WEST){

            this.setXCoordinate(-1*millimeters);

            this.gridcell = GridCell.at(this.gridcell.x - millimeters/this.cellsize, this.gridcell.y);

        }

    }



<<<<<<< HEAD
}

=======
}
>>>>>>> 30f159cefe79d9ff6ed56b91f9ab83180b662e2a
