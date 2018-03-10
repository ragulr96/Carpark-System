import java.util.*;

public class WestminsterCarParkManager implements CarParkManager {

        private static int slots = 20;


        static Scanner input = new Scanner(System.in);
        static ArrayList<Van> list = new ArrayList<Van>();
        static ArrayList<Car> list1 = new ArrayList<Car>();
        static ArrayList<motorBike> list2 = new ArrayList<motorBike>();
        static ArrayList<Vehicle> list3 = new ArrayList<Vehicle>();

        public static void main(String[] args) {
            System.out.println("                        -------------------------------------");
            System.out.println("                        >> WELCOME TO WESTMINSTER CAR_PARK <<");
            System.out.println("                        =====================================");

            Calendar cal = Calendar.getInstance();
            cal.set(2017, 8, 20);
            Date dste = cal.getTime();
            System.out.println("                            " + cal.getTime().toString());
            parkRegestry();
        }

        public static void parkRegestry() {
            System.out.println("\n" + "(01) - Press [1] to Regester Vehicles  ");
            System.out.println("(02) - Press [2] to View Vehicles details ");
            System.out.println("(03) - Press [3] to Remove Vehicles details ");
            System.out.println("(04) - Press [4] to view all the data of the Day ");
            System.out.println("(05) - Press [5] to view the parking cost ");
            System.out.println("(06) - Press [6] to find vehicle by date ");
            System.out.println("(06) - Press [0] to Statistic details of Vehicles ");
            System.out.print("Tab Your Selction : ");
            String user = input.next();

            switch (user) {
                case "1":
                    System.out.println("\n" + " - Press [4] to regester Van");
                    System.out.println(" - Press [5] to regester Car");
                    System.out.println(" - Press [6] to regester MotorBike");
                    System.out.print("Tab Your Selction : ");
                    String user1 = input.next();
                    switch ((user1)) {
                        case "4":
                            parkVan();
                            break;
                        case "5":
                            parkCar();
                            break;
                        case "6":
                            parkBike();
                            break;
                        default:
                            System.err.println("Iinvalid selection " + "\n");
                            parkRegestry();
                    }

                    break;
                case "2":
                    if (list.isEmpty() && list1.isEmpty() && list2.isEmpty()) {
                        System.err.println(" There is no details , Please Enter details ");
                        parkRegestry();
                    } else {
                        viewVan();
                        viewCar();
                        viewBike();
                    }
                    break;
                case "3":
                    System.out.println("\n" + " - Press [v] to release Van");
                    System.out.println(" - Press [c] to release Car");
                    System.out.println(" - Press [m] to release MotorBike");
                    System.out.print("Tab Your Selction : ");
                    user1 = input.next();
                    switch ((user1)) {
                        case "v":
                            releasePark();
                            break;
                        case "c":
                            releasePark1();
                            break;
                        case "m":
                            releasePark2();
                            ;
                            break;
                    }
                case "4":
                    viewAllData();
                    break;
                case "5":
                    calCost();
                    break;
                case "6":
                    findVehicle();
                    break;
                case "0":
                    viewStatic();
                    break;
                default:
                    System.err.println("invalid input Please read the instruction and , try again");
                    parkRegestry();
            }
        }

        public static void end() {
            System.out.println("\n" + "Press [9] to END ");
            System.out.println("Press [8] to COUNTINUE ");
            System.out.print("Tab Your Selction : ");
            String user = input.next();
            switch (user) {
                case "9":
                    input.close();
                    System.out.println("Thank you for using our Service , Come again");
                    break;
                case "8":
                    parkRegestry();
                    break;
                default:
                    System.err.println("invalid input Please read the instruction and , try again");
                    end();
            }
        }

        public static void viewStatic() {
            double sVan = list.size();
            System.out.println("\n - The percentage of Vans in the parking : " + ((sVan * 100) / 20) + "%");
            double sCar = list1.size();
            System.out.println(" - The percentage of Cars in the parking : " + ((sCar * 100) / 20) + "%");
            double sBike = list2.size();
            System.out.println(" - The percentage of Bikes in the parking : " + ((sBike * 100) / 20) + "%");

            System.out.println(" - The total filled space of the parking : " + (((sVan * 100) / 20)+((sCar * 100) / 20)+((sBike * 100) / 20)) + "%");
            end();
        }

