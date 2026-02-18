package com.farmtopalm.terminal.palm;

/**
 * Provisions vendor palm model files into an app-accessible directory.
 * PalmSDK-L expects a path containing e.g. palm_models_1.2.9.pbz, .pb, .bin, etc.
 * Uses getExternalFilesDir(null)/models_palm/models/ (no storage permission needed on Android 11+).
 *
 * Place vendor SDK model files in app/src/main/assets/models/ (e.g. from
 * palm-android-sdk-v1.3.14-L/assets/models/). ensureInstalled() copies them to the external path.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/farmtopalm/terminal/palm/PalmModelsInstaller;", "", "()V", "copyAssetDir", "", "context", "Landroid/content/Context;", "assetDirName", "", "dstDir", "Ljava/io/File;", "copyAssetFile", "assetPath", "dstFile", "ensureInstalled", "modelsDir", "app_debug"})
public final class PalmModelsInstaller {
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.palm.PalmModelsInstaller INSTANCE = null;
    
    private PalmModelsInstaller() {
        super();
    }
    
    /**
     * Directory that PalmSDK-L expects to contain the model files.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File modelsDir(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * Ensure models are installed: copy assets/models/ (all files) into modelsDir.
     * Call before initializing the vendor SDK and before enableDimPalm.
     * Returns the models directory (trailing slash not included; caller may add "/" for vendor).
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File ensureInstalled(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final void copyAssetDir(android.content.Context context, java.lang.String assetDirName, java.io.File dstDir) {
    }
    
    private final void copyAssetFile(android.content.Context context, java.lang.String assetPath, java.io.File dstFile) {
    }
}