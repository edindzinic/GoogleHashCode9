public class Request {

    static int number;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static int startTime;
    static int endTime;
    static int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int p) {
    	points = p;
    }

    public Request(int n, int sX, int sY, int eX, int eY, int sT, int eT) {
        number = n;
        startX = sX;
        startY = sY;
        endX = eX;
        endY = eY;
        startTime = sT;
        endTime = eT;
    }

    public int getNumber() {
        return number;
    }

    public static void setNumber(int n) {
        number = n;
    }

    public int getStartX() {
        return startX;
    }

    public static void setStartX(int sX) {
        startX = sX;
    }

    public int getStartY() {
        return startY;
    }

    public static void setStartY(int sY) {
    	startY = sY;
    }

    public int getEndX() {
        return endX;
    }

    public static void setEndX(int eX) {
        endX = eX;
    }

    public int getEndY() {
        return endY;
    }

    public static void setEndY(int eY) {
        endY = eY;
    }

    public int getStartTime() {
        return startTime;
    }

    public static void setStartTime(int sT) {
        startTime = sT;
    }

    public int getEndTime() {
        return endTime;
    }

    public static void setEndTime(int eT) {
        endTime = eT;
    }
}
