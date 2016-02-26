
import javax.swing.JOptionPane;

public class Cubic 
{
    private double x3 = 0;
    private double x2 = 0;
    private double x1 = 0;
    private double c = 0;
    private boolean syntheticdivision = true;
    private double divider = 1;
    private boolean irrational = true;
    public Cubic()
    {
//        //asks and tests if the user would like irrational or rounded answers
//        String roundedOrIrrational = JOptionPane.showInputDialog("Irrational or Rounded?");
//        if (roundedOrIrrational.indexOf("irrational") >= 0 || roundedOrIrrational.indexOf("Irrational") >= 0)
//        {
//            irrational = true;
//            JOptionPane.showMessageDialog(null, "Irrational it is!");
//        }
//        else if (roundedOrIrrational.indexOf("round") >= 0 || roundedOrIrrational.indexOf("round") >= 0)
//        {
//            irrational = false;
//            JOptionPane.showMessageDialog(null, "Rounded it is!");
//        }
//        else 
//        {
//            JOptionPane.showMessageDialog(null, "'Rounded' or 'Irrational' was not in your answer.");
//        }
//        //ending of what was stated above
        
        //-----------------------------------------------------------------------------------
                
        //x3 term entering
        String term3string = JOptionPane.showInputDialog("Enter your leading coefficient (x^3): ");
        double term3 = Double.parseDouble(term3string); 
        this.x3 = term3;
        
        //x2 term entering
        String term2string = JOptionPane.showInputDialog("Enter your second coefficient (x^2): ");
        double term2 = Double.parseDouble(term2string);
        this.x2 = term2;
        
        //x1 term Entering
        String term1string = JOptionPane.showInputDialog("Enter your last coefficient (x^1): ");
        double term1 = Double.parseDouble(term1string);
        this.x1 = term1;
        
        //x1 term Entering
        String constantstring = JOptionPane.showInputDialog("Enter your constant: ");
        double constant = Double.parseDouble(constantstring);
        this.c = constant;
        
        //asks if the user would like to synthetically divide by some factor
        String divideyesorno = JOptionPane.showInputDialog("Would you like to divide by a factor? (Enter some form of (yes or no)))");
        if (divideyesorno.equals("yes"))
        {
            syntheticdivision = true;
            String divider = JOptionPane.showInputDialog("Please enter your factor that you would like to divide by" + "\n" + "x - ");
            this.divider = Double.parseDouble(divider);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Will not divide");
        }
        //ending of what was stated above

        //Shows all info in a JOptionPane
        paneShowAll();
    }
    public String standardForm()
    {
        return(this.x3 + "x^3" + " + " + this.x2 + "x^2" + " + " + this.x1 + "x" + " + " + this.c);
    }
    public String endBehavior()
    {
        if(this.x3 > 0)
        {
            return("left side negative, right side positive");
        }
        else
        {
            return("left side positive, right side negative");
        }
    }
    public String divideBy(double divider)
    {
        double tempx2 = this.x3;
        double tempx1 = this.x2;
        double tempc = this.x1;
        double tempr = this.c;
        
        if (!(divider == 0))
        {
            tempx1 = tempx1 - (tempx2 * divider);
            tempc = tempc - (tempx1 * divider);
            tempr = tempr - (tempc * divider);
        
            if (tempr == 0)
            {
                return (tempx2 + "x^2" + " + " + tempx1 + "x" + " + " + tempc);
            }
            else if ((tempr/divider) % 1 == 0)
            {
                return (tempx2 + "x^2" + " + " + tempx1 + "x" + " + " + (tempc + (tempr/divider)));
            }
            else if (irrational == true)
            {
                return (tempx2 + "x^2" + " + " + tempx1 + "x" + " + " + tempc + " + " + tempr + "/" + divider);
            }
            else if (irrational == false)//AKA the user wants it rounded off into a decimal
            {
                return (tempx2 + "x^2" + " + " + tempx1 + "x" + " + " + tempc + " + " + (tempr/divider));
            }
            else 
            {
                return (tempx2 + "x^2" + " + " + tempx1 + "x" + " + " + tempc + " + " + tempr + "/" + divider);
            }
        }
        else
        {
            return "Cannot divide by 0";
        }
    }
    public String toString()
    {
        String value = "";
        
        value = value + "Standard Form: ";
        value = value + standardForm();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "End Behavior: ";
        value = value + endBehavior();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "Quadratic when divided by previously endered factor: " + "\n";
        value = value + divideBy(this.divider);
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        return value;
    }
    public void paneShowAll()
    {
        JOptionPane.showMessageDialog(null, toString());
    }
}

