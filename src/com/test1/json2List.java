package com.test1;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;


public class json2List {
	//	static String str ="[{\"prptyId\": \"10905\",\"prptyName\": \"LOGINNAME\",\"prptyNewValue\": \"z6084010\",\"prptyOldValue\": \"z6084010\"},{\"prptyId\": \"10971\",\"prptyName\": \"AREAID\",\"prptyNewValue\": \"355\",\"prptyOldValue\": \"355\"},{\"prptyId\": \"116075\",\"prptyName\": \"TEMPLATENAME\",\"prptyNewValue\": \"20M\",\"prptyOldValue\": \"20M\"},{\"prptyId\": \"116076\",\"prptyName\": \"SEND_FLAG\",\"prptyNewValue\": \"Y\",\"prptyOldValue\": \"Y\"},{\"prptyId\": \"952300\",\"prptyName\": \"REQTIME\",\"prptyNewValue\": \"20180601142914\",\"prptyOldValue\": \"20180601142914\"},{\"prptyId\": \"952301\",\"prptyName\": \"SEQUENCE\",\"prptyNewValue\": \"201806011000010932\",\"prptyOldValue\": \"201806011000010932\"},{\"prptyId\": \"952302\",\"prptyName\": \"TEMPLATE_ID\",\"prptyNewValue\": \"10\",\"prptyOldValue\": \"10\"},{\"prptyId\": \"952303\",\"prptyName\": \"CZ_FLAG\",\"prptyNewValue\": \"\",\"prptyOldValue\": \"N\"}  ]";
	
	static String str ="{\"ROOT\":{\"HEADER\":{\"DB_ID\":\"B1\",\"ROUTING\":{\"ROUTE_KEY\":\"15\",\"ROUTE_VALUE\":\"16\"},\"TRACE_ID\":\"11120945401795555fhhh0M304201\",\"KEEP_LIVE\":\"10.208.201.57\",\"CHANNEL_ID\":\"11\",\"PARENT_CALL_ID\":\"1494553541027369308237\",\"PROVINCE_GROUP\":\"SX\",\"ENDUSRIP\":\"10.208.201.57\"},\"BODY\":{\"OP_CODE\":\"5555\",\"SO_ORDER_TYPE\":\"NC\",\"DEAL_LEVEL\":\"3\",\"CUST_ID_TYPE\":\"2\",\"LOGIN_NO\":\"fhhh0M\",\"CREATE_TIME\":\"20170823150417\",\"SERVICE_NO\":\"13934833389\",\"SUB_ORDER_ID\":\"S17052300000003\",\"CONTACT_ID\":\"1117051250000000416271813\",\"ORDER_ID\":\"O17052300000003\",\"CHANNEL_TYPE\":\"11\",\"CREATE_ACCEPT\":\"504318386636\",\"CUST_ID\":\"16005412778151\",\"ORDER_LINE_ID\":\"L1617080900020\",\"ID_NO\":\"63100253174\",\"SEND_TYPE\":\"Y\",\"CHANGE_TYPE\":\"\",\"MAIN_SVC_ID\":\"B01001\",\"IS_LONG_FLOW\":\"N\",\"ORDER_LINE_SEQ\":1,\"REGION_ID\":\"16\",\"PROVINCE_GROUP\":\"10011\",\"DEAL_LEVEL\":1,\"IS_PARELLEL\":\"N\",\"ACTION_ID\":1104,\"CREATE_ACCEPT\":\"504318386636\",\"AUTHEN_INFO\":{\"APP_NAME\":\"NGBOSS\",\"GROUP_ID\":\"14125\",\"CLASS_CODE\":\"11\",\"CLASS_NAME\":\"\",\"LOGIN_PWD\":\"fb0bdec823cf4cdb\",\"ROUND_AUDIT\":\"Y\",\"PROVINCE_GROUP\":\"10011\",\"LOGIN_NAME\":\"詹建香\",\"SER_NAME\":\"\",\"DEST_PORT\":\"11002\",\"APP_ID\":\"2000\",\"REGION_ID\":\"16\",\"REGION_NAME\":\"\",\"GROUP_NAME\":\"朔州市平朔朝阳路营业厅\",\"SESSION_ID\":\"\",\"SRC_PORT\":\"58582\",\"LOGIN_NO\":\"fhhh0M\",\"FROM_SYS\":\"BOSS\",\"DEST_IP\":\"10.204.96.34\",\"IP_ADDRESS\":\"10.208.201.57\"},\"SVCINFO\":[{\"SVC_ID\":\"B61772\",\"SVC_ACT\":\"1\"},{\"SVC_ID\":\"B01161\",\"SVC_ACT\":\"1\"}],\"REQUEST_INFO\":{\"OPR_INFO\":{\"OLD_SERVICE_NO\":\"1234567\",\"SEND_FLAT\":\"N\"}},\"BUSI_INFO\":{\"CHCK_FLAG\":\"N\",\"ID_NO\":\"220171000000007740\",\"CHCK_TYPE\":\"\",\"GROUP_NAME\":\"自建自营长春市一汽营业厅\",\"SERVICE_NO\":\"18663000629\",\"OP_TYPE\":\"2\",\"NEW_PWD\":\"748992\"}}}}" ;
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		if (str != null && !"".equals(str))
		{
			byte[] bq = str.getBytes("GBK");
			System.out.println("bq=="+bq[0]);
		}
        String retCode ="00200";
        if (!"0".equals(retCode)&& !"000000".equals(retCode)) {
            System.out.println("3333=="+"23233333333");


        }

