package practisequestions.streams.practise.Product;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class ProductOperation {
    public static void main(String[] args) {
        Product keyboard = new Product(1, "Keyboard", 120.00, "Electronics");
        Product mouse = new Product(2, "Mouse", 90.00, "Electronics");
        Product table = new Product(2, "Table", 180, "Furniture");
        List<Product> products = new ArrayList<>(List.of(keyboard, mouse, table));

        //Q1
        List<Product> productList = products.stream().filter(product -> product.getPrice() < 100.00).toList();

        //Q2 Create a new list  containing products with a price reduction of 20%...
        List<Product> priceReductionList = products.stream().map(product -> {
            product.setPrice(product.getPrice() - product.getPrice() * 0.2);
            return product;
        }).toList();

        System.out.println(priceReductionList);

        //Q3 Calculate the average price of all products..
        double averagePrice = products.stream().map(Product::getPrice).mapToDouble(product -> product).average().getAsDouble();
        System.out.println("averagePrice " + averagePrice);

        //Q4
        //Find the product wit the lowest price using stream API...
        Optional<Double> minPrice = products.stream().map(Product::getPrice).min(Comparator.comparing(Function.identity()));
        System.out.println("min price" + minPrice.get());
    }
}
