import java.util.*;
enum cases {
    stop,
    park,
    unpark,
    spots
}
public class ParkingLot {
    static int availSpots = 30;
    public static void main(String[] args) {
        ParkingSpot[][] arr = new ParkingSpot[3][10];
        for (int i = 0; i < arr.length; i++) {
            for(int j =0; j<4; j++){
                arr[i][j]= new ParkingSpot("small");
            }
            for(int j =4; j<7; j++){
                arr[i][j]= new ParkingSpot("medium");
            }
            for(int j =7; j<10; j++){
                arr[i][j]= new ParkingSpot("large");
            }
        }
        boolean running = true;
        Scanner in = new Scanner(System.in);

        while(running){
            System.out.println("Type stop to close program \n park to park\n unpark to unpark \n spots to know the available spots");
            String s1 = in.next();
            cases c;
            c= cases.;
            switch(c) {
                case stop:
                    running = false;
                    break;
                case park:
                    System.out.println("type vehicle size");
                    String str1 = in.next();
                    if(str1.equals("bike")){
                        System.out.println("type the name of the bike");
                        String bike1 = in.next();
                        bike b1 = new bike(bike1);
                        System.out.println(park(arr, b1));
                    }
                    else if(str1.equals("car")){
                        System.out.println("type the name of the car");
                        String car1 = in.next();
                        car c1 = new car(car1);
                        System.out.println(park(arr, c1));
                    }
                    else if(str1.equals("bus")){
                        System.out.println("type the name of the bus");
                        String bus1 = in.next();
                        bus bu1 = new bus(bus1);
                        System.out.println(park(arr, bu1));
                    }
                    break;
                case spots:
                    System.out.println(availSpots);
                    break;
                case unpark:
                    System.out.println("Type the name of the vehicle");
                    String unp = in.next();
                    unpark(arr,unp);
                    break;
            }
        }

    }
    public static String park(ParkingSpot arr[][], bike b){
        int i = 0;
        int j = 0;
        while (i<arr.length){
            try {
                if(arr[i][j].vacant && arr[i][j].spotSize.equals("small")){
                    arr[i][j].vacant = false;
                    arr[i][j].name = b.name;
                    availSpots--;
                    return "Bike is parked successfully";
                }
                else{
                    j++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Didn't find a spot in this going upper level");
                i++;
                j = 0;
            }
        }
        return "No space available";
    }
    public static String park(ParkingSpot arr[][], car b){
        int i = 0;
        int j = 0;
        while (i<arr.length){
            try {
                if(arr[i][j].vacant && arr[i][j].spotSize.equals("medium")){
                    arr[i][j].vacant = false;
                    arr[i][j].name = b.name;
                    availSpots--;
                    return "car is parked successfully";
                }
                else{
                    j++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Didn't find a spot in this going upper level");
                i++;
                j = 0;
            }
        }
        return "No space available";
    }
    public static String park(ParkingSpot arr[][], bus b){
        int i = 0;
        int j = 0;
        while (i<arr.length){
            try {
                if(arr[i][j].vacant && arr[i][j].spotSize.equals("large")){
                    arr[i][j].vacant = false;
                    arr[i][j].name = b.name;
                    availSpots--;
                    return "bus is parked successfully";
                }
                else{
                    j++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Didn't find a spot in this going upper level");
                i++;
                j = 0;
            }
        }
        return "No space available";
    }
    public static void unpark(ParkingSpot[][] arr,String b){
        for(int i =0; i<arr.length; i++){
            for(int j=0; j<arr[i].length;j++){
                if(arr[i][j].name!=null && arr[i][j].name.equals(b)){
                    arr[i][j].name=null;
                    arr[i][j].vacant = true;
                    System.out.println("Vehicle unparked successfully");
                    availSpots++;
                    return;
                }
            }
        }
        System.out.println("No vehicle of the said name");
    }
}