package factorymethod.example2;

public class Main {

}

interface Product {

}

class ProductPhysical implements Product {

}

class ProductDigital implements Product {

}

class Category {

    public Product createProduct() {
        return new ProductPhysical();
    }

}

class DigitalCategory extends Category {

    public Product createProduct() {
        return new ProductDigital();
    }

}