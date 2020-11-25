package com.practise.patterns.structural.decorator;

import org.junit.Assert;
import org.junit.Test;

public class DecoratorTest {
	
	@Test
	public void shouldGetPlainEmail() {
		IEmail plainEmail = new Email("I am a plain email.");
		Assert.assertEquals(plainEmail.getContents(), "I am a plain email.");
	}
	
	@Test
	public void shouldGetEmailWithExtrenalMailMessage() {
		ExternalEmailDecorator externalEmailDecorator = new ExternalEmailDecorator(new Email("I am a plain email."));
		Assert.assertEquals(externalEmailDecorator.getContents(), "I am a plain email." + "\n Company Disclaimer");
	}

	@Test
	public void shouldGetEncruptedEmail() {
		SecureEmailDecorator secureEmailDecorator = new SecureEmailDecorator(new Email("I am a plain email."));
		Assert.assertEquals(secureEmailDecorator.getContents(), "SiFibiFiIXFtYmpvIWZuYmptLw==");
		Assert.assertEquals(secureEmailDecorator.decryptContents(), "I am a plain email.");
	}
}
