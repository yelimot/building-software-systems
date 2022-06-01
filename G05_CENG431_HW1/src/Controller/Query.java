package Controller;

import java.util.ArrayList;

import Domain.Basket.Basket;
import Domain.Product.IProductBase;

public class Query implements IQuery{
	
	public Query() {
	}	
	
	public void Query1(ArrayList<Basket> basketRepository) {
		int totalRevenue = 0;
		for(Basket aBasket : basketRepository) {
			for(IProductBase aProduct : aBasket.getBasketItems()) {
			   if(((aProduct).getProductId().equals("COLI-1"))){
				   totalRevenue += aProduct.getRevenueFromProduct();
			   }
			}
		}
		System.out.println("1- The revenue from COLI-1 product: " + totalRevenue);
	}
	
	public void Query2(ArrayList<Basket> basketRepository, ArrayList<IProductBase> productRepository) {
		IProductBase topSellingProduct = productRepository.get(0);
		int mostSoldQuantity = 0;
		for(IProductBase aProduct : productRepository) {
			int tempSoldQuantity = 0;
			for(Basket aBasket : basketRepository) {
				for(IProductBase a1Product : aBasket.getBasketItems()) {
				   if(((a1Product).getProductId().equals(aProduct.getProductId()))){ 
					   tempSoldQuantity += a1Product.getQuantityOfProduct();
				   }
				}
			}
			if (mostSoldQuantity <= tempSoldQuantity) {
				mostSoldQuantity = tempSoldQuantity;
				topSellingProduct = aProduct;
			}
		} 
		System.out.println("2- Top selling product by quantity: " + topSellingProduct.getProductId() + " with " + mostSoldQuantity);
	}
	
	public void Query3(ArrayList<Basket> basketRepository) {
		Basket mostPaidBasket = null;
		int paidIterator = basketRepository.get(0).getBasketValue();
		for(Basket aBasket : basketRepository) {
			if (aBasket.getBasketValue()>paidIterator) {
				mostPaidBasket = aBasket;
			}
		}
		System.out.println("3- The most paid basket: Basket-" + mostPaidBasket.getBasketId() + " with " + mostPaidBasket.getBasketValue());
	}
	
	public void Query4(ArrayList<Basket> basketRepository) {
		Basket mostDiverseBasket = null;
		int diversityIterator = basketRepository.get(0).getProductDiversity();
		for(Basket aBasket : basketRepository) {
			if (aBasket.getProductDiversity()>diversityIterator) {
				mostDiverseBasket = aBasket;
			}
		}
		System.out.println("4- Basket with the largest number of different products: Basket-" + mostDiverseBasket.getBasketId()
		+ " with " + mostDiverseBasket.getProductDiversity() + " different products.");
	}
	
	
	@SuppressWarnings("deprecation") // getMonth method, but it works.
	public void Query5(ArrayList<Basket> basketRepository, ArrayList<IProductBase> productRepository) {
		String[] months = {"January", "February", "March", "April",
				"May", "June", "July", "August",
				"September", "October", "November", "December"};
		IProductBase highestELPC1 = productRepository.get(0);
		Basket thatBasket = null;
		for(Basket aBasket : basketRepository) {
			for(IProductBase aProduct : aBasket.getBasketItems()) {
			   if(((aProduct).getProductId().equals("ELPC-1")) && (aProduct.getPriceOfThatProduct()>highestELPC1.getPriceOfThatProduct())){
				   highestELPC1 = aProduct;
				   thatBasket = aBasket;
			   }
			}
		}
		System.out.println("5- The month in which the ELPC-1 was sold the most expensive: " + months[thatBasket.getBasketDate().getMonth()]);
	}
	
	// helper method for calculating the increase rate
	private float calculateIncreaseRate(IProductBase headPhone1, IProductBase headPhone2) {
		float lastItem = headPhone2.getPriceOfThatProduct(); // price of the item that higher price
		float firstItem = headPhone1.getPriceOfThatProduct();
		return ((lastItem - firstItem)/firstItem) * 100; // increase rate in terms of %
	}
	
	@SuppressWarnings("deprecation") // getMonth method, but it works.
	public void Query6(ArrayList<Basket> basketRepository) {
		ArrayList<IProductBase> ELPC1ListInJuly = new ArrayList<IProductBase>();;
		for(Basket aBasket : basketRepository) {
			if (aBasket.getBasketDate().getMonth() == 6) { // months as Integers (from 0 to 11, so 6 is July)
				for(IProductBase aProduct : aBasket.getBasketItems()) {
					   if(((aProduct).getProductId().equals("ELHE-2"))) {
						   ELPC1ListInJuly.add(aProduct);
					   }
				}
			}
		}
		System.out.println("6- Price increase rate of ELHE-2 in July: %" + calculateIncreaseRate(ELPC1ListInJuly.get(0), ELPC1ListInJuly.get(ELPC1ListInJuly.size()-1)));
	}
}
