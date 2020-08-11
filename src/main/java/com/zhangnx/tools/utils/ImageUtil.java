package com.zhangnx.myspringboot.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.awt.image.BufferedImage;
import java.util.Hashtable;

public class ImageUtil {


    public static BufferedImage createQr(int w,int h,String url){
        Hashtable<EncodeHintType,Object> hints= new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
        hints.put(EncodeHintType.MARGIN,0);

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.AZTEC.QR_CODE,w,h,hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);

        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }

    }
}

























