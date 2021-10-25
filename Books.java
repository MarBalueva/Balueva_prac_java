import java.lang.*;
public class Books
{
    private String name;
    private String author;

    public Books(String n, String a) {
        name = n;
        author = a;
    }
    public Books(String n){
        name = n;
        author = "";
    }
    public Books(){
        name = "Voina i mir";
        author = "Tolstoy L.N.";
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getName(){
        return name;
    }
    public String getAuthor(){
        return author;
    }
    public String toString(){
        return '"' + this.name + '"' + ", author " + this.author;
    }
}

