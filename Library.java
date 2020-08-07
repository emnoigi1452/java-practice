import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        class Book {
            public String name;
            public String publisher;
            public int publishedYear;

            public Book(String name, String publisher, int publishedYear) {
                this.name = name;
                this.publisher = publisher;
                this.publishedYear = publishedYear;
            }

            public String getName() {
                return this.name;
            }
            public String getPublisher() {
                return this.publisher;
            }
            public int getPublishedYear() {
                return publishedYear;
            }

            public void display() {
                System.out.println(this.name + ", published by: " + this.publisher + " (" + this.publishedYear + ")");
            }
        }

        class Library {
            public String name;
            ArrayList<Book> libraryBooks = new ArrayList<>();

            public Library(String name) {
                this.name = name;
            }

            public void addBooks(Book bookTitle) {
                libraryBooks.add(bookTitle);
            }

            public void displayBooks() {
                for(Book display: libraryBooks) {
                    System.out.println(display.getName() + ", published by: " + display.getPublisher() +
                            " (" + display.getPublishedYear() + ")");
                }
            }
            public int getBookCount() {
                return libraryBooks.size();
            }

            public ArrayList<Book> searchByTitle(String title) {
                ArrayList<Book> results = new ArrayList<>();
                for(Book search: libraryBooks) {
                    if(search.getName().contains(title)) {
                        results.add(search);
                    }
                }
                return results;
            }

            public ArrayList<Book> searchByPublisher(String publisher) {
                ArrayList<Book> results = new ArrayList<>();
                for(Book search: libraryBooks) {
                    if(search.getPublisher().contains(publisher)) {
                        results.add(search);
                    }
                }
                return results;
            }

            public ArrayList<Book> searchByPublishedYear(int publishedYear) {
                ArrayList<Book> results = new ArrayList<>();
                for(Book search: libraryBooks) {
                    if(search.getPublishedYear() == publishedYear) {
                        results.add(search);
                    }
                }
                return results;
            }
        }
    }
}
