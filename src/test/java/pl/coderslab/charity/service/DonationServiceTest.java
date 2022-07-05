package pl.coderslab.charity.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.domain.Donation;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.DonationRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    public void shouldCreateNewDonation() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Zabawki"));

        Donation donation = new Donation();
        donation.setQuantity(10);
        donation.setCategoryList(categoryList);
        donation.setInstitution(new Institution("Test name", "Test description"));
        donation.setStreet("Test street 1");
        donation.setCity("Test city");
        donation.setPhoneNumber("123321231");
        donation.setZipCode("87-100");
        donation.setPickUpDate(LocalDate.now().plusDays(1L));
        donation.setPickUpTime(LocalTime.now().plusHours(1L));
        donation.setPickUpComment("Test comment");

        when(donationRepository.save(ArgumentMatchers.any(Donation.class))).thenReturn(donation);
        Donation newDonation = donationService.createNewDonation(donation);

        assertThat(newDonation.getQuantity()).isSameAs(donation.getQuantity());
        assertThat(newDonation.getCategoryList()).isSameAs(donation.getCategoryList());
        assertThat(newDonation.getInstitution()).isSameAs(donation.getInstitution());
        assertThat(newDonation.getStreet()).isSameAs(donation.getStreet());
        assertThat(newDonation.getCity()).isSameAs(donation.getCity());
        assertThat(newDonation.getPhoneNumber()).isSameAs(donation.getPhoneNumber());
        assertThat(newDonation.getZipCode()).isSameAs(donation.getZipCode());
        assertThat(newDonation.getPickUpDate()).isSameAs(donation.getPickUpDate());
        assertThat(newDonation.getPickUpTime()).isSameAs(donation.getPickUpTime());
        assertThat(newDonation.getPickUpComment()).isSameAs(donation.getPickUpComment());
        verify(donationRepository).save(donation);
    }

}