        public static void parkVan() {
            System.out.println("\n" + "            Regester the Van details in oder");
            System.out.println("            --------------------------------");
            System.out.print("[01] - Enter Vehicle Name : ");
            String vehicleName = input.next();

            System.out.print("[02] - Enter Vehicle number : ");
            String number = input.next();

            System.out.print("[03] - Enter the wheeler : ");
            int wheeler = input.nextInt();

            System.out.print("[04] - Enter the Cargo volume : ");
            int volume = input.nextInt();

            System.out.print("[04] - Enter the Date and time (DD.MM.YYYY.HH.MM.SS) : ");
            String date = input.next();
            String[] day = date.split("\\.");
            slots = slots - 2;

            list.add(new Van(vehicleName, number, wheeler, volume, date));
            list3.add((new Vehicle(vehicleName, number, wheeler, date)));
            end();
        }

        public static void viewVan() {
            Collections.reverse(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.print("\n" + "Date of Enter : " + list.get(i).getDate() + "\n");
                System.out.println("Entered Time : " + list.get(i).getDate().toTime());
                System.out.print("Vehile type : " + list.get(i).getVehicleName() + "\n");
                System.out.print("Vehile number : " + list.get(i).getVehicleNum() + "\n");
            }
        }

        public static void releasePark() {
            System.out.println("No of Vans in the parking : " + list.size());
            for (int x = 0; x < list.size(); x++) {
                System.out.println("Plate Id of the vehicle : " + list.get(x).getVehicleNum());
            }
            System.out.print("Enter Vehicle plat Id to remove :");
            String carName = input.next();// insert code here
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getVehicleNum().equals(carName)) {
                    index = i;
                    System.out.println("\nVehile number : " + list.get(i).getVehicleNum());
                    System.out.println("Entered Date : " + list.get(i).getDate().toString());
                    list.remove(list.remove(i));

                }
            }
            slots = slots +2;
            System.out.print("Available parking slots : " + slots + "\n");
            end();
        }





        public static void parkCar() {
            System.out.println("\n" + "            Regester the Car details in oder");
            System.out.println("            --------------------------------");
            System.out.print("[01] - Enter Vehicle Name : ");
            String vehicleName = input.next();

            System.out.print("[02] - Enter Vehicle number : ");
            String number = input.next();

            System.out.print("[03] - Enter the wheeler : ");
            int wheeler = input.nextInt();

            System.out.print("[04] - Enter the Colour : ");
            String Colour = input.next();

            System.out.print("[05] - Enter the No of Doors : ");
            int doors = input.nextInt();

            System.out.print("[04] - Enter the Date and time (DD.MM.YYYY.HH.MM.SS) : ");
            String date = input.next();
            String[] day = date.split("\\.");
            --slots;
            list1.add(new Car(vehicleName, number, wheeler, Colour, date, doors));
            list3.add((new Vehicle(vehicleName, number, wheeler, date)));
            end();
        }

        public static void findVehicle() {
            System.out.println("No of Bikes in the parking : " + list3.size());
            for (int x = 0; x < list3.size(); x++) {
                System.out.println("Date of the vehicle : " + list3.get(x).getDate().toString() + " Time " +  list3.get(x).getDate().toTime());
            }

            System.out.print("Enter Date to find vehicles dd mm yyyy hh mm ss : ");
            String date = input.next();// insert code here
            String []day = date.split("\\.");
            //int index = -1;
            int year = Integer.parseInt(day[2]);
            int month = Integer.parseInt(day[1]);
            int toDay = Integer.parseInt(day[0]);

            for (int i = 0; i < list3.size(); i++) {
                if (list3.get(i).getDate().getDay() == year &&  list3.get(i).getDate().getMonth() == month && list3.get(i).getDate().getYear() == toDay) {
                    System.out.println("Vehile Number : " + list3.get(i).getVehicleNum());
                    System.out.println("Vehicle Name : " + list3.get(i).getVehicleName());
                    System.out.println("Entered Date : " + list3.get(i).getDate().toString());
                }
            }
            slots++;
            end();
        }

        public static void viewCar() {
            Collections.reverse(list1);
            for (int i = 0; i < list1.size(); i++) {
                System.out.print("\n" + "Date of Enter : " + list1.get(i).getDate().toString() + "\n");
                System.out.println("Entered Time : " + list1.get(i).getDate().toTime());
                System.out.print("Vehile type : " + list1.get(i).getVehicleName() + "\n");
                System.out.print("Vehile number : " + list1.get(i).getVehicleNum() + "\n");
            }
        }

        public static void releasePark1() {
            System.out.println("No of Cars in the parking : " + list1.size());
            for (int x = 0; x < list1.size(); x++) {
                System.out.println("Plate Id of the vehicle : " + list1.get(x).getVehicleNum());
            }
            System.out.print("Enter Vehicle plat Id to remove :");
            String carName = input.next();
            int index = -1;
            for (int i = 0; i < list1.size(); i++) {
                if (list.get(i).getVehicleNum().equals(carName)) {
                    index = i;
                    System.out.println("Vehile number : " + list1.get(i).getVehicleNum());
                    System.out.println("Entered Date : " + list1.get(i).getDate().toString());
                    list1.remove(list1.remove(i));
                }
            }
            slots++;
            System.out.print("Available parking slots : " + slots + "\n");
            end();
        }

        public static void parkBike() {
            System.out.println("\n" + "            Regester the Bike details in oder");
            System.out.println("            ---------------------------------");
            System.out.print("[01] - Enter Vehicle Name : ");
            String vehicleName = input.next();

            System.out.print("[02] - Enter Vehicle number : ");
            String number = input.next();

            int wheeler = 2;

            System.out.print("[04] - Enter the Engin Capacity : ");
            double CC = input.nextDouble();

            System.out.print("[04] - Enter the Date and time (DD.MM.YYYY.HH.MM.SS) : ");
            String date = input.next();
            String[] day = date.split("\\.");
            --slots;
            list2.add(new motorBike(vehicleName, number, wheeler, date, CC));
            list3.add((new Vehicle(vehicleName, number, wheeler, date)));
            end();
        }

        public static void viewBike() {
            Collections.reverse(list2);
            for (int i = 0; i < list2.size(); i++) {
                System.out.print("\n" + "Date of Enter : " + list2.get(i).getDate().toString() + "\n");
                System.out.println("Entered Time : " + list2.get(i).getDate().toTime());
                System.out.print("Vehile type : " + list2.get(i).getVehicleName() + "\n");
                System.out.print("Vehile number : " + list2.get(i).getVehicleNum() + "\n");
                System.out.print("Engine Capacity : " + list2.get(i).getEngineCapacity() + "\n");
            }
            System.out.print("\nAvailable parking slots : " + slots + "\n");
            end();
        }

        public static void releasePark2() {
            System.out.println("No of Bikes in the parking : " + list2.size());
            for (int x = 0; x < list2.size(); x++) {
                System.out.println("Plate Id of the vehicle : " + list2.get(x).getVehicleNum());
            }
            System.out.print("Enter Vehicle plat Id to remove :");
            String carName = input.next();// insert code here
            int index = -1;
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i).getVehicleNum().equals(carName)) {
                    index = i;
                    System.out.println("Vehile number : " + list2.get(i).getVehicleNum());
                    System.out.println("Entered Date : " + list2.get(i).getDate().toString());
                    list2.remove(list2.remove(i));
                }
            }
            System.out.print("Available parking slots : " + slots + "\n");
            end();
        }

        public static void viewAllData() {
            for (int i = 0; i < list3.size(); i++) {
                System.out.println("\nThe Plat Id of the Vehicle : " + list3.get(i).getVehicleNum());
                System.out.println("The Modle of the Vehicle : " + list3.get(i).getVehicleName());
                System.out.println("The time of the Entramce : " + list3.get(i).getDate().toString());
                System.out.println("Entered Time : " + list3.get(i).getDate().toTime());
            }
            end();
        }

        public static void calCost(){
            System.out.println("Enter Leaving time : ");
            String lDate = input.next();
            String[] day = lDate.split("\\.");
            int hour = Integer.parseInt(day[3]);
            int min = Integer.parseInt(day[4]);
            int sec = Integer.parseInt(day[5]);
            int endTime = ((hour*60*60)+(min*60)+sec);
            for(int x=0; x<list3.size(); x++) {
                System.out.println("Vehile number : " + list3.get(x).getVehicleNum());
                System.out.println("Entered Date : " + list3.get(x).getDate().toString());

                double cost = 0.0;
                int hour1 = (endTime - (list3.get(x).getDate().getStartTime())) / 3600;
                if (hour1 <= 3) {

                    cost = hour1 * 3;
                    System.out.println("The cost is 3$ per hour : " + cost + "$");
                } else if(hour1 <= 24){

                    cost = (hour1 - 3) + 9;
                    System.out.println("The cost is 9$ for first 3hour and 1$ per hour : " + cost + "$");
                }
            }

        }

    }
