package pl.coderslab.charity.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.charity.domain.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void shouldGetAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category());

        given(categoryRepository.findAll()).willReturn(categoryList);

        List<Category> expectedCategoryList = categoryService.getAllCategories();

        assertEquals(expectedCategoryList, categoryList);
        verify(categoryRepository).findAll();
    }
}
