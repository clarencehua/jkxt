package software.lawyer.service.impl;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

import software.lawyer.service.Signature;
import software.lawyer.util.StringUtil;

public class RSASignature implements Signature {
	public static final Provider pro = new BouncyCastleProvider();
	private static final String charSet = "UTF-8";

//	private static String publicKeyStr = null;
//	private static String privateKeyStr = null;
	private static PrivateKey privateKey = null;
	private static PublicKey publicKey = null;

	// ����,�ı��,���ɵ���Կ�Իᷢ���仯
//	private static final String seedKey = "test";

	public static void generateKeyPair(String seedKey) throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA", pro);
		kpg.initialize(1024, new SecureRandom(seedKey.getBytes()));
		KeyPair kp = kpg.generateKeyPair();

		privateKey = kp.getPrivate();
//		privateKeyStr = new String(Base64.encode(privateKey.getEncoded()));
		publicKey = kp.getPublic();
//		publicKeyStr = new String(Base64.encode(publicKey.getEncoded()));

//		System.out.println("PrivateKey:" + privateKey);
//		System.out.println("PublicKey:" + publicKey);
//
//		System.out.println(privateKeyStr);
//		System.out.println(publicKeyStr);
	}

	public static PublicKey getPublicRSAKey(String key) throws Exception {
		X509EncodedKeySpec x509 = new X509EncodedKeySpec(Base64.decode(key));
		KeyFactory kf = KeyFactory.getInstance("RSA", pro);
		return kf.generatePublic(x509);
	}

	public static PrivateKey getPrivateRSAKey(String key) throws Exception {
		PKCS8EncodedKeySpec pkgs8 = new PKCS8EncodedKeySpec(Base64.decode(key));
		KeyFactory kf = KeyFactory.getInstance("RSA", pro);
		return kf.generatePrivate(pkgs8);
	}

	public static byte[] encrypt(String input) throws Exception {
//		long start = System.currentTimeMillis();
		Cipher cipher = Cipher.getInstance("RSA", pro);
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] re = cipher.doFinal(input.getBytes(charSet));
//		long end = System.currentTimeMillis();
		// System.out.println("encrypt use time "+(end-start)+"");
		return re;
	}

	public static byte[] decrypt(byte[] encrypted) throws Exception {
//		long start = System.currentTimeMillis();
		Cipher cipher = Cipher.getInstance("RSA", pro);
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] re = cipher.doFinal(encrypted);
//		long end = System.currentTimeMillis();
		// System.out.println("decrypt use time "+(end-start)+"");
		return re;
	}

	public static String decodeJsValue(String jsValue) throws Exception {
		byte[] input = Hex.decode(jsValue);
		byte[] raw = decrypt(input);

		// ��־λΪ0֮������������Ч�ֽ�
		int i = raw.length - 1;
		while (i > 0 && raw[i] != 0) {
			i--;
		}
		i++;
		byte[] data = new byte[raw.length - i];
		for (int j = i; j < raw.length; j++) {
			data[j - i] = raw[j];
		}

		return new String(data, charSet);
	}

	public static void main(String[] args) throws Exception {
		generateKeyPair("3593489");
		System.out.println(publicKey);
		//(2013)�����һ���ֵ�0035��\����\֪ͨ�ࣨ��ͥ������Ӧ�ߡ���֤����֪���������ͥ��Ա��֤�˳�ͥ���ָ�����ȸ���֪ͨ�顢��Ʊ�����棩\2014319151949_1000.jpg
//		String input = "����abcABC123";
//		byte[] en = encrypt(input);
//		String en_str=new String(Hex.encode(en));
//		System.out.println(en_str);
//		
//		byte[] re = decrypt(en);
//		System.out.println(new String(re, charSet));
		String re="7f771b36c6ceaf08c71aaa86efa3439708a4c63d42e8e1f40cd91f9fa6f6d5df49cc29dfe7a553947910bff8e77f643343f64dec9f8b0fc60466dd3b7b0ebebcaa682da9281c643df6b5beab49ea578cc6809d8db96e5c5422a3581705a99e74180749939d2c1ad2f758c831f5ff0b40a419c779794928f5ed715f0a61091312";
		System.out.println(RSASignature.decodeJsValue(re));
	}

	public String sign(String content, String privateKey_txt, String charSet)
			throws SignatureException {
		if (StringUtil.isBlank(privateKey_txt)) {
            throw new SignatureException("privateKey is null!");
        }
		try {
			generateKeyPair(privateKey_txt);
			byte[] en=encrypt(content);
			return new String(Hex.encode(en));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public boolean check(String content, String signature, String publicKey_txt,
			String charset) throws SignatureException {
		if (StringUtil.isBlank(publicKey_txt)) {
            throw new SignatureException("publicKey is null!");
        }
		try {
			generateKeyPair(publicKey_txt);
			String de=decodeJsValue(signature);
			boolean result=false;
			//���ڰ��������ȫ�ǡ����ԭ�򣬶���ah��Ҫ��������������з���
			result=compareAh(content, de);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean compareAh(String src,String des){
		//srcΪȫ������ţ�Ӣ�����ţ�
		//")"��index
		String[] ahArr=src.split("\\)");
		String nf=ahArr[0].substring(1);
		String ah1="("+nf+"��"+ahArr[1];
		String ah2="��"+nf+")"+ahArr[1];
		String ah3="��"+nf+"��"+ahArr[1];
		if(src.equals(des))
			return true;
		if(ah1.equals(des))
			return true;
		if(ah2.equals(des))
			return true;
		if(ah3.equals(des))
			return true;
		return false;
	}
	
}
