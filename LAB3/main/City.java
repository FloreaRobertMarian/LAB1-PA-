package main;

import locatii.Location;
import locatii.Visitable;

import java.util.ArrayList;
import java.util.List;

public class City {
    private List<Location> nodes = new ArrayList<>();

    public List<Location> getNodes() {
        return nodes;
    }

    public void addLocation(Location node) {
        nodes.add(node);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("Orasul contine locatiile:\n");

        for (var node : nodes)
            ret.append(node.getName()).append('\n');

        return ret.toString();
    }

    void displayVisitableNotPayable() {
        List<Visitable> visitableNotPayable = new ArrayList<>();

        for (var node : nodes) {
            Class<?>[] interfaces = node.getClass().getInterfaces();
            boolean visitable = false;
            boolean payable = false;
            for (var interfata : interfaces)
                if (interfata.getName().equals("locatii.Visitable"))
                    visitable = true;
                else if (interfata.getName().equals("locatii.Payable"))
                    payable = true;

            if (visitable && !payable)
                visitableNotPayable.add((Visitable) node);
        }

        // sortez folosind un lambda function
        visitableNotPayable.sort((Visitable l1, Visitable l2) -> {
            return l1.getOpeningTime().compareTo(l2.getOpeningTime());
        });

        for (var location : visitableNotPayable) {
            System.out.println(((Location) location).getName());
        }
    }
}
