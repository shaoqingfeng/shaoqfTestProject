package com.test1;
import java.util.ArrayList;
 import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class ShaoDemo {
	class Dog{
		public int age;                                           
		public String name;                                       
		public Dog(int age, String name) {                        
		    super();                                              
		    this.age = age;                                       
		    this.name = name;
		    
		   
		}  
		 @Override  
		 public int hashCode(){
		    	return this.age;
		    }
		 
		   @Override  
		    public boolean equals(Object obj) {  
		        if (this == obj)  
		            return true;  
		        if (obj == null)  
		            return false;  
		        if (getClass() != obj.getClass())  
		            return false;  
		          
		        Dog other = (Dog) obj;  
		        //if (age != other.age)  
		        //  return false;  
		        if (name == null) {  
		            if (other.name != null)  
		                return false;  
		        } else if (!name.equals(other.name))  
		            return false;  
		        return true;  
		    }  

		@Override                                                 
		public String toString() {                                
		    return "Dog {age=" + age + ", name=" + name + "}";    
		}                                                         
		}                                                         
		public static void main(String[] args) {                  
			List<Dog> list= new ArrayList<>();  
			list.add(new ShaoDemo().new Dog(5, "DogA")); 
			list.add(new ShaoDemo().new Dog(7, "DogC"));             
			list.add(new ShaoDemo().new Dog(6, "DogB"));              
			
			list.add(new ShaoDemo().new Dog(8, "DogC"));
			list.add(new ShaoDemo().new Dog(5, "DogA")); 
			
//			List<Dog> list2 = new ArrayList<>();
//			list2.add(new ShaoDemo().new Dog(5,  "DogA"));
//			list2.add(new ShaoDemo().new Dog(8,  "DogH"));
//			list2.add(new ShaoDemo().new Dog(8,  "Dog8"));
			
			
			
//			Collections.sort(list2, new Comparator<Dog>() {            
//			                                                          
//			    @Override                                             
//			    public int compare(Dog o1, Dog o2) {                  
//			    return o2.age - o1.age;                               
//			    }                                                     
//			});                                                       
//			System.out.println("给按照年龄�?�序�?"+list2);          
//			Collections.sort(list, new Comparator<Dog>() {            
//			                                                          
//			    @Override                                             
//			    public int compare(Dog o1, Dog o2) {                  
//			    return o1.name.compareTo(o2.name);                    
//			    }                                                     
//			});                                                       
//			System.out.println("给顺序排序："+list); 
		
			 System.out.println("原始"+list); 
			
			List< Dog > list3 = new LinkedList<Dog>();
			Set<Dog> set1 = new HashSet<Dog>();
			for (Dog dog : list){
				if(set1.add(dog)){
					list3.add(dog);
				}
			};
			
			System.out.println("去重"+list3);
			
			Collections.sort(list3,new Comparator<Dog>() {
				public int compare(Dog o6, Dog o7) {
					//return o6.age - o7.age;
					return o6.name.compareTo(o7.name);
					
				}

				
			});
		
		        
			System.out.println("排序�?"+list3);  
//			★compareTo()小结
//
//			�?�?由上面的程序我们可以看出，无论是实现了Comparable接口的方法还是实现了Comparator接口的方法，�?终比较的返回值都是�?�过compareTo方法实现的，故就把compareTo方法单独拿出来做个小结�??
//
//			�?�?compareTo()的返回�?�是整型，它是先比较对应字符的大�?(ASCII码顺�?)，如果第�?个字符和参数的第�?个字符不等，结束比较，返回他们之间的差�?�，如果第一个字符和参数的第�?个字符相等，则以第二个字符和参数的第二个字符做比较，以此类推，直至比较的字符或被比较的字符有�?方全比较完，这时就比较字符的长度。例如：
			String  s1 = "abc";                                                                           
			String s2 = "abcd";                                                                           
			String s3 = "abcdfg";                                                                         
			String s4 = "1bcdfg";                                                                         
			String s5 = "cdfg";   
			System.out.println("{{{"+s5.indexOf("d"));
			System.out.println( s1.compareTo(s2) ); // -1 (前面相等,s1长度�?1)                            
			System.out.println( s1.compareTo(s3) ); // -3 (前面相等,s1长度�?3)                            
			System.out.println( s1.compareTo(s4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,�?以返�?48)
			System.out.println( s1.compareTo(s5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,�?以返�?-2)  
            System.out.println(s3.compareTo(s2));
	
		}                                                         

		
		
		
		
}
