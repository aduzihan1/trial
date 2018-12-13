package com.dzh.trial.trial.utils;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.alibaba.fastjson.JSONObject;

public class AES256EncryptionUtil {
    public static final String TAG = AES256EncryptionUtil.class.getSimpleName();
    public static final String ALGORITHM = "AES/ECB/PKCS7Padding";
    private static String mPassword = "rW@vM2UlXKGe2V%!7@%x5mjclBGT0HGc";
    //
    public static void main(String[] args) throws  Exception{

        JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONObject json2 = new JSONObject();
//		json1.put("1", 2);
//		json2.put("2018112882112434527", "http://pic1.nipic.com/2008-08-28/200882812418965_2.jpg");
		 json.put("product_ids", "uoq8ohnaeahxn9X8/hYbv+GXj1VZ+19TBsZBK7575Jg=");
		 //json.put("pagesize", 100);

		/*
		 * json.put("province", 1); json.put("city", 3586); json.put("district",
		 * 36); json.put("consignee", "测试"); json.put("mobile", "13112341234");
		 * json.put("address", "测试地址"); json.put("prescription_image[1]",
		 * "http://xxx.xxx/1.png"); json.put("products[1]", 1);
		 */

		// json.put("province", 440000);
		// json.put("city", 441900);
		// json.put("district", 0);
		/*json.put("province", 150000);
		json.put("city", 150100);
		json.put("district", 150102);
		json.put("consignee", "测试");
		json.put("mobile", "13112341234");
		json.put("address", "测试地址");
		json.put("prescription_image", json2);
		json.put("products", json1);*/

		// json.put("product_ids", "1");
		// json.put("pagesize", 20);

        String data = json.toJSONString();
		// 加密后的数值
		String str641 = Base64Util.encode(Aes256Encode(data, "".getBytes()));
		System.out.println("数据641:" + str641);

		String str6411 = Aes256Decode(Base64Util.decode("uoq8ohnaeahxn9X8/hYbv+GXj1VZ+19TBsZBK7575Jg="), "".getBytes());
		System.out.println("解密641:" + str6411);
		String strOut = "/3TSwcB2AatuyG8DspKlKS61BLmOwoxPEGmuvAkw/E4krWjLecT4qDGQaQUsUjhY";
		String strasdf = "/3TSwcB2AatuyG8DspKlKYaEvpJthWRqCwksJ8+jA0okrWjLecT4qDGQaQUsUjhY";
		String straaaa = "uoq8ohnaeahxn9X8/hYbv+GXj1VZ+19TBsZBK7575Jg=";
		System.out.println("解密641:" + str6411);
		String str64111 = Aes256Decode(Base64Util.decode(straaaa), "".getBytes());
		System.out.println("解密641:" + str64111);
    }

	public static boolean initialized = false;

	/**
	 * @param String
	 *            str 要被加密的字符串
	 * @param byte[]
	 *            key 加/解密要用的长度为32的字节数组（256位）密钥
	 * @return byte[] 加密后的字节数组
	 */
	public static byte[] Aes256Encode(String str, byte[] key) {
		initialize();
		byte[] result = null;
		try {
			key = mPassword.getBytes();
			Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); // 生成加密解密需要的Key
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			result = cipher.doFinal(str.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @param byte[]
	 *            bytes 要被解密的字节数组
	 * @param byte[]
	 *            key 加/解密要用的长度为32的字节数组（256位）密钥
	 * @return String 解密后的字符串
	 */
	public static String Aes256Decode(byte[] bytes, byte[] key) {
		initialize();
		String result = null;
		try {
			key = mPassword.getBytes();
			Cipher cipher = Cipher.getInstance(ALGORITHM, "BC");
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES"); // 生成加密解密需要的Key
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			byte[] decoded = cipher.doFinal(bytes);
			result = new String(decoded, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void initialize() {
		if (initialized)
			return;
		Security.addProvider(new BouncyCastleProvider());
		initialized = true;
	}
}