import java.util.ArrayList;

interface Package {
    double getBoxWeight();
}

class Book {
    private String author;
    private String title;
    private double weight;

    public Book(String paramAuthor, String paramName, double paramWeight) {
        this.author = paramAuthor;
        this.title = paramName;
        this.weight = paramWeight;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public double getWeight() {
        return weight;
    }
}

class CD {
    private String name;
    private int publishedYear;
    private double weight;

    public CD(String paramName, int paramYear) {
        this.name = paramName;
        this.publishedYear = paramYear;
        this.weight = 0.1;
    }

    public String getName() {
        return name;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getWeight() {
        return weight;
    }
}

class Box implements Package {
    private final double weightLimit;
    private int itemCount;
    private ArrayList<Book> books;
    private ArrayList<CD> cds;
    private ArrayList<Box> boxes;

    public Box(double paramLimit) {
        this.weightLimit = paramLimit;
        this.itemCount = 0;
        books = new ArrayList<Book>();
        cds = new ArrayList<CD>();
        boxes = new ArrayList<Box>();
    }
    public double getBoxWeight() {
        double weight = 0;
        for(Book b: books) {
            weight += b.getWeight();
        }
        for(int i = 0; i < cds.size(); i++) {
            weight += 0.1;
        }
        for(Box bx: boxes) {
            weight += bx.getBoxWeight();
        }
        return weight;
    }
    public int getItemCount() {
        verifyItemCount();
        return this.itemCount;
    }
    public void verifyItemCount() {
        this.itemCount = this.books.size() + this.cds.size();
        for(Box b: boxes) {
            this.itemCount += b.getItemCount();
        }
    }
    public int getMiniBoxesAmount() {
        if(this.boxes.size() == 0) {
            return 0;
        } else {
            return this.boxes.size();
        }
    }

    public void add(Book book) {
        if(getBoxWeight() + book.getWeight() <= this.weightLimit) {
            this.books.add(book);
        }
        else {
            System.out.println("Unable to add book because maximum weight achieved!");
        }
    }
    public void add(CD cd) {
        if(getBoxWeight() + 0.1 <= this.weightLimit) {
            this.cds.add(cd);
        }
        else {
            System.out.println("Unable to add cd because maximum weight achieved!");
        }
    }
    public void add(Box box) {
        if(this.getBoxWeight() + box.getBoxWeight() <= this.weightLimit) {
            this.boxes.add(box);
        }
        else {
            System.out.println("Unable to add this box to a bigger box!");
        }
    }
    public String toString() {
        return "Box: " + getItemCount() + " items - Total weight: " + getBoxWeight()
                + "kg\nContaining: " + getMiniBoxesAmount() + " smaller boxes.";
    }
}
