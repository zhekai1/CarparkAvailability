public class Carpark {

    private String area;
    private String availability;
    public Carpark(String area, String availability) {
        this.area = area;
        this.availability = availability;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Carpark" + "\n" +
                "Area: '" + area + "\n" +
                "Availability: " + availability;
    }
}