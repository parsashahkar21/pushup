public class product {
    public String name;
    public double rate;
    public int price;
    public int number_of_rate;
    public String creator_name;

    public product(String name, int price, String creator_name){
        this.name = name;
        this.price = price;
        this.rate = 0; 
        this.number_of_rate = 0;
        this.creator_name = creator_name;
    }

    public void add_rate(int new_rate){
        number_of_rate++;
        rate = ( (rate*(number_of_rate-1))+new_rate ) / number_of_rate;
    }


}
