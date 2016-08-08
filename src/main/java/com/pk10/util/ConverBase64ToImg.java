package com.pk10.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;

public class ConverBase64ToImg {

	public static String conver(HttpServletRequest request, String base64str) throws Exception {
		BufferedOutputStream bufferedOutputStream = null;
		if (base64str.startsWith("data:image")) {
			try {
				String path = request.getSession().getServletContext().getRealPath("/WEB-INF/views");
				String filePath = "img/" + UUID.randomUUID().toString() + "."
						+ base64str.substring(base64str.indexOf("image/") + 6, base64str.indexOf(";base64"));
				byte[] decode = Base64.decodeBase64(base64str.split("base64,")[1]);
				bufferedOutputStream = new BufferedOutputStream(
						new BufferedOutputStream(new FileOutputStream(new File(path + "/" + filePath))));
				bufferedOutputStream.write(decode);
				return filePath;
			} finally {
				if (bufferedOutputStream != null) {
					bufferedOutputStream.close();
				}
			}
		}
		return base64str;

	}
}
