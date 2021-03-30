package com.bs.pageobjects;

import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import com.bs.base.BaseClass;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class Barcode extends BaseClass {
	String img=driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/img[1]")).getAttribute("src");
			URL ul=new URL(img);
			BufferedImage buff=ImageIO.read(ul);
			LuminanceSource ls=new BufferedImageLuminanceSource(buff);
			BinaryBitmap bbm=new BinaryBitmap(new HybridBinarizer(ls));
		Result res=	new MultiFormatReader().decode(bbm);
		System.out.println(res);

}
