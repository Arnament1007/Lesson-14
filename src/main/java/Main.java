import entities.Client;
import services.ClientService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        List<Client> all = clientService.getAll();

        //        all.forEach(System.out::println);
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i));
        }
    }
}
