import java.util.ArrayList;
import java.util.List;

public class Library {
    // Add the missing implementation to this class
	private List<Book> collection;
	private String address;
	public static final String OPENING_HOURS  = "Libraries are open daily from 9am to 5pm."; 
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Book> getCollection() {
		return collection;
	}

	public void setCollection() {
		
		Book b = new Book();
		collection.add(b);
	}

	public static String getOpeningHours() {
		return OPENING_HOURS;
	}

	public Library(String address) {
		this.address = address;
		this.collection = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		this.collection.add(book);
	}
	
	public String borrowBook(String title) {
		
		for(int i = 0; i < collection.size(); i++) {
			if(collection.get(i).getTitle().equals(title)) {
				if(collection.get(i).isBorrowed()) {
					return "Sorry, this book is already borrowed.";
				} else {
					collection.get(i).borrowed();
					return "You successfully borrowed " + "\"" + title + "\".";	
				}
			}
		}
		return "Sorry, this book is not in our catalog.";
	}
	
	public void printAvailableBooks()
	{
		if(this.collection.isEmpty())
		{
			System.out.println("No book in catalog");
		}
		for(Book book:this.collection)
		{
			if(!book.isBorrowed())
			System.out.println(book.getTitle());
		}
	}
	
	public void returnBook(String title) {
		
		for(Book book:this.collection)
		{
			if(book.getTitle().equals(title))
			{
				book.returned();
				System.out.println("You successfully returned " + title);
			}
		}
	}
	
	@Override
	public String toString() {
		String total = "\n";
		for (int i = 0; i < collection.size(); i++) {
			Book b = collection.get(i);
			total = total + b.toString();
		}
		return total;
	}

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        System.out.println(firstLibrary.address);
        System.out.println(secondLibrary.address);

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours: ");
        System.out.println(OPENING_HOURS);
        System.out.println("Library addresses: ");
        System.out.println(firstLibrary.getAddress());
        System.out.println(secondLibrary.getAddress());
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        
        System.out.println(firstLibrary.borrowBook("The Lord of the Rings"));
        System.out.println(firstLibrary.borrowBook("The Lord of the Rings"));
        System.out.println(secondLibrary.borrowBook("The Lord of the Rings"));
        System.out.println();

        // Print the titles of all available books from both libraries
        
        System.out.println("Books available in the first library: ");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
       System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of books available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}