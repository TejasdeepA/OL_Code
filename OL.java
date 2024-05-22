package LocalRepo;

import java.util.ArrayList;
import java.util.Scanner;
class Library{
    Scanner sc= new Scanner(System.in);
    ArrayList<String> avbk = new ArrayList<>();
    int i;
    int q;
    int ind;
    int n= 0;
    String[] issbk=new String[3];
    Library(String [] initialBooks){
        for (String book : initialBooks) {
            avbk.add(book);
        }
        System.out.printf("\nWelcome to The Alchemystic!!!, an Online Library.\n");
        /*System.out.printf("\nThe various features provided by this library include:\n" +
                "1. Displaying the available books\n" +
                "2. Issuing books\n" +
                "3. Having the customers return books\n" +
                "4. Adding new books to the library\n\n");*/
    }
    public void showAvailableBooks(){
        int a= 0;
        for (int i = 0; i < avbk.size(); i++) {
            a = a + 1;
            System.out.println(a + ". " + avbk.get(i));
        }
        index();
    }
    public void issueBook(){
       /* String t;
        n= n++;
        if(n> 2) {
            System.out.println("Sorry, you are allowed to borrow only 3 books at a time. But you could first return a book and then borrow another one instead");
            index();
        }
        else {
            System.out.printf("\nType the index no. of the book you wish to borrow\n");
            System.out.println(q= sc.nextInt());
            issbk[n]= avbk.get(q-1);
            for (int x= 0; x<=n; x++) {
                System.out.println("You have borrowed: " + issbk[x]);
            }
            System.out.println("Is that all?");
            t= sc.next();
            System.out.println(t);
        }
        if(t.equals("yes")){
            index();
        }
        else{
            issueBook();
        }*/


        for (int n= 0;;n++) {
            if(n>2) {
                System.out.println("Sorry, you are allowed to borrow only 3 books at a time. But you could first return a book and then borrow another one instead");
                break;
            }
            System.out.printf("\nType the index no. of the book you wish to borrow\n");
            System.out.println(q= sc.nextInt());

            issbk[n] = avbk.get(q - 1);
            for (int x= 0; x<=n; x++) {
                System.out.println("You have borrowed: " + issbk[x]);
            }

            System.out.println("Is that all?");
            String t= sc.next();
            System.out.println(t);
            if(t.equals("yes")){
                index();
                break;
            }
        }
    }
    public void returnBook(){
        int rbk,j,k;
        j= issbk.length;
        for(k=1;k<=j;k++){
            System.out.printf("\nType the index no. of the book you wish to return\n");
            System.out.println(rbk= sc.nextInt());
            for(int i1= rbk;i1<j;i1++){
                issbk[i1-1]= issbk[i1];
            }
            j--;
            System.out.println("Is that all?");
            String t= sc.next();
            System.out.println(t);
            if(t.equals("yes")){
                break;
            }
        }
        if (j>=1) {
            System.out.println("The books in your possession now are: ");
            for (int p= 0; p<j;p++){
                int m= p+1;
                System.out.print(m+". ");
                System.out.println(issbk[p]);
            }
            index();
        }
        else{
            System.out.println("You currently have no books in your possession ");
            index();
        }
    }
    public void addBook(){
        System.out.println("Which book do you want to add to the collection?");
        String newBook = sc.next();
        avbk.add(newBook);
        System.out.println("The new collection now comprises of the following books: ");
        showAvailableBooks();
        index();
        }
    public void index() {
        System.out.println("\nWhat would you like to do?\n1. Show available books\n2. Return a book\n3. Add a new book\n4. Issue books \n5. Exit");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                showAvailableBooks();
                break;
            case 2:
                returnBook();
                break;
            case 3:
                addBook();
                break;
            case 4:
                issueBook();
                break;
            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
                index();
                break;
        }
    }
}
public class OL {
    public static void main(String[] args) {
        String[] initialBooks = {
                "The Lord of the Rings by J.R.R. Tolkien",
                "Harry Potter and the Philosopher’s Stone by J.K. Rowling",
                "Rich Dad Poor Dad",
                "The Hitchhiker’s Guide to the Galaxy by Douglas Adams",
                "Frankenstein by Mary Shelley"
        };
        Library alchemist= new Library(initialBooks);
        while(true){
            alchemist.index();
        }

    }
}