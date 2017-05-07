package cn.xuemengzihe.sylu.ces.test.util;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;

import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;

/**
 * <h1>RSA加密与解密</h1>
 * <p>
 * </p>
 * 
 * @author 李春
 * @time 2017年5月6日 下午4:18:21
 */
public class RSAEnDeCode {

	/**
	 * RSA加密
	 */
	@Test
	public void rasEncode() {
		System.out.println(new String(Base64
				.encodeBase64(((RSAPublicKey) keyPairGen.generateKeyPair()
						.getPublic()).getEncoded())).length());
	}

	/**
	 * RSA解密
	 */
	@Test
	public void rsaDecode() {
	}

	public KeyPairGenerator keyPairGen;

	@Before
	public void keyPairGen() {
		try {
			this.keyPairGen = KeyPairGenerator.getInstance("RSA");
			this.keyPairGen.initialize(1024);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
