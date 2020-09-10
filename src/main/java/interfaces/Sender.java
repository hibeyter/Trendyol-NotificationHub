package interfaces;

import java.util.List;

public interface Sender {
   void send(List<Channel> channels);
   double calculateTotalAmount();
   void  payInvoice();
}
