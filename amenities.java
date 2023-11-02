public class Amenity {
    private String name;
    private boolean state;

    public Amenity(String name, boolean State) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    private void setName() {
        this.name = name;
    }

    public boolean getState() {
        return state;
    }

    public void setState() {
        this.state = state;
    }

    public void isOpen(Amenity amenity) {
        if (amenity.getState() == false) {
            System.out.println(amenity.getName() + " is closed.");
        }
        else {
            System.out.println(amenity.getName() + " is open.");
        }
    }

    public static void main(String[] args) {

        String name = "pool";
        boolean state = false;

        Amenity amen = new Amenity(name, state);

        amen.getName();
        amen.isOpen(amen);

    }

}