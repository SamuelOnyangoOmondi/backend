package com.farmtopalm.terminal.biometric;

/**
 * Real implementation of [IOpenCallback] (no Proxy). Use this instead of a reflective
 * Proxy so the vendor JNI layer gets a normal object and does not hit weak-global-ref bugs.
 *
 * Sets [openSuccessSignalled] in onOpenSuccess so the waiter can treat success as authoritative
 * even if the latch await timed out a moment before the callback ran (avoids false "scanner error").
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/farmtopalm/terminal/biometric/VeinshineOpenCallback;", "Lcom/api/stream/IOpenCallback;", "openLatch", "Ljava/util/concurrent/CountDownLatch;", "openSuccessSignalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onLog", "Lkotlin/Function1;", "", "", "(Ljava/util/concurrent/CountDownLatch;Ljava/util/concurrent/atomic/AtomicBoolean;Lkotlin/jvm/functions/Function1;)V", "signalled", "onDownloadPrepare", "onDownloadProgress", "progress", "", "onDownloadSuccess", "onOpenFail", "code", "onOpenSuccess", "signalOnce", "tag", "isSuccess", "", "app_debug"})
public final class VeinshineOpenCallback implements com.api.stream.IOpenCallback {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.CountDownLatch openLatch = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean openSuccessSignalled = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onLog = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean signalled = null;
    
    public VeinshineOpenCallback(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.CountDownLatch openLatch, @org.jetbrains.annotations.NotNull()
    java.util.concurrent.atomic.AtomicBoolean openSuccessSignalled, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onLog) {
        super();
    }
    
    private final void signalOnce(java.lang.String tag, boolean isSuccess) {
    }
    
    @java.lang.Override()
    public void onDownloadPrepare() {
    }
    
    @java.lang.Override()
    public void onDownloadProgress(int progress) {
    }
    
    @java.lang.Override()
    public void onDownloadSuccess() {
    }
    
    @java.lang.Override()
    public void onOpenSuccess() {
    }
    
    @java.lang.Override()
    public void onOpenFail(int code) {
    }
}