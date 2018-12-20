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

    private static final String CORRECT_INPUT_ONE = "08:00";

    private static final String CORRECT_INPUT_TWO = "8:00";

    private static final String INCORRECT_INPUT_ONE = "88:99";

    private static final String INCORRECT_INPUT_TWO = "08:123";

    private static final String INCORRECT_INPUT_THREE = "998:12";

    private static final String INCORRECT_INPUT_FOUR = "998:123";

    private static final String INCORRECT_INPUT_FIVE = "8:9";

    private static final String INCORRECT_INPUT_SIX = "08:9";

    private static final String INCORRECT_MINUTES = "09:99";

    private static final String INCORRECT_HOURS = "99:09";

    private static final String RANDOM_STRING = "asdasdas";

    private static final String EMPTY_HOURS_AND_MINUTES = ":";

    private static final String EMPTY_MINUTES = "08:";

    private static final String EMPTY_HOURS = ":45";

    private static final String INCORRECT_INPUT="aa:aa";


    @Before
    public void setUp() {

    }

    @Test
    public void testIsValidCorrectInput() {

        assertThat(screeningService.isValid(CORRECT_INPUT_ONE)).isTrue();
    }

    @Test
    public void testIsValidCorrectInputWithoutZeroInFrontHours() {

        assertThat(screeningService.isValid(CORRECT_INPUT_TWO)).isTrue();
    }

    @Test
    public void testIsValidIncorrectInput() {
        assertThat(screeningService.isValid(INCORRECT_INPUT_ONE)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputTooLongMinuteInput() {
        assertThat(screeningService.isValid(INCORRECT_INPUT_TWO)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputTooLongHourInput() {
        assertThat(screeningService.isValid(INCORRECT_INPUT_THREE)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputTooLongHourAndMinuteInput() {
        assertThat(screeningService.isValid(INCORRECT_INPUT_FOUR)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputWithoutZeroInFrontHoursAndMinutes() {

        assertThat(screeningService.isValid(INCORRECT_INPUT_FIVE)).isFalse();
    }

    @Test
    public void testIsValidIncorrectInputWithoutZeroInFrontMinutes() {

        assertThat(screeningService.isValid(INCORRECT_INPUT_SIX)).isFalse();
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

    @Test
    public void testIsValidIncorrectInputWithString() {
        assertThat(screeningService.isValid(INCORRECT_INPUT)).isFalse();
    }


}
