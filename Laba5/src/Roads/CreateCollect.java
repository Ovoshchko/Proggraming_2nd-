package Roads;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateCollect {
    private Scanner scanner;

    public CreateCollect() {
        this.scanner = new Scanner(System.in);
    }

    public Route create(String id) {
        Route route = new Route();
        if (id.equals("free")) {
            route.setId((Integer)RouteCollection.makeId());
        } else {
            route.setId(Integer.parseInt(id));
        }

        this.setName(route);
        Coordinates coordinates = new Coordinates();
        this.setCoordinateX(coordinates);
        this.setCoordinateY(coordinates);
        route.setCoordinates(coordinates);
        Location locTo = new Location();
        Location locFrom = new Location();
        this.setNameLoc(locFrom);
        this.setCoordinateX(locFrom);
        this.setCoordinateY(locFrom);
        route.setFrom(locFrom);
        this.setNameLoc(locTo);
        this.setCoordinateX(locTo);
        this.setCoordinateY(locTo);
        route.setTo(locTo);
        this.setDistance(route);
        return route;
    }

    public void setName(Route route) {
        System.out.println("Введите название дороги.");
        System.out.print("$ ");
        String name = this.scanner.nextLine();
        if (!name.equals("") && !name.equals("null")) {
            route.setName(name);
        } else {
            this.setName(route);
        }

    }

    public void setCoordinateX(Coordinates coords) {
        try {
            System.out.println("Введите координату x:");
            System.out.print("~ ");
            String x = this.scanner.nextLine();
            if (!x.equals("") && !x.equals((Object)null)) {
                long xn = Long.parseLong(x);
                if (xn >= -486.0) {
                    coords.setX(xn);
                } else {
                    System.out.println("Минимальное значение поля: -486");
                    this.setCoordinateX(coords);
                }

                coords.setX(xn);
            } else {
                this.setCoordinateX(coords);
            }
        } catch (NumberFormatException | InputMismatchException v) {
            //v.printStackTrace();
            System.out.println("Значение должно быть типа:\"long\".");
            this.setCoordinateX(coords);
        }

    }

    public void setCoordinateY(Coordinates coords) {
        try {
            System.out.println("Введите координату y:");
            System.out.print("~ ");
            String y = this.scanner.nextLine();
            if (!y.equals("") && !y.equals((Object)null)) {
                double yn = Double.parseDouble(y);
                if (yn <= 15) {
                    coords.setY(yn);
                } else {
                    System.out.println("Максимальное значение поля: 15");
                    this.setCoordinateY(coords);
                }

                coords.setY(yn);
            } else {
                this.setCoordinateY(coords);
            }
        } catch (NumberFormatException | InputMismatchException v) {
            System.out.println("Значение должно быть типа:\"double\".");
            this.setCoordinateY(coords);
        }

    }

   public void setNameLoc(Location loca){
       System.out.println("Введите название локации.");
       System.out.print("$ ");
       String name = this.scanner.nextLine();
       if (!name.equals("") && !name.equals("null")&&(name.length()<=425)) {
           loca.setName(name);
       } else {
           this.setNameLoc(loca);
       }
   }

    public void setCoordinateX(Location loca) {
        try {
            System.out.println("Введите координату x:");
            System.out.print("~ ");
            String x = this.scanner.nextLine();
            if (!x.equals("") && !x.equals((Object)null)) {
                float xn = Float.parseFloat(x);
                loca.setX(xn);
            } else {
                this.setCoordinateX(loca);
            }
        } catch (NumberFormatException | InputMismatchException v) {
            System.out.println("Значение должно быть типа:\"float\".");
            this.setCoordinateX(loca);
        }

    }

    public void setCoordinateY(Location loca) {
        try {
            System.out.println("Введите координату y:");
            System.out.print("~ ");
            long y = this.scanner.nextLong();
            loca.setY(y);
        } catch (NumberFormatException | InputMismatchException v) {
            System.out.println("Значение должно быть типа:\"long\".");
            this.setCoordinateY(loca);
        }

    }


    public void setDistance(Route route){
        try{
            System.out.println("Введите дистанцию:");
            System.out.print("~ ");
            String dist = this.scanner.nextLine();
            if (!dist.equals("") && !dist.equals((Object)null)) {
                Integer dista = Integer.parseInt(dist);
                if (dista>1){
                    route.setDistance(dista);
                }
                else {
                    System.out.println("Значение должно быть больше 1.");
                    this.setDistance(route);
                }
            } else {
                this.setDistance(route);
            }
        } catch(NumberFormatException | InputMismatchException v){
            System.out.println("Значение должно быть типа:\"Integer\".");
            this.setDistance(route);
        }
    }
}
