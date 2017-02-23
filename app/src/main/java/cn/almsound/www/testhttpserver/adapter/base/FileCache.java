package cn.almsound.www.testhttpserver.adapter.base;

import android.content.Context;

import java.io.File;

/**
 * 文件缓存工具
 *
 * Created by ALM on 2016/7/7.
 */
@SuppressWarnings("WeakerAccess")
public class FileCache {

    //缓存目录
    private File cacheDir;

    public FileCache(Context context) {
        // 如果有SD卡则在SD卡中建一个LazyList的目录存放缓存的图片
        // 没有SD卡就放在系统的缓存目录中
        if (android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED))
        {
            cacheDir = FileUtil.App_Dir;
        }
        else
        {
            cacheDir = context.getCacheDir();
        }

        //如果目录不存在，那么创建一个缓存目录
        if (!cacheDir.exists())
        {
            //noinspection ResultOfMethodCallIgnored
            cacheDir.mkdirs();
        }
    }

    /**
     * 清除缓存
     */
    public void clear() {
        File[] files = cacheDir.listFiles();
        if (files == null)
        {
            return;
        }

        for (File f : files)
        {
            //noinspection ResultOfMethodCallIgnored
            f.delete();
        }
    }

}