package singleton;

public class Main {

    public static void main(String[] args) {

        //singleton pattern - eager initialization
        Product product = Product.getInstance();
        System.out.println(product);

        //singleton pattern - lazy initialization
        Product1 product1 = Product1.getInstance();
        System.out.println(product1);

        //singleton pattern - thread safe
        Product2 product2 = ProductFactory2.INSTANCE.getInstance();
        System.out.println(product2);

        //singleton pattern - thread safe
        Product3 product3 = Product3.getInstance();
        System.out.println(product3);

    }

}


//singleton pattern - eager initialization
class Product {
    private static Product instance = new Product();

    private Product() {
    }

    public static Product getInstance() {
        return instance;
    }
}

//singleton pattern - lazy initialization
class Product1 {
    private static Product1 instance;

    private Product1() {
    }

    public static Product1 getInstance() {
        if (instance == null) {
            instance = new Product1();
        }
        return instance;
    }
}


//singleton pattern - thread safe
class Product2 {}
enum ProductFactory2 {
    INSTANCE;

    public Product2 getInstance() {
        return new Product2();
    }
}

//singleton pattern - thread safe
class Product3 {
    private static Product3 instance;

    private Product3() {
    }

    public static synchronized Product3 getInstance() {
        if (instance == null) {
            instance = new Product3();
        }
        return instance;
    }
}

