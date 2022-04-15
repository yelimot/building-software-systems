package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Domain.Basket.Basket;
import Domain.Product.IProductBase;
import Domain.Product.Electronic.Headphone;
import Domain.Product.Electronic.Monitor;
import Domain.Product.Electronic.PC;
import Domain.Product.Electronic.Phone;
import Domain.Product.Clothing.Coat;
import Domain.Product.Clothing.Skirt;
import Domain.Product.Cosmetic.Lipstick;
import Domain.Product.Cosmetic.Perfume;

public class FileIO implements IFileIO {
	
		private ArrayList<IProductBase> productRepository = new ArrayList<IProductBase>();
		private ArrayList<Basket> basketRepository = new ArrayList<Basket>();
		
		/** 
		* Constructor with initialisation of DB simulation.
		*/
		public FileIO() throws IOException, ParseException, CloneNotSupportedException {
			readProducts("products.csv");
			readBaskets("baskets.csv");
		}
		
		public ArrayList<IProductBase> getProductRepository() {
			return productRepository;
		}

		public ArrayList<Basket> getBasketRepository() {
			return basketRepository;
		}
		
		public void readProducts(String path) throws IOException {
			BufferedReader csvReader = new BufferedReader(new FileReader(path));
		    String row;
			while ((row = csvReader.readLine()) != null) {
		   		String[] listOfAttributes = row.split(";");		   		
		   		String[] productId = listOfAttributes[0].split("-");
		   		if (productId[0].equals("ELPC")){
		   			productRepository.add(new PC(listOfAttributes[0],  
				   			listOfAttributes[1], Integer.valueOf(listOfAttributes[2]), 
				   			Integer.valueOf(listOfAttributes[3]), listOfAttributes[4]));
		   		} else if (productId[0].equals("ELMO")){
		   			productRepository.add(new Monitor(listOfAttributes[0],  
		   					listOfAttributes[1], listOfAttributes[2]));
		   		} else if (productId[0].equals("ELPH")){
		   			productRepository.add(new Phone(listOfAttributes[0],  
		   					listOfAttributes[1], Integer.valueOf(listOfAttributes[2])));
		   		} else if (productId[0].equals("ELHE")){
		   			productRepository.add(new Headphone(listOfAttributes[0],  
		   					listOfAttributes[1], Integer.valueOf(listOfAttributes[2])));
		   		} else if (productId[0].equals("CLCO")){
		   			productRepository.add(new Coat(listOfAttributes[0],  
		   					listOfAttributes[1], listOfAttributes[2], listOfAttributes[3]));
		   		} else if (productId[0].equals("CLSK")){
		   			productRepository.add(new Skirt(listOfAttributes[0],  
		   					listOfAttributes[1], listOfAttributes[2], listOfAttributes[3] ));
		   		} else if (productId[0].equals("COPE")){
		   			productRepository.add(new Perfume(listOfAttributes[0],  
		   					listOfAttributes[1], Integer.valueOf(listOfAttributes[2]), listOfAttributes[3] ));
		   		} else if (productId[0].equals("COLI")){
		   			productRepository.add(new Lipstick(listOfAttributes[0],  
		   					listOfAttributes[1], Integer.valueOf(listOfAttributes[2]), listOfAttributes[3],
		   					listOfAttributes[4]));
		   		}
		   	}
			csvReader.close();
		}
		
		// helper method that returns 'clone of the product' from productRepository by its Id.
		private IProductBase getById(String someId) throws CloneNotSupportedException {
			for(IProductBase someProduct : productRepository) { 
				   if(((someProduct).getProductId().equals(someId))){ 
				       return someProduct.clone();
				   }
				}
			return null;
		}

		public void readBaskets(String path) throws IOException, ParseException, CloneNotSupportedException {
			BufferedReader csvReader = new BufferedReader(new FileReader(path));
		    String row;
			while ((row = csvReader.readLine()) != null) {
				String[] listOfAttributes = row.split(";"); 
				Basket oneBasket = new Basket(listOfAttributes[0], new SimpleDateFormat("dd.MM.yyyy").parse(listOfAttributes[listOfAttributes.length - 1]));
				basketRepository.add(oneBasket);
				int numberOfIterations = (listOfAttributes.length-2)/3; // 'every 3 items' indicates number of iterations (except first and last indexes).
				int k = 1; // product index to accessing quantity and price
				for (int i=0; i<numberOfIterations; i++) {
						IProductBase justReadedProduct = getById(listOfAttributes[k]);
						basketRepository.get(Integer.valueOf(listOfAttributes[0])-1).getBasketItems().add(justReadedProduct);
						basketRepository.get(Integer.valueOf(listOfAttributes[0])-1).setProductDiversity();
						justReadedProduct.setPriceOfThatProduct(Integer.valueOf(listOfAttributes[k+1]));
						justReadedProduct.setQuantityOfProduct(Integer.valueOf(listOfAttributes[k+2]));
						justReadedProduct.setRevenueFromProduct();
						basketRepository.get(Integer.valueOf(listOfAttributes[0])-1).increaseBasketValue(justReadedProduct.getRevenueFromProduct());
						k += 3;
				}
			}
			csvReader.close();	
		}
}
