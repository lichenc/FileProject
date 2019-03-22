package com.imooc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) {
		// 创建File 对象
		File file = new File("c:\\imooc\\file");
		if (!file.isDirectory()) {
			System.out.println(file.mkdirs());
		}

		// 创建文件
		File file1 = new File("c:\\imooc\\file\\Monday.docx");
		// 判断文件对象是否存在，如果不存在就创建
		if (!file1.exists()) {
			try {
				if (file1.createNewFile()) {
					System.out.println("创建文件成功！");
					System.out.println("文件名称：" + file1.getName());
					System.out.println("文件上一级目录：" + file1.getParent());
				}

				System.out.println("文件/目录：这是一个文件");
				if (file1.canRead() && file1.canWrite())
					System.out.println("读写性：这个文件既可以读还可以写");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// 字节输入流InputStream
		// 文件输入流FileInputStream，从文件系统中的某个文件中获得输入字节
		try {
			FileInputStream fis = new FileInputStream(
					"c:\\imooc\\file\\test.txt");
			int n = 0;
			int count = 0;
			System.out.print("文件内容：");
			while ((n = fis.read()) != -1) {
				System.out.print((char) n);
				count++;
			}
			System.out.println("统计结果：test.txt文件中共有" + count + "个字节");
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// FileOutputStream 文件输出流
		FileOutputStream fos;
		FileInputStream fis;
		try {
			fos = new FileOutputStream("c:\\imooc\\file\\test1.txt");
			fis = new FileInputStream("c:\\imooc\\file\\test1.txt");
			fos.write(50);
			fos.write('a');
			System.out.print(fis.read());
			System.out.print((char) fis.read());
			// 关闭文件输出流
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 文件拷贝
		try {
			FileInputStream fis1 = new FileInputStream(
					"c:\\imooc\\file\\test1.txt");
			FileOutputStream fos1 = new FileOutputStream(
					"c:\\imooc\\file\\testcopy.txt");
			int n = 0;
			byte[] b = new byte[1024];
			// fis1.read(b) 是将 test1.txt文件一个字节一个字节地读到byte数组b中
			// 然后fos1再从b数组中写到testcopy.txt文件中
			while ((n = fis1.read(b)) != -1) {
				fos1.write(b, 0, n);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
