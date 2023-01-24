package komendy.lista;

import database.DataAccessObject;
import komendy.IKomenda;
import model.Atrakcja;
import model.Hotel;
import model.OfertaWakacyjna;
import model.Wycieczka;

import java.util.List;
import java.util.Optional;

public class KomendaSzczegolyOfertaWakacyjna implements IKomenda {

    private DataAccessObject<OfertaWakacyjna> daoOferta = new DataAccessObject<>();
    private DataAccessObject<Atrakcja> daoAtrakcja = new DataAccessObject<>();
    private DataAccessObject<Hotel> daoHotel = new DataAccessObject<>();
    private DataAccessObject<Wycieczka> daoWycieczka = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "szczegoly oferty wakacyjnej";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj dla ktorej oferty chcesz poznac szcegoly:");
        daoOferta.findAll(OfertaWakacyjna.class).forEach(System.out::println);
        String ofertaId = IKomenda.SCANNER.nextLine();

        Long idOferta = Long.parseLong(ofertaId);
        Optional<OfertaWakacyjna> ofertaOptional = daoOferta.find(OfertaWakacyjna.class, idOferta);

        if (ofertaOptional.isEmpty()) {
            System.err.println("Oferta o podanym id nie istnieje");

        } else {
            System.out.println("Opis wycieczki:");
            String opis = daoWycieczka.find(Wycieczka.class, idOferta).get().getOpis();
            System.out.println(opis);

            List<Atrakcja> atrakcje = daoAtrakcja.findAll(Atrakcja.class);
            List<Atrakcja> atrakcjeDlaOferty = atrakcje.stream()
                    .filter(atrakcja -> atrakcja.getId().equals(idOferta))
                    .toList();
            System.out.println("Atrakcje dla wybranej wycieczki to:");
            System.out.println(atrakcjeDlaOferty);

            List<Hotel> hotele = daoHotel.findAll(Hotel.class);
            List<Hotel> hoteleDlaOferty = hotele.stream()
                    .filter(hotel -> hotel.getId().equals(idOferta))
                    .toList();
            System.out.println("Hotele dla wybranej wycieczki to:");
            System.out.println(hoteleDlaOferty);

        }
    }
}
