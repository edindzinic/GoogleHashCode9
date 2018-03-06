
import java.util.*;

public class Dispatch {

    public static int bonus;
    public static int timeLimit;
    static ArrayList<Request> requests = new ArrayList<Request>();
    static Taxi[] taxis;

    public static void addRequest(Request r){
        requests.add(r);
    }

    public static void addTaxis(int nrOfTaxis){
        taxis = new Taxi[nrOfTaxis];
        for (int i = 0; i<taxis.length; i++){
            taxis[i] = new Taxi();
        }
    }

    public static void startDispatching(){

            //while(!(requests.isEmpty()) && !(noFeasibleRides())) {
                for (int i = 0; i < taxis.length; i++) {
                    int tempPoints1 = Integer.MIN_VALUE;
                    Request tempRequest = null;

                    for (Request r : requests) {
                        int tempPoints2 = points(taxis[i], r);
                        if(tempPoints2 > tempPoints1 && checkFeasibility(taxis[i],r)){
                        //@Problem with  checkFeasibility and checkTimeOverflow
                        //if (tempPoints2 > tempPoints1 && checkFeasibility(taxis[i], r) && checkTimeOverflow(taxis[i], r)) {
                            tempPoints1 = tempPoints2;
                            tempRequest = r;
                        }

                    }

                    taxis[i].assignRequest(tempRequest);
                    deleteRequest(tempRequest);
                }

            //}
    }

    public static boolean noFeasibleRides(){

        for (int i = 0; i < taxis.length; i++) {
            for (Request r : requests) {
                if(checkFeasibility(taxis[i],r)){
                    return false;
                }
            }
        }
        return true;
    }


    public static int points(Taxi t, Request r){
        int points;
        points = calculateDistance(r) + calculateBonus(t,r) - r.getEndTime() - calculateWaitTime(t,r) - t.getTime() - calculateDistanceToStart(t,r);
        return points;
    }

    public void assignRequestToTaxi(Taxi t, Request r){
        t.assignRequest(r);
    }

    public static void deleteRequest(Request r){
        requests.remove(r);
    }

    public static int calculateDistanceToStart(Taxi t, Request r){
        int result;
        result = Math.abs(r.getStartX()-t.getPosX()) + Math.abs(r.getStartY()-t.getPosY());
        return result;
    }


    public static int calculateDistance(Request r){
        int result;
        result = Math.abs(r.getStartX()-r.getEndX()) + Math.abs(r.getStartY()-r.getEndY());
        return result;
    }

    public void updateTaxiPosition(Taxi t, int x, int y){
        t.setPosX(x);
        t.setPosY(y);
    }
    //@Problem here
    public static boolean  checkFeasibility(Taxi t, Request r){
        int result;
        System.out.print(t +" "+ r);
        result = calculateDistanceToStart(t,r) + calculateDistance(r) + t.getTime() - r.getEndTime();
        if (result > 0){
            return false;
        }else{
            return true;
        }
    }

    public static int getTimeLimit() {
        return timeLimit;
    }

    public static void setTimeLimit(int t) {
        timeLimit = t;
    }

    //@Problem here
    public static boolean checkTimeOverflow(Taxi t, Request r){
        int x = t.getTime() + t.calulateTime(r);
        if(x <= timeLimit){
            return false;
        }
        return true;
    }

    public static int calculateWaitTime(Taxi t, Request r){
        int result;
        result = calculateDistanceToStart(t,r) + t.getTime() - r.getStartTime();
        return Math.max(0, result);
    }

    public static int calculateBonus(Taxi t, Request r){
        int result;
        result = calculateDistanceToStart(t,r) + t.getTime();
        if (result <= r.getStartTime()){
            return bonus;
        }else{
            return 0;
        }
    }

    public static int getBonus() {
        return bonus;
    }

    public static void setBonus(int b) {
        bonus = b;
    }




}

