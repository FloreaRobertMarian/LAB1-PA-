package main;

import locatii.*;

import java.time.Duration;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel("v1");

        Museum v2 = new Museum("v2");
        v2.setOpeningTime(LocalTime.of(8, 30));
        v2.setClosingTime(LocalTime.of(20, 0));

        Museum v3 = new Museum("v3");
        v3.setOpeningTime(LocalTime.of(8, 0));
        v3.setClosingTime(LocalTime.of(21, 0));

        Church v4 = new Church("v4");
        v4.setOpeningTime(LocalTime.of(8, 30));
        v4.setClosingTime(LocalTime.of(20, 15));

        Church v5 = new Church("v5");
        v5.setOpeningTime(LocalTime.of(13, 0));
        v5.setClosingTime(LocalTime.of(18, 50));

        Restaurant v6 = new Restaurant("v6");

        // adaug costurile intre ele
        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v3.setCost(v2, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v5.setCost(v4, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        City city = new City();

        // adaug locatiile
        city.addLocation(v1);
        city.addLocation(v2);
        city.addLocation(v3);
        city.addLocation(v4);
        city.addLocation(v5);
        city.addLocation(v6);

        System.out.println(city);

        city.displayVisitableNotPayable();

        Duration duration = Visitable.getVisitingDuration(v4);
        System.out.println(duration.toHours());

        TravelPlan travelPlan = new TravelPlan(city);
        travelPlan.addPreference(0, v1);
        travelPlan.addPreference(1, v2);
        travelPlan.addPreference(1, v3);
        travelPlan.addPreference(2, v5);
        travelPlan.addPreference(3, v6);
    }
}
