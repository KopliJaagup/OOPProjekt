import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Loogika {
    public static void pane(ArrayList täringud, Punktitabel punktitabel, int mängija) {
        Scanner scanner = new Scanner(System.in);
        String koht;
        boolean tsükkel = true;

        while (tsükkel) {
            koht = scanner.nextLine().trim().toLowerCase();
            int summa = 0;

            switch (koht) {
                case "ühed":
                    summa = arvutaArv(täringud, 1);
                    tsükkel = paneYhed(summa, punktitabel, mängija);
                    break;

                case "kahed":
                    summa = arvutaArv(täringud, 2);
                    tsükkel = paneKahed(summa, punktitabel, mängija);
                    break;

                case "kolmed":
                    summa = arvutaArv(täringud, 3);
                    tsükkel = paneKolmed(summa, punktitabel, mängija);
                    break;

                case "neljad":
                    summa = arvutaArv(täringud, 4);
                    tsükkel = paneNeljad(summa, punktitabel, mängija);
                    break;

                case "viied":
                    summa = arvutaArv(täringud, 5);
                    tsükkel = paneViied(summa, punktitabel, mängija);
                    break;

                case "kuued":
                    summa = arvutaArv(täringud, 6);
                    tsükkel = paneKuued(summa, punktitabel, mängija);
                    break;

                case "paar":
                    summa = arvutaPaar(täringud, 2);
                    tsükkel = panePaar(summa, punktitabel, mängija);
                    break;

                case "kaks paari":
                    summa = arvutaKaksPaar(täringud, 2, 2);
                    tsükkel = paneKakspaar(summa, punktitabel, mängija);
                    break;

                case "kolmik":
                    summa = arvutaPaar(täringud, 3);
                    tsükkel = paneKolmik(summa, punktitabel, mängija);
                    break;

                case "nelik":
                    summa = arvutaPaar(täringud, 4);
                    tsükkel = paneNelik(summa, punktitabel, mängija);
                    break;

                case "väike rida":
                    ArrayList vrida = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
                    Collections.sort(täringud);
                    if (vrida.equals(täringud)) {
                        summa = 15;
                    }

                    tsükkel = paneVrida(summa, punktitabel, mängija);
                    break;

                case "suur rida":
                    ArrayList srida = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6));
                    Collections.sort(täringud);
                    if (srida.equals(täringud)) {
                        summa = 20;
                    }

                    tsükkel = paneSrida(summa, punktitabel, mängija);
                    break;

                case "maja":
                    summa = arvutaKaksPaar(täringud, 2, 3);
                    tsükkel = paneMaja(summa, punktitabel, mängija);
                    break;

                case "chance":
                    for (int i = 0; i < 5; i++) {
                        summa += (int) täringud.get(i);
                    }

                    tsükkel = paneChance(summa, punktitabel, mängija);
                    break;

                case "yatzy":
                    summa = arvutaPaar(täringud, 5);
                    if (summa != 0) {
                        summa = 50;
                    }

                    tsükkel = paneYatzy(summa, punktitabel, mängija);
                    break;

                default:
                    System.out.println("Pole sobiv väärtus!");
            }
        }

        if (punktitabel.getP1_vSumma() >= 63) {
            punktitabel.setP1_boonus(50);
        } else {
            punktitabel.setP1_boonus(0);
        }

        if (punktitabel.getP2_vSumma() >= 63) {
            punktitabel.setP2_boonus(50);
        } else {
            punktitabel.setP2_boonus(0);
        }
    }

    public static int arvutaArv(ArrayList täringud, int arv) {
        int summa = 0;
        for (int i = 0; i < 5; i++) {
            if (täringud.get(i).equals(arv)) {
                summa += 1;
            }
        }
        return summa;
    }

    public static int arvutaPaar(ArrayList täringud, int arv) {
        int summa = 0;
        int loendur = 0;
        int paaris = 0;

        for (int i = 6; i >= 1; i--) {
            for (int j = 0; j < 5; j++) {
                if (i == (int) täringud.get(j)) {
                    loendur += 1;
                }
            }

            if (loendur >= arv) {
                paaris = i;
                break;
            } else {
                loendur = 0;
            }
        }

        if (loendur >= arv) {
            summa = paaris * arv;
        }
        return summa;
    }

    public static int arvutaKaksPaar(ArrayList täringud, int arv1, int arv2) {
        int loendur = 0;
        int loendur2 = 0;
        int paaris = 0;
        int paaris2 = 0;
        int summa = 0;
        int summa2 = 0;

        for (int i = 6; i >= 1; i--) {
            if (loendur != 0) {
                for (int j = 0; j < 5; j++) {
                    if (i == (int) täringud.get(j)) {
                        loendur2 += 1;
                    }
                }

                if (loendur2 >= arv2) {
                    paaris2 = i;
                    break;
                } else {
                    loendur2 = 0;
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    if (i == (int) täringud.get(j)) {
                        loendur += 1;
                    }
                }

                if (loendur >= arv1) {
                    paaris = i;
                } else {
                    loendur = 0;
                }
            }

        }

        if (loendur >= arv1 && loendur2 >= arv2) {
            summa = (paaris * arv1) + (paaris2 * arv2);
        }

        loendur = 0;
        loendur2 = 0;
        paaris = 0;
        paaris2 = 0;

        for (int i = 6; i >= 1; i--) {
            if (loendur != 0) {
                for (int j = 0; j < 5; j++) {
                    if (i == (int) täringud.get(j)) {
                        loendur2 += 1;
                    }
                }

                if (loendur2 >= arv1) {
                    paaris2 = i;
                    break;
                } else {
                    loendur2 = 0;
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    if (i == (int) täringud.get(j)) {
                        loendur += 1;
                    }
                }

                if (loendur >= arv2) {
                    paaris = i;
                } else {
                    loendur = 0;
                }
            }

        }

        if (loendur >= arv2 && loendur2 >= arv1) {
            summa2 = (paaris * arv2) + (paaris2 * arv1);
        }

        if (summa2 > summa) {
            summa = summa2;
        }

        return summa;
    }

    public static boolean paneYhed(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_yks() == -1) {
                punktitabel.setP1_yks(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_yks() == -1) {
                punktitabel.setP2_yks(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }

        return tsükkel;
    }

    public static boolean paneKahed(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_kaks() == -1) {
                punktitabel.setP1_kaks(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_kaks() == -1) {
                punktitabel.setP2_kaks(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneKolmed(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_kolm() == -1) {
                punktitabel.setP1_kolm(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_kolm() == -1) {
                punktitabel.setP2_kolm(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneNeljad(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_neli() == -1) {
                punktitabel.setP1_neli(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_neli() == -1) {
                punktitabel.setP2_neli(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneViied(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_viis() == -1) {
                punktitabel.setP1_viis(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_viis() == -1) {
                punktitabel.setP2_viis(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneKuued(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_kuus() == -1) {
                punktitabel.setP1_kuus(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_kuus() == -1) {
                punktitabel.setP2_kuus(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean panePaar(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_paar() == -1) {
                punktitabel.setP1_paar(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_paar() == -1) {
                punktitabel.setP2_paar(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneKakspaar(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_kakspaar() == -1) {
                punktitabel.setP1_kakspaar(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_kakspaar() == -1) {
                punktitabel.setP2_kakspaar(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneKolmik(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_kolmik() == -1) {
                punktitabel.setP1_kolmik(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_kolmik() == -1) {
                punktitabel.setP2_kolmik(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneNelik(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_nelik() == -1) {
                punktitabel.setP1_nelik(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_nelik() == -1) {
                punktitabel.setP2_nelik(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneVrida(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_vrida() == -1) {
                punktitabel.setP1_vrida(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_vrida() == -1) {
                punktitabel.setP2_vrida(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneSrida(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_srida() == -1) {
                punktitabel.setP1_srida(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_srida() == -1) {
                punktitabel.setP2_srida(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneMaja(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_maja() == -1) {
                punktitabel.setP1_maja(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_maja() == -1) {
                punktitabel.setP2_maja(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneChance(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_chance() == -1) {
                punktitabel.setP1_chance(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_chance() == -1) {
                punktitabel.setP2_chance(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }

    public static boolean paneYatzy(int summa, Punktitabel punktitabel, int mängija) {
        boolean tsükkel = true;
        if (mängija == 1) {
            if (punktitabel.getP1_yatzy() == -1) {
                punktitabel.setP1_yatzy(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        } else {
            if (punktitabel.getP2_yatzy() == -1) {
                punktitabel.setP2_yatzy(summa);
                tsükkel = false;
            } else {
                System.out.println("Antud väljale on tulemus juba kantud!");
            }
        }
        return tsükkel;
    }
}