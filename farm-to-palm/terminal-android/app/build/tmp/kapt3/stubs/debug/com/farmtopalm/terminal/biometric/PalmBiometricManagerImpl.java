package com.farmtopalm.terminal.biometric;

/**
 * Implementation that wraps the palm vendor SDK via [PalmSdkBridge] / [VeinshinePalmSdk].
 * Open and capture use async APIs so the real device is used without blocking the main thread.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J2\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J*\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00142\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J*\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0018\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/farmtopalm/terminal/biometric/PalmBiometricManagerImpl;", "Lcom/farmtopalm/terminal/biometric/PalmBiometricManager;", "context", "Landroid/content/Context;", "palmTemplateDao", "Lcom/farmtopalm/terminal/data/db/dao/PalmTemplateDao;", "(Landroid/content/Context;Lcom/farmtopalm/terminal/data/db/dao/PalmTemplateDao;)V", "deviceOpen", "", "initialized", "lastError", "", "modelsPath", "captureForEnroll", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "hand", "callback", "Lkotlin/Function1;", "Lcom/farmtopalm/terminal/util/Result;", "Lcom/farmtopalm/terminal/biometric/dto/CaptureResult;", "captureForIdentify", "identify", "Lcom/farmtopalm/terminal/biometric/dto/IdentifyResult;", "capture", "initialize", "open", "release", "status", "Lcom/farmtopalm/terminal/biometric/dto/PalmDeviceStatus;", "app_debug"})
public final class PalmBiometricManagerImpl implements com.farmtopalm.terminal.biometric.PalmBiometricManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.farmtopalm.terminal.data.db.dao.PalmTemplateDao palmTemplateDao = null;
    private boolean initialized = false;
    private boolean deviceOpen = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String lastError;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String modelsPath;
    
    public PalmBiometricManagerImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.dao.PalmTemplateDao palmTemplateDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.farmtopalm.terminal.util.Result<kotlin.Unit> initialize() {
        return null;
    }
    
    @java.lang.Override()
    public void open(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.util.Result<kotlin.Unit>, kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.farmtopalm.terminal.biometric.dto.PalmDeviceStatus status() {
        return null;
    }
    
    @java.lang.Override()
    public void captureForEnroll(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    java.lang.String hand, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.biometric.dto.CaptureResult>, kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    public void captureForIdentify(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.biometric.dto.CaptureResult>, kotlin.Unit> callback) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.biometric.dto.IdentifyResult> identify(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.biometric.dto.CaptureResult capture) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.farmtopalm.terminal.util.Result<kotlin.Unit> release() {
        return null;
    }
}