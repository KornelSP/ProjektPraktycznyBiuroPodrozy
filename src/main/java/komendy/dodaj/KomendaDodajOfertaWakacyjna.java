package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Klient;
import model.OfertaWakacyjna;

import java.time.LocalDateTime;

public class KomendaDodajOfertaWakacyjna implements IKomenda {

    private DataAccessObject<Klient> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj oferte wakacyjna";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj początkowa date oferty:");
        String startString = IKomenda.SCANNER.nextLine();
        LocalDateTime start = LocalDateTime.parse(startString);

        System.out.println("Podaj końcową date oferty:");
        String koniecString = IKomenda.SCANNER.nextLine();
        LocalDateTime koniec = LocalDateTime.parse(koniecString);

        System.out.println("Podaj cene za dziecko:");
        Double cenaDziecko = IKomenda.SCANNER.nextDouble();

        System.out.println("Podaj cene za dorosłego:");
        Double cenaDorosly = IKomenda.SCANNER.nextDouble();

        System.out.println("Podaj ilosc miejsc w ofercie:");
        int iloscMiejsc = IKomenda.SCANNER.nextInt();

        OfertaWakacyjna oferta = OfertaWakacyjna.builder()
                .dataCzasStart(start)
                .dataCzasKoniec(koniec)
                .cenaDziecko(cenaDziecko)
                .cenaDorosly(cenaDorosly)
                .iloscMiejsc(iloscMiejsc)
                .build();
    }
}
