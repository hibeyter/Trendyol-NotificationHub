package common;

import common.languages.English;
import common.languages.Turkish;
import org.junit.Test;
import packages.EmailFlexible;

import static org.junit.Assert.assertEquals;

public class ErrorMessageTest {


    @Test
    public void it_should_english_message(){
        English english = new English();

        String message = english.nullBody();

        assertEquals("Empty content",message);
    }

    @Test
    public void it_should_turkish_message(){
        Turkish turkish = new Turkish();

        String message = turkish.nullBody();

        assertEquals("Boş içerik",message);
    }
}
