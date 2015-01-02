package com.wondersgroup.cloud.cluster.bootstrap;

public class SingleNodeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SeedApp.main(new String[]{"localhost", "2551"});
//		SeedApp.main(new String[]{"localhost", "2552"});
//		SeedApp.main(new String[]{"localhost", "2553"});
		
		MasterApp.main(new String[]{"localhost", "2570"});
	}

}
