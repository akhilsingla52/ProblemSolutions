package com.enviroment;

public class GetEnvExample {
	public static void main(String[] args)  {
		//not case sensitive
        String homePath = System.getenv("java_home");
        System.out.println(homePath);
	}
}
