package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var ConsumoApi = new ConsumoApi();
		var json = ConsumoApi.obterDados("https://www.omdbapi.com/?t=The+Big+Bang+Theory&apikey=7ed534ca");
		System.out.println(json);
//		json = ConsumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dadosFormatados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dadosFormatados);
		//teste

	}
}
