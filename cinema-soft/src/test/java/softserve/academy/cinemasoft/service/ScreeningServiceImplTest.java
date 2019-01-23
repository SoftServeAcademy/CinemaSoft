package softserve.academy.cinemasoft.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import softserve.academy.cinemasoft.model.Screening;
import softserve.academy.cinemasoft.repository.ScreeningRepository;
import softserve.academy.cinemasoft.utils.Validator;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class ScreeningServiceImplTest {

    @Mock
    private ScreeningRepository screeningRepository;

    @Mock
    private Validator validator;

    private ScreeningServiceImpl screeningService;

    @Before
    public void setUp() {
       screeningService = new ScreeningServiceImpl(screeningRepository, validator);
    }

    @Test
    public void testFindAllScreenings() {
        screeningService.findAllScreenings();
        verify(screeningRepository, only()).findAll();
    }

    @Test
    public void testAddScreening() {
        Screening screening = new Screening();
        when(screeningRepository.save(screening)).thenReturn(screening);

        Screening result = screeningService.addScreening(screening);

        verify(screeningRepository, only()).save(screening);
        assertEquals(screening, result);
    }

    @Test
    public void testDeleteScreening() {
        screeningService.deleteScreening(anyInt());

        verify(screeningRepository, only()).deleteById(anyInt());
    }

    @Test
    public void testFindById() {
        Screening screening = new Screening();
        when(screeningRepository.findById(anyInt())).thenReturn(screening);

        screeningService.findById(5);

        verify(screeningRepository, only()).findById(5);
    }

}
