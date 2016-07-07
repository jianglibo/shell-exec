package com.jianglibo.shellexec;

import java.io.IOException;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jianglibo.shellexec.factory.AppModule;

public class GuiceMain {

	public static void main(String[] args) throws IOException {
		Injector injector = Guice.createInjector(new AppModule());
		
//		injector.getInstance(SolrCliApp.class).run();
	}
}
