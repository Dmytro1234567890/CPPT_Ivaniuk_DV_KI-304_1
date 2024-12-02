import java.util.ArrayList;

public class TruckDriver {
    public static void main(String[] args) {
        TruckContainer<? super Cargo> truck = new TruckContainer<>();

        truck.addCargo(new Food("Apples", 500));
        truck.addCargo(new Machinery("Excavator", 12000));
        truck.addCargo(new Food("Bananas", 300));
        truck.addCargo(new Machinery("Bulldozer", 15000));

        truck.listCargo();

        Cargo minCargo = truck.findMin();
        if (minCargo != null) {
            System.out.println("The lightest cargo on the truck is:");
            minCargo.print();
        } else {
            System.out.println("No cargo found.");
        }

        truck.removeCargo(2);

        truck.listCargo();
    }
}

class TruckContainer<T extends Cargo> {
    protected ArrayList<T> cargoList;

    public TruckContainer() {
        cargoList = new ArrayList<>();
    }
    /*public TruckContainer(int a) {
        cargoList = new ArrayList<>();
    }*/
    public void addCargo(T cargo) {
        cargoList.add(cargo);
        System.out.print("Cargo added: ");
        cargo.print();
    }

    public void removeCargo(int index) {
        if (index >= 0 && index < cargoList.size()) {
            System.out.println("Removing cargo at index: " + index);
            cargoList.remove(index);
        } else {
            System.out.println("Invalid index. No cargo removed.");
        }
    }

    public T findMin() {
        if (!cargoList.isEmpty()) {
            T min = cargoList.get(0);
            for (T cargo : cargoList) {
                if (cargo.compareTo(min) < 0) {
                    min = cargo;
                }
            }
            return min;
        }
        return null;
    }

    public void listCargo() {
        System.out.println("All cargo in the truck:");
        for (int i = 0; i < cargoList.size(); i++) {
            System.out.print("Index " + i + ": ");
            cargoList.get(i).print();
        }
    }
}

interface Cargo extends Comparable<Cargo> {
    int getWeight();
    void print();
}

class Food implements Cargo {
    private String name;
    private int weight;

    public Food(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Cargo c) {
        return Integer.compare(this.weight, c.getWeight());
    }

    @Override
    public void print() {
        System.out.println("Food Cargo: " + name + ", Weight: " + weight + " kg");
    }
}

class Machinery implements Cargo {
    private String machineName;
    private int weight;

    public Machinery(String name, int weight) {
        this.machineName = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Cargo c) {
        return Integer.compare(this.weight, c.getWeight());
    }

    @Override
    public void print() {
        System.out.println("Machinery Cargo: " + machineName + ", Weight: " + weight + " kg");
    }
}
