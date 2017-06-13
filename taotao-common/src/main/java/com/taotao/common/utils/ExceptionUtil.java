package com.taotao.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	/**
	 * 获取异常的堆栈信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getStackTrace(Throwable t) {//异常
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
   /*
    * 获取异常的堆栈信息，将它打印到pw里面，输出到一个控制台，再把控制台消息变成字符串。
    */
		try {
			t.printStackTrace(pw);//将它打印到pw里面
			return sw.toString();//输出到一个控制台，再把控制台消息变成字符串。
		} finally {
			pw.close();
		}
	}
}
