package br.com.alura.screenmatch.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;

public class Main {
    private Scanner sc = new Scanner(System.in);

    private ConverteDados conversor =  new ConverteDados();
    private ConsumoApi consumo = new ConsumoApi();
    private final String ENDERECO = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=7e0b1d61";

    public void exibirMenu() {
        System.out.println("Digite o nome da serie");
        var nomeSerie = sc.nextLine();

        var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ","+") + API_KEY);

        ConverteDados conversor =  new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dados);

        List<DadosTemporada> temporadas = new ArrayList<>();
	 	for (int i = 1; i <= dados.totalTemporadas(); i++) {
	 		json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ","+") + "&season=" + i + API_KEY);
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
	 		temporadas.add(dadosTemporada);
		}

		    temporadas.forEach(System.out::println);
	    }
}

