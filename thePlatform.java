import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class thePlatform {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Query query = new Query(sc.nextLine());
        getMediaAll(query);
    }

    private static class Media {
        String title;

        public Media(){}

        public Media(String title) {
            this.title = title;
        }
    }

    private static class Query {
        String query;

        Query(String query) {
            this.query = query;
        }
    }

    static List<Media> getMediaAll(Query query) {
        List<Media> list = new ArrayList<>();
        int startCounter = 0;
        int endCounter = 500;

        if(getMedia(query,0,500).size() <= 500) {
            list.addAll(getMedia(query,0,500));
        } else {

            // keep adding the Media objects into the list
            // exit the loop when you have less than 500 Media objects
            while(getMedia(query,startCounter,endCounter).size() == 500) {
                list.addAll(getMedia(query,startCounter,endCounter));
                startCounter = ++endCounter;
                endCounter += 500;
            }

            // add the remaining Media objects from the database < 500
            list.addAll(getMedia(query,startCounter,endCounter));
        }

        return list;
    }

    static List<Media> getMedia(Query query, int startIndex, int endIndex) {

        List<Media> list = new ArrayList<>();

        // add 500 Media objects into the list
        for(int i = 0; i < 500; ++i) {
            list.add(new Media(String.valueOf(i)));
        }

        return list;
    }

}
