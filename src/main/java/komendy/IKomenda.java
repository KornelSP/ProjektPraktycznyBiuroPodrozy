package komendy;

import java.util.Scanner;

public interface IKomenda {
    Scanner SCANNER = new Scanner(System.in);

    String getKomenda();

    void obsluga();
}
