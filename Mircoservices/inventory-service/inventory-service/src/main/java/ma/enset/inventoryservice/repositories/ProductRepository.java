package ma.enset.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import ma.enset.inventoryservice.entities.Product;

@RepositoryRestController
public interface ProductRepository extends JpaRepository<Product,Long> {
}
