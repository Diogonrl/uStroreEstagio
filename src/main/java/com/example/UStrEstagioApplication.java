package com.example;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Candidato;
import com.example.domain.Eleitor;
import com.example.domain.Voto;
import com.example.domain.enums.TipoCandidato;
import com.example.repositories.CandidatoRepository;
import com.example.repositories.EleitorRepository;
import com.example.repositories.VotoRepository;

@SpringBootApplication
public class UStrEstagioApplication implements CommandLineRunner {

	@Autowired
	private EleitorRepository eleitorRepository;
	@Autowired
	private VotoRepository votoRepository;
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UStrEstagioApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		
		Eleitor eleitor1 = new Eleitor(null, "050799");
		Eleitor eleitor2 = new Eleitor(null, "051059");
		Eleitor eleitor3 = new Eleitor(null, "989844");
		Eleitor eleitor4 = new Eleitor(null, "959547");
		
		Candidato pres1 = new Candidato( null,"presidente1", TipoCandidato.PRESIDENTE, 13);
		Candidato pres2 = new Candidato( null,"presidente2", TipoCandidato.PRESIDENTE, 15 );
		Candidato gov1 = new Candidato( null,"governador1", TipoCandidato.GOVERNADOR, 50);
		Candidato gov2 = new Candidato( null,"governador2", TipoCandidato.GOVERNADOR, 13);
		Candidato depE1 = new Candidato( null,"DepEstadual1", TipoCandidato.DEPESTADUAL, 20013);
		Candidato depE2 = new Candidato( null,"DepEstadual2", TipoCandidato.DEPESTADUAL, 50000);
		Candidato depF1 = new Candidato( null,"DepFederal1", TipoCandidato.DEPFEDERAL, 90905);
		Candidato depF2 = new Candidato( null,"DepFederal2", TipoCandidato.DEPFEDERAL, 78789);
		Candidato sen1 = new Candidato( null,"senador1", TipoCandidato.SENADOR, 150);
		Candidato sen2 = new Candidato( null,"senador2", TipoCandidato.SENADOR, 700);
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

		Voto voto1 = new Voto(null, sdf.parse("20:10"), eleitor1);
		Voto voto2 = new Voto(null, sdf.parse("12:10"), eleitor2);
		Voto voto3 = new Voto(null, sdf.parse("20:30"), eleitor3);
		Voto voto4 = new Voto(null, sdf.parse("09:40"), eleitor4);
		
		
		voto1.getCandidatos().addAll(Arrays.asList (pres1,gov2, depE1, depF2, sen1));
		voto2.getCandidatos().addAll(Arrays.asList(pres2,gov1,depE2,depF2,sen1));
		


		eleitorRepository.saveAll(Arrays.asList(eleitor1,eleitor2,eleitor3,eleitor4));
		candidatoRepository.saveAll(Arrays.asList(pres1,pres2,gov1,gov2,depE1,depE2,depF1,depF2,sen1,sen2));
		votoRepository.saveAll(Arrays.asList(voto1,voto2,voto3,voto4));
	}

}
