package com.pb.interfaceImpl;

import org.springframework.stereotype.Component;

import com.pb.interfacePackage.calculate;
@Component
public class calculateImpl implements calculate {

	@Override
	public int jia(int i, int j) {
		System.out.println("this jia method begin ");
		int result = i+j;
		System.out.println("this jia method end");
		return result;
	}

	@Override
	public int jian(int i, int j) {
		System.out.println("this jian method begin");
		int result = i-j;
		System.out.println("this jian method end");
		return result;
	}

	@Override
	public int cheng(int i, int j) {
		System.out.println("this cheng method begin");
		int result = i*j;
		System.out.println("this cheng method end");
		return result;
	}

	@Override
	public int chu(int i, int j) {
		System.out.println("this chu method begin");
		int result = i/j;
		System.out.println("this chu method end");
		return result;
	}

}
