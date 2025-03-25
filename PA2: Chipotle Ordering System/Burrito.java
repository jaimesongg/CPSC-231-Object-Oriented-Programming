import java.util.Scanner;
public class Burrito{
    private String m_size;
    private String m_protein;
    private String m_rice;
    private String m_beans;
    private boolean m_guac;
    private boolean m_tomatillo;
    private boolean m_sourCream;
    private boolean m_cheese;
    private boolean m_lettuce;

    //default constructor
    public Burrito(){
        m_size = "Regular";
        m_protein = "Chicken";
        m_rice = "White";
        m_beans = "Black";
        m_lettuce = true;
        m_sourCream = true;
        m_guac = false;
        m_tomatillo = false;
        m_cheese = false;  
    }    

    //overload constructor
    public Burrito(String size, String protein, String rice, String beans, boolean guac, boolean tomatillo, boolean sourcream, boolean cheese, boolean lettuce){
        m_size = size;
        m_protein = protein;
        m_rice = rice;
        m_beans = beans;
        m_guac = guac;
        m_tomatillo = tomatillo;
        m_sourCream = sourcream;
        m_cheese = cheese;
        m_lettuce = lettuce;
    }
        
    //copy constructor
    public Burrito(Burrito other){
        //using "this" to refer to current object being initialized
        //this.m_size refers to m_size member variable of new Burrito object being constructed
        //other.m_size refers to the m_size member variable of the existing Burrito object passed as a parameter to the constructor
        this.m_size = other.m_size; 
        this.m_protein = other.m_protein;
        this.m_rice = other.m_rice;
        this.m_beans = other.m_beans;
        this.m_guac = other.m_guac;
        this.m_tomatillo = other.m_tomatillo;
        this.m_sourCream = other.m_sourCream;
        this.m_cheese = other.m_cheese;
        this.m_lettuce = other.m_lettuce;
    }

    //accessors and mutators
    public String getSize(){ //accessor
        return m_size;
    }

    public void setSize(String size){ //mutator
        m_size = size;
    }

    public String getProtein(){
        return m_protein;
    }

    public void setProtein(String protein){
        m_protein = protein;
    }

    public String getRice(){
        return m_rice;
    }

    public void setRice(String rice){
        m_rice = rice;
    }

    public String getBeans(){
        return m_beans;
    }

    public void setBeans(String beans){
        m_beans = beans;
    }

    //calcCost method
    public double calcCost(){
        double cost = 0.0;

        if (m_size.equalsIgnoreCase("Regular")){
            cost += 9.0;
        } else if(m_size.equalsIgnoreCase("Kids")){
            cost += 7.0;
        }

        if (m_protein.equalsIgnoreCase("Chicken")){
            cost += 0.50;
        } else if(m_protein.equalsIgnoreCase("Steak")){
            cost += 1.25;
        } else if(m_protein.equalsIgnoreCase("Veggie")){
            cost += 0.50;
        }

        //checks if the burrito includes guac and the protein is not veggie
        if (m_guac && !m_protein.equalsIgnoreCase("Veggie")){
            cost += 2.65;
        }

        if (m_sourCream){
            cost += 0.25;
        }

        if (m_cheese){
            cost += 0.50;
        }

        return cost;

    }

    //toString method
    public String toString() {
        return "Size: " + m_size + "\n" +
                "Protein: " + m_protein + "\n" +
                "Rice: " + m_rice + "\n" +
                "Beans: " + m_beans + "\n" +
                "Guac: " + m_guac + "\n" +
                "Tomatillo: " + m_tomatillo + "\n" +
                "Sour Cream: " + m_sourCream + "\n" +
                "Cheese: " + m_cheese + "\n" +
                "Lettuce: " + m_lettuce + "\n" +
                "Cost: $" + calcCost();
    }
    //equals method
    public boolean equals(Burrito other){
        return this.m_size.equals(other.m_size) &&
        this.m_protein.equals(other.m_protein) &&
        this.m_rice.equals(other.m_rice) &&
        this.m_beans.equals(other.m_beans) &&
        this.m_guac == other.m_guac &&
        this.m_tomatillo == other.m_tomatillo &&
        this.m_sourCream == other.m_sourCream &&
        this.m_cheese == other.m_cheese &&
        this.m_lettuce == other.m_lettuce;  
    }




    
}