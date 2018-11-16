package cs2340.happythoughts.models;

public enum Category {
    APPLIANCES("Appliances"),
    BABY("Baby"),
    BAGSANDACCESSORIES("Bags and Accessories"),
    BOOKSMOVIESMUSICGAMES("Books, Movies, Music and Games"),
    CLOTHING("Clothing"),
    ELECTRONICS("Electronics"),
    FURNITURE("Furniture"),
    SHOES("Shoes"),
    SPORTSANDOUTDOORS("Sports and Outdoors"),
    TOYS("Toys");

    private String category;

    Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}