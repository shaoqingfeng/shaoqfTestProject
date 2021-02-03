package com.test.proxy;

public class OrderService implements IOrderService {
	private OrderDao orderDao;
	
	public  OrderService() {
		// TODO Auto-generated constructor stub
		orderDao = new OrderDao();
	}

	@Override
	public int createOrder(Order order) {
		// TODO Auto-generated method stub
		System.out.println("OrderServcie 调用orderDao创建订单");
		return orderDao.insert(order);
	}

}
