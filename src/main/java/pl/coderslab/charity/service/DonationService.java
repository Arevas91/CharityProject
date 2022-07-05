package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@AllArgsConstructor
public class DonationService {

    private final DonationRepository donationRepository;

    public Long getAllDonations() {
        return donationRepository.count();
    }

    public Long getCountOfDonationsQuantity() {
        Long result = donationRepository.countAllDonationByQuantity();

        if (result == null) {
            return 0L;
        } else {
            return result;
        }
    }

    public Donation createNewDonation(Donation donation) {
        return donationRepository.save(donation);
    }
}
