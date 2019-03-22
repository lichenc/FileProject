package com.imooc.test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferDemo {
	public static void main(String[] args) {
		// 缓冲区,使用缓存区字节流可以提高文件复制的时间
		try {
			// 对比使用缓存区和没有缓存区的操作时间
			long startTime = System.currentTimeMillis();
			FileOutputStream fos = new FileOutputStream(
					"C:\\imooc\\file\\one.txt");

			for (int i = 0; i < 100000; i++) {
				fos.write(50);
			}

			long endTime = System.currentTimeMillis();
			System.out.println("one.txt不使用缓冲流来写");
			long fisrtTime = 0;
			System.out.println("用时为：" + (fisrtTime = endTime - startTime));

			startTime = System.currentTimeMillis();
			FileOutputStream fos1 = new FileOutputStream(
					"C:\\imooc\\file\\two.txt");

			BufferedOutputStream bos = new BufferedOutputStream(fos1);
			for (int i = 0; i < 100000; i++) {
				bos.write(50);
			}
			endTime = System.currentTimeMillis();
			System.out.println("two.txt使用缓冲流来写");
			long secondTime = 0;
			System.out.println("用时为：" + (secondTime = endTime - startTime));

			System.out.println("节省时间：" + (fisrtTime - secondTime) + "ms");
			bos.flush();
			// fis.close();
			fos.close();
			// bis.close();
			fos1.close();
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * one.txt不使用缓冲流来写 用时为：1639 two.txt使用缓冲流来写 用时为：117 节省时间：1522ms
		 */

	}
}
