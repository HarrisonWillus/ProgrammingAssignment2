/*
    CSC 120
    Programming Assignment number 2
  
    Name: Harrison Williams 

    Date: 09/18/2023

    Description: Shows book objects that are made and printed in good format
*/

import java.awt.*;
import java.text.*;
import javax.swing.*;

public class MUPanel extends JPanel  {
    
    private Books favBook, gfFavBook, funBook, knownBook;
    
    private MUTextArea muta;
    


    public MUPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        setName("CSC 120 Lab # 4");
        setBackground(Color.WHITE);
        muta = new MUTextArea();
        muta.setBounds(10, 10, 780, 580);
        add(muta);
        
        favBook = new Books("Ready Player One", "Ernest Cline", 9.97, 374);
        gfFavBook = new Books("The Invisible Life of Addie Larue", "V. E. Schwab", 10.98,448);
        funBook = new Books("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 15.74, 448);
        knownBook = new Books("The Cat in the Hat", "Dr. Seuss", 9.99, 61);

        workWithBooksObjects();
    } // end of MUPanel constructor
    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setFont( new Font("SansSerif", Font.PLAIN, 24));
        g.drawString("Look in Java Console for output", 100, 60);
        
    } // end of paintComponent()

    
    public void workWithBooksObjects(){
        //defines the format for present day currency
        DecimalFormat currency = new DecimalFormat("#.00");
        
        //shows if toString works for two of the objects
        muta.println(favBook.toString());
        muta.println(gfFavBook.toString());
        
        muta.println();
        
        //shows what each book represents
        muta.println("My favorite Book is " + favBook.getBook() + " by " + favBook.getAuthor() 
                + " with " + favBook.getPageNum() + " pages!");
        muta.println("My Girlfriends favorite Book is " + gfFavBook.getBook() + " by " + gfFavBook.getAuthor() 
                + " with " + gfFavBook.getPageNum() + " pages!");
        muta.println("A fun book to read is " + funBook.getBook() + " by " + funBook.getAuthor() 
                + " with " + funBook.getPageNum() + " pages!");
        muta.println("A well known book is " + knownBook.getBook() + " by " + knownBook.getAuthor() 
                + " with " + knownBook.getPageNum() + " pages!");
        
        muta.println();
        
        //shows each price of the books
        muta.println("The book " + favBook.getBook() + " costs $" + favBook.getPrice() + " before tax.");
        muta.println("The book " + gfFavBook.getBook() + " costs $" + gfFavBook.getPrice() + " before tax.");
        muta.println("The book " + funBook.getBook() + " costs $" + funBook.getPrice() + " before tax.");
        muta.println("The book " + knownBook.getBook() + " costs $" + knownBook.getPrice() + " before tax.");
        
        muta.println();
        
        //calculates the price per page
        Double pricePerPage, pricePerPage2;
        
        pricePerPage = favBook.getPrice() / favBook.getPageNum();
        
        pricePerPage2 = gfFavBook.getPrice() / gfFavBook.getPageNum();
        
        muta.println("The price per page in " + favBook.getBook() + " is $" 
                + currency.format(pricePerPage) +".");
        muta.println("The price per page in " + gfFavBook.getBook() + " is $" 
                + currency.format(pricePerPage2) + ".");
        
        Double discountPct = 0.0;
        
        //gets user input for the discounted price
        String userInput = JOptionPane.showInputDialog("Enter the discount percentage: ");
        discountPct = Double.parseDouble(userInput);
        
        muta.println();
        
        //shows the discount the user inputs
        muta.println("*************ALERT*************");
        muta.println("TODAYS FUN DISCOUNT IS %" + discountPct + "!!");
        muta.println("*******************************");
       
        muta.println();
        
        //calculates the discounted price and sets the new price to the corresponding book
        Double discountPrice = 0.0;
        discountPrice = favBook.getPrice() * (100.0 - discountPct) / 100.0;
        favBook.setPrice(discountPrice);
        discountPrice = gfFavBook.getPrice() * (100.0 - discountPct) / 100.0;
        gfFavBook.setPrice(discountPrice);
        
        //prints out the new price after the discount is added
        muta.println("My favorit book, " + favBook.getBook() + ", discounted with %" 
                + discountPct + " costs $" + currency.format(favBook.getPrice()) + " before tax.");
        muta.println("My girlfriends favorit book, " + gfFavBook.getBook() + ", discounted with %" 
                + discountPct + " costs $" + currency.format(gfFavBook.getPrice()) + " before tax.");
        
    } //end of workWithBooksObjects()
    
    
    
    /***********************************************
     * Do NOT change or delete anything below here!
     ***********************************************/
    public void frame() {
        for (Component c: getComponents())
            c.setSize(c.getPreferredSize());
        JFrame f = new JFrame(getName());
        f.setContentPane(this);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);   
        
    } // end of frame()

    public static void main(String args[]){new MUPanel().frame();}

}
