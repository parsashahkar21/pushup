
import java.util.ArrayList;

class admin_user extends user{

    ArrayList<product> Myproducts = new ArrayList<product>();

    public admin_user(String username, String pass, String number){
        super( username, pass, number);
    }

    public void add_product(product new_product){
        Myproducts.add(new_product);
    }

    public void delete_product(product new_product){
        for(product f : Myproducts){
            if(f.name == new_product.name)
                Myproducts.remove(new_product);
        }
    }
    

}