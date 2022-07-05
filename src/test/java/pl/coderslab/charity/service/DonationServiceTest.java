package pl.coderslab.charity.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DonationServiceTest {

    @Mock
    private DonationRepository donationRepository;

    @InjectMocks
    private DonationService donationService;

    @Test
    public void shouldGetAllDonations() {
        List<Donation> donationList = new ArrayList<>();
        donationList.add(new Donation());

        given(donationRepository.count()).willReturn(Long.valueOf(donationList.size()));

        Long expectedDonationCount = donationService.getAllDonations();

        assertEquals(expectedDonationCount, Long.valueOf(donationList.size()));
        verify(donationRepository).count();
    }

}
