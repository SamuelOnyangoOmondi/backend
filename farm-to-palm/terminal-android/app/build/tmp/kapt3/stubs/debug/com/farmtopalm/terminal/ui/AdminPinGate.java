package com.farmtopalm.terminal.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/farmtopalm/terminal/ui/AdminPinGate;", "", "()V", "DEFAULT_PIN", "", "PIN_KEY", "hasPinSet", "", "prefs", "Landroid/content/SharedPreferences;", "setPinHash", "", "pin", "sha256", "s", "verify", "app_debug"})
public final class AdminPinGate {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PIN_KEY = "admin_pin_sha256";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_PIN = "1234";
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.ui.AdminPinGate INSTANCE = null;
    
    private AdminPinGate() {
        super();
    }
    
    public final void setPinHash(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs, @org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
    }
    
    public final boolean verify(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs, @org.jetbrains.annotations.NotNull()
    java.lang.String pin) {
        return false;
    }
    
    public final boolean hasPinSet(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences prefs) {
        return false;
    }
    
    private final java.lang.String sha256(java.lang.String s) {
        return null;
    }
}