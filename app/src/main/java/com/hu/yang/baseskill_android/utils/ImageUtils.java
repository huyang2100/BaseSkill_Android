package com.hu.yang.baseskill_android.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yanghu on 2017/7/17.
 */

public class ImageUtils {
    public static void saveBitmapToGallery(Context ctx, Bitmap bitmap) {
        //save bitmap
        File dir = new File(Environment.getExternalStorageDirectory(), ctx.getPackageName() + "/images");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filename = System.currentTimeMillis() + ".jpg";
        File file = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //insert image to gallery
        try {
            MediaStore.Images.Media.insertImage(ctx.getContentResolver(), file.getAbsolutePath(), filename, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //notify gallery update
        ctx.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + file.getAbsolutePath())));
    }
}
