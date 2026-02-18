package com.farmtopalm.terminal.di;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/farmtopalm/terminal/di/AppModule;", "", "()V", "eventRepo", "Lcom/farmtopalm/terminal/data/repo/EventRepo;", "context", "Landroid/content/Context;", "palmBiometricManager", "Lcom/farmtopalm/terminal/biometric/PalmBiometricManager;", "studentRepo", "Lcom/farmtopalm/terminal/data/repo/StudentRepo;", "terminalRepo", "Lcom/farmtopalm/terminal/data/repo/TerminalRepo;", "app_debug"})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.data.repo.StudentRepo studentRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.data.repo.EventRepo eventRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.data.repo.TerminalRepo terminalRepo(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Palm scanner: currently always the impl with mock capture/identify.
     * When you add a real vendor implementation (e.g. VendorPalmBiometricManager backed by the SDK jar):
     * 1. Set buildConfigField "USE_VENDOR_PALM_SDK" to true for device/release in build.gradle.
     * 2. Return that implementation here when BuildConfig.USE_VENDOR_PALM_SDK is true.
     * See BIOMETRIC_SDK_INTEGRATION.md for exact wiring (init, open, capture, identify).
     */
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.biometric.PalmBiometricManager palmBiometricManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}