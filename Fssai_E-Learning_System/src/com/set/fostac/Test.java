package com.set.fostac;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "170,1833,120,";
		int index = 0;
		if(str != null)
			{
				index =str.lastIndexOf(","); 
				System.out.println(index +"-"+ str.substring(0, index));	
			}
		
	}

}
