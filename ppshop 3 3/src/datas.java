import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.io.FileWriter;



public class datas {




    public datas(){

    }

    public static ArrayList<normal_user> get_nusers(){
        ArrayList<normal_user> nusers = new  ArrayList<normal_user>();
        try {
			FileReader reader = new FileReader("ndata.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;


			while ((line = bufferedReader.readLine()) != null) {
				String[] ez1 = line.split("@");
                normal_user ez2 = new normal_user(ez1[0], ez1[1], ez1[2]);
                nusers.add(ez2);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
        return nusers;
    }

    public static void set_nusers(normal_user ez1){
        try {
			FileWriter writer = new FileWriter("ndata.txt", true);

			writer.write(ez1.username + "@" + ez1.passhash + "@" + ez1.number + "@\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static ArrayList<admin_user> get_ausers(){
        ArrayList<admin_user> ausers = new  ArrayList<admin_user>();
        try {
			FileReader reader = new FileReader("adata.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;


			while ((line = bufferedReader.readLine()) != null) {
				String[] ez1 = line.split("@");
                admin_user ez2 = new admin_user(ez1[0], ez1[1], ez1[2]);
                ausers.add(ez2);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
        return ausers;
    }

    public static void set_ausers(admin_user ez1){
        try {
			FileWriter writer = new FileWriter("adata.txt", true);

			writer.write(ez1.username + "@" + ez1.passhash + "@" + ez1.number + "@\n");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }


    public static ArrayList<product> get_product(admin_user ez1){
        ArrayList<product> products = new ArrayList<product>();
        try {
			FileReader reader = new FileReader("pdata.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

            

			while ((line = bufferedReader.readLine()) != null) {
                
				String[] ez2 = line.split("@"); 

                

                if(ez2[0].equals(ez1.username)){
                    product ww = new product(ez2[1], Integer.parseInt(ez2[2]), ez2[0]);
                    ww.rate = Double.parseDouble(ez2[3]);
                    ww.number_of_rate = Integer.parseInt(ez2[4]);
                    products.add(ww);
                }
                
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
        return products;
    }

    public static void set_product(admin_user ez1, product newp){
        try {
			FileWriter writer = new FileWriter("pdata.txt", true);
			writer.write(ez1.username+"@"+newp.name+"@"+newp.price+"@"+newp.rate+"@"+newp.number_of_rate+"@\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static ArrayList<product> allproducts(){
        ArrayList<product> products = new ArrayList<product>();

        ArrayList<admin_user> ausers = datas.get_ausers();
        for(admin_user x : ausers){
            ArrayList<product> productsofx = datas.get_product(x);
            for(product z : productsofx) products.add(z);
        }
        return products;
    }

    
    public static ArrayList<product> get_cart(normal_user ez1){
        ArrayList<product> products = new ArrayList<product>();
        try {
			FileReader reader = new FileReader("cart.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
                
				String[] ez2 = line.split("@"); 

                if(ez2[0].equals(ez1.username)){
                    product ww = new product(ez2[1], Integer.parseInt(ez2[2]), ez2[0]);
                    ww.rate = Double.parseDouble(ez2[3]);
                    ww.number_of_rate = Integer.parseInt(ez2[4]);
                    products.add(ww);
                }
                
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
        return products;
    }

    public static void set_cart(normal_user ez1, product newp){
        try {
			FileWriter writer = new FileWriter("cart.txt", true);
			writer.write(ez1.username+"@"+newp.name+"@"+newp.price+"@"+newp.rate+"@"+newp.number_of_rate+"@\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }



}