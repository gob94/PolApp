package com.thinksoft.businesslayer.bussinessmanagers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.j256.ormlite.support.ConnectionSource;
import com.thinksoft.models.dtos.Address;
import com.thinksoft.models.dtos.Brand;
import com.thinksoft.models.dtos.Client;
import com.thinksoft.models.dtos.Order;
import com.thinksoft.models.dtos.PaymentFrequency;
import com.thinksoft.models.dtos.Product;
import com.thinksoft.models.dtos.User;
import com.thinksoft.models.dtos.Vehicle;
public interface BusinessManager {
	
	public boolean addAddress(Address address);
	
	public boolean addBrand(Brand brand); 
	
	public boolean addClient(Client client);
	
	public void addDefaultOrderValues();
	
	public Order addOrder(int clientId, int paymentId, long total);
	
	public boolean addProduct(Product product);

	boolean addProductsToOrder(Order order, Map<Integer, Integer> productsId,
			ConnectionSource connectionSource);

	public boolean addUser(User user);


	public boolean addVechicle(Vehicle vehicle);

	public boolean checkUserCredentials(String userName, String password);
	
	public boolean clientHasOrders(int clientId);
	
	public List<Map<String, String>> getAllActiveOrders();
	
	public List<Map<String, String>> getAllOrderProducts(Order order);
	public Map<Integer, Integer> getAllProductsByOrderId(Order order);
	
	public List<Map<String, String>> getAllClients();

	public List<Map<String, String>> getAllProducts();

	public List<Map<String, String>> getAllVehicles();
	public Client getClientById(int id);

	
	public String getClientPhoneNumber(int clientId);
	
	public List<Map<String, String>> getClientProducts(int clientId);
	
	public Order getOrderById(int id);
	
	public Product getProduct(int id);
	
	public Product getProductByCode(String id);

	public String getFormatedDate(Date date);
	
	public Product getProductById(int id);
	
	public Vehicle getVehicleByLicensePlate(String licensePlate);

	public double getProductPrice(int id);
	
	public List<Map<String, String>> getSpecifiedNumberOfClients(long number);
	public List<Map<String,String>> listOfPaymentMethods();
	
	public List<Map<String,String>> listOfSellers();
	
	public String registerUser(User user);
	
	public List<Map<String, String>> searchClients(String[] queryString);
	
	public List<Map<String, String>> searchProducts(String[] queryString);
	
	public String verifyClientInformation(String name, String[] lastName,long phoneNumber);

	public String verifyOrderInformation(int clientId, int paymentId);

	public String verifyProductInformation(String code, String name, String quantity, String price);

	public User verifyUserInformation(String userName, String password,
			String name, String[] lastName, String identification);
	public PaymentFrequency getPaymentFrequencyById(int paymentId);

	public void updateOrder(Order order);

	boolean updateClient(Client client);

	public boolean updateProduct(Product product);
	
	public Address getAddressByClientId(int id);
	
}
