
import javax.swing.JOptionPane;
public class Quadratic 
{
    private double aterm = 0;
    private double bterm = 0;
    private double cterm = 0;
    private double yintercept = 0;
    private double dividend = 0;
    private double takenoutsquare = 1; 
    private double Xvertex = 0;
    private double Yvertex = 0;
    private boolean irrational = true;
    public Quadratic()
    {
//        //rounded or irrational
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
        
        //-----------------------------------------------------------------------------------
        
        //A term entering
        String atermstring = JOptionPane.showInputDialog("Enter your A term: ");
        double a = Double.parseDouble(atermstring); 
        this.aterm = a;
        
        //B term entering
        String btermstring = JOptionPane.showInputDialog("Enter your B term: ");
        double b = Double.parseDouble(btermstring);
        this.bterm = b;
        
        //C term Entering
        String ctermstring = JOptionPane.showInputDialog("Enter your C term: ");
        double c = Double.parseDouble(ctermstring);
        this.cterm = c;
        this.yintercept = c; //y-intercept is the same as c
        
        //Shows all info in a JOptionPane
        paneShowAll();
    }
    public String standardForm()
    {
        if (this.aterm == 1)
        {
            return ("x^2" + " + " + this.bterm + "x" + " + " + this.cterm);
        }
        else if (this.bterm == 1)
        {
            return (this.aterm + "x^2" + " + " + "x" + " + " + this.cterm);
        }
        else if (this.cterm == 1)
        {
            return (this.aterm + "x^2" + " + " + this.bterm + "x" + " + " + this.cterm);
        }
        else if (this.aterm == 0)
        {
            return (this.bterm + "x" + " + " + this.cterm);
        }
        else if (this.bterm == 0)
        {
            return (this.aterm + "x^2" + " + " + this.cterm);
        }
        else if (this.cterm == 0)
        {
            return (this.aterm + "x^2" + " + " + this.bterm + "x");
        }
        else
        {
            return (this.aterm + "x^2" + " + " + this.bterm + "x" + " + " + this.cterm);
        }
    }
    
    private String numerator = "";
    private String negnumerator = "";
    
