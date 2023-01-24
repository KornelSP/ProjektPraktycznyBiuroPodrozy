package komendy.dodaj;

import database.DataAccessObject;
import komendy.IKomenda;
import model.OfertaWakacyjna;
import model.Wycieczka;

import java.util.Optional;

public class KomendaDodajOfertaWakacyjna implements IKomenda {

    private DataAccessObject<OfertaWakacyjna> dao = new DataAccessObject<>();
    private DataAccessObject<Wycieczka> daoWycieczka = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj oferte wakacyjna";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id wycieczki z dostepnych ponizej:");
        daoWycieczka.findAll(Wycieczka.class).forEach(System.out::println);

        Optional<Wycieczka> wycieczkaOptional;
        String idWycieczkiString;
        do {
            idWycieczkiString = IKomenda.SCANNER.nextLine();
            Long idWycieczki = Long.parseLong(idWycieczkiString);

            wycieczkaOptional = daoWycieczka.find(Wycieczka.class, idWycieczki);
            if (wycieczkaOptional.isEmpty()) {
                System.err.println("Wycieczka o podanym id nie istnieje, podaj poprawne id:");
            } else {
                System.out.println("Wycieczka zostala dodana.");
            }
        } while (wycieczkaOptional.isEmpty());

//        System.out.println("Podaj poczatkowa date oferty:");
//        String startString = IKomenda.SCANNER.nextLine();
//        LocalDateTime start = LocalDateTime.parse(startString);
//
//        System.out.println("Podaj koncowa date oferty:");
//        String koniecString = IKomenda.SCANNER.nextLine();
//        LocalDateTime koniec = LocalDateTime.parse(koniecString);

        System.out.println("Podaj cene za dziecko:");
        Double cenaDziecko = IKomenda.SCANNER.nextDouble();

        System.out.println("Podaj cene za doroslego:");
        Double cenaDorosly = IKomenda.SCANNER.nextDouble();

        System.out.println("Podaj ilosc miejsc w ofercie:");
        int iloscMiejsc = IKomenda.SCANNER.nextInt();
        int takieTam = IKomenda.SCANNER.nextInt();
        System.out.println("");

        OfertaWakacyjna oferta = OfertaWakacyjna.builder()
//                .dataCzasStart(start)
//                .dataCzasKoniec(koniec)
                .cenaDziecko(cenaDziecko)
                .cenaDorosly(cenaDorosly)
                .iloscMiejsc(iloscMiejsc)
                .wycieczka(wycieczkaOptional.get())
                .build();

        dao.insert(oferta);
    }
}
