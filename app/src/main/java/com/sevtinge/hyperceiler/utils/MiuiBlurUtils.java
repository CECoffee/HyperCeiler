package com.sevtinge.hyperceiler.utils;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

public class MiuiBlurUtils {

    public static void setContainerPassBlur(View view, int i) {
        if (view == null) {
            Log.d("MiuiBlurUtils", "setPassBlur view is null");
            return;
        }
        try {
            boolean passWindowBlurEnabled = setPassWindowBlurEnabled(view, false);
            setMiBackgroundBlurMode(view, 1);
            setMiBackgroundBlurRadius(view, i);
            Log.i("MiuiBlurUtils", "setContainerPassBlur result :" + passWindowBlurEnabled + ",view : " + view);
        } catch (Exception e) {
            Log.e("MiuiBlurUtils", "setContainerPassBlur error , view :" + view);
            e.printStackTrace();
        }
    }

    public static boolean setPassWindowBlurEnabled(View view, boolean z) {
        return ReflectUtils.invokeObject(View.class, view, "setPassWindowBlurEnabled", Boolean.TYPE, Boolean.FALSE, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)}).booleanValue();
    }

    public static void setMiBackgroundBlurMode(View view, int i) {
        ReflectUtils.invokeObject(View.class, view, "setMiBackgroundBlurMode", Void.TYPE, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
    }

    public static void setMiBackgroundBlurRadius(View view, int i) {
        ReflectUtils.invokeObject(View.class, view, "setMiBackgroundBlurRadius", Void.TYPE, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
    }

    public static void addMiBackgroundBlendColor(View view, int i, int i2) {
        ReflectUtils.invokeObject(View.class, view, "addMiBackgroundBlendColor", Void.TYPE, new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void clearMiBackgroundBlendColor(View view) {
        ReflectUtils.invokeObject(View.class, view, "clearMiBackgroundBlendColor", Void.TYPE, new Class[0], new Object[0]);
    }

    public static void setMiViewBlurMode(View view, int i) {
        ReflectUtils.invokeObject(View.class, view, "setMiViewBlurMode", Void.TYPE, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
    }

    public static void disableMiBackgroundContainBelow(View view, boolean z) {
        ReflectUtils.invokeObject(View.class, view, "disableMiBackgroundContainBelow", Void.TYPE, new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(z)});
    }

    public static void clearContainerPassBlur(View view) {
        if (view == null) {
            Log.d("MiuiBlurUtils", "clearContainerMiBackgroundBlur view is null");
            return;
        }
        try {
            setMiBackgroundBlurMode(view, 0);
            boolean passWindowBlurEnabled = setPassWindowBlurEnabled(view, false);
            Log.d("MiuiBlurUtils", "clearContainerPassBlur result :" + passWindowBlurEnabled + ", view: " + view);
        } catch (Exception e) {
            Log.e("MiuiBlurUtils", "clearContainerMiBackgroundBlur error , view :" + view);
            e.printStackTrace();
        }
    }

    public static void setMemberBlendColor(View view, boolean z, int i) {
        setMemberBlendColor(view, z, i, 255);
    }

    public static void setMemberBlendColor(View view, boolean z, int i, int i2) {
        if (view == null) {
            Log.d("MiuiBlurUtils", "setMemberBlendColor view is null");
            return;
        }
        try {
            clearMiBackgroundBlendColor(view);
            setMiViewBlurMode(view, 3);
            int argb = Color.argb(i2, Color.red(i), Color.green(i), Color.blue(i));
            int argb2 = Color.argb(i2, 0, 0, 0);
            addMiBackgroundBlendColor(view, argb, 101);
            if (z) {
                addMiBackgroundBlendColor(view, argb2, 105);
            } else {
                addMiBackgroundBlendColor(view, argb2, 103);
            }
            Log.i("MiuiBlurUtils", "setMemberBlendColor: view:" + view + ",colorDark:" + z + ",color:" + Integer.toHexString(argb) + ",labColor:" + Integer.toHexString(argb2));
        } catch (Exception e) {
            Log.e("MiuiBlurUtils", "setMemberBlendColor error , view :" + view);
            e.printStackTrace();
        }
    }

    public static void clearMemberBlendColor(View view) {
        if (view == null) {
            Log.d("MiuiBlurUtils", "clearMemberBlendColor view is null");
            return;
        }
        try {
            setMiViewBlurMode(view, 0);
            clearMiBackgroundBlendColor(view);
            Log.d("MiuiBlurUtils", "clearMemberBlendColor view :" + view);
        } catch (Exception e) {
            Log.e("MiuiBlurUtils", "clearMemberBlendColor error , view :" + view);
            e.printStackTrace();
        }
    }
}