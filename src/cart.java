import java.util.*;

public class cart {
    private double pricesSum;
    private static List<product> productsList = new ArrayList<product>();

    public static void addProduct(product product){
        productsList.add(product);
    }

    public static product findCheapest(){
        return Collections.min(productsList, Comparator.comparing(product::getPrice));
    }

    public static product findMostExpensive(){
        return Collections.max(productsList, Comparator.comparing(product::getPrice));
    }


    public static List<product> budgetShopping(int howMany){
        List<product> copy;
        Collections.copy(copy);
        List<product> cheapest = new ArrayList<product>();
        for (int i = 0; i < howMany; i++){
            product tmp = findCheapest();

            cheapest.add(tmp);

        }
    }

    public static void main(String[] args){
        product firstOne = new product(27.5, "001234", "shoes");
        product thirdOne = new product(15.5, "001234", "shoes");
        product secondOne = new product(2, "001234", "T-shirt");

        addProduct(firstOne);
        addProduct(secondOne);
        product maxPrice =  findMostExpensive();
        product minPrice =  findCheapest();
        System.out.println("The most expensive product is : " + maxPrice.getWholeProduct());
        System.out.println("The least expensive product is : " + minPrice.getWholeProduct());


    }

}
