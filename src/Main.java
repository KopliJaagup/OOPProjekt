import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Punktitabel punktitabel = new Punktitabel();
        ArrayList täring;

        System.out.println("YATZY");

        for (int i = 0; i < 15; i++) {
            System.out.println("Mängija 1 kord");
            täring = käik();
            Loogika.pane(täring, punktitabel, 1);

            System.out.println("Mängija 2 kord");
            täring = käik();
            Loogika.pane(täring, punktitabel, 2);

            if (i != 14) {
                punktitabel.näitaTabel();
            }
        }

        punktitabel.näitaTabel();

        int skoor_p1 = punktitabel.getP1_sSumma();
        int skoor_p2 = punktitabel.getP2_sSumma();

        if (skoor_p1 > skoor_p2) {
            System.out.println("Mängija 1 võitis!");
        } else if (skoor_p2 > skoor_p1) {
            System.out.println("Mängija 2 võitis!");
        } else {
            System.out.println("Mäng lõppes viigiga!");
        }

    }

    public static ArrayList käik() {
        ArrayList täring;

        täring = Täringud.Visked(5);
        täring = Täringud.jätaTäringud(täring);
        System.out.println("Kuhu soovid enda visatud tulemuse kirja panna?");

        return täring;
    }
}