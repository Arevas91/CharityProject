package pl.coderslab.charity.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@AllArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {

    private final DonationService donationService;
    private final InstitutionService institutionService;

    @RequestMapping("")
    public String homeAction(Model model){
        return "index";
    }

    @ModelAttribute("givenDonations")
    public Long showDonationBags() {
        return donationService.getAllDonations();
    }

    @ModelAttribute("donationsForInstitutions")
    public Long showDonations() {
        return donationService.getCountOfDonationsQuantity();
    }

    @ModelAttribute("institutions")
    public List<Institution> showInstitutions() {
        return institutionService.getAllInstitutions();
    }
}
