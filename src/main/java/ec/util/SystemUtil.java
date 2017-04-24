/*
 *	Copyright © 2013 Changsha Shishuo Network Technology Co., Ltd. All rights reserved.
 *	长沙市师说网络科技有限公司 版权所有
 *	http://www.shishuo.com
 */

package ec.util;

import java.io.File;


public class SystemUtil {

	public static String classPath;
	static{
		classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		if ("\\".equals(File.separator)) {
			classPath = classPath.substring(1, classPath.length());
			classPath = classPath.replace("/", "\\");
		}
		System.out.println("**********"+classPath);
	}

}
