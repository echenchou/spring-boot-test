package ec.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;


public class AuthUtils {
	private static String MD5Salt = "balundata";
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println(MD5("111111"));
//	}
	
	public static String MD5(String str) {
		return DigestUtils.md5Hex(str+MD5Salt);
	}
	
	public static boolean passwordEquals(String source,String target){
		if(StringUtils.isNotBlank(target)){
			return target.equals(MD5(source));
		}
		return false;
	}
}
