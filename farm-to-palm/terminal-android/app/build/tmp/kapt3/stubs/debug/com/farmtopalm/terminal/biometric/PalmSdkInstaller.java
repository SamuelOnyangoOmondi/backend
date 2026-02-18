package com.farmtopalm.terminal.biometric;

/**
 * Returns the models path used by the vendor SDK (PalmSdk.initialize, enableDimPalm).
 * Uses [PalmModelsInstaller] so models live under getExternalFilesDir(null)/models_palm/models/
 * (no storage permission needed) and match the path passed to enableDimPalm.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/farmtopalm/terminal/biometric/PalmSdkInstaller;", "", "()V", "getModelsPath", "", "context", "Landroid/content/Context;", "app_debug"})
public final class PalmSdkInstaller {
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.biometric.PalmSdkInstaller INSTANCE = null;
    
    private PalmSdkInstaller() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModelsPath(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}