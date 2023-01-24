
package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.OfertaWakacyjna;
import model.Wycieczka;

import java.util.List;
import java.util.Optional;

public class KomendaListaOfertaWakacyjna implements IKomenda {

    private DataAccessObject<Wycieczka> dao = new DataAccessObject<>();
    private DataAccessObject<OfertaWakacyjna> daoOferta = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista ofert wakacyjnych";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj dla ktorej wycieczki chcesz przejzec oferty:");
        dao.findAll(Wycieczka.class).forEach(System.out::println);
        String wycieczkaId = IKomenda.SCANNER.nextLine();

        Long idWycieczka = Long.parseLong(wycieczkaId);
        Optional<Wycieczka> ofertaOptional = dao.find(Wycieczka.class, idWycieczka);

        if (ofertaOptional.isEmpty()) {
            System.err.println("wycieczka o podanym id nie istnieje");

        } else {

            List<OfertaWakacyjna> oferty = daoOferta.findAll(OfertaWakacyjna.class);
            List<OfertaWakacyjna> ofertyDlaWycieczki = oferty.stream()
                    .filter(ofertaWakacyjna -> ofertaWakacyjna.getId().equals(idWycieczka))
                    .toList();
            System.out.println("Oferty dla wybranej wycieczki to:");
            System.out.println(ofertyDlaWycieczki);
        }
    }
}