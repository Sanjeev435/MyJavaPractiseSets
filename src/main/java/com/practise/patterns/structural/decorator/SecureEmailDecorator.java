package com.practise.patterns.structural.decorator;

import java.util.Base64;

//concrete decorator
public class SecureEmailDecorator extends EmailDecorator {
	private String content;
	private String encryptedData;

	public SecureEmailDecorator(IEmail basicEmail) {
		super(basicEmail);
	}

	@Override
	public String getContents() {
		// secure original
		this.encryptedData = encrypt(originalEmail.getContents());
		return this.encryptedData;
	}
	
	public String decryptContents() {
		this.content = decrypt(this.encryptedData);
		return this.content;
	}
	
	// encrypt the string
    private String encrypt(String data) {
        byte[] result = data.getBytes();
        for (int i = 0; i < result.length; i++) {
            result[i] += (byte) 1;
        }
        return Base64.getEncoder().encodeToString(result);
    }

    private String decrypt(String data) {
        byte[] result = Base64.getDecoder().decode(data);
        for (int i = 0; i < result.length; i++) {
            result[i] -= (byte) 1;
        }
        return new String(result);
    }
}
