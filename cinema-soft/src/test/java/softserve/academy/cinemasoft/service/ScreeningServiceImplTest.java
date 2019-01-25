package softserve.academy.cinemasoft.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import softserve.academy.cinemasoft.model.Screening;
import softserve.academy.cinemasoft.repository.ScreeningRepository;
import softserve.academy.cinemasoft.utils.Validator;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        Screening firstScreening = new Screening();
        Screening secondScreening = new Screening();
        Screening thirdScreening = new Screening();
        List<Screening> listOfScreening = List.of(firstScreening, secondScreening, thirdScreening);

        when(screeningRepository.findAll()).thenReturn(listOfScreening);

        List<Screening> resultList = screeningService.findAllScreenings();

        verify(screeningRepository, only()).findAll();
        assertEquals(resultList, listOfScreening);
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
        screeningService.deleteScreening(1);

        verify(screeningRepository, only()).deleteById(1);
    }


    @Test
    public void testFindById() {
        Screening screening = new Screening();
        when(screeningRepository.findById(anyInt())).thenReturn(screening);

        screeningService.findById(1);

        verify(screeningRepository, only()).findById(1);
    }
}
