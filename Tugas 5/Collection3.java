import java.util.HashMap;
import java.util.Map;

public class Collection3 {
    public static void main (String args []) {
        Map<String, String> perusahaan = new HashMap<String, String>();
        perusahaan.put("Apple", "Steven Paul Jobs");
        perusahaan.put("Facebook", "Mark Zuckerberg");
        perusahaan.put("Instagram", "Kevin Systrom");
        perusahaan.put("Linux", "Linux Benedict Torvalds");
        perusahaan.put("Microsoft", "Bill Gates");
        perusahaan.put("Twitter", "Jack Dorsey");

        for (String i: perusahaan.keySet()){
            System.out.println(i.toUpperCase() + " dikembangkan oleh " + perusahaan.get(i));
        }
    }
}