package com.farmtopalm.terminal.biometric;

/**
 * Facade over the palm SDK. When the Veinshine JAR is on the classpath, uses [VeinshinePalmSdk]
 * (real hardware). When not, [isUsingRealSdk] is false and open/capture fail with [lastError] (no mock).
 *
 * Open and capture are async: use [openAsync] and [captureForEnrollAsync] / [captureForIdentifyAsync].
 * Sync [open] and [captureForEnroll] / [captureForIdentify] return false/null with [lastError] when
 * real SDK is used (call the async APIs from a coroutine instead).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0004J,\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00042\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00170\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014J$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00170\u001bJ&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!J(\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002J\u0006\u0010&\u001a\u00020\'J\u0016\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\bJ\"\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u001bJ\u0006\u0010-\u001a\u00020\u0017J\u0087\u0001\u0010.\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192w\u0010\u001a\u001as\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(2\u0012\u0013\u0012\u001103\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(4\u0012\u0013\u0012\u001103\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(5\u0012\u0013\u0012\u001103\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(6\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b0\u0012\b\b1\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u00170/R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR(\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00048F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/farmtopalm/terminal/biometric/PalmSdkBridge;", "", "()V", "_lastError", "", "appContext", "Landroid/content/Context;", "<set-?>", "", "isUsingRealSdk", "()Z", "value", "lastError", "getLastError", "()Ljava/lang/String;", "setLastError", "(Ljava/lang/String;)V", "veinshine", "Lcom/farmtopalm/terminal/biometric/VeinshinePalmSdk;", "captureForEnroll", "Lcom/farmtopalm/terminal/biometric/dto/CaptureResult;", "hand", "captureForEnrollAsync", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onResult", "Lkotlin/Function1;", "captureForIdentify", "captureForIdentifyAsync", "compare", "", "probeRgb", "", "probeIr", "templateRgb", "templateIr", "cosineSimilarityFeature", "getRuntimeMetadata", "Lcom/farmtopalm/terminal/biometric/VeinshinePalmSdk$RuntimeMetadata;", "init", "context", "modelsPath", "open", "openAsync", "release", "runHardwareSelfTest", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "success", "", "rgbBytes", "irBytes", "quality", "error", "app_debug"})
public final class PalmSdkBridge {
    @org.jetbrains.annotations.NotNull()
    private static final com.farmtopalm.terminal.biometric.VeinshinePalmSdk veinshine = null;
    @kotlin.jvm.Volatile()
    private static volatile boolean isUsingRealSdk = false;
    @org.jetbrains.annotations.Nullable()
    private static java.lang.String _lastError;
    @org.jetbrains.annotations.Nullable()
    private static android.content.Context appContext;
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.biometric.PalmSdkBridge INSTANCE = null;
    
    private PalmSdkBridge() {
        super();
    }
    
    public final boolean isUsingRealSdk() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastError() {
        return null;
    }
    
    private final void setLastError(java.lang.String value) {
    }
    
    public final boolean init(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String modelsPath) {
        return false;
    }
    
    /**
     * Synchronous open. When using real SDK this returns false; call [openAsync] from a coroutine instead.
     */
    public final boolean open() {
        return false;
    }
    
    /**
     * Open the device asynchronously. Call from a coroutine or with a scope.
     */
    public final void openAsync(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResult) {
    }
    
    /**
     * Synchronous capture. When using real SDK this returns null; use [captureForEnrollAsync] instead.
     */
    @org.jetbrains.annotations.Nullable()
    public final com.farmtopalm.terminal.biometric.dto.CaptureResult captureForEnroll(@org.jetbrains.annotations.NotNull()
    java.lang.String hand) {
        return null;
    }
    
    /**
     * Capture for enrollment asynchronously.
     */
    public final void captureForEnrollAsync(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    java.lang.String hand, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.biometric.dto.CaptureResult, kotlin.Unit> onResult) {
    }
    
    /**
     * Synchronous capture for identify. When using real SDK returns null; use [captureForIdentifyAsync].
     */
    @org.jetbrains.annotations.Nullable()
    public final com.farmtopalm.terminal.biometric.dto.CaptureResult captureForIdentify() {
        return null;
    }
    
    /**
     * Capture for identification asynchronously.
     */
    public final void captureForIdentifyAsync(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.biometric.dto.CaptureResult, kotlin.Unit> onResult) {
    }
    
    public final float compare(@org.jetbrains.annotations.NotNull()
    byte[] probeRgb, @org.jetbrains.annotations.NotNull()
    byte[] probeIr, @org.jetbrains.annotations.NotNull()
    byte[] templateRgb, @org.jetbrains.annotations.NotNull()
    byte[] templateIr) {
        return 0.0F;
    }
    
    /**
     * Fallback when SDK compareFeatureScore returns result=4 (unsupported format).
     * Tries int8 interpretation first (2064 bytes = 2064 signed bytes, common for embeddings), then float LE (516 floats).
     * Returns similarity in [0,1]; higher = more likely same person.
     */
    private final float cosineSimilarityFeature(byte[] probeRgb, byte[] probeIr, byte[] templateRgb, byte[] templateIr) {
        return 0.0F;
    }
    
    /**
     * Runtime metadata (stream type + model hashes) for template compatibility checks.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.biometric.VeinshinePalmSdk.RuntimeMetadata getRuntimeMetadata() {
        return null;
    }
    
    public final void release() {
    }
    
    /**
     * For Hardware Self Test: run init → open → capture once and report result.
     */
    public final void runHardwareSelfTest(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function5<? super java.lang.Boolean, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> onResult) {
    }
}