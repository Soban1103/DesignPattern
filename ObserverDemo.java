import java.util.*;
interface Observer {
    public void update(String name, String message);
}

interface Subject {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
    public void notify(String message);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String channelName, String videoName) {
        System.out.println(this.name + " you have to see a video " + videoName + " from " + channelName);
    }

}


class Channel implements Subject {
    private String name;
    private ArrayList<Observer> subscribers;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<Observer>();
    }

    @Override
    public void subscribe(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notify(String videoName) {
        for(Observer subscriber: this.subscribers)
            subscriber.update(this.name, videoName);
    }

    public void videoName(String videoName) {
        System.out.println(this.name + " has uploaded " + videoName + " video on his/her channel");
        this.notify(videoName);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        Channel freeCodeCamp = new Channel("FreeCodeCamp");
        Channel neuralNine = new Channel("Neural Nine");
        Channel sentdex = new Channel("sentdex");

        Subscriber kunal = new Subscriber("Kunal");
        Subscriber tanmay = new Subscriber("Tanmay");
        Subscriber bhavya = new Subscriber("Bhavya");
        Subscriber kishan = new Subscriber("Kishan");
        Subscriber priyank = new Subscriber("Priyank");

        freeCodeCamp.subscribe(kunal);
        freeCodeCamp.subscribe(kishan);
        neuralNine.subscribe(bhavya);
        neuralNine.subscribe(tanmay);
        sentdex.subscribe(priyank);
        sentdex.subscribe(kunal);

        freeCodeCamp.videoName("Introduction to Reinforcement learning");
        neuralNine.videoName("Develop Blockchain in Python");
        sentdex.videoName("Introduction to MindsDB");
        sentdex.unsubscribe(kunal);
        sentdex.videoName("Getting started with Julia");
    }
}