package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.Arrays;

@SpringBootApplication
public class CharityApplication implements CommandLineRunner {

    private final InstitutionRepository institutionRepository;

    public CharityApplication(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CharityApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (institutionRepository.findAll().isEmpty()) {
            Institution[] institutions = {new Institution("Dbam o zdrowie", "Pomoc ubogim dzieciom"), new Institution("A kogo", "Pomoc w wybudzaniu dzieci ze śpiączki"), new Institution("Dla dzieci", "Pomoc osobom znajdującym się w trudnej sytuacji życiowej"), new Institution("Bez domu", "Pomoc dla osób nie posiadających miejsca zamieszkania")};
            institutionRepository.saveAll(Arrays.asList(institutions));
        }
    }

}
