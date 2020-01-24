package edu.toronto.csc301;

public class BasicRobot implements IBasicRobot {

    private double x;
    private double y;
    private int rotation;

    public BasicRobot(double x, double y, int rotation){
        this.x = x;
        this.y = y;
        if(0<=rotation && rotation<=359){
            this.rotation = rotation;
        }
        else{
            throw new IllegalArgumentException();
        }

    }


    public BasicRobot(int i, int j){
        this.x = i;
        this.y = j;
    }










    @Override
    public double getXCoordinate() {
        return this.x;
    }

    @Override
    public double getYCoordinate() {

        return this.y;
    }

    @Override
    public int getRotation() {

        return this.rotation;
    }

    @Override
    public void rotateRight(int degrees) {

        if(0<degrees && degrees<360){
            this.rotation = (this.rotation + degrees) % 360;
        }
        else if(degrees<0){
            this.rotation = (360+(this.rotation + degrees) % 360) % 360;
        }
        else if(degrees > 360){
            this.rotation = (this.rotation + degrees - 360) % 360;
        }

    }

    @Override
    public void rotateLeft(int degrees) {
        if(0<degrees && degrees<360){
            if(this.rotation >= degrees) {
                this.rotation = (this.rotation - degrees) % 360;
            }
            else{
                this.rotation = this.rotation - degrees + 360;
            }
        }
        else if(degrees<0){
            this.rotation = (this.rotation + Math.abs(degrees)) % 360;
        }
        else if(degrees > 360){
            this.rotation = (360 - degrees + 360) % 360;
        }
    }

    @Override
    public void moveForward(int centimeters) {
        if(this.rotation == 0){
            this.y += centimeters;
        }
        else if(this.rotation ==90){
            this.x += centimeters;
        }
        else if(this.rotation == 180){
            this.y -= centimeters;
        }
        else if(this.rotation == 270){
            this.x -= centimeters;
        }
        else if(this.rotation == 45){
            this.x = 1000/Math.sqrt(2);
            this.y = 1000/Math.sqrt(2);
        }
        else if(this.rotation == 60){
            this.x = 1000/(2/Math.sqrt(3));
            this.y = 1000/2;
        }
        else if(this.rotation ==150){
            this.x = 1000/2;
            this.y = -1000/(2/Math.sqrt(3));
        }
        else{
            this.x += centimeters * Math.sin(this.rotation * Math.PI/180);
            this.y += centimeters * Math.cos(this.rotation * Math.PI/180);
        }

    }

    public void setYCoordinate(int size) {
        this.y += size;
    }

    public void setXCoordinate(int size) {
        this.x += size;
    }

    public void setRotation(int size) {
        this.rotation = size;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 30f159cefe79d9ff6ed56b91f9ab83180b662e2a
