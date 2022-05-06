import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cart {
    private double pricesSum;
    private static List<product> productsList = new ArrayList<product>();

    public static boolean addProduct(product product){
        return productsList.add(product);
    }

    public static void main(String[] args){
        product firstOne = new product(27.5, "001234", "shoes", 27.5);
        product secondOne = new product(27.5, "001234", "T-shirt", 27.5);

        addProduct(firstOne);
        addProduct(secondOne);
        for (product prod : productsList){
            System.out.println(prod.getWholeProduct());
        }
    }

}
