package pl.coderslab.charity.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.charity.domain.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class InstitutionServiceTest {

    @Mock
    private InstitutionRepository institutionRepository;

    @InjectMocks
    private InstitutionService institutionService;

    @Test
    public void shouldGetAllCategories() {
        List<Institution> institutionList = new ArrayList<>();
        institutionList.add(new Institution());

        given(institutionRepository.findAll()).willReturn(institutionList);

        List<Institution> expectedInstitutionList = institutionService.getAllInstitutions();

        assertEquals(expectedInstitutionList, institutionList);
        verify(institutionRepository).findAll();
    }
}
