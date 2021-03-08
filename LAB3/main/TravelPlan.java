package main;

import locatii.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelPlan {
    // fiecare preferinta va avea asociata o lista de locatii
    // preferintele sunt de la 0 la infinit
    // preferinta 0 => locatia cea mai dorita
    // mai multe locatii pot avea aceeasi preferinta (nu conteaza ordinea in care vor fi vizitate)
    private Map<Integer, List<Location>> preferences = new HashMap<>();
    private City city;

    public TravelPlan(City city) {
        this.city = city;
    }

    public void addPreference(int preferenceValue, Location location) {
        if (!preferences.containsKey(preferenceValue))
            preferences.put(preferenceValue, new ArrayList<>());

        preferences.get(preferenceValue).add(location);
    }
}
