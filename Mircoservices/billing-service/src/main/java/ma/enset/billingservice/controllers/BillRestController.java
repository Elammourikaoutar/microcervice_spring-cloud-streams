package ma.enset.billingservice.controllers;

import ma.enset.billingservice.entities.Bill;
import ma.enset.billingservice.repositories.BillRepository;
import ma.enset.billingservice.repositories.CustomerServiceClient;
import ma.enset.billingservice.repositories.InventoryServiceClient;
import ma.enset.billingservice.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BillRestController{
    private BillRepository billRepository;
    private ProductRepository productItemRepository;
    private CustomerServiceClient customerServiceClient;
    InventoryServiceClient inventoryServiceClient;
    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable(name="id") Long id){
        Bill bill=billRepository.findById(id).get();
        bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
        bill.setProductItems(productItemRepository.findByBillId(id));
        /*bill.getProductItems().forEach(pi->{
            pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()));
        });*/
        return bill; }
}
