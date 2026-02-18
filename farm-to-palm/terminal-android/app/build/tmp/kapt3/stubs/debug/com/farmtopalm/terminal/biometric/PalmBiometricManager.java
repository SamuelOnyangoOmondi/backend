package com.farmtopalm.terminal.biometric;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00030\tH&J*\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00030\tH&J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u000f\u001a\u00020\u000bH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J*\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0004\u0012\u00020\u00030\tH&J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\b\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/farmtopalm/terminal/biometric/PalmBiometricManager;", "", "captureForEnroll", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "hand", "", "callback", "Lkotlin/Function1;", "Lcom/farmtopalm/terminal/util/Result;", "Lcom/farmtopalm/terminal/biometric/dto/CaptureResult;", "captureForIdentify", "identify", "Lcom/farmtopalm/terminal/biometric/dto/IdentifyResult;", "capture", "initialize", "open", "release", "status", "Lcom/farmtopalm/terminal/biometric/dto/PalmDeviceStatus;", "app_debug"})
public abstract interface PalmBiometricManager {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.util.Result<kotlin.Unit> initialize();
    
    /**
     * Opens the device asynchronously. Use this when [PalmSdkBridge.isUsingRealSdk] is true.
     */
    public abstract void open(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.util.Result<kotlin.Unit>, kotlin.Unit> callback);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.biometric.dto.PalmDeviceStatus status();
    
    /**
     * Capture for enrollment; runs asynchronously and invokes [callback] on completion.
     */
    public abstract void captureForEnroll(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    java.lang.String hand, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.biometric.dto.CaptureResult>, kotlin.Unit> callback);
    
    /**
     * Capture for identification; runs asynchronously and invokes [callback] on completion.
     */
    public abstract void captureForIdentify(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.biometric.dto.CaptureResult>, kotlin.Unit> callback);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.biometric.dto.IdentifyResult> identify(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.biometric.dto.CaptureResult capture);
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.farmtopalm.terminal.util.Result<kotlin.Unit> release();
}