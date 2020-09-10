package packages;

import org.junit.Test;


import static org.junit.Assert.*;

public class EmailQuotaTest {


    @Test
    public void it_should_ten_price(){
        // Given
        EmailQuota emailQuota = new EmailQuota();

        // When
        double price = emailQuota.calculateAmount();

        // Then

        assertEquals(10.0,price,0);

    }

    @Test
    public void it_should_twenty_price(){
        // Given
        EmailQuota emailQuota = new EmailQuota();

        // When
        for (int i = 0; i <1002 ; i++) {
            emailQuota.increaseCount();
        }
        double price = emailQuota.calculateAmount();
        // Then

        assertEquals(20.0,price,0);
    }
}
