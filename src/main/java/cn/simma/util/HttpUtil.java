package cn.simma.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.alibaba.fastjson.JSONObject;

/** * @author  Simma  
 *@date  创建时间：2019年1月11日 下午2:38:21
 * @version 1.0 
 * @parameter   
 */
public class HttpUtil {
	public static void main(String[] args) {
		CloseableHttpClient httpclient=HttpClients.createDefault();
		String url="https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=18903009820";
		HttpGet httpGet=new HttpGet(url);
		JSONObject jsonObject=null;
		try {
			CloseableHttpResponse cHttpResponse=httpclient.execute(httpGet);
			System.out.println(cHttpResponse.getStatusLine());
			HttpEntity entity=cHttpResponse.getEntity();
			StringBuilder repstr=new StringBuilder();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(entity.getContent(), "GBK"),8*1024);
			String line=null;
			while((line=bufferedReader.readLine())!=null){
				repstr.append(line);
			}
			String str=repstr.toString();
			int index=str.indexOf('{');
			String jsonStr=str.substring(index);
			jsonObject=JSONObject.parseObject(jsonStr);
			
			System.out.println(jsonObject.getString("telString"));
			System.out.println(jsonObject.getString("province"));

			System.out.println(jsonStr);
			cHttpResponse.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

