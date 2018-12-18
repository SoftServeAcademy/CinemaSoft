package softserve.academy.cinemasoft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import softserve.academy.cinemasoft.service.ScreeningService;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ScreeningServiceTest {
    @Autowired
    @InjectMocks
    private ScreeningService screeningService;

    private static final String CORRECT_HOUR_NUMBER_ONE = "08:00";

    private static final String CORRECT_HOUR_NUMBER_TWO = "8:00";

    private static final String CORRECT_HOUR_NUMBER_THREE = "08:9";

    private static final String CORRECT_HOUR_NUMBER_FOUR = "8:9";

    private static final String INCORRECT_HOUR_NUMBER_ONE = "88:99";

    private static final String INCORRECT_HOUR_NUMBER_TWO = "08:123";

    private static final String INCORRECT_HOUR_NUMBER_THREE = "998:123";

    private static final String INCORRECT_HOUR_NUMBER_FOUR = "998:123";

    private static final String INCORRECT_MINUTES = "09:99";

    private static final String INCORRECT_HOURS = "99:09";

    private static final String RANDOM_STRING = "asdasdas";

    private static final String EMPTY_HOURS_AND_MINUTES = ":";

    private static final String EMPTY_HOURS = "08:";

    private static final String EMPTY_MINUTES = ":45";

    private static final String INCORRECT_INPUT="aa:aa";


    @Before
    public void setUp() {

    }

    @Test
    public void testIsValidCorrectInput() {

        assertThat(screeningService.isValid(CORRECT_HOUR_NUMBER_ONE)).isTrue();
    }

    @Test
    public void testIsValidCorrectInputWithoutZeroInFrontHours() {

        assertThat(screeningService.isValid(CORRECT_HOUR_NUMBER_TWO)).isTrue();
    }

    @Test
    public void testIsValidCorrectInputWithoutZeroInFrontMinutes() {

        assertThat(screeningService.isValid(CORRECT_HOUR_NUMBER_THREE)).isTrue();
    }

    @Test
    public void testIsValidCorrectInputWithoutZeroInFrontHoursAndMinutes() {

        assertThat(screeningService.isValid(CORRECT_HOUR_NUMBER_FOUR)).isTrue();
    }

    @Test
    public void testIsValidIncorrectInput() {
        assertThat(screeningService.isValid(INCORRECT_HOUR_NUMBER_ONE)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputTooLongInput() {
        assertThat(screeningService.isValid(INCORRECT_HOUR_NUMBER_TWO)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputTooLongHourInput() {
        assertThat(screeningService.isValid(INCORRECT_HOUR_NUMBER_THREE)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputTooLongHourAndMinuteInput() {
        assertThat(screeningService.isValid(INCORRECT_HOUR_NUMBER_FOUR)).isFalse();
    }

    @Test
    public void testIsValidIncorrectMinutes() {
        assertThat(screeningService.isValid(INCORRECT_MINUTES)).isFalse();
    }

    @Test
    public void testIsValidIncorrectHours() {
        assertThat(screeningService.isValid(INCORRECT_HOURS)).isFalse();
    }

    @Test
    public void testIsValidRandomStringInput() {
        assertThat(screeningService.isValid(RANDOM_STRING)).isFalse();
    }

    @Test
    public void testIsValidEmptyHoursAndMinutes() {
        assertThat(screeningService.isValid(EMPTY_HOURS_AND_MINUTES)).isFalse();
    }

    @Test
    public void testIsValidEmptyHours() {
        assertThat(screeningService.isValid(EMPTY_HOURS)).isFalse();
    }

    @Test
    public void testIsValidEmptyMinutes() {
        assertThat(screeningService.isValid(EMPTY_MINUTES)).isFalse();
    }

    @Test(expected = NumberFormatException.class)
    public void testIsValidIncorrectInputWithString() {
        assertThat(screeningService.isValid(INCORRECT_INPUT)).isFalse();
    }


}
