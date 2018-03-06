import java.util.*;

public class Taxi {

    static int posX=0;
    static int posY=0;
    static int time=0;
    List<Request> assignedRequest = new ArrayList<Request>();

    public int getTime() {
        return time;
    }

    public void setTime(int t) {
        time = t;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int pX) {
        posX = pX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int pY) {
        posY = pY;
    }


    // @Fix
    // recieves NULL instead of Request!!!
    public void assignRequest(Request r) {
        assignedRequest.add(r);
        System.out.println(r);
        System.out.println(r.getEndX());
        System.out.println(r.getEndY());
        System.out.println(calulateTime(r));
        ride(r.getEndX(),r.getEndY(),calulateTime(r));
    }

    //works? prob not correctly
    public int calulateTime(Request r){
       int result;
       result = Dispatch.calculateWaitTime(this,r) + Dispatch.calculateDistanceToStart(this, r) + Dispatch.calculateDistanceToStart(this, r);
       return result;
    }



    public void ride(int x, int y, int t){
        posX = x;
        posY = y;
        time = time + t;
    }
}