    public String quadForm()
    {
        double numwodividend = (-1 * this.bterm);
        this.dividend = ((this.bterm*this.bterm)-((4)*this.aterm*this.cterm)) / (takenoutsquare * takenoutsquare);
        double denom = 2 * this.aterm;
        if (takenoutsquare > 1) //is there a removed term from the dividend
        {
            this.numerator = (numwodividend + " + " + (takenoutsquare) + "<" + dividend + ">");
            // + version of zero
            
            this.negnumerator = (numwodividend + " - " + (takenoutsquare) + "<" + dividend + ">");
            // - version of zero
            
            if (dividend == 1) //gets rid of the dividend if it is == 1
            {
                if (numwodividend % 1 == 0 && takenoutsquare % 1 == 0) //does this is the b^2 term and the takenoutsquare are whole
                {
                   if((numwodividend + takenoutsquare) % denom == 0) //does the whole numerator / the whole denomenator yield a whole number
                   {
                       return ((numwodividend + takenoutsquare) / denom) + " and " + ((numwodividend - takenoutsquare) / denom);
                   }
                   else // does this if the numerator / the denomenator =/= a whole number
                   {
                       return (numwodividend + takenoutsquare) + "/" + denom + " and " + (numwodividend - takenoutsquare) + "/" + denom;
                   }
                }
                else // does this if the b^2 or the takenoutsquare are decimals
                {
                   return (numwodividend + " + " + (takenoutsquare) + denom + " and " + (numwodividend + " - " + (takenoutsquare)) + denom );
                }    
            }
            else if (dividend == 0)
            {
                this.numerator = (numwodividend + " + " + takenoutsquare);
                this.negnumerator = (numwodividend + " - " + takenoutsquare);
                return (numerator + "/" + denom + " and " + negnumerator + "/" + denom);
            }
            else //leaves the numerator as is because the dividend cannot be removed or is irrational
            {
                return (numerator + "/" + denom + " and " + negnumerator + "/" + denom);
            }
            
        }
        else //if there is not a term that could be removed from the dividend
        {
            numerator = (numwodividend  +  " + "  +  "<"+ dividend +">");
            negnumerator = (numwodividend  +  " - "  +  "<"+ dividend +">");
            return (numerator + "/" + denom + " and " + negnumerator + "/" + denom);
        }
    }
    public String simplifyDividend()
    {
        for (double i = this.dividend; i > 0; i--)
        {
            double mod = i * i;
            if(this.dividend % mod == 0)
            {
                this.dividend = this.dividend / mod;
                this.takenoutsquare = this.takenoutsquare * i;
            }
        }
        return quadForm();
    }
    public String simplifiedQuadForm()
    {
        simplifyDividend();
        return quadForm();
    }
    public String areZerosReal()
    {
        if(dividend < 0)
        {
            return "Zeros are not real";
        }
        else
        {
            return "Zeros are real";
        }
    }
    public String vertex()
    {
        this.Xvertex = (-1 * (this.bterm / (2 * this.aterm)));
        this.Yvertex = ((this.aterm * (this.Xvertex * this.Xvertex)) + (this.bterm * this.Xvertex) + (this.cterm)); // (-b)/(2a)
        System.out.println("Vertex: (" + this.Xvertex + "," + this.Yvertex + ")");
        return ("(" + this.Xvertex + "," + this.Yvertex + ")");
    }
    public String domain()
    {
        return ("(" + "-infinity,infinity" + ")");
    }
    public String range()
    {
        if (this.aterm > 0)
        {
            System.out.println("Range: " + "(" + Yvertex + "," + "infinity" + ")");
            return ("" + "(" + Yvertex + "," + "infinity" + ")");
        }
        else
        {
            System.out.println("Range: " + "(" + "infinity" + "," + Yvertex + ")");
            return ("" + "(" + "infinity" + "," + Yvertex + ")");
        }
    }
    public String incDec()
    {
        if (this.aterm > 0)
        {
            return ("Increases: " + "(" + Xvertex + "," + "infinity" + ")") + "\n" + "\n" + ("Decreases: " + "(" + "-infinity" + "," + Xvertex + "]");
        }
        else
        {
            return ("Increases" + "(" + "infinity" + "," + Xvertex + "]") + "\n" + "\n" + ("Decreases: "+ "(" + Xvertex + "," + "infinity" + ")");
        }
    }
    public void consoleShowAll()
    {
        System.out.println("All Quadtratic info: ");
        standardForm();
        quadForm();
        simplifiedQuadForm();
        areZerosReal();
        vertex();
        domain();
        range();
        incDec();
    }
    public void paneShowAll()
    {
        JOptionPane.showMessageDialog(null, toString());
    }
    public String toString()
    {
        String value = "";
        
        value = value + "Standard Quadratic Form: ";
        value = value + standardForm();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "";
        value = value + quadForm();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "Simplified Zeros: ";
        value = value + simplifiedQuadForm();
        value = value + "\n";
        //line space
        value = value + "";
        value = value + "<> means that the number contained is in a radical";
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "";
        value = value + areZerosReal();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "Vertex: ";
        value = value + vertex();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "Domain: ";
        value = value + domain();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "Range: ";
        value = value + range();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        value = value + "";
        value = value + incDec();
        value = value + "\n";
        //line space
        value = value + "\n";
        //line space
        
        
        return value; //return statement
    }
    //things to do:
        //make it give an approximation of the zeros and if they arent real
        //make it where even if the radical cant be taken all the way out, that the -b term and the takenoutsquare will be split and simplified
        //make it to where if any of the terms in standardForm are 0 or 1, that they are simplified to either get rid of them or not show them.
        //make a dropdown list that lets the user choose whether or not to round off irrational zeros, vertex, and incDec
        //make it to were if I go with the type-in for choosing rounding, that if the user doesn't give a correct answer, that it asks again
        //make it to were if the rounded statement given by the user is tested to see whether irrational or rounded shows up first in the String
}
