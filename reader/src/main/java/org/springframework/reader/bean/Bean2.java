package org.springframework.reader.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Marco
 * @version 1.0
 * @date 2020/12/8 下午10:02
 */
//@Component
public class Bean2 {
//	@Autowired
//	private Bean2 bean2;

	private String word = "200";

	public void say() {
		System.out.println(word);
		System.out.println("bean2 say fuck");
//		System.out.println(bean2.add(1,2));
	}

	public int add(int x, int y) {
		return x + y;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
