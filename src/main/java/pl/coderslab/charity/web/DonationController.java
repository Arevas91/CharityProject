package pl.coderslab.charity.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.getAllCategories();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/donate")
    public String showForm(Model model) {
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping("/donate")
    public String makeDonation(@ModelAttribute("donation") @Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "donationForm";
        } else {
            donationService.createNewDonation(donation);
            return "formConfirmation";
        }
    }

}
