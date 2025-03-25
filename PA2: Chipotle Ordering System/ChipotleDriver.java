public class ChipotleDriver{    
    public static void main(String[] args){

Burrito defaultBurrito = new Burrito(); 

// veggieBurrito: regular, veggie, white rice, pinto beans, guacamole, lettuce, tomatillo 
Burrito veggieBurrito = new Burrito("Regular", "Veggie", "White", "Pinto", true, true, true, false, true);// veggieBurrito

Burrito veggieBurrito2 = new Burrito(veggieBurrito);// Same as veggieBurrito, use copy constructor*

Burrito  defaultBurrito2 = new Burrito(defaultBurrito);// Same as defaultBurrito, use copy constructor*

BurritoOrder order = new BurritoOrder(3);// create an order of THREE Burritos


// no need to change anything here

// add defaultBurrito to the order
System.out.println(order.addBurrito(defaultBurrito));

// add veggieBurrito to the order
System.out.println(order.addBurrito(veggieBurrito));

// add veggieBurrito2 to the order
System.out.println(order.addBurrito(veggieBurrito2));

// add defaultBurrito2 to the order – what happens here? 
System.out.println(order.addBurrito(defaultBurrito2));

// are veggieBurrito and veggieBurrito2 the same? should be!
System.out.print("are veggieBurrito and veggieBurrito2 the same? ");
System.out.println(veggieBurrito.equals(veggieBurrito2));
// are veggieBurrito and defaultBurrito the same? shouldn't be...
System.out.print("are veggieBurrito and defaultBurrito the same? ");
System.out.println(veggieBurrito.equals(defaultBurrito));

// Should call order’s toString methods
System.out.println(order);
}
}