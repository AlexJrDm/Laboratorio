public class Person {
    private String names;
    private String surnames;
    private int age;
    private Long cedula;
    private String ticketType;
    private  double ticketPrice;


    public Person(String names, String surnames, int age, Long cedula, String ticketType, double ticketPrice) {
        this.names = names;
        this.surnames = surnames;
        this.age = age;
        this.cedula = cedula;
        this.ticketType = ticketType;
        this.ticketPrice = ticketPrice;

    }

    public String getNames() {
        return names;
    }

    public String getSurnames() {
        return surnames;
    }

    public int getAge() {
        return age;
    }

    public Long getCedula() {
        return cedula;
    }

    public String getTicketType() {
        return ticketType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }



}
