package com.farmtopalm.terminal.data.crypto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0019\u001a\u00020\u001a2\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0002J\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/farmtopalm/terminal/data/crypto/Crypto;", "", "()V", "ANDROID_KEYSTORE", "", "FALLBACK_PREFS_NAME", "GCM_IV_LENGTH", "", "GCM_TAG_LENGTH", "KEY_ALIAS", "MASTER_KEY_ALIAS", "PREFS_NAME", "createEncryptedPrefs", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "decrypt", "", "encrypted", "deleteMasterKeyEntry", "", "encrypt", "plain", "getOrCreateAesKey", "Ljavax/crypto/SecretKey;", "isKeyStoreRelated", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "prefs", "tryCreateEncryptedPrefs", "app_debug"})
public final class Crypto {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ANDROID_KEYSTORE = "AndroidKeyStore";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ALIAS = "farmtopalm_biometric_enc";
    private static final int GCM_TAG_LENGTH = 128;
    private static final int GCM_IV_LENGTH = 12;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "farmtopalm_secure";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FALLBACK_PREFS_NAME = "farmtopalm_secure_plain";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String MASTER_KEY_ALIAS = "farm_to_palm_master_key";
    @org.jetbrains.annotations.NotNull()
    public static final com.farmtopalm.terminal.data.crypto.Crypto INSTANCE = null;
    
    private Crypto() {
        super();
    }
    
    /**
     * Returns a SharedPreferences instance that WILL NOT crash the app.
     *
     * 1) Try EncryptedSharedPreferences (best)
     * 2) If it fails, delete the key + retry once
     * 3) If it still fails, fall back to standard SharedPreferences
     */
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences prefs(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    private final android.content.SharedPreferences tryCreateEncryptedPrefs(android.content.Context context) {
        return null;
    }
    
    private final android.content.SharedPreferences createEncryptedPrefs(android.content.Context context) {
        return null;
    }
    
    /**
     * Delete master key entry so Android can regenerate it.
     * Prevents "stuck" keystore state from crashing forever.
     */
    private final void deleteMasterKeyEntry() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final javax.crypto.SecretKey getOrCreateAesKey(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * True if the exception is due to Keystore/key generation failure (e.g. -1000 on some devices).
     */
    private final boolean isKeyStoreRelated(java.lang.Exception e) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] encrypt(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    byte[] plain) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] decrypt(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    byte[] encrypted) {
        return null;
    }
}