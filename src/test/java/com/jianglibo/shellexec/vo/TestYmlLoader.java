package com.jianglibo.shellexec.vo;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jianglibo.shellexec.factory.AppModule;

public class TestYmlLoader {

	@Test
	public void d() {
		Injector injector = Guice.createInjector(new AppModule());
	}
}
