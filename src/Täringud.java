import java.util.ArrayList;
import java.util.Scanner;

public class Täringud {

    public static void main(String[] args) {
    }

    public static int täringuSilmad() {
        int m = (int) (Math.random() * (6 - 1 + 1) + 1);
        return m;
    }

    public static ArrayList Visked(int täringuteArv) {
        ArrayList visked = new ArrayList<>();
        for (int i = 0; i < täringuteArv; i++) {
            visked.add(täringuSilmad());
        }
        return visked;
    }

    public static ArrayList jätaTäringud(ArrayList täringud) {
        int viseteArv = 1;
        System.out.println("Esimese viskega tuli: " + täringud);
        ArrayList valitudTäringud = täringud;
        for (int a = viseteArv; a < 3; a++) {
            System.out.println("Sisesta mitu täringut tahad alles jätta: ");
            System.out.println("Juhul kui ei taha uuesti visata sisesta 5");
            int mitu = 0;
             boolean tr = true;
             while (tr) {
                Scanner mituTäringut = new Scanner(System.in); // mitu täringut jätta
                if (mituTäringut.hasNextInt()) {
                    tr = false;
                    mitu = mituTäringut.nextInt();
                    break;
                } else {
                    System.out.println("Sisesta õige number:");
                }
            }

            if (Integer.parseInt(String.valueOf(mitu)) == 1) {
                System.out.println("Sisesta nr milliseid täringuid tahad jätta: täring 1 = " + valitudTäringud.get(0)
                        + " | täring 2 = " + valitudTäringud.get(1)
                        + " | täring 3 = " + valitudTäringud.get(2)
                        + " | täring 4 = " + valitudTäringud.get(3)
                        + " | täring 5 = " + valitudTäringud.get(4));

                int jäta = 0;
                tr = true;
                while (tr = true) {
                    Scanner jätaTäringud = new Scanner(System.in); // millised täringut jätta
                    if (jätaTäringud.hasNextInt()) {
                        tr = false;
                        jäta = jätaTäringud.nextInt();
                        break;
                    } else {
                        System.out.println("Sisesta number:");
                    }
                }

                if (jäta > 0 && jäta <= 5) {
                    ArrayList uued = Visked(4);
                    ArrayList ajutine = new ArrayList<>();
                    ajutine.add(valitudTäringud.get(jäta - 1));
                    for (int i = 0; i < uued.size(); i++) {
                        ajutine.add(uued.get(i));
                    }
                    valitudTäringud = ajutine;
                    viseteArv++;
                } else {
                    System.out.println("Oled sisestanud arvu, mis pole vahemikus 1-5 või oled selle juba valinud.");
                }
            } else if (Integer.parseInt(String.valueOf(mitu)) == 2) {
                ArrayList uued = Visked(3);
                ArrayList ajutine = new ArrayList<>();
                ArrayList print = valitudTäringud;
                ArrayList eitohi= new ArrayList();

                for (int j = 0; j < mitu; j++) {
                    System.out.println("Sisesta nr milliseid täringuid tahad jätta: täring 1 = " + print.get(0)
                            + " | täring 2 = " + print.get(1)
                            + " | täring 3 = " + print.get(2)
                            + " | täring 4 = " + print.get(3)
                            + " | täring 5 = " + print.get(4));
                    int jäta = 0;
                    tr = true;
                    while (tr) {
                        Scanner jätaTäringud = new Scanner(System.in); // millised täringut jätta
                        if (jätaTäringud.hasNextInt()) {
                            tr = false;
                            jäta = jätaTäringud.nextInt();
                            break;
                        } else {
                            System.out.println("Sisesta number:");
                        }
                    }

                    if (jäta > 0 && jäta < 6 && (!eitohi.contains(jäta))) {
                        ajutine.add(valitudTäringud.get(jäta - 1));
                        eitohi.add(jäta);
                        if (j == 0) {
                            for (int i = 0; i < uued.size(); i++) {
                                ajutine.add(uued.get(i));
                            }
                        }

                    } else {
                        System.out.println("Oled sisestanud arvu, mis pole vahemikus 1-5 või oled selle juba valinud.");
                        j--;
                    }

                }
                viseteArv++;
                valitudTäringud = ajutine;

            } else if (Integer.parseInt(String.valueOf(mitu)) == 3) {
                ArrayList uued = Visked(2);
                ArrayList ajutine = new ArrayList<>();
                ArrayList print = valitudTäringud;
                ArrayList eitohi= new ArrayList();

                for (int j = 0; j < mitu; j++) {
                    System.out.println("Sisesta nr milliseid täringuid tahad jätta: täring 1 = " + print.get(0)
                            + " | täring 2 = " + print.get(1)
                            + " | täring 3 = " + print.get(2)
                            + " | täring 4 = " + print.get(3)
                            + " | täring 5 = " + print.get(4));
                    int jäta = 0;
                    tr = true;
                    while (tr) {
                        Scanner jätaTäringud = new Scanner(System.in); // millised täringut jätta
                        if (jätaTäringud.hasNextInt()) {
                            tr = false;
                            jäta = jätaTäringud.nextInt();
                            break;
                        } else {
                            System.out.println("Sisesta number:");
                        }


                    }
                    System.out.println("asdf");
                    if (jäta > 0 && jäta < 6 && (!eitohi.contains(jäta))) {
                        ajutine.add(valitudTäringud.get(jäta - 1));
                        eitohi.add(jäta);
                        if (j == 0) {
                            for (int i = 0; i < uued.size(); i++) {
                                ajutine.add(uued.get(i));
                            }
                        }

                    } else {
                        System.out.println("Oled sisestanud arvu, mis pole vahemikus 1-5 või oled selle juba valinud.");
                        j--;
                    }

                }
                viseteArv++;
                valitudTäringud = ajutine;

            } else if (Integer.parseInt(String.valueOf(mitu)) == 4) {
                ArrayList uued = Visked(1);
                ArrayList ajutine = new ArrayList<>();
                ArrayList print = valitudTäringud;
                ArrayList eitohi= new ArrayList();
                for (int j = 0; j < mitu; j++) {
                    System.out.println("Sisesta nr milliseid täringuid tahad jätta: täring 1 = " + print.get(0)
                            + " | täring 2 = " + print.get(1)
                            + " | täring 3 = " + print.get(2)
                            + " | täring 4 = " + print.get(3)
                            + " | täring 5 = " + print.get(4));
                    int jäta = 0;
                    tr = true;
                    while (tr == true) {
                        Scanner jätaTäringud = new Scanner(System.in); // millised täringut jätta
                        if (jätaTäringud.hasNextInt()) {
                            tr = false;
                            jäta = jätaTäringud.nextInt();
                            break;
                        } else {
                            System.out.println("Sisesta number:");
                        }
                    }

                    if (jäta > 0 && jäta < 6 && (!eitohi.contains(jäta))){
                        ajutine.add(valitudTäringud.get(jäta - 1));
                        eitohi.add(jäta);
                        if (j == 0) {
                            for (int i = 0; i < uued.size(); i++) {
                                ajutine.add(uued.get(i));
                            }
                        }

                    } else {
                        System.out.println("Oled sisestanud arvu, mis pole vahemikus 1-5 või oled selle juba valinud.");
                        j--;
                    }

                }
                viseteArv++;
                valitudTäringud = ajutine;

            } else if (Integer.parseInt(String.valueOf(mitu)) == 0) {
                ArrayList uued = Visked(5);
                ArrayList ajutine = new ArrayList<>();
                for (int i = 0; i < uued.size(); i++) {
                    ajutine.add(uued.get(i));
                }
                viseteArv++;
                valitudTäringud = ajutine;

            } else if (Integer.parseInt(String.valueOf(mitu)) == 5) {
                viseteArv = 4;
                break;

            } else {
                System.out.println("Sisesta õige arv");
                a--;
            }

            System.out.println("Sinu täringud on " + valitudTäringud);

        }
        return valitudTäringud;
    }
}
// Lisa et viskeid oleks kolm