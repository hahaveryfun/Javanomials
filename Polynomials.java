
import javax.swing.JOptionPane;
//preconditions that must be met for program to write correctly
    //findVertex() must be run before range() can run

public class Polynomials {

    public static void main(String[] args) 
    {
        String[] choices = { "Quadratic", "Cubic"};
        String input = (String) JOptionPane.showInputDialog(null, "Type of Function:", "Initial Choice", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        if (input.equals("Quadratic"))
        {
            Quadratic Q = new Quadratic();
        }
        else if(input.equals("Cubic"))
        {
            Cubic C = new Cubic();
        }
    }
}
