package tk.idealist.pipeline.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SuperReducedStringServiceTest {

    private static final String EMPTY_STRING_OUTPUT = "Empty String";

    @InjectMocks
    private SuperReducedStringService superReducedStringService;

    @Test
    void testReduceWhenEmptyInput() {
        var input = "";
        var result = superReducedStringService.reduce(input);
        Assertions.assertEquals(EMPTY_STRING_OUTPUT, result);
    }

    @Test
    void testReduceWhenPassedSingleSymbol() {
        var input = "a";
        var result = superReducedStringService.reduce(input);
        Assertions.assertEquals(input, result);
    }

    @Test
    void testReduceWhenTheSameSymbolsPassedTwice() {
        var input = "aa";
        var result = superReducedStringService.reduce(input);
        Assertions.assertEquals(EMPTY_STRING_OUTPUT, result);
    }

//    @Test
//    void testReduceWhenEvenNumberOfTimesPassedTheSameSymbol() {
//        var input = "bbbb";
//        var result = superReducedStringService.reduce(input);
//        Assertions.assertEquals(EMPTY_STRING_OUTPUT, result);
//    }
//
//    @Test
//    void testReduceWhenPassedSymboldAreReduced() {
//        var input = "abbbC1223";
//        var result = superReducedStringService.reduce(input);
//        Assertions.assertEquals("abC13", result);
//    }
}
