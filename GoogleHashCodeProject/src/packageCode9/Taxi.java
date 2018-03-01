package packageCode9;
import java.util.*;

public class Taxi {

    int posX=0;
    int posY=0;
    int time=0;
    List<Request> assignedRequest = new ArrayList<Request>();

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void assignRequest(Request r) {
        assignedRequest.add(r);
        ride(r.getEndX(),r.getEndY(),calulateTime(r));
    }

    public int calulateTime(Request r){
       int result;
       result = Dispatch.calculateWaitTime(this,r) + Dispatch.calculateDistanceToStart(this, r) + Dispatch.calculateDistance(r);
       return result;
    }



    public void ride(int x, int y, int t){
        this.posX = x;
        this.posY = y;
        this.time = this.time + t;
    }
}
