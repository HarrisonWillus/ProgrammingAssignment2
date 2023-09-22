/**
 * Date: 09/15/2023
 * 
 * @author harrisonwilliams
 * 
 * Description: shows the price and name of books as well as their respectable authors
 */
public class Books {
    
    private String bName, aName;
    private Double price;
    private Integer pageNum;
    
    public Books(String book, String author, Double p, Integer pages){
        bName = book;
        aName = author;
        price = p;
        pageNum = pages;
    }
    
    public String getBook(){
        return bName;
    } //end of getBook()
    
    public String getAuthor(){
        return aName;
    } //end of getAuthor()
    
    public Double getPrice(){
        return price;
    } //end of getPrice()
    
    public Integer getPageNum(){
        return pageNum;
    } //end of getPageNum()
    
    public void setPrice(Double newPrice){
        price = newPrice;
    } //end of setPrice()
    
    public String toString(){
        String description;
        description = "This books name is " + bName + " by " + aName + " that costs $" + price + " with " + pageNum + " pages.";
        return description;
    } //end of toString

} //end of class Books
