import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String news);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}

class NewsAgency {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void setNews(String news) {
        this.news = news;
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for(Observer o : observers) {
            o.update(news);
        }
    }
}

public class ObserverDemo {

    public static void main(String[] args){
        NewsAgency agency = new NewsAgency();

        Observer s1 = new Subscriber("Sachith");
        Observer s2 = new Subscriber("Avintha");
        Observer s3 = new Subscriber("Abeywardhana");

        agency.addObserver(s3);
        agency.addObserver(s2);
        agency.addObserver(s1);

        agency.setNews("New Design Pattern Released");
        agency.setNews("Observer Pattern explained");
    }
}