package proxy.example1;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        final var productService = new ProductService(new ProductRepositoryValidatorProxy2());
        productService.saveProduct(new ProductX(" ", new BigDecimal(20)));

    }

}

class ProductService {

    private final ProductRepositoryInterface productRepository;

    public ProductService(final ProductRepositoryInterface productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(final ProductX product) {
        productRepository.save(product);
    }

}

class ProductRepository {

    void save(final ProductX product) {
        System.out.println("Saving product: " + product);
    }

}

class ProductX {

    private final String name;
    private final BigDecimal price;

    public ProductX(final String name, final BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }

}

// example proxy with inheritance
class ProductRepositoryValidatorProxy extends ProductRepository {

    @Override
    void save(final ProductX product) {
        validateProduct(product);
        super.save(product);
    }

    private static void validateProduct(final ProductX product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be less than zero");
        }

        if (product.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }

}

// example proxy with composition
interface ProductRepositoryInterface {
    void save(final ProductX product);
}

class ProductRepositoryValidatorProxy2 implements ProductRepositoryInterface {

    private final ProductRepository productRepository;

    public ProductRepositoryValidatorProxy2() {
        this.productRepository = new ProductRepository();
    }

    @Override
    public void save(final ProductX product) {
        validateProduct(product);
        productRepository.save(product);
    }

    private static void validateProduct(final ProductX product) {
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price cannot be less than zero");
        }

        if (product.getName().isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }


}

