package packages;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmsQuotaTest {


    @Test
    public void it_should_twenty_price(){
        // Given
        SmsQuota smsQuota = new SmsQuota();

        // When
        double price = smsQuota.calculateAmount();

        // Then

        assertEquals(20.0,price,0);

    }

    @Test
    public void it_should_forty_price(){
        // Given
        SmsQuota smsQuota = new SmsQuota();

        // When
        for (int i = 0; i <1999 ; i++) {
            smsQuota.increaseCount();
        }
        double price = smsQuota.calculateAmount();
        // Then

        assertEquals(40.0,price,0);
    }

    @Test
    public void it_should_sixty_price(){
        // Given
        SmsQuota smsQuota = new SmsQuota();

        // When
        for (int i = 0; i <2000 ; i++) {
            smsQuota.increaseCount();
        }
        double price = smsQuota.calculateAmount();

        // Then
        assertEquals(60.0,price,0);
    }
}
