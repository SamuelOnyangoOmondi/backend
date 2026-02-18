package com.farmtopalm.terminal.biometric;

/**
 * Kotlin wrapper around the Veinshine palm SDK (com.api.stream.*).
 * Uses reflection so the app compiles without the vendor JAR; at runtime
 * requires the JAR in app/libs/ and .so in jniLibs/.
 *
 * All blocking SDK calls run on Dispatchers.IO. Capture/open use suspendCancellableCoroutine
 * to convert vendor callbacks into suspend functions.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 e2\u00020\u0001:\u0002efB\u0005\u00a2\u0006\u0002\u0010\u0002J \u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\rH\u0082@\u00a2\u0006\u0002\u00106J\u0018\u00107\u001a\u0004\u0018\u0001022\u0006\u00108\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u00109J\u0010\u0010:\u001a\u0004\u0018\u000102H\u0086@\u00a2\u0006\u0002\u0010;J-\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020?\u00a2\u0006\u0002\u0010CJ\u0018\u0010D\u001a\u0004\u0018\u00010\u00012\u0006\u0010E\u001a\u00020FH\u0082@\u00a2\u0006\u0002\u0010GJ\u001a\u0010H\u001a\u0004\u0018\u0001022\u0006\u0010I\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\u0001H\u0002J\u001a\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010I\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\rH\u0002J\u001f\u0010N\u001a\u0004\u0018\u00010=2\u0006\u0010O\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\rH\u0002\u00a2\u0006\u0002\u0010PJ\u001f\u0010Q\u001a\u0004\u0018\u0001042\u0006\u0010O\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\rH\u0002\u00a2\u0006\u0002\u0010RJ\u0006\u0010S\u001a\u00020TJ\u001a\u0010U\u001a\u00020\u00192\u0006\u0010E\u001a\u00020F2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\rJ\u0012\u0010W\u001a\u0004\u0018\u0001022\u0006\u0010I\u001a\u00020\u0001H\u0002J\u0016\u0010X\u001a\u00020\u00192\u0006\u0010E\u001a\u00020FH\u0086@\u00a2\u0006\u0002\u0010GJ\u0017\u0010Y\u001a\u0004\u0018\u00010=2\u0006\u0010I\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010ZJ\u0012\u0010[\u001a\u0004\u0018\u00010\r2\u0006\u0010I\u001a\u00020\u0001H\u0002J\u0010\u0010\\\u001a\u0002042\u0006\u0010I\u001a\u00020\u0001H\u0002J\u0006\u0010]\u001a\u00020^J\u001c\u0010_\u001a\u00020^2\u0006\u0010`\u001a\u00020\u00012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\rH\u0002J\u0006\u0010b\u001a\u00020^J\b\u0010c\u001a\u00020^H\u0002J\u0010\u0010d\u001a\u00020^2\u0006\u0010`\u001a\u00020\u0001H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\r@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006g"}, d2 = {"Lcom/farmtopalm/terminal/biometric/VeinshinePalmSdk;", "", "()V", "captureCallbackHolder", "captureExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "captureInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "captureSessionActive", "captureTimeoutSec", "", "currentStreamType", "", "delayAfterReleaseMs", "deviceCallLock", "Ljava/util/concurrent/locks/ReentrantLock;", "deviceClass", "Ljava/lang/Class;", "deviceCreateWaitSec", "deviceInstance", "deviceOpenHolder", "deviceStrong", "gotFirstFrame", "<set-?>", "", "isAvailable", "()Z", "isInitialized", "isOpen", "lastCaptureHintRef", "Ljava/util/concurrent/atomic/AtomicReference;", "lastError", "getLastError", "()Ljava/lang/String;", "lastReleaseTimeMs", "Ljava/util/concurrent/atomic/AtomicLong;", "openCallbackHolder", "openCallbackStrong", "openMutex", "Lkotlinx/coroutines/sync/Mutex;", "openTimeoutSec", "opening", "palmSdkClass", "streamHolder", "streamRunning", "streamThreadRef", "Ljava/lang/Thread;", "veinshineInstance", "captureOnce", "Lcom/farmtopalm/terminal/biometric/dto/CaptureResult;", "recogMode", "", "logLabel", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureOnceForEnroll", "hand", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "captureOnceForIdentify", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareFeatureScore", "", "probeRgb", "", "probeIr", "templateRgb", "templateIr", "([B[B[B[B)Ljava/lang/Float;", "createAndOpenDevice", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractFromImages", "raw", "veinshine", "fieldNumber", "", "name", "getFloatField", "obj", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Float;", "getIntField", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Integer;", "getRuntimeMetadata", "Lcom/farmtopalm/terminal/biometric/VeinshinePalmSdk$RuntimeMetadata;", "initialize", "modelsPath", "mapCaptureResult", "open", "readMatchScore", "(Ljava/lang/Object;)Ljava/lang/Float;", "readMatchTemplateId", "readQuality", "release", "", "startStream", "device", "forceStreamType", "stopCapture", "stopStream", "tryDestroyStreams", "Companion", "RuntimeMetadata", "app_debug"})
public final class VeinshinePalmSdk {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Class<?> palmSdkClass;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Class<?> deviceClass;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object deviceInstance;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object veinshineInstance;
    private boolean isAvailable = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String lastError;
    private boolean isInitialized = false;
    private boolean isOpen = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean captureInProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean opening = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.sync.Mutex openMutex = null;
    
    /**
     * Instance strong refs (some builds behave oddly with companion-only refs).
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object deviceOpenHolder;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object openCallbackHolder;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object deviceStrong;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Object openCallbackStrong;
    
    /**
     * Second param to capturePalmOnce(callback, int): on many builds this is timeout in MS, not recog mode. Passing 2 → 2ms timeout → instant kTimeout.
     */
    private static final int CAPTURE_TIMEOUT_MS = 30000;
    private static final int RECOG_MODE_REGISTER = 1;
    private static final int RECOG_MODE_IDENTIFY = 2;
    @kotlin.jvm.JvmField()
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    public static volatile java.lang.Object strongDevice;
    @kotlin.jvm.JvmField()
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    public static volatile java.lang.Object strongOpenCallback;
    
    /**
     * Wait for Device.create() listener (USB permission can take 10–20s on some devices).
     */
    private final long deviceCreateWaitSec = 25L;
    private final long openTimeoutSec = 15L;
    private final long captureTimeoutSec = 30L;
    
    /**
     * Min ms to wait after release() before open() so native g_instanceDic can clear.
     */
    private final long delayAfterReleaseMs = 500L;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicLong lastReleaseTimeMs = null;
    
    /**
     * Single-thread executor so capture never overlaps; callbacks can run on SDK thread.
     */
    private final java.util.concurrent.ExecutorService captureExecutor = null;
    
    /**
     * Lock around any device stop/start/capture so no two threads invoke SDK concurrently.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.locks.ReentrantLock deviceCallLock = null;
    
    /**
     * Last hint from capture callback (e.g. UNEXPECTED_CENTER_BOX_POS) for user-facing no-result message.
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicReference<java.lang.String> lastCaptureHintRef = null;
    
    /**
     * Strong ref to capture callback so it is not GC'd before SDK invokes it.
     */
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile java.lang.Object captureCallbackHolder;
    
    /**
     * True only after StartPalmCapture until we get frame/error/timeout. Only call StopPalmCapture when this is true to avoid SDK "mICapturePalmCallback is null".
     */
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean captureSessionActive = null;
    
    /**
     * Stream must be started before capturePalmOnce (0x42023 = "Unopened flow" otherwise).
     */
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile java.lang.Object streamHolder;
    @kotlin.jvm.Volatile()
    private volatile boolean streamRunning = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean gotFirstFrame = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicReference<java.lang.Thread> streamThreadRef = null;
    
    /**
     * Stream type chosen at startStream (e.g. "RGB_IR", "IR"); stored for template metadata.
     */
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private volatile java.lang.String currentStreamType;
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.biometric.VeinshinePalmSdk.Companion Companion = null;
    
    public VeinshinePalmSdk() {
        super();
    }
    
    public final boolean isAvailable() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastError() {
        return null;
    }
    
    public final boolean isInitialized() {
        return false;
    }
    
    public final boolean isOpen() {
        return false;
    }
    
    public final boolean initialize(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String modelsPath) {
        return false;
    }
    
    /**
     * Open device once; reuse same instance if already open. Single-flight: concurrent callers get
     * "Already opening"; if already open returns true without calling create/open again (avoids g_instanceDic "device index exist").
     * Only call [release] when you need a full teardown (e.g. Retry after error); do not release on every screen leave.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object open(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.Object createAndOpenDevice(android.content.Context context, kotlin.coroutines.Continuation<java.lang.Object> $completion) {
        return null;
    }
    
    /**
     * Start stream so frames flow; required before capturePalmOnce (else 0x42023 "Unopened flow").
     * Uses reflection: deviceSupportStreamType -> createStream(type) -> allocateFrames -> start -> getFrames loop.
     * @param forceStreamType if non-null (e.g. "IR"), use this type for IR-only device fallback; must be in supported list.
     */
    private final void startStream(java.lang.Object device, java.lang.String forceStreamType) {
    }
    
    private final void stopStream() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object captureOnceForEnroll(@org.jetbrains.annotations.NotNull()
    java.lang.String hand, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.biometric.dto.CaptureResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object captureOnceForIdentify(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.biometric.dto.CaptureResult> $completion) {
        return null;
    }
    
    private final java.lang.Object captureOnce(int recogMode, java.lang.String logLabel, kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.biometric.dto.CaptureResult> $completion) {
        return null;
    }
    
    private final java.lang.Number fieldNumber(java.lang.Object raw, java.lang.String name) {
        return null;
    }
    
    private final int readQuality(java.lang.Object raw) {
        return 0;
    }
    
    private final com.farmtopalm.terminal.biometric.dto.CaptureResult mapCaptureResult(java.lang.Object raw) {
        return null;
    }
    
    private final java.lang.String readMatchTemplateId(java.lang.Object raw) {
        return null;
    }
    
    private final java.lang.Float readMatchScore(java.lang.Object raw) {
        return null;
    }
    
    /**
     * Best-effort read of stream type and model hash keys for template metadata.
     */
    @org.jetbrains.annotations.NotNull()
    public final com.farmtopalm.terminal.biometric.VeinshinePalmSdk.RuntimeMetadata getRuntimeMetadata() {
        return null;
    }
    
    private final com.farmtopalm.terminal.biometric.dto.CaptureResult extractFromImages(java.lang.Object raw, java.lang.Object veinshine) {
        return null;
    }
    
    public final void stopCapture() {
    }
    
    /**
     * Best-effort: call destroyStream(stream) or destroyStream() on device so vendor can clear internal state.
     */
    private final void tryDestroyStreams(java.lang.Object device) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float compareFeatureScore(@org.jetbrains.annotations.NotNull()
    byte[] probeRgb, @org.jetbrains.annotations.NotNull()
    byte[] probeIr, @org.jetbrains.annotations.NotNull()
    byte[] templateRgb, @org.jetbrains.annotations.NotNull()
    byte[] templateIr) {
        return null;
    }
    
    private final java.lang.Float getFloatField(java.lang.Object obj, java.lang.String name) {
        return null;
    }
    
    private final java.lang.Integer getIntField(java.lang.Object obj, java.lang.String name) {
        return null;
    }
    
    /**
     * Stop capture, destroy stream, close device, clear refs. Call only when you need a full teardown
     * (e.g. Retry after "already in use", or app exit). Prefer reusing the same device — do not call
     * release() on every screen leave, so the next open() can reuse and avoid g_instanceDic "device index exist".
     */
    public final void release() {
    }
    
    /**
     * Static strong refs until release() — required for buggy SDKs that keep only weak refs to callback.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/farmtopalm/terminal/biometric/VeinshinePalmSdk$Companion;", "", "()V", "CAPTURE_TIMEOUT_MS", "", "RECOG_MODE_IDENTIFY", "RECOG_MODE_REGISTER", "strongDevice", "strongOpenCallback", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    /**
     * Runtime metadata for template storage (stream type + model hashes).
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/farmtopalm/terminal/biometric/VeinshinePalmSdk$RuntimeMetadata;", "", "streamType", "", "rgbModelHash", "irModelHash", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIrModelHash", "()Ljava/lang/String;", "getRgbModelHash", "getStreamType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class RuntimeMetadata {
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String streamType = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String rgbModelHash = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String irModelHash = null;
        
        public RuntimeMetadata(@org.jetbrains.annotations.Nullable()
        java.lang.String streamType, @org.jetbrains.annotations.Nullable()
        java.lang.String rgbModelHash, @org.jetbrains.annotations.Nullable()
        java.lang.String irModelHash) {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getStreamType() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRgbModelHash() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getIrModelHash() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.farmtopalm.terminal.biometric.VeinshinePalmSdk.RuntimeMetadata copy(@org.jetbrains.annotations.Nullable()
        java.lang.String streamType, @org.jetbrains.annotations.Nullable()
        java.lang.String rgbModelHash, @org.jetbrains.annotations.Nullable()
        java.lang.String irModelHash) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}