package br.com.alura.screenmatch.main;

import java.util.Scanner;

import br.com.alura.screenmatch.service.ConsumoApi;

public class Main {
    private Scanner sc = new Scanner(System.in);

    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7e0b1d61";

    public void exibirMenu() {
        System.out.println("Digite o nome da serie");
        var nomeSerie = sc.nextLine();

        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_KEY);
    
    }
}
