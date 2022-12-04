package Roads;

import java.util.Date;

public class Route {
    private int id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate ;
    private Location from = new Location();
    private Location to = new Location();
    private Integer distance;

    public Route(){this.creationDate = new Date();}

    public void setId(int id){this.id = id;}

    public int getId(){return  this.id;}

    public void setName(String name){this.name = name;}

    public String getName(){return this.name;}

    public void setCoordinates(Coordinates co){this.coordinates = co;}

    public Coordinates getCoordinates(){return this.coordinates;}

    public void setDate(Date date){
       this.creationDate = date;
    }

    public Date getDate(){return this.creationDate;}

    public void setFrom(Location location){this.from = location;}

    public void setFrom(String name, Float x, long y){
        this.from.setName(name);
        this.from.setY(y);
        this.from.setX(x);
    }

    public String getFrom(){return "\n\tИмя "+from.getName()+"\n\tКоордината х: "+from.getX()+"\n\tКоордината y: "+from.getY();}

    public Location getFrom(int i){return this.from;}

    public void setTo(Location to){this.to = to;}

    public void setTo(String name, Float x, long y){
        this.to.setName(name);
        this.to.setY(y);
        this.to.setX(x);
    }

    public Location getTo(int i){return this.to;}

    public String getTo(){return "\n\tИмя "+to.getName()+"\n\tКоордината х: "+to.getX()+"\n\tКоордината y: "+to.getY();}

    public void setDistance(Integer distance){this.distance = distance;}

    public Integer getDistance(){return this.distance;}

    public int CompareTo(Object o){
        Route route = (Route)o;
        return (int)(this.getDistance()-route.getDistance());
    }

    public String getInfo() {
        int var10000 = this.id;
        return "Дорога [id:" + var10000 + "]:\n\tНазвание: " + this.name + "\n\tКоординаты:\n\t\tx: " + this.coordinates.getX() + "\n\t\ty: " + this.coordinates.getY() + "\n\tДата cоздания: " + this.getDate() + "\n\tДорога начало " + this.getFrom()+ "\n\tДорога конец " + this.getTo()+"\n\tДистанция: " + this.getDistance();
    }
}