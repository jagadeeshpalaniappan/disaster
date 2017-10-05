package com.sundar.disastermanagement.service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import com.sundar.disastermanagement.vo.IncidentInchargeVO;
import com.sundar.disastermanagement.vo.IncidentVO;


public class MessageService{

        public void sendMsg(List<IncidentInchargeVO> list,IncidentVO incidentVO)
    	{
            //Your authentication key
            String authkey = "176781A3t1x0lS59d12dc4";
            //Multiple mobiles numbers separated by comma
            String mobiles = "";
            int i=1;
            for(IncidentInchargeVO inchargeVO:list)
            {
            mobiles=mobiles+inchargeVO.getMobile();
            if(list.size()!=i)
            	mobiles=mobiles+",";
            i++;
            }
            System.out.println(mobiles);
            //Sender ID,While using route4 sender id should be 6 characters long.
            String senderId = "FloodC";
            //Your message to send, Add URL encoding here.
            String message = "Reported by "+incidentVO.getName()+"\t"+incidentVO.getMobile()+
        			"\n"+incidentVO.getDescription();
            //define route
            String route="4";

            //Prepare Url
            URLConnection myURLConnection=null;
            URL myURL=null;
            BufferedReader reader=null;

            //encoding message
            @SuppressWarnings("deprecation")
			String encoded_message=URLEncoder.encode(message);

            //Send SMS API
            String mainUrl="https://control.msg91.com/api/sendhttp.php?";

            //Prepare parameter string
            StringBuilder sbPostData= new StringBuilder(mainUrl);
            sbPostData.append("authkey="+authkey);
            sbPostData.append("&mobiles="+mobiles);
            sbPostData.append("&message="+encoded_message);
            sbPostData.append("&route="+route);
            sbPostData.append("&sender="+senderId);

            //final string
            mainUrl = sbPostData.toString();
            try
            {
                //prepare connection
                myURL = new URL(mainUrl);
                myURLConnection = myURL.openConnection();
                myURLConnection.connect();
                reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
                //reading response
                String response;
                while ((response = reader.readLine()) != null)
                //print response
                System.out.println(response+"\n email sent successfully");

                //finally close connection
                reader.close();
            }
            catch (IOException e)
            {
                    e.printStackTrace();
            }
        }
}