        File file=new File("E:\\file.doc");
        String fileName=file.getName();
        String fileTyle=fileName.substring(fileName.lastIndexOf("."));
        System.out.println(fileTyle);

        String caselsh = fileName.substring(0,fileName.lastIndexOf("."));
        System.out.println(caselsh);
        System.out.println(caselsh+"_"+"A"+fileTyle);
//        List<Map<String, Object>> prptysList = new ArrayList<Map<String, Object>>();
//        List<Map<String, Object>> newPrptysList = new ArrayList<Map<String, Object>>();
//        MBean mBean = new MBean(str);
//        System.out.println("mBean222=="+mBean.toString());
		// TODO Auto-generated method stub
//        if(!str.isEmpty() && !str.equals("")){
//		 System.out.println("str:===="+str);
//	        JSONArray jsonArray = JSONArray.fromObject(str);
//	        
//	        System.out.println("jsonArray:===="+jsonArray);
//	        StringBuffer stringBuffer = new StringBuffer();
//	        StringBuffer stringBuffer2 = new StringBuffer();
//	        String Prpty ="";
//	        prptysList = (java.util.List<Map<String, Object>>) JSONArray.toCollection(jsonArray, Map.class);
//	        System.out.println("prptysList:===="+prptysList);
//
//	        Map<String,Object> inParamMap = new HashMap<String, Object>();
//	        
//	        for (Map<String, Object> prptyMap : prptysList){
//	        	inParamMap.put((String) prptyMap.get("prptyName"), prptyMap.get("prptyNewValue"));
//	        	
//	        	stringBuffer.append((String) prptyMap.get("prptyName")+"="+prptyMap.get("prptyNewValue")+"|");
//	        	
//	        }
//	        if(stringBuffer.length()>1){
//	        Prpty = stringBuffer.substring(0,stringBuffer.length()-1);
//	        }
//	        stringBuffer2.append(inParamMap.toString());
//	         newPrptysList.add(inParamMap);
//	        System.out.println("stringBuffer:===="+stringBuffer);
//	        System.out.println("Prpty:===="+Prpty);
//	        System.out.println("stringBuffer2:===="+stringBuffer2);
//        }
        String qq = "32Y544Y999Y";
        System.out.println("BEGIN_TIME:==RR"+"==" +  qq.lastIndexOf("Y") );

        System.out.println("BEGIN_TIME:===="+"》" +  qq.lastIndexOf("Y") );

        System.out.println("BEGIN_TIME:===="+"==" + qq.substring(0,qq.lastIndexOf("Y")));
        //当前操作时间
        Date currDate = new Date();
        Calendar currCal = Calendar.getInstance();
        currCal.setTime(currDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(currDate);
        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdfYMD.format(currDate);

        Map<String,Object> qryPreDryRdHisInMap = new HashMap<String,Object>();
//        qryPreDryRdHisInMap.put("ID_NO", idNo)
//        qryPreDryRdHisInMap.put("OP_CODE","1052")
//        qryPreDryRdHisInMap.put("UPDATE_TYPE","D")
//        qryPreDryRdHisInMap.put("BEGIN_TIME",year + "0101")
//        qryPreDryRdHisInMap.put("END_TIME", ymd)
         System.out.println("BEGIN_TIME:===="+year + "0101");
        System.out.println("year:===="+ymd);


    }

}
