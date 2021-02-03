package com.test.proxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderServiceStaticProxy implements IOrderService {
	
	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	private IOrderService orderService;
	public  OrderServiceStaticProxy(IOrderService orderService) {
		// TODO Auto-generated constructor stub
		this.orderService = orderService;
	}
	
	@Override
	public int createOrder(Order order) {
		// TODO Auto-generated method stub
		
		before();
		Long time = order.getCreateTime();
		Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
		System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据====");
		DynamicDataSourceEntry.set(dbRouter);
		orderService.createOrder(order);
		after();
		
		return 0;
	}

	private void after() {
		// TODO Auto-generated method stub
		System.out.println("Proxy before method.");
	}

	private void before() {
		// TODO Auto-generated method stub
		System.out.println("Proxy after method.");
	}
	
	public static void main(String[] args){
		
		try {
			Order order = new Order();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date= simpleDateFormat.parse("2017-02-01");
			order.setCreateTime(date.getTime());
			
			IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
			orderService.createOrder(order);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
