package packages;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmsFlexibleTest {

    @Test
    public void it_should_twenty_price(){
        // Given
        SmsFlexible smsFlexible = new SmsFlexible();
        // When
        double price = smsFlexible.calculateAmount();
        // Then
        assertEquals(30.0,price,0);
    }

    @Test
    public void it_should_thirty_one_price(){
        // Given
        SmsFlexible smsFlexible = new SmsFlexible();
        // When
        for (int i = 0; i <2010 ; i++) {
            smsFlexible.increaseCount();
        }
        double price = smsFlexible.calculateAmount();
        // Then
        assertEquals(31.0,price,0);
    }
}
