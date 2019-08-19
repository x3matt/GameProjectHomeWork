package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({WordTest.class,
        GameTest.class,
        ParameterizedWordOpenLetterTest.class,
        ParameterizedGameOpenLetterTest.class,
        ParameterizedWordOpenWordTest.class,
        ParameterizedGameOpenWordTest.class})
public class SuiteController {
}
