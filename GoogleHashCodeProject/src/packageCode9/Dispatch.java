package packageCode9;

import java.util.*;

public class Dispatch {

    int bonus;
    int timeLimit;
    int maxSteps;
    List<Request> requests = new ArrayList<Request>();
    Taxi[] taxis;

    public void addRequest(Request r){
        requests.add(r);
    }

    public void startDispatching(int taxisNr, int b){
            this.bonus = b;
            this.taxis = new Taxi[taxisNr];

            while(!(requests.isEmpty()) && !(noFeasibleRides())) {

                for (int i = 0; i < this.taxis.length; i++) {
                    int tempPoints1 = 0;
                    Request tempRequest = null;

                    for (Request r : requests) {
                        int tempPoints2 = points(this.taxis[i], r);
                        if (tempPoints2 > tempPoints1 && checkFeasibility(taxis[i], r) && checkTimeOverflow(taxis[i], r)) {
                            tempPoints1 = tempPoints2;
                            tempRequest = r;
                        }
                    }

                    this.taxis[i].assignRequest(tempRequest);
                    deleteRequest(tempRequest);


                }

            }
    }

    public boolean noFeasibleRides(){

        for (int i = 0; i < this.taxis.length; i++) {
            for (Request r : requests) {
                if(checkFeasibility(this.taxis[i],r)){
                    return false;
                }
            }
        }
        return true;
    }


    public int points(Taxi t, Request r){
        int points;
        points = calculateDistance(r) + calculateBonus(t,r) - r.getEndTime() - calculateWaitTime(t,r) - t.getTime() - calculateDistanceToStart(t,r);
        return points;
    }

    public void assignRequestToTaxi(Taxi t, Request r){
        t.assignRequest(r);
    }

    public void deleteRequest(Request r){
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

    public boolean  checkFeasibility(Taxi t, Request r){
        int result;
        result = calculateDistanceToStart(t,r) + calculateDistance(r) + t.getTime() - r.getEndTime();
        if (result > 0){
            return false;
        }else{
            return true;
        }
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean checkTimeOverflow(Taxi t, Request r){
        int x = t.getTime() + t.calulateTime(r);
        if(x<=timeLimit){
            return false;
        }
        return true;
    }

    public static int calculateWaitTime(Taxi t, Request r){
        int result;
        result = calculateDistanceToStart(t,r) + t.getTime() - r.getStartTime();
        return Math.max(0, result);
    }

    public int calculateBonus(Taxi t, Request r){
        int result;
        result = calculateDistanceToStart(t,r) + t.getTime();
        if (result <= r.getStartTime()){
            return bonus;
        }else{
            return 0;
        }
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


}

