package com.farmtopalm.terminal.data.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0007J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/farmtopalm/terminal/data/repo/TerminalRepo;", "", "dao", "Lcom/farmtopalm/terminal/data/db/dao/TerminalConfigDao;", "(Lcom/farmtopalm/terminal/data/db/dao/TerminalConfigDao;)V", "getConfig", "Lcom/farmtopalm/terminal/data/db/entities/TerminalConfigEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isActivated", "", "saveConfig", "", "terminalId", "", "schoolId", "apiBaseUrl", "tokenEnc", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHeartbeat", "app_debug"})
public final class TerminalRepo {
    @org.jetbrains.annotations.NotNull()
    private final com.farmtopalm.terminal.data.db.dao.TerminalConfigDao dao = null;
    
    public TerminalRepo(@org.jetbrains.annotations.NotNull()
    com.farmtopalm.terminal.data.db.dao.TerminalConfigDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getConfig(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.farmtopalm.terminal.data.db.entities.TerminalConfigEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isActivated(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveConfig(@org.jetbrains.annotations.NotNull()
    java.lang.String terminalId, @org.jetbrains.annotations.NotNull()
    java.lang.String schoolId, @org.jetbrains.annotations.NotNull()
    java.lang.String apiBaseUrl, @org.jetbrains.annotations.NotNull()
    byte[] tokenEnc, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateHeartbeat(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}