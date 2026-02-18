package com.farmtopalm.terminal.usb;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"ACTION_USB_PERMISSION", "", "EYECOOL_PRODUCT_ID", "", "EYECOOL_VENDOR_ID", "ensureUsbPermission", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findEyecoolDevice", "Landroid/hardware/usb/UsbDevice;", "app_debug"})
public final class UsbPermissionHelperKt {
    
    /**
     * Eyecool ECX166 V (735f:6204) — vendor-specific USB, no kernel driver.
     */
    private static final int EYECOOL_VENDOR_ID = 29535;
    private static final int EYECOOL_PRODUCT_ID = 25092;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_USB_PERMISSION = "com.farmtopalm.terminal.USB_PERMISSION";
    
    /**
     * Find the Eyecool palm device (735f:6204) in the USB device list.
     * Returns null if not attached.
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.hardware.usb.UsbDevice findEyecoolDevice(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Ensure USB permission for the Eyecool device. Call before any vendor SDK open/identify.
     * - If device not found: returns false, [lastError] can be set by caller.
     * - If already has permission: returns true.
     * - Otherwise: requests permission, suspends until user allows/denies, then returns the result.
     */
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object ensureUsbPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}