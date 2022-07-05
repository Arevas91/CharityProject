package pl.coderslab.charity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.Arrays;

@SpringBootApplication
public class CharityApplication implements CommandLineRunner {

    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;

    public CharityApplication(InstitutionRepository institutionRepository, CategoryRepository categoryRepository) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
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

        if (categoryRepository.findAll().isEmpty()) {
            Category[] categories = { new Category("Ubrania, które nadają się do ponownego użycia"), new Category("Ubrania, które nadają się do wyrzucenia"), new Category("Zabawki"), new Category("Książki"), new Category("Inne")};
            categoryRepository.saveAll(Arrays.asList(categories));
        }
    }

}
