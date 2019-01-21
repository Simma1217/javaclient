package cn.simma.util;

import org.apache.log4j.Logger;

/** * @author  Simma  
 *@date  创建时间：2019年1月21日 下午1:35:06
 * @version 1.0 
 * @parameter   
 */
public class log4jTest {
	private static Logger mylogger=Logger.getLogger(log4jTest.class);
	public static void main(String[] args) {
		mylogger.debug("我是debug的信息");
		mylogger.warn("我是warn的信息");
		mylogger.info("我是info的信息");
		mylogger.error("我是error的信息");
	}

}

