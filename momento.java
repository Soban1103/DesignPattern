import java.util.ArrayList;
import java.util.List;

class Originator{
    private int temperature;
    private int volume;

    public Originator(int t,int v){
        temperature = t;
        volume = v;

    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getTemperature() {
        return temperature;
    }
    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Temperature is : " + temperature + " & Volume is : " + volume;
    }

    public void restoreToState(Memento m){
        temperature = m.getTemperature();
        volume = m.getVolume();
    }

    public Memento saveStatetoMemento(){
        return new Memento(temperature, volume);
    }
}

class Memento{
//body will same as originator only difference is that it does not have setter methods

    private int temperature;
    private int volume;

    public Memento(int t,int v){
        temperature = t;
        volume = v;

    }
  

    public int getTemperature() {
        return temperature;
    }
    public int getVolume() {
        return volume;
    }

    public String toString() {
        return "Temperature is : " + temperature + " & Volume is : " + volume;
    }

}

class CareTaker{
    List<Memento> lm = new ArrayList<Memento>();

    public void addMemento(Memento m){
        lm.add(m);
    }

    public Memento getMementoObject(int i){
        return lm.get(i);

    }

}

public class momento {
   public static void main(String[] args) {
    Originator o1 = new Originator(15, 20);
    System.out.println(o1);

    CareTaker cto = new CareTaker();
    Memento m1 = o1.saveStatetoMemento();
    cto.addMemento(m1);

    o1.setTemperature(20);
    o1.setVolume(50);
    System.out.println(o1);

    m1 = o1.saveStatetoMemento();
    cto.addMemento(m1);
    
    o1.setTemperature(25);
    o1.setVolume(26);
    System.out.println(o1);
    m1 = o1.saveStatetoMemento();
    cto.addMemento(m1);
    

    o1.restoreToState(cto.getMementoObject(0));
    System.out.println(o1);

   } 
}
