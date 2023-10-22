package factorymethod.example1;

public class Main {

}

interface Product {}

interface Category {
    Product newProduct();
}

class ProductPhysical implements Product {}

class ProductDigital implements Product {}

class Digital implements Category {

    @Override
    public Product newProduct() {
        return null;
    }

}

class Physical implements Category {

    @Override
    public Product newProduct() {
        return null;
    }

}

