package packages;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailFlexibleTest {

    @Test
    public void it_should_seven_point_five__price(){
        // Given
        EmailFlexible emailConst= new EmailFlexible();
        // When
        double price = emailConst.calculateAmount();
        // Then
        assertEquals(7.5,price,0);
    }

    @Test
    public void it_should_twenty_price(){
        // Given
        EmailFlexible emailConst= new EmailFlexible();
        // When
        for (int i = 0; i <2100 ; i++) {
            emailConst.increaseCount();
        }
        double price = emailConst.calculateAmount();
        // Then
        assertEquals(10.5,price,0);
    }
}
