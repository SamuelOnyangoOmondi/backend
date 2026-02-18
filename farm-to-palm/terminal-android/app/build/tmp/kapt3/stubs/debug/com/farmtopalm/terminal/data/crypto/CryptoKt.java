package com.farmtopalm.terminal.data.crypto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0012\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0002"}, d2 = {"PLAIN_SENTINEL", "", "app_debug"})
public final class CryptoKt {
    
    /**
     * Sentinel prefix for token stored without Keystore (fallback when Keystore fails on device).
     */
    @org.jetbrains.annotations.NotNull()
    private static final byte[] PLAIN_SENTINEL = {(byte)0, (byte)1};
}