package com.test.proxy;

import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField.AbstractFormatter;

//数据源动态路由业务
public class OrderServiceDynamicProxy implements InvocationHandler {
	
	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	private Object target;
	
	public Object getInstance(Object target){
		this.target = target;
		Class<?> clazz = target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(), this);
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		before(args[0]);
		
		Object object = method.invoke(target, args);
		after();
		return object;
	}

	private void after() {
		// TODO Auto-generated method stub
		System.out.println("proxy after method");
	}
	
	private void before(Object target) {
		// TODO Auto-generated method stub
	
		
		try {
			System.out.println("Proxy before method.");
			Long time = (Long) target.getClass().getMethod("getCreateTime").invoke(target);
			Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
			System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
			DynamicDataSourceEntry.set(dbRouter);
			System.out.println("===="+DynamicDataSourceEntry.DEFAULT_SOURCE);

		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
	}

	public static void main (String[] args) {

		// TODO Auto-generated method stub
	
		try {
			Order order = new Order();
			SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy/mm/dd");
			Date date;
			date = simpleDateFormat.parse("2018/02/02");
			order.setCreateTime(date.getTime());
			IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy().getInstance(new OrderService());
			
			orderService.createOrder(order);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}	
	
}