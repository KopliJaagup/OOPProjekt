public class Main {
    public static void main(String[] args) {

        System.out.println(Täringud.jätaTäringud(Täringud.Visked(5)));


        Punktitabel punktitabel = new Punktitabel();
        punktitabel.näitaTabel2();
        punktitabel.setP1_yks(2);
        punktitabel.setP1_kuus(24);
        punktitabel.setP1_chance(15);
        punktitabel.setP1_maja(30);
        punktitabel.näitaTabel2();
    }
}