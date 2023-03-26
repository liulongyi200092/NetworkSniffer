package util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressUtil {
	/**
	 * ��Mac��ַ��������ʽת��Ϊ�ַ�����ʽ
	 * ����:Ethernet->source()/destination()
	 */
	public static String macBytesToString(byte[] macBytes) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < macBytes.length; i++) {
			String hexString = Integer.toHexString(0xFF & macBytes[i]);
			if(hexString.length()<2) {
				hexString = "0"+hexString;
			}
			builder.append(':').append(hexString);
		}
		return builder.substring(1);
	}
	
	/**
	 * ��Ip��ַ��������ʽת��Ϊ�ַ�����ʽ
	 * ����:Ip->source()/destination()
	 */
	public static String ipBytesToString(byte[] ipBytes) {
		InetAddress sourceAddress = null;
		try {
			sourceAddress = InetAddress.getByAddress(ipBytes);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  sourceAddress.getHostAddress();
	}

}
