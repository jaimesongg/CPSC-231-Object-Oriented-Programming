public class BurritoOrder{
    private Burrito[] m_order; //array of Burrito objects representing order of burritos
    private int m_numBurritos;
    private int m_numBurritosMax;

    //default constructor
    //initializes order with a single default burrito
    public BurritoOrder(){ 
        m_numBurritosMax = 1; //sets max number of burritos to 1
        m_order = new Burrito[m_numBurritosMax]; //creates array with max number of burritos
        m_order[0] = new Burrito(); //adds default burrito to array
        m_numBurritos = 1; //sets number of burritos in the order to 1
    }

    //overloaded constructor
    //initializes order with specified max number of burritos
    public BurritoOrder(int numBurritosMax){
        m_numBurritosMax = numBurritosMax; //assigns value of parameter numBurritosMax to private member variable m_numBurritosMax
        m_order = new Burrito[m_numBurritosMax]; //initializes m_order array with a size equal to max number of burritos allowed
        m_numBurritos = 0;
    }
    
    //adds a new burrito to order if there is space available in array 
    public int addBurrito(Burrito b){
        if (m_numBurritos < m_numBurritosMax){ //checks to see if number of burritos is less than the max
            m_order[m_numBurritos] = b;
            m_numBurritos++;
            return 1; // Successful addition
        } else {
            return -1; // Unsuccessful addition (array is full)
        }
    }
     //method to calculate total cost of the order
     public double calcTotal() {
        double total = 0.0; //initializes variable total
        for (int i = 0; i < m_numBurritos; i++) { //iterates through m_order array, calls calcCost() for each burrito and adds to result to total
            //with each iteration of the for loop, adds cost of the ith burrito to the total 
            //calls calcCost() method of Burrito class for ith burrito in the order and adds returned cost value to total
            total += m_order[i].calcCost(); 

        }
        return total;
    }

    //method to represent order as a string
    public String toString() {
        StringBuilder orderDetails = new StringBuilder(); //cretes new StringBuilder object named orderDetails
        orderDetails.append("Total cost of the order: $").append(calcTotal()).append("\n");
        for (int i = 0; i < m_numBurritos; i++) {
            orderDetails.append("Burrito ").append(i + 1).append(":\n");
            orderDetails.append(m_order[i].toString()).append("\n");
        }
        return orderDetails.toString();
    }


}