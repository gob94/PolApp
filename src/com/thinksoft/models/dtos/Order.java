package com.thinksoft.models.dtos;

import java.util.Date;

import com.j256.ormlite.table.DatabaseTable;
import com.thinksoft.models.dtos.impl.ClientImpl;
import com.thinksoft.models.dtos.impl.PaymentFrequencyImpl;
import com.thinksoft.models.dtos.impl.UserImpl;

@DatabaseTable
public interface Order {
	
	public int getOrderId();
 
	public Date getCreationDate();

	public Date getNextPaymentDate();

	public float getFinalBalance();

	public float getActualBalance();

	public UserImpl getUserId();
	public ClientImpl getClientId();

	public PaymentFrequencyImpl getPaymentFrequencyId();
	
	public boolean getOrderState();

	public void setOrderId(int orderId);

	public void setCreationDate(Date creationDate);

	public void setNextPaymentDate(Date nextPaymentDate);

	public void setFinalBalance(float finalBalance);

	public void setActualBalance(float actualBalance);

	public void setUserId(UserImpl userId);

	public void setClientId(ClientImpl clientId);

	public void setPaymentFrequencyId(PaymentFrequencyImpl paymentFrequencyId);
	
	public void setOrderState(boolean orderState);
}
