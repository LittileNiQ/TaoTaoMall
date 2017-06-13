package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	public static void main(String[] args) throws Exception {
		// 创建一个FtpClient对象
		FTPClient ftpClient = new FTPClient();
		// 创建ftp连接
		ftpClient.connect("192.168.23.129", 21);// 端口默认不写是21
		// 登陆FTP服务器，使用用户名和密码来登陆
		ftpClient.login("ftpuser", "ftpuser");
		// 上传文件
		// 读取本地文件
		FileInputStream inputStream = new FileInputStream(new File("D:\\Documents\\Pictures\\pics\\21.jpg"));
		// 设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
	    //修改文件的格式

		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		// 第一个参数：服务器端文档名
		// 第二个参数：上传文件的io流 inputstream
		ftpClient.storeFile("123.jpg", inputStream);

		// 关闭连接
		inputStream.close();

		ftpClient.logout();
	}
	@Test
   public void testFtpUtil() throws Exception{
		FileInputStream inputStream = new FileInputStream(new File("D:\\Documents\\Pictures\\pics\\21.jpg"));
		FtpUtil.uploadFile("192.168.23.129", 21, "ftpuser","ftpuser", "/home/ftpuser/www/images", "/2017/05/13", "hello1.jpg", inputStream);
   }
}
