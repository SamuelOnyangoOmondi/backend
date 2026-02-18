package com.farmtopalm.terminal.provisioning;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/farmtopalm/terminal/provisioning/ProvisioningManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "client", "Lokhttp3/OkHttpClient;", "jsonType", "Lokhttp3/MediaType;", "terminalRepo", "Lcom/farmtopalm/terminal/data/repo/TerminalRepo;", "activate", "Lcom/farmtopalm/terminal/util/Result;", "Lcom/farmtopalm/terminal/provisioning/ProvisioningManager$ActivationResult;", "activationCode", "", "baseUrl", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isActivated", "", "pingHealth", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ActivationResult", "app_debug"})
public final class ProvisioningManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.farmtopalm.terminal.data.repo.TerminalRepo terminalRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.MediaType jsonType = null;
    
    public ProvisioningManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object activate(@org.jetbrains.annotations.NotNull()
    java.lang.String activationCode, @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.util.Result<com.farmtopalm.terminal.provisioning.ProvisioningManager.ActivationResult>> $completion) {
        return null;
    }
    
    /**
     * GET /health to test if the device can reach the backend. Use before activating.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object pingHealth(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.util.Result<java.lang.String>> $completion) {
        return null;
    }
    
    public final boolean isActivated() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lcom/farmtopalm/terminal/provisioning/ProvisioningManager$ActivationResult;", "", "terminalId", "", "schoolId", "apiBaseUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiBaseUrl", "()Ljava/lang/String;", "getSchoolId", "getTerminalId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ActivationResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String terminalId = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String schoolId = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String apiBaseUrl = null;
        
        public ActivationResult(@org.jetbrains.annotations.NotNull()
        java.lang.String terminalId, @org.jetbrains.annotations.NotNull()
        java.lang.String schoolId, @org.jetbrains.annotations.NotNull()
        java.lang.String apiBaseUrl) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTerminalId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSchoolId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getApiBaseUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.farmtopalm.terminal.provisioning.ProvisioningManager.ActivationResult copy(@org.jetbrains.annotations.NotNull()
        java.lang.String terminalId, @org.jetbrains.annotations.NotNull()
        java.lang.String schoolId, @org.jetbrains.annotations.NotNull()
        java.lang.String apiBaseUrl) {
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