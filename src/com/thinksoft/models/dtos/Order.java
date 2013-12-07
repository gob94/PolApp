package com.thinksoft.models.dtos;

import java.util.Date;

import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.PaymentFrequencyImpl;

@DatabaseTable
public interface Order {
	
	public int getOrderId();
 
	public Date getCreationDate();

	public Date getNextPaymentDate();

	public long getFinalBalance();

	public long getActualBalance();

	public ClientImpl getClient();

	public PaymentFrequencyImpl getPaymentFrequency();
	
	public boolean getOrderState();

	public void setOrderId(int orderId);

	public void setCreationDate(Date creationDate);

	public void setNextPaymentDate(Date nextPaymentDate);

	public void setFinalBalance(long finalBalance);

	public void setActualBalance(long actualBalance);

	public void setClient(ClientImpl client);

	public void setPaymentFrequency(PaymentFrequencyImpl paymentFrequency);
	
	public void setOrderState(boolean orderState);
}
