import komendy.IKomenda;
import komendy.dodaj.*;
import komendy.lista.*;
import komendy.usun.KomendaUsunAtrakcja;
import komendy.usun.KomendaUsunHotel;
import komendy.usun.KomendaUsunKlient;
import komendy.usun.KomendaUsunOfertaWakacyjna;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<IKomenda> listaKomend = List.of(
                new KomendaDodajAtrakcja(),
                new KomendaDodajHotel(),
                new KomendaDodajKlient(),
                new KomendaDodajLokalizacja(),
                new KomendaDodajOfertaWakacyjna(),
                new KomendaDodajWycieczka(),
                new KomendaListaAtrakcja(),
                new KomendaListaAtrakcjaWRegionie(),
                new KomendaListaHotel(),
                new KomendaListaKlient(),
                new KomendaListaLokalizacja(),
                new KomendaListaOfertaWakacyjna(),
                new KomendaSzczegolyOfertaWakacyjna(),
                new KomendaListaWycieczka(),
                new KomendaUsunAtrakcja(),
                new KomendaUsunHotel(),
                new KomendaUsunKlient(),
                new KomendaUsunOfertaWakacyjna()
        );

        String komenda = "";
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }

            System.out.println();
            System.out.println("* Aby zakonczyc prace programu wpisz \"exit\".");

            System.out.println("Podaj komende:");
            komenda = IKomenda.SCANNER.nextLine();

            for (IKomenda dostepnaIKomenda : listaKomend) {
                if (dostepnaIKomenda.getKomenda().equals(komenda)) {
                    dostepnaIKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));

    }
}
