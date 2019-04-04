package com.myapp.generics;

public class MinMaxArrayImpl<T extends Comparable<T>> implements MinMaxArray<T> {

	
	private T vals[];
	
	public MinMaxArrayImpl(T ... vals) {
		this.vals = vals;
	}

	@Override
	public T min() {
		T v = vals[0];
		for (T val : vals) {
			if (val.compareTo(v) < 0) {
				v = val;
			}
		}
		return v;
	}

	@Override
	public T max() {
		T v = vals[0];
		for (T val : vals) {
			if (val.compareTo(v) > 0) {
				v = val;
			}
		}
		return v;
	}

	
	
//	public static void main(String[] args) {
//		//Integer integerArray[]= {2,3,4,5,56,7};
//		MinMaxArray<Integer> intArray=new MinMaxArrayImpl<>(2,3,4,5,56,7);
//	}
}
