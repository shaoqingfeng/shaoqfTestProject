package com.test1;

import java.util.HashMap;
import java.util.Map;


public class substringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sql ="select nvl((select attr_value from pd_usersvcattr_info where id_No='$(100)$' and svc_id='${114}$' and svc_id='$[114]$' and attr_id='BB0000120$$$'),'34343434002$$$$$$$$$$$0000$$$$$$$$$$$$$$$$$$2$$$$$$$$$$$$$$$$$$$') from dual";
		Map<String,String> para = new HashMap<String,String>();
		para.put("parakey", "eerer");
		para.put("parakey", "eerer");
		sqlReplace(sql,para);
	}
	
	//34343434002$$$$$$$$$$$$$$$$$$$$$0000$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$2$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//34343434002$$$$$$$$$$$0000$$$$$$$$$$$$$$$$$$2$$$$$$$$$$$$$$$$$$$
	public static String sqlReplace(String sql, Map<String,String> paramValue)
    {
		 
//		String revers[] = {"$(","${","$[",")$","}$","]$"}; 
//		//String src = "";
//		 for (int i = 0; i < revers.length; i++) { 
//			 String zf = revers[i];
//			 if(sql.indexOf(zf)!=-1 && zf.equals("${")){
//				 sql = sql.replace(zf, "^{"); 
//			 	}else if(sql.indexOf(zf)!=-1 && zf.equals("$(")){
//			 		sql = sql.replace(zf, "^("); 	
//			 	}else if(sql.indexOf(zf)!=-1 && zf.equals("$[")){
//			 		sql = sql.replace(zf, "^["); 	
//			 	}else if(sql.indexOf(zf)!=-1 && zf.equals(")$")){
//			 		sql = sql.replace(zf, ")^"); 	
//			 	}else if(sql.indexOf(zf)!=-1 && zf.equals("}$")){
//			 		sql = sql.replace(zf, "}^"); 	
//			 	}else if(sql.indexOf(zf)!=-1 && zf.equals("]$")){
//			 		sql = sql.replace(zf, "]^"); 	
//			 	}			 
//			} 
		
	
		System.out.println("sql=="+sql);
        String[] q = sql.split("[$]");
//		String[] q = sql.split("\\^");
        StringBuffer sb = new StringBuffer();
       
        int i = 0;
        boolean is_$=false;
        for (String s : q)
        {

        	System.out.println("s1="+s);
            if (!"".equals(s) && (s.substring(0, 1).equals("(") || s.substring(0, 1).equals("[") || s.substring(0, 1).equals("{")))
           // if (!"".equals(s) && ("(".equals(s.substring(0, 1)) || "[".equals(s.substring(0, 1)) || "{".equals(s.substring(0, 1))))
            {
                if(s.indexOf(",")!=-1){
                    s=substring(s,paramValue.get(s));  
                    System.out.println("ssssss=="+s);
                    
                }else{
                    s = "?";                  
                }
                is_$ = true;
            }else{
            		System.out.println("is_$=="+is_$);
                if(!is_$ && i!=0){
                   	s="$"+s;
                    System.out.println("sss="+s);
                }
                is_$=false;
                //山西优化：'$(100)$',还需去掉单引号
                
                if(s.startsWith("'") ){
                    s=s.substring(1,s.length());
                }
                if(s.endsWith("'") && i!=q.length-1){
                    s=s.substring(0,s.length()-1);
                }
                

            }
            
            /*
             * if(s.substring(0,1).equals("{")){ s=tableName.get(i); i++; }
             */
            sb.append(s);
            
            i++;
           
        }

        System.out.println("sb=="+sb.toString());
        return sb.toString();
        
    }
	
	private static String substring(String s,String sv) {
        /*
         C版重写的字符串截取支持以下逻辑
        string str("abcdefghij");
        substring(str,1,0);    //str = "abcdefghij"  不行
        substring(str,2,3);    //str = "bcd" 满足
        substring(str,-2,0);   //str = "abcdefghi"  不行
        substring(str,-1,3);   //str = "hij" 满足
        substring(str,2,-2);   //str = "bcdefghi" 会报错
        substring(str,-1,-2);  //str = "cdefghij"   会报错
         */
        String [] strSub=s.replace("(","").replace(")","").split(",");
        String returnStr="";
        int beginPos=Integer.parseInt(strSub[1].trim());
        int subLength=Integer.parseInt(strSub[2].trim());
        if (beginPos>0)
        {
            returnStr=sv.substring(beginPos-1,beginPos+subLength-1);
        }
        else{
            returnStr=sv.substring(sv.length()-Math.abs(beginPos)-subLength+1,sv.length()-Math.abs(beginPos)+1);
        }
        return returnStr;
    }
}
